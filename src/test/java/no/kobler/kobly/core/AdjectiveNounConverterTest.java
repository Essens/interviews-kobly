package no.kobler.kobly.core;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class AdjectiveNounConverterTest {
@Test
public void testToWords() {
    //assertThat(AdjectiveNounConverter.toWords(0)).isEqualTo("DaringFish");
    assertThat(AdjectiveNounConverter.toWords(0)).isEqualTo("Daring-Plump-Sleepy-Cheetah");
    assertThat(AdjectiveNounConverter.toWords(1)).isEqualTo("Daring-Plump-Sleepy-Platypus");
    assertThat(AdjectiveNounConverter.toWords(2)).isEqualTo("Daring-Plump-Sleepy-Lion");
    assertThat(AdjectiveNounConverter.toWords(4)).isEqualTo("Daring-Plump-Hangry-Cheetah");
    }

@Test
public void testToInt() {
    assertThat(AdjectiveNounConverter.fromWords("Daring-Plump-Sleepy-Cheetah")).isEqualTo(0);
    assertThat(AdjectiveNounConverter.fromWords("Daring-Plump-Hangry-Cheetah")).isEqualTo(4);
    }
    }