package guru.qa;

import guru.qa.data.*;
import guru.qa.io.SwingLoginView;
import guru.qa.io.SwingMainView;
import guru.qa.service.Application;
import guru.qa.service.MainUserService;
import guru.qa.service.SecurityService;

public class Main {
    public static void main(String[] args) {
        new Application(
                new SwingLoginView(
                        new MainUserService(
                                new SecurityService(),
                                new DataBaseUserRepository()
                        )
                ),
                new SwingMainView(
                        new DataBaseMessageRepository()
                )
        ).run();
    }
}