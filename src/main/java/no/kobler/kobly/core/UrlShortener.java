package no.kobler.kobly.core;

<<<<<<< HEAD
import java.util.Optional;

public class UrlShortener {
  public String shorten(String url) {
    return "";
  }

  public Optional<String> findUrl(String id) {
    return Optional.empty();
  }
}

=======
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class UrlShortener {
  private static AtomicInteger idGenerator = new java.util.concurrent.atomic.AtomicInteger();
  private Map<Integer, String> store = new HashMap<>();

  public String shorten(String url) {
    Integer id = idGenerator.incrementAndGet();

    String base62EncodedId = Integer.toString(id, 26);

    store.put(id, url);

    return base62EncodedId;
  }

  public Optional<String> findUrl(String id) {
    return Optional.ofNullable(store.get(Integer.valueOf(id, 26)));
  }
}
>>>>>>> Simple in-memory shortener
