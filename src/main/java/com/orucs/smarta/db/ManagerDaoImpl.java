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

    private static final String GET_ALL_MANAGERS_FOR_COMPANY = "SELECT manager.id, manager.firstname, manager.surname, company_manager.mobile, company.fax, company_manager.landline, company_manager.email FROM company, company_manager, manager WHERE company.id = ? AND company.id = company_manager.company_id AND manager.id = company_manager.manager_id;";
    private static final String INSERT_MANAGER = "INSERT INTO manager (firstname, surname, email, mobile) VALUES (?, ?, ?, ?)";
    private static final String INSERT_COMPANY_MANAGER = "INSERT INTO company_manager (company_id, manager_id, joined, departed, mobile, landline, email) VALUES (?, ?, ?, ?, ?, ?, ?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Manager> create(Long companyId, Manager manager) {
        jdbcTemplate.update(INSERT_MANAGER, manager.getFirstname(), manager.getSurname(), manager.getPersonalEmail(), manager.getPersonalMobile());
        jdbcTemplate.update(INSERT_COMPANY_MANAGER, companyId, manager.getId(), manager.getJoined(), manager.getDeparted(), manager.getWorkMobile(), manager.getWorkPhone(), manager.getWorkEmail());
        return getManagersForCompany(companyId);
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
            record.setFirstname(resultSet.getString(2));
            record.setSurname(resultSet.getString(3));
            record.setWorkMobile(resultSet.getString(4));
            record.setWorkPhone(resultSet.getString(5));
            record.setPersonalMobile(resultSet.getString(6));
            record.setWorkEmail(resultSet.getString(7));
            return record;
        }
    }
}
