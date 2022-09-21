package designpattern.creational.buildergof;

import designpattern.creational.buildereffective.Door;
import designpattern.creational.buildereffective.Floor;

import java.util.HashMap;
import java.util.Map;

public class BasicRoomSkeleton implements RoomBuilder {

  private Floor floor;
  private Map<Direction, Door> doors = new HashMap<>();

  @Override
  public void buildFloor() {
    floor = new Floor();
  }


  @Override
  public void buildDoor(Direction direction) {
    doors.put(direction, new Door());
  }

  @Override
  public Room build() {
    return new Room(floor, doors);
  }
}
