package guru.qa.service;

import guru.qa.domain.User;
import guru.qa.exception.AuthenticateException;
import guru.qa.io.LoginView;
import guru.qa.io.MainView;

public class Application {

    private final LoginView loginView;
    private final  MainView mainView;

    public Application(LoginView loginView, MainView mainView) {
        this.loginView = loginView;
        this.mainView = mainView;
    }

    public void run() {
        try {
            User user = loginView.doLogin();
            mainView.showMainFrame(user);
            mainView.startMessaging(user);
        } catch (AuthenticateException e) {
            mainView.showError(e);
            run();
        }
    }
}
