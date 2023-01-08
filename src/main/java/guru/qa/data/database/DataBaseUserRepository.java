package guru.qa.data.database;

import guru.qa.data.UserRepository;
import guru.qa.domain.User;
import guru.qa.service.SecurityService;
import org.springframework.jdbc.core.JdbcTemplate;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

public class DataBaseUserRepository implements UserRepository {

    private static final JdbcTemplate jdbcTemplate = new JdbcTemplate(
            DataSourceProvider.INSTANCE.getDataSource()
    );

    @Override
    public Optional<User> findUserByUserName(String userName) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findUserByIcqNumber(String userName) {
        return Optional.empty();
    }

    public void addUser(User user) {
        jdbcTemplate.update("INSERT INTO users (user_name, password, icq_number) values (?, ?, ?)",
                user.getUserName(), user.getPasswordHash(), user.getIcqNumber());
    }













    public static void main(String[] args) {
        try {
            User user = new User("Sliva", 1003, new SecurityService().calculateHash("123456"));
            DataBaseUserRepository dataBaseUserRepository = new DataBaseUserRepository();
            dataBaseUserRepository.addUser(user);
        } catch (
                NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }
}
