package designpattern.creational.buildergof;

public class RoomDirector {

  private RoomBuilder builder;

  public RoomDirector(RoomBuilder builder) {
    this.builder = builder;
  }

  public Room createTypeARoom() {
    builder.buildFloor();
    builder.buildDoor(Direction.SOUTH);

    return builder.build();
  }

  public Room createTypeBRoom() {
    builder.buildFloor();
    builder.buildDoor(Direction.NORTH);

    return builder.build();
  }

}