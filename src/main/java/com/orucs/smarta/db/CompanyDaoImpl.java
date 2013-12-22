package com.orucs.smarta.db;

import com.orucs.smarta.controller.ResourceNotFound;
import com.orucs.smarta.db.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Repository
public class CompanyDaoImpl implements CompanyDao {
    private static final String CREATE_COMPANY_STATEMENT = "INSERT INTO COMPANY (name, address, lat, lng, landline, email) VALUES (:name, :address, :lat, :lng, :landline, :email)";
    private static final String GET_ALL_COMPANIES_STATEMENT = "SELECT id, name, address, lat, lng, landline, email FROM company";
    private static final String GET_COMPANY_BY_ID = "SELECT id, name, address, lat, lng, landline, email FROM company where id = :id";
    private static final String UPDATE_COMPANY = "UPDATE company SET name = :name, address = :address, lat = :lat, lng = lng, landline = :landline, email = :email WHERE id = :id";

    private static final CompanyRowMapper ROW_MAPPER = new CompanyRowMapper();

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setDatasource(DataSource datasource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(datasource);
    }

    @Override
    public void insert(Company company) throws Exception {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("name", company.getName());
        parameters.put("address", company.getAddress());
        parameters.put("lat", company.getLat());
        parameters.put("lng", company.getLng());
        parameters.put("landline", company.getLandline());
        parameters.put("email", company.getEmail());
        namedParameterJdbcTemplate.update(CREATE_COMPANY_STATEMENT, parameters);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Company> getAll() throws Exception {
        return namedParameterJdbcTemplate.query(GET_ALL_COMPANIES_STATEMENT, ROW_MAPPER);
    }

    @Override
    public Company getCompany(Long id) throws Exception {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("id", id);
        List<Company> companies = namedParameterJdbcTemplate.query(GET_COMPANY_BY_ID, parameters, ROW_MAPPER);

        if (companies.size() > 0) {
            return companies.get(0);
        } else {
            throw new ResourceNotFound("Company not found");
        }
    }

    @Override
    public void updateCompany(Company company) throws Exception {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("name", company.getName());
        parameters.put("address", company.getAddress());
        parameters.put("lat", company.getLat());
        parameters.put("lng", company.getLng());
        parameters.put("landline", company.getLandline());
        parameters.put("email", company.getEmail());

        namedParameterJdbcTemplate.update(UPDATE_COMPANY, parameters);
    }

    private static class CompanyRowMapper implements RowMapper<Company> {
        @Override
        public Company mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Company record = new Company();
            record.setId(resultSet.getLong(1));
            record.setName(resultSet.getString(2));
            record.setAddress(resultSet.getString(3));
            record.setLat(resultSet.getString(4));
            record.setLng(resultSet.getString(5));
            record.setLandline(resultSet.getString(6));
            record.setEmail(resultSet.getString(7));
            return record;
        }
    }
}
