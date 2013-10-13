package com.orucs.smarta.db;

import com.orucs.smarta.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private static final String CREATE_USER = "INSERT INTO users (username, password) VALUES (?, ?)";
    private static final String FIND_USER = "SELECT * FROM users WHERE users.username = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(User user) {
        jdbcTemplate.update(CREATE_USER, user.getUsername(), user.getPassword());
    }

    @Override
    public List<User> findUserByUsername(String username) {
        return jdbcTemplate.query(FIND_USER, new UserRowMapper(), username);
    }

    private static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            User record = new User();
            record.setUsername(resultSet.getString(1));
            record.setPassword(resultSet.getString(2));
            return record;
        }
    }
}
