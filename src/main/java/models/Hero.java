package models;
public class Hero {
    String name;
    int age;
    String ability;
    String weakness;
    public Hero(String name,int age,String ability,String weakness){
      this.name = name;
      this.age = age;
      this.ability= ability;
      this.weakness = weakness;
    }
   public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public String getAbility(){
        return this.ability;
    }
    public String getWeakness(){
        return this.weakness;
    }

    public static void clearAll() {
    }
}
