package designpattern.creational.singleton;

public class ThreadSafeDoubleCheckSingleton {
  private static ThreadSafeDoubleCheckSingleton instance;
  private ThreadSafeDoubleCheckSingleton(){}

  public static ThreadSafeDoubleCheckSingleton getInstance(){
    if(instance == null){
      synchronized(ThreadSafeDoubleCheckSingleton.class){
        if(instance == null){
          instance = new ThreadSafeDoubleCheckSingleton();
        }
      }
    }
    return instance;
  }
}
