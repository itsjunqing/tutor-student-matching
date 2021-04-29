package controller;

import model.DashboardModel;
import model.LoginModel;
import stream.User;
import view.DashboardView;
import view.LoginView;
import view.StudentView;
import view.TutorView;

public class LoginController {

    private LoginModel loginModel;
    private LoginView loginView;

    public LoginController(LoginModel loginModel, LoginView loginView) {
        this.loginModel = loginModel;
        this.loginView = loginView;
        listenLogin();
    }

    private void listenLogin() {
        loginView.getLoginButton().addActionListener(e -> {
            String username = loginView.getUserField().getText();
            String password = String.valueOf(loginView.getPasswordField().getPassword());
            if (loginModel.performLogin(username, password)) {
                loginView.getErrorLabel().setText("Success! Launching Dashboard...");
                loginSuccess(loginModel.getUser(username));
            } else {
                loginView.getErrorLabel().setText("Error: Wrong credentials!");
            }
        });
    }

    private void loginSuccess(User user) {
        DashboardModel dashboardModel = new DashboardModel(user);
        DashboardView dashboardView;
        if (user.getIsStudent()) {
            dashboardView = new StudentView(dashboardModel);
        } else {
            dashboardView = new TutorView(dashboardModel);
        }
        DashboardController dashboardController = new DashboardController(dashboardModel, dashboardView);
        loginView.dispose(); // destroy login view
    }
}
