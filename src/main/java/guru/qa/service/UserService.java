package guru.qa.service;

import guru.qa.domain.User;
import guru.qa.exception.AuthenticateException;

public interface UserService {

    User authenticate(String userName, String password) throws AuthenticateException;
}
