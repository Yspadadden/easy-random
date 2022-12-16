package org.jeasy.random.beans;

import java.util.List;
import java.util.Objects;

public record SimpleRecord(String id, List<String> listString) {

  public SimpleRecord(String id, List<String> listString) {
    this.id = id;
    this.listString = Objects.requireNonNull(listString);
  }

  public SimpleRecord(SimpleRecord in) {
    this(in.id, List.copyOf(in.listString));
  }
}
