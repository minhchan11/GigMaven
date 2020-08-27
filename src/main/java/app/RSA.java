package app;

// refer from https://introcs.cs.princeton.edu/java/99crypto/RSA.java.html,
// https://scanftree.com/programs/java/implementation-of-rsa-algorithmencryption-and-decryption-in-java/
// https://www.nayuki.io/page/java-biginteger-was-made-for-rsa-cryptography

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * The type Rsa.
 */
public class RSA {

  /**
   * The constant GREATER.
   */
  protected static final int GREATER = 1;
  /**
   * The constant LESS_THAN.
   */
  protected static final int LESS_THAN = -1;
  private static final int BIT_LENGTH = 10; // to convert to Integer later on
  private final static BigInteger ONE = BigInteger.ONE;
  private final static SecureRandom RANDOM = new SecureRandom();
  private final Key publicKey;
  private final Key privateKey;

  /**
   * Instantiates a new Rsa.
   */
  public RSA() {
    // Generate p and q
    BigInteger p = BigInteger.probablePrime(BIT_LENGTH,RANDOM);
    BigInteger q = BigInteger.probablePrime(BIT_LENGTH,RANDOM);

    // Generate n
    BigInteger n = p.multiply(q);

    // Generate p-1, q-1 and phi
    BigInteger p_min_1 = p.subtract(ONE);
    BigInteger q_min_1 = q.subtract(ONE);
    BigInteger phi = p_min_1.multiply(q_min_1);

    // Generate e,d
    BigInteger e;
    do {
      e = BigInteger.probablePrime(BIT_LENGTH,new SecureRandom());
    } while (((e.compareTo(phi))==LESS_THAN) && ((e.compareTo(ONE)) == GREATER) && ((e.gcd(phi).compareTo(ONE)) != 0));

    BigInteger d = e.modInverse(phi);

    // Output
    this.publicKey = new Key(e,n);
    this.privateKey = new Key(d,n);
  }

  /**
   * Gets public key.
   *
   * @return the public key
   */
  public Key getPublicKey() {
    return publicKey;
  }

  /**
   * Gets private key.
   *
   * @return the private key
   */
  public Key getPrivateKey() {
    return privateKey;
  }

  /**
   * Encrypt signature.
   *
   * @param message    the message
   * @param privateKey the private key
   * @return the signature
   */
  public static Signature encrypt(Integer message, Key privateKey){
    BigInteger originalMessage = NumberAdapter.fromIntToBig(message);
    BigInteger encryptedSignature = originalMessage.modPow(privateKey.getExponent(), privateKey.getMod());
    return new Signature(originalMessage,encryptedSignature);
  }

  /**
   * Verify boolean.
   *
   * @param encrypted the encrypted
   * @param publicKey the public key
   * @return the boolean
   */
  public static Boolean verify(Signature encrypted, Key publicKey){
    BigInteger decrypted = encrypted.getSignature().modPow(publicKey.getExponent(), publicKey.getMod());
    return decrypted.equals(encrypted.getMessage());
  }

}
