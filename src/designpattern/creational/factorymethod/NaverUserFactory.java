package designpattern.creational.factorymethod;

public class NaverUserFactory extends UserFactory {
  @Override
  protected User createUser() {
    return new NaverUser();
  }
}
