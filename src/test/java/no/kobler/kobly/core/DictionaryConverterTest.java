package no.kobler.kobly.core;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class DictionaryConverterTest {
  @Test
  public void testToWords() {
    assertThat(DictionaryConverter.toWord(0)).isEqualTo("Omega");
    assertThat(DictionaryConverter.toWord(1)).isEqualTo("Alpha");
    assertThat(DictionaryConverter.toWord(2)).isEqualTo("Beta");
    assertThat(DictionaryConverter.toWord(3)).isEqualTo("Delta");
    assertThat(DictionaryConverter.toWord(4)).isEqualTo("AlphaOmega");
    assertThat(DictionaryConverter.toWord(8)).isEqualTo("BetaOmega");
    assertThat(DictionaryConverter.toWord(9)).isEqualTo("BetaAlpha");
  }

  @Test
  public void testFromWords() {
    assertThat(DictionaryConverter.fromWord("Omega")).isEqualTo(0);
    assertThat(DictionaryConverter.fromWord("Alpha")).isEqualTo(1);
    assertThat(DictionaryConverter.fromWord("Beta")).isEqualTo(2);
    assertThat(DictionaryConverter.fromWord("Delta")).isEqualTo(3);
    assertThat(DictionaryConverter.fromWord("AlphaOmega")).isEqualTo(4);
    assertThat(DictionaryConverter.fromWord("BetaOmega")).isEqualTo(8);
    assertThat(DictionaryConverter.fromWord("BetaAlpha")).isEqualTo(9);
  }
}