package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * The type CreditBank.
 */
public class CreditBank {

  /**
   * The constant MIN_LIMIT.
   */
  protected static final int MIN_LIMIT = 0;
  /**
   * The constant MAX_LIMIT_DEPOSIT.
   */
  protected static final int MAX_LIMIT_DEPOSIT = 2000;
  /**
   * The constant MAX_LIMIT_WITHDRAWAL.
   */
  protected static final int MAX_LIMIT_WITHDRAWAL = 3000;
  private static CreditBank creditBankInstance;
  private final HashMap<Integer, List<Integer>> customerInfo;

  private CreditBank(){
    this.customerInfo = new HashMap<>();
  }

  /**
   * Get instance bank.
   *
   * @return the bank
   */
  public static CreditBank getInstance(){
    if (creditBankInstance == null){
      creditBankInstance = new CreditBank();
    }
    return creditBankInstance;
  }

  /**
   * Check id exist boolean.
   *
   * @param id the id
   * @return the boolean
   */
  public Boolean checkIdExist(Integer id){
    return customerInfo.get(id) != null;
  }

  /**
   * Clear instance.
   */
  public static void clearInstance()
  {
    creditBankInstance = null;
  }

  /**
   * Add customer info.
   *
   * @param newClient the new client
   * @throws InvalidRangeException the invalid range exception
   */
  public void addCustomerInfo(Client newClient) throws InvalidRangeException {
    Integer clientId = newClient.getId();
    Integer publicKeyExponent = NumberAdapter.fromBigToInt(newClient.getPublicKey().getExponent());
    Integer publicKeyModulus = NumberAdapter.fromBigToInt(newClient.getPublicKey().getMod());
    Integer depositLimit = RandomGenerator.createRandomIntRange(MIN_LIMIT, MAX_LIMIT_DEPOSIT);
    Integer withdrawalLimit = RandomGenerator.createRandomIntRange(MIN_LIMIT, MAX_LIMIT_WITHDRAWAL);
    List<Integer> newCustomerInfo = new ArrayList<>(Arrays.asList(publicKeyExponent,publicKeyModulus,depositLimit,withdrawalLimit));
    this.customerInfo.put(clientId, newCustomerInfo);
  }

  /**
   * Gets customer info.
   *
   * @return the customer info
   */
  public HashMap<Integer, List<Integer>> getCustomerInfo() {
    return customerInfo;
  }
}
