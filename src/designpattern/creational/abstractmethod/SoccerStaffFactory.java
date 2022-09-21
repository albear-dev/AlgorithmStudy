package designpattern.creational.abstractmethod;

public class SoccerStaffFactory implements StaffFactory {
  @Override
  public Manager createManager() {
    return new SoccerManager();
  }

  @Override
  public Player createPlayer() {
    return new SoccerPlayer();
  }
}
