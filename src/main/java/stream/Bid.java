package stream;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Bid {
    private String id;
    private String type;
    private User initiator;
    private String initiatorId;
    private Date dateCreated;
    private Date dateClosedDown;
    private Subject subject;
    private String subjectId;
    private Extra additionalInfo;
    private List<Message> messages;

    /**
     * Constructor used to GET Bid (Deserialization)
     */
    public Bid(String id, String type, User initiator, Date dateCreated,
               Date dateClosedDown, Subject subject, Extra additionalInfo, List<Message> messages) {
        this.id = id;
        this.type = type;
        this.initiator = initiator;
        this.dateCreated = dateCreated;
        this.dateClosedDown = dateClosedDown;
        this.subject = subject;
        this.additionalInfo = additionalInfo;
        this.messages = messages;
    }

    /**
     * Constructor used for creating and POST new Bid (Serialization)
     */
    public Bid(String type, String initiatorId, Date dateCreated, String subjectId, Extra additionalInfo) {
        this.type = type;
        this.initiatorId = initiatorId;
        this.dateCreated = dateCreated;
        this.subjectId = subjectId;
        this.additionalInfo = additionalInfo;
    }

    /**
     * Constructor used for mark Bid as closed down (Serialization)
     */
    public Bid(Date dateClosedDown) {
        this.dateClosedDown = dateClosedDown;
    }

    // TODO: Inner class below to be modified
    @Data
    private class Extra {
        private String info;
        private String preference;
        private String bidOffers;
    }
}
