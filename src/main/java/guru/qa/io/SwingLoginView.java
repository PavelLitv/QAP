package guru.qa.io;

import guru.qa.domain.User;
import guru.qa.exception.AuthenticateException;
import guru.qa.service.UserService;

import javax.swing.JOptionPane;

import static javax.swing.JOptionPane.QUESTION_MESSAGE;

public class SwingLoginView implements LoginView {

    private final UserService userService;

    public SwingLoginView(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User doLogin() throws AuthenticateException {
        String userName = showInputPopup("Введите имя пользователя: ");
        String password = showInputPopup("Введите пароль: ");
        return userService.authenticate(userName, password);
    }

    private String showInputPopup(String message) {
        return (String) JOptionPane.showInputDialog(
                null,
                message,
                APP_NAME,
                QUESTION_MESSAGE,
                DEER_ICON,
                null,
                null
                );
    }
}
