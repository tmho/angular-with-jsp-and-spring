package com.orucs.smarta.db;

import com.orucs.smarta.db.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
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
public class ManagerDaoImpl implements ManagerDao {

    private static final String GET_ALL_MANAGERS_FOR_COMPANY = "SELECT manager.id, manager.firstname, manager.surname, company_manager.mobile, company.fax, company_manager.landline, company_manager.email FROM company, company_manager, manager WHERE company.id = :companyId AND company.id = company_manager.company_id AND manager.id = company_manager.manager_id;";
    private static final String INSERT_MANAGER = "INSERT INTO manager (firstname, surname, email, mobile) VALUES (:fistname, :surname, :email, :mobile)";
    private static final String INSERT_COMPANY_MANAGER = "INSERT INTO company_manager (company_id, manager_id, joined, departed, mobile, landline, email) VALUES (:companyId, :managerId, :joined, :departed, :mobile, :landline, :email)";

    private static final ManagerRowMapper ROW_MAPPER = new ManagerRowMapper();

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setDatasource(DataSource datasource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(datasource);
    }

    @Override
    public List<Manager> create(Long companyId, Manager manager) {
        Map<String, Object> insertManagerParameters = new HashMap<String, Object>();
        insertManagerParameters.put("firstname", manager.getFirstname());
        insertManagerParameters.put("surname", manager.getSurname());
        insertManagerParameters.put("email", manager.getPersonalEmail());
        insertManagerParameters.put("mobile", manager.getPersonalMobile());
        namedParameterJdbcTemplate.update(INSERT_MANAGER, insertManagerParameters);

        Map<String, Object> insertCompanyManagerParameters = new HashMap<String, Object>();
        insertCompanyManagerParameters.put("companyId", manager.getFirstname());
        insertCompanyManagerParameters.put("managerId", manager.getSurname());
        insertCompanyManagerParameters.put("joined", manager.getPersonalEmail());
        insertCompanyManagerParameters.put("departed", manager.getPersonalMobile());
        insertCompanyManagerParameters.put("mobile", manager.getPersonalMobile());
        insertCompanyManagerParameters.put("landline", manager.getPersonalMobile());
        insertCompanyManagerParameters.put("email", manager.getPersonalMobile());
        namedParameterJdbcTemplate.update(INSERT_COMPANY_MANAGER, insertCompanyManagerParameters);
        return getManagersForCompany(companyId);
    }

    @Override
    public List<Manager> getManagersForCompany(Long companyId) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("companyId", companyId);
        return namedParameterJdbcTemplate.query(GET_ALL_MANAGERS_FOR_COMPANY, parameters, ROW_MAPPER);
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
