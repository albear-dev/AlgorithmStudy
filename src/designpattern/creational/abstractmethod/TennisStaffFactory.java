package designpattern.creational.abstractmethod;

public class TennisStaffFactory implements StaffFactory {
  @Override
  public Manager createManager() {
    return new TennisManager();
  }

  @Override
  public Player createPlayer() {
    return new TennisPlayer();
  }
}
