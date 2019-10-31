package no.kobler.kobly.core;

import static org.assertj.core.api.Assertions.assertThat;

<<<<<<< HEAD
<<<<<<< HEAD
import java.util.Optional;
=======
>>>>>>> Simple in-memory shortener
=======
import java.util.Optional;
>>>>>>> With hex converter
import org.junit.Test;

public class UrlShortenerTest {
  @Test
  public void testUrlIsShortened() {
    UrlShortener urlShortener = new UrlShortener();

    String url = "http://this.is.a.long.url";
    assertThat(urlShortener.shorten(url).length()).isLessThan(url.length());
  }

  @Test
  public void testShortenedIdCanBeUsedToRetrieveOriginalUrl() {
    UrlShortener urlShortener = new UrlShortener();

    String url = "http://this.is.a.long.url";
    String shortened = urlShortener.shorten(url);
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> With hex converter
    Optional<String> result = urlShortener.findUrl(shortened);
    assertThat(result).isPresent();
    assertThat(result.get()).isEqualTo(url);
  }

  @Test
  public void testSameUrlGivesDifferentShortenedLinks() {
    UrlShortener urlShortener = new UrlShortener();

    String url = "http://this.is.a.long.url";
    String shortened1 = urlShortener.shorten(url);
    String shortened2 = urlShortener.shorten(url);
    assertThat(urlShortener.findUrl(shortened1).get()).isEqualTo(url);
    assertThat(urlShortener.findUrl(shortened2).get()).isEqualTo(url);
    assertThat(shortened1).isNotEqualTo(shortened2);
<<<<<<< HEAD
=======
    assertThat(urlShortener.findUrl(shortened).get()).isEqualTo(url);
>>>>>>> Simple in-memory shortener
=======
>>>>>>> With hex converter
  }
}