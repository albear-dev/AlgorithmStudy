package designpattern.creational.factorymethod;

public class AppMain {
  public static void main(String[] args) {
    UserFactory kakaoUserFactory = new KakaoUserFactory();
    User kakaoUser = kakaoUserFactory.newInstance();
    kakaoUser.signup();

    UserFactory naverUserFactory = new NaverUserFactory();
    User naverUser = naverUserFactory.newInstance();
    naverUser.signup();

  }
}
