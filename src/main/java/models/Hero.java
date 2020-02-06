package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String name;
    private int age;
    private String ability;
    private String weakness;
    private int id;
    private int squadId;
    private boolean created = false;
    private LocalDateTime createdAt;
    private static List<Hero> instances = new ArrayList<>();



    public Hero(String name, int age, String ability, String weakness,int squadId){
      this.name = name;
      this.age = age;
      this.ability= ability;
      this.weakness = weakness;
      this.squadId = squadId;
      Squad squad = Squad.find(squadId);
      squad.addHero(this);
      instances.add(this);
      this.id=instances.size();
      this.created = false;
      this.createdAt = LocalDateTime.now();

    }
   public String getName(){
        return name;
    }
    private void setName(String name) {
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    private void setAge(int age) {
        this.age = age;
    }
    public String getAbility(){
        return ability;
    }
    private void setAbility(String ability) {
        this.ability = ability;
    }
    public String getWeakness(){
        return weakness;
    }
    private void setWeakness(String weakness) {
        this.weakness = weakness;
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
    public boolean getCreated(){
        return created;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public static Hero findById(int n){
        return instances.get(n-1);
    }
    public void update(String name,String ability,String weakness,int age){
        this.name = name;
        this.ability = ability;
        this.weakness = weakness;
        this.age = age;
    }
    public int getId() {
        return id;
    }
    public int getSquadId() {
        return squadId;
    }
    public static void clearAll() {
        instances.clear();
    }

}
