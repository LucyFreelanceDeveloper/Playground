package com.example.turncombatexample;

public class Fighter {
    private String name;
    private int life;
    private int maxLife;
    private int attack;
    private int defence;
    private Dice dice;
    private String lastMessage;

    public Fighter(String name, int life, int maxLife, int attack, int defence, Dice dice, String lastMessage) {
        this.name = name;
        this.life = life;
        this.maxLife = maxLife;
        this.attack = attack;
        this.defence = defence;
        this.dice = dice;
        this.lastMessage = lastMessage;
    }

    public void doAttack(Fighter enemy) {
    }

    public void defenceYourself(int hit) {

    }

    public boolean isAlive() {
        return true;
    }

    private void setMessage() {}

    public String returnLastMessage() {
        return lastMessage;
    }

    public String graphicRepresentationOfLife() {
        return "";
    }

    @Override
    public String toString() {
        return name;
    }
}
