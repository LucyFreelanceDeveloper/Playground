package com.example.turncombatexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TurnCombatExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurnCombatExampleApplication.class, args);

		Dice dice = new Dice();
		Fighter hero = new Fighter("Hero", 10, 20, 10, dice);
		Fighter enemy = new Fighter("Shadow", 10, 15, 15, dice);
		Arena arena = new Arena(hero, enemy, dice);

		arena.battle();
	}
}
