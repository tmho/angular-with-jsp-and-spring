package com.orucs.smarta.db;

import com.orucs.smarta.db.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ManagerDaoImpl implements ManagerDao {

//    private static final String CREATE_COMPANY_STATEMENT = "INSERT INTO COMPANY (name, address, lat, lng, landline, email) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String GET_ALL_MANAGERS_FOR_COMPANY = "SELECT manager.id, manager.firstname, manager.surname, company_manager.mobile, company.fax, company_manager.landline, company_manager.email FROM company, company_manager, manager WHERE company.id = ? AND company.id = company_manager.company_id AND manager.id = company_manager.manager_id;";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Manager> create(Long companyId, Manager manager) {
//        jdbcTemplate.update(CREATE_COMPANY_STATEMENT, company.getName(), company.getAddress(), company.getLat(), company.getLng(), company.getLandline(), company.getEmail());
        return getManagersForCompany(1L);
    }

    @Override
    public List<Manager> getManagersForCompany(Long companyId) {
        return jdbcTemplate.query(GET_ALL_MANAGERS_FOR_COMPANY, new Object[]{companyId}, new ManagerRowMapper());
    }


    private static class ManagerRowMapper implements RowMapper<Manager> {
        @Override
        public Manager mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Manager record = new Manager();
            record.setId(resultSet.getLong(1));
            record.setFirstName(resultSet.getString(2));
            record.setSurname(resultSet.getString(3));
            record.setMobile(resultSet.getString(4));
            record.setFax(resultSet.getString(5));
            record.setLandline(resultSet.getString(6));
            record.setEmail(resultSet.getString(7));
            return record;
        }
    }
}
