package by.hayel.data.structure.queue.model.util;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FirstLastLink {
  int data;
  FirstLastLink next;

  public FirstLastLink(int data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return String.format("FirstLastLink {%d}", data);
  }
}
