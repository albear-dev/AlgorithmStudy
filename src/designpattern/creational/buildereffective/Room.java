package designpattern.creational.buildereffective;

import designpattern.creational.buildergof.Direction;

import java.util.Map;

public class Room {

  private Floor floor;
  private Map<Direction, Wall> walls;
  private Map<Direction, Door> doors;
  private Map<Direction, Window> windows;

  // 빌더로 필드 세팅
  public Room(RoomBuilder roomBuilder) {
    this.floor = roomBuilder.getFloor();
    this.walls = roomBuilder.getWalls();
    this.doors = roomBuilder.getDoors();
    this.windows = roomBuilder.getWindows();
  }

  // 출력을 위함
  @Override
  public String toString() {
    StringBuffer buffer = new StringBuffer(floor.toString()).append("\n");
    for (Direction direction : walls.keySet()) {
      buffer.append(direction.getValue()).append("쪽의 ").append(walls.get(direction).toString()).append("\n");
    }
    for (Direction direction : doors.keySet()) {
      buffer.append(direction.getValue()).append("쪽의 ").append(doors.get(direction).toString()).append("\n");
    }
    for (Direction direction : windows.keySet()) {
      buffer.append(direction.getValue()).append("쪽의 ").append(windows.get(direction).toString()).append("\n");
    }
    return buffer.toString();
  }
}