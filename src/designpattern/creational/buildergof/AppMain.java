package designpattern.creational.buildergof;

public class AppMain {
  public static void main(String[] args) {
    RoomDirector roomDirectorA = new RoomDirector(new BasicRoomSkeleton());
    Room typeA = roomDirectorA.createTypeARoom();
    System.out.println(typeA);

    RoomDirector roomDirectorB = new RoomDirector(new BasicRoomSkeleton());
    Room typeB = roomDirectorB.createTypeBRoom();
    System.out.println(typeB);
  }
}
