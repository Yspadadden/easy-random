package org.jeasy.random.beans;

import java.util.Objects;
import java.util.Optional;

public record MyReferencedRecord(String id, Optional<String> someText) {

  public MyReferencedRecord(String id, Optional<String> someText) {
    this.id = Objects.requireNonNull(id);
    this.someText = someText;
  }

  public MyReferencedRecord(MyReferencedRecord ref) {
    this(ref.id, Optional.ofNullable(ref.someText.orElse(null)));
  }
}