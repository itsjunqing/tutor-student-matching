package model.contract;

import lombok.Getter;
import service.ApiService;
import stream.Contract;

import java.util.Calendar;
import java.util.Date;

/**
 * A class of ContractConfirmModel to store the information on confirming/verifying the contract details.
 */
@Getter
public class ContractConfirmModel {

    // Note: this contract is the object yet to be pushed to the API (consists of firstPartyId and not firstParty)
    private Contract contract;
    private int type;
    private boolean sign;

    /**
     * Constructs a ContractConfirmModel
     * @param contract a Contract object to be confirmed
     * @param type type (by confirmed by Tutor / Student)
     * @param sign a Boolean mark to indicate to sign the contract or otherwise
     */
    public ContractConfirmModel(Contract contract, int type, boolean sign) {
        this.type = type;
        this.sign = sign;
        this.contract = contract;
    }

    /**
     * Updates the expiry date of the Contract object based on the given months
     * @param months an integer representing how many months is the contract duration
     */
    public void updateExpiry(int months) {
        // calculate expiry date based on date creation
        Calendar c = Calendar.getInstance();
        c.setTime(contract.getDateCreated());

        c.add(Calendar.MONTH, months);
        Date expiryDate = c.getTime();

        // update expiry date
        contract.setExpiryDate(expiryDate);
    }

    /**
     * Pushes the Contract object to the API and sign if required
     */
    public void signContract() {
        // push to API
        Contract contractAdded = ApiService.contractApi().add(contract);
        String contractId = contractAdded.getId();
        // sign when it is required
        if (sign) {
            ApiService.contractApi().sign(contractId, new Contract(new Date()));
        }
    }
}
