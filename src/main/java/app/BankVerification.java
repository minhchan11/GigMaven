package app;

import static app.ConstantsUtils.INVALID;
import static app.ConstantsUtils.VALID;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * The type CreditBank verification.
 */
public class BankVerification {

  protected static final int INITIAL_VALUE = 1;

  public BankVerification() {
  }

  /**
   * Verify transaction array list.
   *
   * @param toVerify the to verify
   * @return the array list
   */
  public ArrayList<List<String>> verifyTransaction(HashMap<Integer, Signature> toVerify) {
    AtomicInteger transactionNumber = new AtomicInteger(INITIAL_VALUE);
    return toVerify.entrySet().stream().map(
        transaction -> verifyOneTransaction(transaction.getKey(), transaction.getValue(),
            transactionNumber.getAndIncrement())).collect(Collectors.toCollection(ArrayList::new));
  }

  /***
   * Helper method to verify one transaction
   * @param clientId id of client
   * @param customerSignature signature created by simulator
   * @param transactionNumber get current transaction number
   * @return a List of string that has all information
   */
  private List<String> verifyOneTransaction(Integer clientId,Signature customerSignature, Integer transactionNumber){
    CreditBank currentCreditBank = CreditBank.getInstance();
    Integer message = NumberAdapter.fromBigToInt(customerSignature.getMessage());
    Integer digitalSignature = NumberAdapter.fromBigToInt(customerSignature.getSignature());

    // Get info from bank
    List<Integer> customerInfo = currentCreditBank.getCustomerInfo().get(clientId);
    ListIterator<Integer> customerInfoIterator = customerInfo.listIterator();
    BigInteger publicKeyExponent = NumberAdapter.fromIntToBig(customerInfoIterator.next());
    BigInteger publicKeyModulus = NumberAdapter.fromIntToBig(customerInfoIterator.next());
    Integer depositLimit = customerInfoIterator.next();
    Integer withdrawalLimit = customerInfoIterator.next();

    // verify and create entry only from bank side
    Key publicKey = new Key(publicKeyExponent,publicKeyModulus);
    Boolean valid = RSA.verify(customerSignature,publicKey);
    CreditBankActivity processor = new CreditBankActivity();
    String result = processor.processTransaction(message,depositLimit,withdrawalLimit,valid);
    ReportBuilder newReport = new ReportBuilder(transactionNumber,clientId,message,digitalSignature,valid,result);
    return newReport.makeRecord();
  }

  @Override
  public int hashCode() {
    return BankVerification.class.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof BankVerification;
  }

  @Override
  public String toString() {
    return "BankVerification{}";
  }

  /***
   * Helper builder class
   */
  private static class ReportBuilder{
    private final Integer transactionNumber;
    private final LocalDate date;
    private final LocalTime time;
    private final Integer clientId;
    private final Integer message;
    private final Integer digitalSignature;
    private final Boolean verified;
    private final String transactionStatus;

    /**
     * Instantiates a new Report builder.
     *
     * @param transactionNumber the transaction number
     * @param clientId          the client id
     * @param message           the message
     * @param digitalSignature  the digital signature
     * @param verified          the verified
     * @param transactionStatus the transaction status
     */
    public ReportBuilder(Integer transactionNumber, Integer clientId, Integer message,
        Integer digitalSignature, Boolean verified, String transactionStatus) {
      this.transactionNumber = transactionNumber;
      this.date = LocalDate.now();
      this.time = LocalTime.now();
      this.clientId = clientId;
      this.message = message;
      this.digitalSignature = digitalSignature;
      this.verified = verified;
      this.transactionStatus = transactionStatus;
    }

    /**
     * Make record list.
     *
     * @return the list
     */
    public List<String> makeRecord() {
      String record = transactionNumber +
          "," + date +
          "," + convertTime(time) +
          "," + clientId +
          "," + message +
          "," + digitalSignature +
          "," + convertBoolean(verified) +
          "," + transactionStatus;
      List<String> singleEntry = new ArrayList<>();
      singleEntry.add(record);
      return singleEntry;
    }

    /***
     * Helper class to build string for boolean
     * @param valid boolean
     * @return string yes or no
     */
    private String convertBoolean(Boolean valid){
      if (valid){
        return VALID;
      }
      return INVALID;
    }

    /***
     * Helper class to convert time to readable format
     * @param time local time
     * @return string time
     */
    private String convertTime(LocalTime time) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
      return formatter.format(time);
    }
  }


}
