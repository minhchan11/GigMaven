package app;

import java.math.BigInteger;
import java.util.Objects;

/**
 * The type Key.
 */
public class Key {
  private BigInteger exponent;
  private BigInteger mod;

  /**
   * Instantiates a new Key.
   *
   * @param exponent the exponent
   * @param mod      the mod
   */
  public Key(BigInteger exponent, BigInteger mod) {
    this.exponent = exponent;
    this.mod = mod;
  }

  /**
   * Gets exponent.
   *
   * @return the exponent
   */
  public BigInteger getExponent() {
    return exponent;
  }

  /**
   * Gets mod.
   *
   * @return the mod
   */
  public BigInteger getMod() {
    return mod;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Key key = (Key) o;
    return Objects.equals(exponent, key.exponent) &&
        Objects.equals(mod, key.mod);
  }

  @Override
  public int hashCode() {
    return Objects.hash(exponent, mod);
  }

  @Override
  public String toString() {
    return "Key{" +
        "exponent=" + exponent +
        ", mod=" + mod +
        '}';
  }
}
