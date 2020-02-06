package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Squad{
private String name;
private String mission;
private int size ;
private int id ;
private static ArrayList<Squad> instances = new ArrayList<>();
private List<Hero> heroes = new ArrayList<>();

 public Squad(String name, String mission,int size){
     this.size = size;
     this.name = name;
     this.mission = mission;
     instances.add(this);
     this.id = instances.size();
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getSize() {
        return size;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public List<Hero> getHeroes() {
        return heroes;
    }
    public void addHero(Hero hero) {
        if (heroes.size()<this.getSize()) {
            heroes.add(hero);
        }
    }
    public static ArrayList<Squad> getSquads() {
        return instances;
    }
    public static void clearSquads() {
        instances.clear();
    }
    public void removeHeroes() {
        heroes.clear();
    }
    public void removeHero(Hero hero) {
        heroes.remove(hero);
    }
    public static Squad find(int n) {
        return instances.get(n-1);
    }
}