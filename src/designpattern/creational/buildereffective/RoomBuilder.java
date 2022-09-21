package designpattern.creational.buildereffective;

import designpattern.creational.buildergof.Direction;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class RoomBuilder {
  private Floor floor;
  private Map<Direction, Wall> walls = new HashMap<>();
  private Map<Direction, Door> doors = new HashMap<>();
  private Map<Direction, Window> windows = new HashMap<>();

  public RoomBuilder() {
    this.floor = new Floor();
  }

  public RoomBuilder buildWalls(Direction direction) {
    this.walls.put(direction, new Wall());
    return this;
  }

  public RoomBuilder buildDoors(Direction direction) {
    this.doors.put(direction, new Door());
    return this;
  }

  public RoomBuilder buildWindows(Direction direction) {
    this.windows.put(direction, new Window());
    return this;
  }

  public Floor getFloor() {
    return floor;
  }

  public Map<Direction, Wall> getWalls() {
    return walls;
  }

  public Map<Direction, Door> getDoors() {
    return doors;
  }

  public Map<Direction, Window> getWindows() {
    return windows;
  }

  public Room build() {
    return new Room(this);
  }
}