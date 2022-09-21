package designpattern.creational.abstractmethod;

public class AppMain {
  public static void main(String[] args) {
    use(new SoccerStaffFactory());
    use(new TennisStaffFactory());
  }

  private static void use(StaffFactory factory) {
    Manager manager = factory.createManager();
    Player player = factory.createPlayer();
  }
}
