package guru.qa.data.database;

import guru.qa.domain.Message;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageMapper implements RowMapper<Message>{

    @Override
    public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Message(
                rs.getString("value_message"),
                rs.getInt("from_user_icq"),
                rs.getInt("to_user_icq"),
                rs.getDate("creation_date")
        );
    }
}
