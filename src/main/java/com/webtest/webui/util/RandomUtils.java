package com.webtest.webui.util;

import java.util.Random;

public class RandomUtils
{
  private static final Random RANDOM = new Random();

  public static byte[] nextBytes(int count)
  {
    byte[] result = new byte[count];
    RANDOM.nextBytes(result);
    return result;
  }

  public static int nextInt(int startInclusive, int endExclusive)
  {
    if (startInclusive == endExclusive) {
      return startInclusive;
    }

    return startInclusive + RANDOM.nextInt(endExclusive - startInclusive);
  }

  public static int nextInt(int n) {
    return nextInt(0, n);
  }

  public static long nextLong(long startInclusive, long endExclusive)
  {
    if (startInclusive == endExclusive) {
      return startInclusive;
    }

    return (long)nextDouble(startInclusive, endExclusive);
  }

  public static double nextDouble(double startInclusive, double endInclusive)
  {
    if (startInclusive == endInclusive) {
      return startInclusive;
    }

    return startInclusive + (endInclusive - startInclusive) * RANDOM.nextDouble();
  }

  public static float nextFloat(float startInclusive, float endInclusive)
  {
    if (startInclusive == endInclusive) {
      return startInclusive;
    }

    return startInclusive + (endInclusive - startInclusive) * RANDOM.nextFloat();
  }
}