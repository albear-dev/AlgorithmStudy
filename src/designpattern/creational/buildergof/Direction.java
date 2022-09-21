package designpattern.creational.buildergof;

public enum Direction {
  NORTH("남"), SOUTH("북"), EAST("동"), WEST("서");
  private String value;

  Direction(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
