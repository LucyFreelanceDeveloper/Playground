package com.example.turncombatexample;

public class Arena {

    private Fighter fighterA;
    private Fighter fighterB;
    private Dice dice;

    public Arena(Fighter fighterA, Fighter fighterB, Dice dice) {
        this.fighterA = fighterA;
        this.fighterB = fighterB;
        this.dice = dice;
    }

    public void battle() {
        Fighter fighterA = this.fighterA;
        Fighter fighterB = this.fighterB;
        System.out.println("Welcome to arena!");
        System.out.printf("Today will fight %s with %s! %n%n", fighterA, fighterB);

        //change order of fighters
        boolean firstIsFighterB = (dice.roll() <= dice.returnNumberOfSides() / 2);
        if (firstIsFighterB) {
            fighterA = this.fighterB;
            fighterB = this.fighterA;
        }
        System.out.printf("Začínat bude bojovník %s! %nZápas může začít...%n", fighterA);

        while (fighterA.isAlive() && fighterB.isAlive()) {
            fighterA.doAttack(fighterB);
            draw();
            printMessage(fighterA.returnLastMessage());
            printMessage(fighterB.returnLastMessage());
            if (fighterB.isAlive()) {
                fighterB.doAttack(fighterA);
                draw();
                printMessage(fighterB.returnLastMessage());
                printMessage(fighterA.returnLastMessage());
            }
            System.out.println();
        }
    }

    private void draw() {
        System.out.println("-------------- Arena -------------- \n");
        System.out.println("Health of fighters: \n");
        System.out.printf("%s %s%n", fighterA, fighterA.graphicRepresentationOfLife());
        System.out.printf("%s %s%n", fighterB, fighterB.graphicRepresentationOfLife());
    }

    private void printMessage(String message) {
        System.out.println(message);
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            System.out.println("Error failed to sleep the thread!");
        }
    }
}
