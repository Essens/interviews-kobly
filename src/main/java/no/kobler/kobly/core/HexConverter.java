package no.kobler.kobly.core;

public class HexConverter {
  private static String ALPHABET = "0123456789abcdef";

  public static String toHex(int i) {
    StringBuilder stringBuilder = new StringBuilder();

    int rest = i;

    do {
      int remainder = rest % 16;
      stringBuilder.append(ALPHABET.toCharArray()[remainder]);
      rest = rest / 16;
    } while (rest > 0);

    return stringBuilder.reverse().toString();
  }

  public static int fromHex(String s) {
    int n = 0;
    int pos = 0;

    for (char c : new StringBuilder(s).reverse().toString().toCharArray()) {
      n += ALPHABET.indexOf(c) * 16 * pos;
      pos += 1;
    }

    return n;
  }
}
