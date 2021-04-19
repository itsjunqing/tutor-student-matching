package controller;

import model.BidInfo;
import model.BidMessageInfo;
import model.OfferingModel;

public class OfferingController {

    private OfferingModel offeringModel;

    public OfferingController(OfferingModel offeringModel) {
        this.offeringModel = offeringModel;
    }

    public void refreshListener() {
        offeringModel.refreshBids();
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

        BidInfo bidInfo = new BidInfo(tutorId, time, day, duration, rate, numberOfSessions, freeLesson, contractDuration);

        offeringModel.sendOffer(bidIndexOnDisplay, bidInfo);
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
        BidMessageInfo bidMessageInfo = new BidMessageInfo(tutorId, time, day, duration, rate, numberOfSessions, freeLesson,
                contractDuration, parsedMessage);

        offeringModel.sendMessage(bidIndexOnDisplay, bidMessageInfo);
    }



}