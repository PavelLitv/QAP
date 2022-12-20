package guru.qa.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import guru.qa.domain.Message;
import guru.qa.domain.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FileMessageRepository implements MessageRepository {

    private static final String DATA_FILE_PATH = "./DATA.json";
    private static final ObjectMapper om = new ObjectMapper();
    private static List<Message> STORE = new ArrayList<>();

    static {
        // dtuchs  5001
        // Stanislav 5002
        // Artem 5003

        try {
            List<Message> dataFromFile =  om.readValue(new File(DATA_FILE_PATH), new TypeReference<List<Message>>() {});
            STORE.addAll(dataFromFile);
        } catch (Exception e) {
            e.printStackTrace();
            STORE.add(new Message("Привет от Стаса!", 5002, 5001, yesterdayDate()));
            STORE.add(new Message("Как дела?", 5002, 5001, yesterdayDate()));
            STORE.add(new Message("Привет от создателей Allure!", 5003, 5001, yesterdayDate()));
        }
    }

    @Override
    public void sendMessage(Message message) {
        STORE.add(message);
    }

    @Override
    public List<Message> getAllMessages(User user) {
        return STORE.stream()
                .filter(msg -> msg.getFrom() == user.getIcqNumber() || msg.getTo() == user.getIcqNumber())
                .collect(Collectors.toList());
    }

    @Override
    public void persistData() {
        try {
            om.writeValue(new File(DATA_FILE_PATH), STORE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Date yesterdayDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_WEEK, -1);
        return cal.getTime();
    }
}
