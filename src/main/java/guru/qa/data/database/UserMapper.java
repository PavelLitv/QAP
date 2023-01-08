package guru.qa.data.database;

import guru.qa.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(
                rs.getInt("id"),
                rs.getString("user_name"),
                rs.getInt("icq_number"),
                rs.getBytes("password")
        );
    }
}
