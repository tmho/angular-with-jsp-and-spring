package com.orucs.smarta.db;

import com.orucs.smarta.controller.ResourceNotFound;
import com.orucs.smarta.db.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Transactional
@Repository
public class CompanyDaoImpl implements CompanyDao {
    private static final String CREATE_COMPANY_STATEMENT = "INSERT INTO COMPANY (name, address, lat, lng, landline, email) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String GET_ALL_COMPANIES_STATEMENT = "SELECT id, name, address, lat, lng, landline, email FROM company";
    private static final String GET_COMPANY_BY_ID = "SELECT id, name, address, lat, lng, landline, email FROM company where id = ?";
    private static final String UPDATE_COMPANY = "UPDATE company SET name = ?, address = ?, lat = ?, lng = ?, landline = ?, email = ? WHERE id = ?";

    private static final CompanyRowMapper rowMapper = new CompanyRowMapper();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Company> insert(Company company) {
        jdbcTemplate.update(CREATE_COMPANY_STATEMENT, new Object[]{
                company.getName(), company.getAddress(), company.getLat(), company.getLng(), company.getLandline(), company.getEmail()});
        return getAll();
    }

    @Override
    public List<Company> getAll() {
        return jdbcTemplate.query(GET_ALL_COMPANIES_STATEMENT, new CompanyRowMapper());
    }

    @Override
    public Company getCompany(Long id) throws Exception {
        List<Company> companies = jdbcTemplate.query(GET_COMPANY_BY_ID, new Object[]{id}, rowMapper);

        if (companies.size() > 0) {
            return companies.get(0);
        } else {
            throw new ResourceNotFound("Company not found");
        }
    }

    @Transactional
    @Override
    public List<Company> updateCompany(Company company) {
        jdbcTemplate.update(UPDATE_COMPANY,
                company.getName(), company.getAddress(), company.getLat(), company.getLng(), company.getLandline(), company.getEmail(), company.getId());
        return getAll();
    }

    @Transactional
    @Override
    public List<Company> test() throws Exception {

        Company company1 = new Company();
        company1.setName("new company 1");
        company1.setId(1L);
        updateCompany(company1);
        Company company2 = new Company();
        company2.setName("new company 2");
        company2.setId(9191L);
        updateCompany(company2);

        return getAll();
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
