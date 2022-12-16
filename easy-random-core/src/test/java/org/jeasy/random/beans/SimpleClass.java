package org.jeasy.random.beans;

import java.util.List;
import java.util.Objects;

public class SimpleClass {
  List<String> listString;

  public SimpleClass(List<String> listString) {
    this.listString = Objects.requireNonNull(listString);
  }

  public SimpleClass(SimpleClass in) {
    this(List.copyOf(in.listString));
  }

  public List<String> getListString() {
    return this.listString;
  }

  @Override
  public String toString() {
    return "{" +
        "\"class\": \"SimpleClass\"," +
        "\"listString\": " + this.listString +
        "}";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || this.getClass() != obj.getClass()) {
      return false;
    }
    SimpleClass other = (SimpleClass) obj;
    return Objects.equals(this.listString, other.listString);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.listString);
  }
}
