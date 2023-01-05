package by.hayel.data.structure.hash.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Link {
  int key;
  Link next;

  public Link(int key) {
    this.key = key;
  }

  @Override
  public String toString() {
    return String.format("Link [key=%s]", key);
  }
}
