package designpattern.creational.buildergof;

public interface RoomBuilder {
  void buildFloor();                       // 바닥 생성
  void buildDoor(Direction direction);     // 문 생성
  Room build();                            // 최종적으로 '방' 빌드
}
