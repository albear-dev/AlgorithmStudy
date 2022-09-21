package designpattern.creational.factorymethod;

public abstract class UserFactory {
  public User newInstance() {
    User user = createUser();
    user.signup();
    return user;
  }

  protected abstract User createUser();
}
