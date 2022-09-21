package designpattern.creational.simplefactory;

public class PetFactory {

    public Pet createPet(Pet.Type petType) {
      return switch (petType) {
        case CAT -> new Cat();
        case DOG -> new Dog();
        default -> throw new IllegalArgumentException("Pet 타입이 아닙니다");
      };
    }
}
