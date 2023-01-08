package guru.qa.data;

import guru.qa.data.database.MessageMapper;
import guru.qa.domain.Message;
import guru.qa.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;



public class DataBaseMessageRepository implements MessageRepository {

    private static final JdbcTemplate template = new JdbcTemplate(
            DataSourceProvider.INSTANCE.getDataSource()
    );

    @Override
    public void sendMessage(Message message) {
        template.update("INSERT INTO messages (from_user_icq, to_user_icq, value_message, creation_date) values (?, ?, ?, ?)",
                message.getFrom(), message.getTo(), message.getText(), message.getCreationDate());
    }

    @Override
    public List<Message> getAllMessages(User user) {
        return template.query("SELECT * FROM messages WHERE from_user_icq = ? OR to_user_icq = ?",
                new MessageMapper(),
                user.getIcqNumber(), user.getIcqNumber()
        );
    }

    @Override
    public void persistData() {

    }
}
