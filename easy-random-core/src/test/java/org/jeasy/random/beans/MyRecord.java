package org.jeasy.random.beans;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public record MyRecord(String id, Optional<String> description, MyReferencedRecord ref,
                       Byte counter, List<String> listString, DayOfWeek day) {
  
  public MyRecord(String id, Optional<String> description, MyReferencedRecord ref,
      Byte counter, List<String> listString, DayOfWeek day) {
    this.id = Objects.requireNonNull(id);
    this.description = description;
    this.ref = Objects.requireNonNull(ref);
    this.counter = counter;
    this.listString = Objects.requireNonNull(listString);
    this.day = day;
  }

  public MyRecord(MyRecord in) {
    this(in.id, 
        Optional.ofNullable(in.description.orElse(null)), 
        new MyReferencedRecord(in.ref), 
        Byte.valueOf(in.counter), 
        List.copyOf(in.listString),
        in.day);
  }
}
