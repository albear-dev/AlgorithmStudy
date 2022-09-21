package designpattern.creational.factorymethod;

public class NaverUser implements User {
  @Override
  public void signup() {
    System.out.println("네이버 가입");
  }
}
