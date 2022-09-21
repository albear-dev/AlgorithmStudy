package designpattern.creational.simplefactory;

public class AppMain {
  public static void main(String[] args) throws Exception {
    PetFactory factory = new PetFactory();
    Pet cat = factory.createPet(Pet.Type.CAT);
    Pet dog = factory.createPet(Pet.Type.DOG);

    System.out.println(cat.sound());
    System.out.println(dog.sound());
  }
}

