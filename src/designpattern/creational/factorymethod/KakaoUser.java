package designpattern.creational.factorymethod;

public class KakaoUser implements User{
  @Override
  public void signup() {
    System.out.println("카카오 가입");
  }
}
