package guru.qa.data.database;

import guru.qa.data.MessageRepository;
import guru.qa.domain.Message;
import guru.qa.domain.User;

import java.util.List;

public class DataBaseMessageRepository implements MessageRepository {
    @Override
    public void sendMessage(Message message) {

    }

    @Override
    public List<Message> getAllMessages(User user) {
        return null;
    }
}
