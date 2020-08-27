package app;

import java.math.BigInteger;
import java.util.Objects;

/**
 * The type Signature.
 */
public class Signature {
  private final BigInteger message;
  private final BigInteger signature;

  /**
   * Instantiates a new Signature.
   *
   * @param message   the message
   * @param signature the signature
   */
  public Signature(BigInteger message, BigInteger signature) {
    this.message = message;
    this.signature = signature;
  }

  /**
   * Gets message.
   *
   * @return the message
   */
  public BigInteger getMessage() {
    return message;
  }

  /**
   * Gets signature.
   *
   * @return the signature
   */
  public BigInteger getSignature() {
    return signature;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Signature signature1 = (Signature) o;
    return Objects.equals(message, signature1.message) &&
        Objects.equals(signature, signature1.signature);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, signature);
  }

  @Override
  public String toString() {
    return "Signature{" +
        "message=" + message +
        ", signature=" + signature +
        '}';
  }
}
