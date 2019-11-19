package no.kobler.kobly.core;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class HexConverterTest {
  @Test
  public void testToHex() {
    assertThat(HexConverter.toHex(0)).isEqualTo("0");
    assertThat(HexConverter.toHex(1)).isEqualTo("1");
    assertThat(HexConverter.toHex(15)).isEqualTo("f");
    assertThat(HexConverter.toHex(16)).isEqualTo("10");
    assertThat(HexConverter.toHex(17)).isEqualTo("11");
    assertThat(HexConverter.toHex(255)).isEqualTo("ff");
    assertThat(HexConverter.toHex(256)).isEqualTo("100");
  }

  @Test
  public void testFromHex() {
    assertThat(HexConverter.fromHex("0")).isEqualTo(0);
    assertThat(HexConverter.fromHex("1")).isEqualTo(1);
    assertThat(HexConverter.fromHex("f")).isEqualTo(15);
    assertThat(HexConverter.fromHex("10")).isEqualTo(16);
    assertThat(HexConverter.fromHex("ff")).isEqualTo(255);
    assertThat(HexConverter.fromHex("100")).isEqualTo(256);
  }
}