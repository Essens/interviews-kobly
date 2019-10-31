package no.kobler.kobly.core;

import com.google.common.base.Joiner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DictionaryConverter {
  private static List<String> DICTIONARY = Arrays.asList("Omega", "Alpha", "Beta", "Delta");

  public static String toWord(int i) {
    ArrayList<String> words = new ArrayList<>();

    int rest = i;

    do {
      int remainder = rest % 4;
      words.add(0, DICTIONARY.get(remainder));
      rest = rest / 4;
    } while (rest > 0);

    return Joiner.on("").join(words);
  }

  public static int fromWord(String s) {
    String[] words = s.split("\\p{Upper}");
    int n = 0;
    int pos = 0;

    for (int i = words.length; i >= 0; i--) {
      n += DICTIONARY.indexOf(words[i - 1]) * 4 * pos;
      pos += 1;
    }

    return n;
  }
}
