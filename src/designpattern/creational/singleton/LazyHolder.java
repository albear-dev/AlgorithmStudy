package designpattern.creational.singleton;


public class LazyHolder {
    private LazyHolder(){}

    private static class SingletonHelper{
        private static final LazyHolder INSTANCE = new LazyHolder();
    }

    public static LazyHolder getInstance(){
        return SingletonHelper.INSTANCE;
    }
}