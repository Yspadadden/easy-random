package org.jeasy.random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.nio.charset.StandardCharsets;

import org.jeasy.random.beans.MyClass;
import org.jeasy.random.beans.MyRecord;
import org.jeasy.random.beans.SimpleClass;
import org.jeasy.random.beans.SimpleRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class EasyRandomRecordTest {

  protected EasyRandom easyRandom;

  @BeforeEach
  void setupEasyRandomInstance() {
    EasyRandomParameters randomParameters = new EasyRandomParameters()
        .seed(System.nanoTime())
        .objectPoolSize(100)
        .charset(StandardCharsets.UTF_8)
        .stringLengthRange(5, 50)
        .collectionSizeRange(1, 10)
        .scanClasspathForConcreteTypes(true)
        .overrideDefaultInitialization(true)
        .ignoreRandomizationErrors(false)        ;
    this.easyRandom = new EasyRandom(randomParameters);
  }

  @RepeatedTest(10)
  void usingEasyRandomWithRecords() {
    var myRecord = this.easyRandom.nextObject(MyRecord.class);
    assertAll(
        () -> assertThat(myRecord).isEqualTo(new MyRecord(myRecord)),
        () -> assertThat(myRecord.description()).isPresent(),
        () -> assertThat(myRecord.listString()).isNotEmpty()
    );
  }

  @RepeatedTest(1)
  void usingEasyRandomWithClasses() {
    var myClass = this.easyRandom.nextObject(MyClass.class);
    assertAll(
        () -> assertThat(myClass).isEqualTo(new MyClass(myClass)),
        () -> assertThat(myClass.getOptInteger()).isPresent(),
        () -> assertThat(myClass.getListString()).isNotEmpty()
    );
  }

  @RepeatedTest(10)
  void usingEasyRandomWithSimpleRecord() {
    var simpleRecord = this.easyRandom.nextObject(SimpleRecord.class);
    assertAll(
        () -> assertThat(simpleRecord).isEqualTo(new SimpleRecord(simpleRecord)),
        () -> assertThat(simpleRecord.id()).isNotNull(),
        () -> assertThat(simpleRecord.listString()).isNotEmpty()
    );
  }

  @RepeatedTest(1)
  void usingEasyRandomWithSimpleClass() {
    var simpleClass = this.easyRandom.nextObject(SimpleClass.class);
    assertAll(
        () -> assertThat(simpleClass).isEqualTo(new SimpleClass(simpleClass)),
        () -> assertThat(simpleClass.getListString()).isNotEmpty()
    );
  }
}