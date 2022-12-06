package guru.qa.data;

import guru.qa.domain.Message;
import guru.qa.domain.User;

import java.util.List;

public interface MessageRepository {

    void sendMessage(User user, Message message);

    List<Message> getAllMessages(User user);
}
