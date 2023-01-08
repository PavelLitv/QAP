package guru.qa.data;

import guru.qa.data.database.UserMapper;
import guru.qa.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class DataBaseUserRepository implements UserRepository {

    private static final JdbcTemplate template = new JdbcTemplate(
            DataSourceProvider.INSTANCE.getDataSource()
    );

    @Override
    public Optional<User> findUserByUserName(String userName) {
       return Optional.ofNullable(Objects.requireNonNull(template.queryForObject("SELECT * FROM users WHERE user_name = ?",
               new UserMapper(),
               userName
       )).addUsersToContactList((getContactList(userName))));
    }

    private Optional<User> findUserByUserId(int id) {
        return Optional.ofNullable(template.queryForObject("SELECT * FROM users WHERE id = ?",
                new UserMapper(),
                id
        ));
    }

    @Override
    public Optional<User> findUserByIcqNumber(String userName) {
        return Optional.empty();
    }

    private void addUser(User user) {
        template.update("INSERT INTO users (user_name, password, icq_number) values (?, ?, ?)",
                user.getUserName(), user.getPasswordHash(), user.getIcqNumber());
    }

    private User[] getContactList(String username) {
        List<User> users = new ArrayList<>();
        List<Integer> contactsId = new ArrayList<>(getIdContacts(getIdUser(username)));
        contactsId.forEach(
                id -> findUserByUserId(id).ifPresent(users::add));
        users.toArray(new User[0]);
        return users.toArray(User[]::new);
    }

    private Integer getIdUser(String userName) {
        return template.queryForObject("SELECT id FROM users WHERE user_name = ?",
                Integer.class,
                userName);
    }

    private List<Integer> getIdContacts(int idUser) {
        return template.query("SELECT contact_id FROM contacts WHERE user_id = ?",
                (rs, rowNum) -> rs.getInt("contact_id"),
                idUser);
    }
}
