package edu.arep.EC2.repository;

import edu.arep.EC2.entities.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert userInsert;

    public UserRepository(NamedParameterJdbcTemplate jdbcNamedTemplate,
                          SimpleJdbcInsert userInsert) {
        this.jdbcTemplate = jdbcNamedTemplate;
        this.userInsert = userInsert;
    }

    public int save(User user) {
        return userInsert.executeAndReturnKey(user.toMap()).intValue();
    }

    public User getById(int userId) {
        Map<String, Object> params = new HashMap<String, Object>() {{
            put("id", userId);
        }};

        return jdbcTemplate.queryForObject(getByIdQuery(), params, new BeanPropertyRowMapper<>(User.class));
    }

    public List<User> getAll() {
        return jdbcTemplate.query(getAllQuery(), Collections.emptyMap(), new BeanPropertyRowMapper<>(User.class));
    }

    private String getByIdQuery() {
        return "SELECT * FROM users WHERE users.id = :id;";
    }

    private String getAllQuery() {
        return "SELECT * FROM users;";
    }
}
