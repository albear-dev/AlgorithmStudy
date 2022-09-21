package designpattern.creational.prototype;

import java.util.List;

public class AppMain {
  public static void main(String[] args) throws Exception {
    Monster monster = new Monster(10, 10, List.of("Knife"));

    System.out.println(monster);

    Monster newMonster = monster.clone();
    newMonster.setHp(50);
    newMonster.getItems().add("Shield");

    System.out.println(newMonster);

  }
}
