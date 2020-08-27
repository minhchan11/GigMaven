package app;


import java.math.BigInteger;

/**
 * The type Number adapter.
 */
public class NumberAdapter {

  /**
   * From big to integer.
   *
   * @param bigInt the big int
   * @return the integer
   */
  public static Integer fromBigToInt(BigInteger bigInt){
    return bigInt.intValue();
  }

  /**
   * From int to big integer.
   *
   * @param integer the integer
   * @return the big integer
   */
  public static BigInteger fromIntToBig(Integer integer){
    return BigInteger.valueOf(integer);
  }

  /**
   * From string to int integer.
   *
   * @param integer the integer
   * @return the integer
   */
  public static Integer fromStringToInt(String integer){
    return Integer.valueOf(integer);
  }

}
