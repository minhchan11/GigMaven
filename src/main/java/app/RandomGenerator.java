package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The type Random generator.
 */
public class RandomGenerator {

  /**
   * The constant OFFSET.
   */
  protected static final int OFFSET = 5;
  /**
   * The constant SUCCESS.
   */
  protected static final int SUCCESS = 100;
  /**
   * The constant SUCCESS_MARKER.
   */
  protected static final int SUCCESS_MARKER = 1;

  /**
   * Create random int range int.
   *
   * @param min the min
   * @param max the max
   * @return the int
   * @throws InvalidRangeException the invalid range exception
   */
  public static int createRandomIntRange(int min, int max) throws InvalidRangeException {
    if (max <= min){
        throw new InvalidRangeException("Range is invalid, max must be greater or equal than min");
    }
    Random random = new Random();
    return random.nextInt((max-min)+ SUCCESS_MARKER) + min;
  }

  /**
   * Create random id list.
   *
   * @param size the size
   * @return the list
   */
  public static List<Integer> createRandomID(int size){
    int offset = size * OFFSET; // ID are not consecutive to prevent guessing
    List<Integer> possibilities = IntStream.range(SUCCESS_MARKER, offset).boxed().collect(Collectors.toCollection(
        ArrayList::new));
    Collections.shuffle(possibilities);
    return possibilities.subList(0,size);
  }

  /**
   * Create random invalid list.
   *
   * @param size     the size
   * @param fraction the fraction
   * @return the list
   */
  public static List<Integer> createRandomInvalid(int size, int fraction){
    int[] transactions = new int[size];
    if (fraction == SUCCESS) {
      Arrays.fill(transactions, SUCCESS_MARKER);
    } else if (fraction > 0 && fraction < SUCCESS) {
      double endIndex = size * ((SUCCESS - fraction)/(double) SUCCESS);
      Arrays.fill(transactions,0,(int)endIndex, SUCCESS_MARKER);
    }
    List<Integer> output = Arrays.stream(transactions).boxed().collect(Collectors.toList());
    if (fraction > 0 && fraction < SUCCESS){
      Collections.shuffle(output);
    }
    return output;
  }
}
