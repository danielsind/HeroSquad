package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String name;
    private int id;
    private static List<Hero> instances = new ArrayList<>();
    private int age;
    private String ability;
    private String weakness;
    private boolean created = false;
    private LocalDateTime createdAt;

    public Hero(String name, int age, String ability, String weakness){
      this.name = name;
      this.age = age;
      this.ability= ability;
      this.weakness = weakness;
      instances.add(this);
      this.id=instances.size();
      this.created = false;
      this.createdAt = LocalDateTime.now();
    }
   public String getName(){
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge(){
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getAbility(){
        return this.ability;
    }
    public void setAbility(String ability) {
        this.ability = ability;
    }
    public String getWeakness(){
        return this.weakness;
    }
    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public static List<Hero> getInstances() {
        return instances;
    }
    public static void setInstances(List<Hero> instances) {
        Hero.instances = instances;
    }
    public void setNameAgeAbilityWeakness(String name,int age,String ability,String weakness){
        this.setAbility(ability);
        this.setAge(age);
        this.setName(name);
        this.setWeakness(weakness);
    }

    public static void clearAll() {
        instances.clear();
    }
    public boolean getCreated(){
        return this.created;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
}
