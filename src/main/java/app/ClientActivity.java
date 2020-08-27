package app;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The type Client activity.
 */
public class ClientActivity {

  /**
   * The constant RANDOM_INVALID.
   */
  protected static final int RANDOM_INVALID = 10000;
  /**
   * The constant RANDOM_VALID.
   */
  protected static final int RANDOM_VALID = 30000;
  /**
   * The constant MIN_AMOUNT.
   */
  protected static final int MIN_AMOUNT = 1;

  public ClientActivity() {
  }

  /**
   * Create client activity hash map.
   *
   * @param clientList the client list
   * @param fraction   the fraction
   * @return the hash map
   * @throws InvalidRangeException the invalid range exception
   */
  public HashMap<Integer, Signature> createClientActivity(ArrayList<Client> clientList,
      Integer fraction)
      throws InvalidRangeException {
    HashMap<Integer,Signature> output = new HashMap<>();
    int length = clientList.size();
    List<Integer> probability = RandomGenerator.createRandomInvalid(length,fraction);
    for (int i = 0; i < length; i++) {
      Client currentClient = clientList.get(i);
      Integer currentProbability = probability.get(i);
      if (currentProbability == 0){ // if probability is zero, just create random number
        BigInteger message = NumberAdapter.fromIntToBig(this.createRandomInvalid());
        BigInteger signature = NumberAdapter.fromIntToBig(this.createRandomInvalid());
        Signature invalidSignature = new Signature(message,signature); // make random signature
        output.put(currentClient.getId(),invalidSignature);
      } else { // otherwise create a digital signature
        Integer message = RandomGenerator.createRandomIntRange(MIN_AMOUNT, RANDOM_VALID);
        Signature validSignature = RSA.encrypt(message,currentClient.getPrivateKey()); // signature must be created
        output.put(currentClient.getId(),validSignature);
      }
    }
    return output;
  }

  /***
   * Helper method to create a random number in a range
   * @return an integer
   * @throws InvalidRangeException when range is set wrongly
   */
  private Integer createRandomInvalid() throws InvalidRangeException {
    return RandomGenerator.createRandomIntRange(
        MIN_AMOUNT,
        RANDOM_INVALID);
  }

  @Override
  public int hashCode() {
    return ClientActivity.class.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof ClientActivity;
  }

  @Override
  public String toString() {
    return "ClientActivity{}";
  }
}
