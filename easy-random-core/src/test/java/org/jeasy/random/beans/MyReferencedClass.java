package org.jeasy.random.beans;

import java.util.Objects;

public class MyReferencedClass {
  String id;

  public MyReferencedClass(String id) {
    this.id = id;
  }

  public MyReferencedClass(MyReferencedClass in) {
    this(in.id);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || this.getClass() != obj.getClass()) {
      return false;
    }
    MyReferencedClass other = (MyReferencedClass) obj;
    return Objects.equals(this.id, other.id)
        ;
  }

  @Override public int hashCode() {
    return Objects.hash(this.id);
  }

  @Override public String toString() {
    return "{" +
        "\"class\": \"MyReferencedClass\"," +
        "\"id\": \"" + this.id + "\"" +
        "}";
  }
}
