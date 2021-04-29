package controller;

import model.OfferingModel;
import view.builder.OfferingView;
//import view.OfferingView;

public class OfferingController {

    private OfferingModel offeringModel;
    private OfferingView offeringView;

//    public OfferingController(OfferingModel offeringModel, OfferingView offeringView) {
    public OfferingController(OfferingModel offeringModel){
        this.offeringModel = offeringModel;
//        this.offeringView = offeringView;
    }

    public void listenRefresh() {
        offeringModel.refresh();
    }

    public void listenToOffer() {
        // offer button is selected -> create offer view -> extract info from view -> create BidInfo -> patch to Bid API
        // close view after offer
        int bidIndexOnDisplay = -1;

        String tutorId = "-1";
        String time = "-1";
        String day = "Saturday";
        int duration = 1;
        int rate = 10;
        int numberOfSessions = 2;
        boolean freeLesson = true;
        int contractDuration = 4;

//        BidInfo bidInfo = new BidInfo(tutorId, time, day, duration, rate, numberOfSessions, contractDuration, "", freeLesson);

//        offeringModel.sendOffer(bidIndexOnDisplay, bidInfo);
    }

    public void listenBuyOut() {

    }

    public void listenToReply() {
        // create reply view -> extract info from view -> create BidMessageInfo -> post to Message API
        // view must provide info on which bid did tutor selected
        // close reply view after this function ends

        int bidIndexOnDisplay = -1;

        String tutorId = "-1";
        String time = "-1";
        String day = "Saturday";
        int duration = 1;
        int rate = 10;
        int numberOfSessions = 2;
        boolean freeLesson = true;
        int contractDuration = 4;
        String parsedMessage = "I am a pro tutor";
//        BidInfo bidInfo = new BidInfo(tutorId, time, day, duration, rate, numberOfSessions, contractDuration,
//                parsedMessage, freeLesson);
//
//        offeringModel.sendMessage(bidIndexOnDisplay, bidInfo);
    }



}
