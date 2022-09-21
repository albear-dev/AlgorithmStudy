package designpattern.creational.simplefactory;

public interface Pet {
  enum Type{
    CAT, DOG
  }

  public String sound();
}
