package guru.qa.data;

import guru.qa.domain.User;
import guru.qa.service.SecurityService;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

public class MockUserRepository implements UserRepository {
    @Override
    public Optional<User> findUserByUserName(String userName) {
        final String password = "12345";
        try {
            User user0 = new User("dtuchs", 5001, new SecurityService().calculateHash(password));
            User user1 = new User("svasenkov", 5002, new SecurityService().calculateHash(password));
            User user2 = new User("arteme", 5003, new SecurityService().calculateHash(password));
            user0.addUsersToContactList(user1, user2);

            if (userName.equals("dtuchs")) {
                return Optional.of(user0);
            } else {
                return Optional.empty();
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<User> findUserByIcqNumber(String userName) {
        return Optional.empty();
    }
}
