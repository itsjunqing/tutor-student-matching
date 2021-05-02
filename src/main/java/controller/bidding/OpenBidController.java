package controller.bidding;

import entity.BidPreference;
import model.bidding.OpenBidModel;
import stream.Contract;
import view.bidding.OpenBidView;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class OpenBidController extends BiddingController {

    private OpenBidModel openBidModel;
    private OpenBidView openBidView;

    /**
     * Constructor to create an OpenBid
     * @param userId
     * @param bp
     */
    public OpenBidController(String userId, BidPreference bp) {
        this.openBidModel = new OpenBidModel(userId, bp);
//        SwingUtilities.invokeLater(() -> {
            this.openBidView = new OpenBidView(openBidModel);
            this.openBidModel.attach(openBidView);
            listenViewActions();
//        });
    }

    /**
     * Constructor for OpenBid in progress
     * @param userId
     */
    public OpenBidController(String userId) {
        this.openBidModel = new OpenBidModel(userId);
//        SwingUtilities.invokeLater(() -> {
            this.openBidView = new OpenBidView(openBidModel);
            this.openBidModel.attach(openBidView);
            listenViewActions();
//        });
    }

    @Override
    public void listenViewActions() {
        openBidView.getRefreshButton().addActionListener(this::handleRefresh);
        openBidView.getSelectOfferButton().addActionListener(this::handleOfferSelection);
    }

    private void handleRefresh(ActionEvent e) {
        System.out.println("From OpenBidController: Refresh is clicked");
        openBidModel.refresh();
    }

    private void handleOfferSelection(ActionEvent e) {
        System.out.println("From OpenBidController: Offer is clicked");
        int selection = openBidView.getOfferSelection();
        System.out.println("selection");
        Contract contract = openBidModel.offerSelection(selection);
        if (contract != null){
            handleContract(contract);
            openBidView.dispose();
        }
        else {;
        }

//        Bid currentBid = openBidModel.getBid();
//        BidInfo bidInfo = openBidModel.getOpenBidOffers().get(selection-1);
//        openBidModel.markBidClose();
//        System.out.println("From OpenBidController: Selected offer = " + bidInfo.toString());
//        // change to to usage of contract factory
//        createContract(currentBid, bidInfo);
    }
}
