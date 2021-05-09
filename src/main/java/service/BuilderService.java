package service;

import entity.BidInfo;
import entity.Constants;
import entity.Preference;
import stream.*;

import java.util.Calendar;
import java.util.Date;

/**
 * A builder class that builds objects to be re-used.
 */
public class BuilderService {

    /**
     * Builds a Bid object based on the preference given
     * @param userId a String of user id
     * @param bp a bid Preference object
     * @param type the type ("Open" or "Close")
     * @return a Bid object
     */
    public static Bid buildBid(String userId, Preference bp, String type) {
        BidAdditionalInfo bidAdditionalInfo = new BidAdditionalInfo(bp);
        Date dateCreated = new Date();
        String subjectId = ApiService.subjectApi().getAll().stream()
                .filter(s -> s.getName().equals(bp.getSubject()))
                .findFirst()
                .orElse(null) // null guarantee to not occur as view selected is from a list of available subjects
                .getId();
        return new Bid(type, userId, dateCreated, subjectId, bidAdditionalInfo);
    }

    /**
     * Builds a Contract object with a default expiry (will require caller to set manually if expiry were to change)
     * @param bid a Bid object
     * @param offer an offer from tutor (when offering) or student (when buyout)
     * @return a Contract object
     */
    public static Contract buildContract(Bid bid, BidInfo offer) {
        System.out.println("Bid = " + bid);
        String studentId = bid.getInitiator().getId();
        String tutorId = offer.getInitiatorId();
        String subjectId = bid.getSubject().getId();
        Date dateCreated = new Date();

        // calculate expiry date based on date creation
        Calendar c = Calendar.getInstance();
        c.setTime(dateCreated);
        c.add(Calendar.MONTH, Constants.DEFAULT_CONTRACT_DURATION);
        Date expiryDate = c.getTime();

        // calculate payment = rate per session * number of sessions
        Payment payment = new Payment(offer.getRate() * offer.getNumberOfSessions());
        Lesson lesson = new Lesson(bid.getSubject().getName(), offer.getDay(), offer.getTime(),
                offer.getDuration(), offer.getNumberOfSessions(), offer.isFreeLesson());

        return new Contract(studentId, tutorId, subjectId, dateCreated, expiryDate, payment,
                lesson, bid.getAdditionalInfo().getPreference());
    }

    public static Contract buildContract(Contract contract, String tutorId) {
        Contract newContract = new Contract(contract); // copies a new Contract
        contract.setSecondPartyId(tutorId); // set to new tutor
        return newContract;
    }

}
