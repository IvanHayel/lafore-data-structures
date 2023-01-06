package by.hayel.data.structure.graph.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Vertex {
  char label;
  boolean isVisited;

  public Vertex(char label) {
    this.label = label;
    isVisited = false;
  }

  @Override
  public String toString() {
    return String.format("Vertex {%c}", label);
  }
}
