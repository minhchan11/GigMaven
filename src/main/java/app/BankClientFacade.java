package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * The type CreditBank client facade.
 */
public class BankClientFacade {
  private final ArrayList<Client> clientList;
  private final Integer percentageInvalid;

  /**
   * Instantiates a new CreditBank client facade.
   *
   * @param clientList        the client list
   * @param percentageInvalid the percentage invalid
   */
  public BankClientFacade(ArrayList<Client> clientList, Integer percentageInvalid) {
    this.clientList = clientList;
    this.percentageInvalid = percentageInvalid;
  }

  /**
   * Simulate array list.
   *
   * @return the array list
   * @throws InvalidRangeException the invalid range exception
   */
  public ArrayList<List<String>> simulate() throws InvalidRangeException {
    // step 1: create a range of client activity
    ClientActivity clientActivity = new ClientActivity();
    // step 2: Create bank registration and verification
    BankRegistration bankRegistration = new BankRegistration();
    BankVerification bankVerification = new BankVerification();

    // step 3: register client into bank database
    bankRegistration.registerClients(this.clientList);
    // step 4: create signatures and request from client
    HashMap<Integer, Signature> simulatedActivity = clientActivity
        .createClientActivity(this.clientList, this.percentageInvalid);
    // step 5: verify all activities
    return bankVerification.verifyTransaction(simulatedActivity);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankClientFacade that = (BankClientFacade) o;
    return Objects.equals(clientList, that.clientList) &&
        Objects.equals(percentageInvalid, that.percentageInvalid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientList, percentageInvalid);
  }

  @Override
  public String toString() {
    return "BankClientFacade{" +
        "clientList=" + clientList +
        ", percentageInvalid=" + percentageInvalid +
        '}';
  }
}
