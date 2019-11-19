package no.kobler.kobly.core;

import com.google.common.base.Joiner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdjectiveNounConverter {
  public static int BITS = 2;
  public static int BIT_MASK = 0b11;
  private static List<String> ADJECTIVES1 = Arrays.asList("Daring", "Dashing", "Fabulous", "Rich");
  private static List<String> ADJECTIVES2 = Arrays.asList("Plump", "Peachy", "Scrappy", "Bald");
  private static List<String> ADJECTIVES3 = Arrays.asList("Sleepy", "Hangry", "Creepy", "Birdlike");
  private static List<String> NOUNS = Arrays.asList("Cheetah", "Platypus", "Lion", "Giraffe");

  public static String toWords(int number) {
    ArrayList<String> words = new ArrayList<>();

    words.add(ADJECTIVES1.get((number >> (BITS * 3)) & BIT_MASK));
    words.add(ADJECTIVES2.get((number >> (BITS * 2)) & BIT_MASK));
    words.add(ADJECTIVES3.get((number >> BITS) & BIT_MASK));
    words.add(NOUNS.get(number & BIT_MASK));

    return Joiner.on("-").join(words);
  }

  public static int fromWords(String s) {
    String[] words = s.split("-");

    return
        (ADJECTIVES1.indexOf(words[0]) << (BITS * 3)) +
        (ADJECTIVES2.indexOf(words[1]) << (BITS * 2)) +
        (ADJECTIVES3.indexOf(words[2]) << BITS) +
            NOUNS.indexOf(words[3]);
  }
}
