package com.example.turncombatexample;

public class Fighter {
    private String name;
    private int life;
    private int maxLife;
    private int attack;
    private int defence;
    private Dice dice;
    private String lastMessage;

    public Fighter(String name, int life, int attack, int defence, Dice dice) {
        this.name = name;
        this.life = life;
        this.maxLife = life;
        this.attack = attack;
        this.defence = defence;
        this.dice = dice;
    }

    public void doAttack(Fighter enemy) {
        int hit = attack + dice.roll();
        setMessage(String.format("%s attacking with hit %s HP", name, hit));
        enemy.defenceYourself(hit);
    }

    public void defenceYourself(int hit) {
        int injury = hit - (defence + dice.roll());
        if (injury > 0) {
            life -= injury;
            lastMessage = String.format("%s get hurt by %s HP", name, injury);
            if (life <= 0) {
                life = 0;
                lastMessage += " and died.";
            }
        } else {
            lastMessage = String.format("%s counter the attack", name);
        }
        setMessage(lastMessage);
    }

    public boolean isAlive() {
        return life > 0;
    }

    private void setMessage(String message) {
        this.lastMessage = message;
    }

    public String returnLastMessage() {
        return lastMessage;
    }

    public String graphicRepresentationOfLife() {
        String graphicLife = "[";
        int sum = 20;
        double numberOfPieces = Math.round(((double) life / maxLife) * sum);
        if ((numberOfPieces == 0) && (isAlive())) {
            numberOfPieces = 1;
        }
        for (int i = 0; i < numberOfPieces; i++) {
            graphicLife += "#";
        }
        for (int i = 0; i < sum - numberOfPieces; i++) {
            graphicLife += " ";
        }
        graphicLife += "]";
        return graphicLife;
    }

    @Override
    public String toString() {
        return name;
    }
}
