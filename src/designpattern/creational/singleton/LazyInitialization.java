package designpattern.creational.singleton;

public class LazyInitialization {
  private static LazyInitialization instance;

  // 생성자 호출을 막는다.
  private LazyInitialization(){}

  public static LazyInitialization getInstance(){
    if(instance == null) instance = new LazyInitialization();
    return instance;
  }
}
