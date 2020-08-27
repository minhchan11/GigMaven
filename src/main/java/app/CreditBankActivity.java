package app;

import static app.ConstantsUtils.ACCEPTED;
import static app.ConstantsUtils.DEPOSIT;
import static app.ConstantsUtils.REJECTED;
import static app.ConstantsUtils.WITHDRAWAL;

/**
 * The type CreditBank activity.
 */
public class CreditBankActivity {

  /**
   * The constant TENTH_DIGIT.
   */
  protected static final int TENTH_DIGIT = 10;
  /**
   * The constant THRESHOLD.
   */
  protected static final int THRESHOLD = 5;
  /**
   * The constant SPACE.
   */
  protected static final String SPACE = " ";

  public CreditBankActivity() {
  }

  /**
   * Process transaction string.
   *
   * @param message         the message
   * @param depositLimit    the deposit limit
   * @param withdrawalLimit the withdrawal limit
   * @param valid           the valid
   * @return the string
   */
  public String processTransaction(Integer message, Integer depositLimit,Integer withdrawalLimit, Boolean valid){
    int intention = message % TENTH_DIGIT;
    int amount = message/ TENTH_DIGIT;
    String finalMessage;
    if (intention < THRESHOLD){
      finalMessage = approveTransaction(amount,depositLimit,DEPOSIT,valid);
    } else {
      finalMessage = approveTransaction(amount,withdrawalLimit,WITHDRAWAL,valid);
    }
    return finalMessage;
  }

  /***
   * Helper method to approve the transaction if it is valid and amount is less than limit
   * @param amount amount transaction
   * @param limit limit transaction
   * @param transactionType type of transaction
   * @param valid result of validation from digital signature
   * @return
   */
  private String approveTransaction(Integer amount, Integer limit, String transactionType,
      Boolean valid) {
    if (!valid) {
      return transactionType.concat(SPACE).concat(REJECTED);
    }
    if (amount <= limit) {
      return transactionType.concat(SPACE).concat(ACCEPTED);
    }
    return transactionType.concat(SPACE).concat(REJECTED);
  }

  @Override
  public int hashCode() {
    return CreditBankActivity.class.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof CreditBankActivity;
  }

  @Override
  public String toString() {
    return "CreditBankActivity{}";
  }
}
