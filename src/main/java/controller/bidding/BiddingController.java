package controller.bidding;

import controller.EventListener;
import controller.contract.ContractController;
import stream.Contract;


public abstract class BiddingController implements EventListener {

    protected void handleContract(Contract contract) {
        ContractController contractController = new ContractController(contract);
    }

    public abstract void listenViewActions();

}
