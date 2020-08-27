package app;

import java.util.ArrayList;

/**
 * The type CreditBank registration.
 */
public class BankRegistration {

  public BankRegistration() {
  }

  /**
   * Register clients with the bank by adding customer info.
   *
   * @param clients the clients
   */
  public void registerClients(ArrayList<Client> clients) {
    CreditBank currentCreditBank = CreditBank.getInstance();
    clients.forEach(client -> {
      try {
        currentCreditBank.addCustomerInfo(client);
      } catch (InvalidRangeException e) {
        e.printStackTrace();
      }
    });
  }

  @Override
  public int hashCode() {
    return BankRegistration.class.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof BankRegistration;
  }

  @Override
  public String toString() {
    return "BankRegistration{}";
  }
}
