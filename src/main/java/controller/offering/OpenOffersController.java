package controller.offering;

import controller.EventListener;
import controller.contract.ContractConfirmController;
import entity.BidInfo;
import model.offering.OpenOffersModel;
import stream.Contract;
import view.ViewUtility;
import view.form.OpenReply;
import view.offering.OpenOffersView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class OpenOffersController implements EventListener {

    private OpenOffersModel openOffersModel;
    private OpenOffersView openOffersView;

    public OpenOffersController(String userId, String bidId) {
        this.openOffersModel = new OpenOffersModel(userId, bidId);
        SwingUtilities.invokeLater(() -> {
            this.openOffersView = new OpenOffersView(openOffersModel);
            this.openOffersModel.attach(openOffersView);
            listenViewActions();
        });
    }

    public void listenViewActions() {
        openOffersView.getRefreshButton().addActionListener(this::handleRefresh);
        openOffersView.getRespondButton().addActionListener(this::handleRespond);
        openOffersView.getBuyOutButton().addActionListener(this::handleBuyOut);
    }

    private void handleRefresh(ActionEvent e) {
        openOffersModel.refresh();
    }

    private void handleRespond(ActionEvent e) {
        OpenReply openReply = new OpenReply();
        openReply.getSendOpenReplyButton().addActionListener(e1 -> handleBidInfo(e1, openReply));
    }

    private void handleBidInfo(ActionEvent e, OpenReply openReplyForm) {
        try {
            BidInfo bidInfo = extractOpenReplyInfo(openReplyForm);
            System.out.println("Extracted: " + bidInfo);
            openOffersModel.respond(bidInfo);
            openReplyForm.dispose();

        } catch (NullPointerException exception) {
            openReplyForm.getErrorLabel().setText("Form is incomplete!");
        }
    }

    private void handleBuyOut(ActionEvent e) {
        // Get preferences -> Form contract to be posted to API
        Contract contract = openOffersModel.buyOut();
        // Get contract duration -> post -> sign -> dispose
        new ContractConfirmController(contract, ViewUtility.TUTOR_CODE, true);
        openOffersView.dispose();
    }

    private BidInfo extractOpenReplyInfo(OpenReply openReplyForm) throws NullPointerException {
        String tutorId = openOffersModel.getUserId();
        String time = openReplyForm.getTimeBox();
        String day = openReplyForm.getDayBox();
        int duration = openReplyForm.getDurationBox();
        int rate = openReplyForm.getRateField();
        int numberOfSessions = openReplyForm.getNumOfSessionBox();
        boolean freeLesson = openReplyForm.getFreeLessonBox();
        return new BidInfo(tutorId, time, day, duration, rate, numberOfSessions, freeLesson);
    }

}
