package designpattern.creational.buildergof;

import designpattern.creational.buildereffective.Door;
import designpattern.creational.buildereffective.Floor;

import java.util.Map;

public class Room {

  private Floor floor;
  private Map<Direction, Door> doors;

  // 바닥과 벽들, 문들, 창문들로 방을 생성
  public Room(Floor floor, Map<Direction, Door> doors) {
    this.floor = floor;
    this.doors = doors;
  }

  @Override
  public String toString(){
    return floor.toString() + doors.toString();
  }
}