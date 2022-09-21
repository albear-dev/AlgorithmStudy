package designpattern.creational.buildereffective;

import designpattern.creational.buildergof.Direction;

public class AppMain {
  public static void main(String[] args) {
    Room roomA = new RoomBuilder()
        .buildWalls(Direction.EAST)
        .buildWalls(Direction.WEST)
        .buildWalls(Direction.SOUTH)
        .buildWindows(Direction.SOUTH)
        .build();

    System.out.println(roomA);

    Room roomB = new RoomBuilder()
        .buildWalls(Direction.EAST)
        .buildWalls(Direction.WEST)
        .buildWalls(Direction.NORTH)
        .buildWalls(Direction.SOUTH)
        .buildDoors(Direction.NORTH)
        .buildWindows(Direction.EAST)
        .buildWindows(Direction.WEST)
        .buildWindows(Direction.NORTH)
        .buildWindows(Direction.SOUTH)
        .build();

    System.out.println(roomB);
  }
}
