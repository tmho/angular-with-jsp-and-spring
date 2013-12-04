package com.orucs.smarta.db;

import com.orucs.smarta.db.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CompanyDaoImpl implements CompanyDao {
    private static final String CREATE_COMPANY_STATEMENT = "INSERT INTO COMPANY (name, address, lat, lng, landline, email) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String GET_ALL_COMPANIES_STATEMENT = "SELECT id, name, address, lat, lng, landline, email FROM company";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Company> insert(Company company) {
        jdbcTemplate.update(CREATE_COMPANY_STATEMENT, company.getName(), company.getAddress(), company.getLat(), company.getLng(), company.getLandline(), company.getEmail());
        return getAll();
    }

    @Override
    public List<Company> getAll() {
        return jdbcTemplate.query(GET_ALL_COMPANIES_STATEMENT, new CompanyRowMapper());
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
