package view;

import lombok.Getter;
import model.DashboardModel;

import javax.swing.*;

@Getter
public abstract class DashboardView {

    protected DashboardModel dashboardModel;
    protected JPanel mainPanel; // mainPanel holds both contractPanel and buttons
    protected JPanel contractPanel; // used to clear and update the content, only this need to be updated
    protected JButton refreshButton;
    protected JButton initiateButton;

    // Note: once buttons are created, when refresh is called, only contractPanel is updated, buttons are not destroyed
    // so the same buttons listened in the controller will continue to work

    public DashboardView(DashboardModel dashboardModel) {
        this.dashboardModel = dashboardModel;
    }

    public abstract void updateContracts();
}
