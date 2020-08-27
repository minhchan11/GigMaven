package app;

import java.util.Objects;

/**
 * The type Client.
 */
public class Client {
  private final Integer id;
  private final Key publicKey;
  private final Key privateKey;

  /**
   * Instantiates a new Client.
   *
   * @param id the id
   */
  public Client(Integer id) {
    this.id = id;
    RSA rsa = new RSA();
    this.publicKey = rsa.getPublicKey();
    this.privateKey = rsa.getPrivateKey();
  }

  /**
   * Gets id.
   *
   * @return the id
   */
  public Integer getId() {
    return id;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Client client = (Client) o;
    return Objects.equals(id, client.id); // since ID is unique and key is random
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  } // since ID is unique and key is random

  @Override
  public String toString() {
    return "Client{" +
        "id=" + id +
        '}';
  }
}
