package designpattern.creational.simplefactory;

public class Dog implements Pet{
  @Override
  public String sound() {
    return "멍멍";
  }
}
