package designpattern.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class Monster implements Cloneable {
  private int hp;
  private int mp;
  private List<String> items;

  public Monster(int hp, int mp, List<String> items){
    this.hp = hp;
    this.mp = mp;
    this.items = items;
  }

  public int getHp(){
    return this.hp;
  }

  public int getMp(){
    return this.mp;
  }

  public void setHp(int hp){
    this.hp = hp;
  }

  public void setMp(int mp){
    this.mp = mp;
  }

  public List<String> getItems(){
    return this.items;
  }

  @Override
  public Monster clone() throws CloneNotSupportedException{
    return new Monster(this.hp, this.mp, new ArrayList<>(this.items));
  }

  @Override
	public String toString() {
		return "hp["+this.hp+"] mp["+this.mp+"] items["+this.items+"]";
	}
}
