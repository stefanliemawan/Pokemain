/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemain;

/**
 *
 * @author stefanliemawan
 */

import java.util.Random;
import pokemain.Pokemon;

public class Action {
    
        //Game Action
        
        Random rand = new Random();
        
        Action(){}
        
	public int run(){
		int r = rand.nextInt(100) + 1;
		if (r > 75){
			System.out.println("You succeed to run!");
			return 1;
		}else {
			System.out.println("You failed to run!");
			return 0;
		}
	}

    public double checkType(Pokemon att, Pokemon atted){
        if(att.getType() == "Grass"){
            if(atted.getType() == "Fire"){
                return 0.5;
            }
            else if(atted.getType() == "Water"){
                return 2;
            }
            else {
                return 1;
            }
        }
        else if(att.getType() == "Fire"){
            if(atted.getType() == "Water"){
                return 0.5;
            }
            else if(atted.getType() == "Grass"){
                return 2;
            }
            else {
                return 1;
            }
        }
        else{
            if(atted.getType() == "Grass"){
                return 0.5;
            }
            else if(atted.getType() == "Fire"){
                return 2;
            }
            else {
                return 1;
            }
        }
    }

    public double checkCrit(){
        double crit;
        int rCrit = rand.nextInt(101);
        if (rCrit == 100){
            crit = 4;
        }
        else if(rCrit <= 99 && rCrit > 90){
            crit = 2;
        }
        else {
            crit = 1;
        }

        return crit;

    }

	public void tackle(Pokemon att, Pokemon atted){
		int power = 40;
		double cdamage = ((((2*att.getLevel()/5)+2)*power*(att.getAttack()/atted.getDefense()))/50 +2)* checkCrit();

		int damage = (int) cdamage;

		int hp = atted.getHp() - damage;
		atted.setHp(hp);
	}

	// Drop Def
	public void tailwhip(Pokemon atted){
		int def = atted.getDefense();
		def = def - 1;

		atted.setDefense(def);
	}

	// Drop Atk
	public void growl(Pokemon atted){
		int att = atted.getAttack();
		att = att -1;
		atted.setAttack(att);
	}

	public void bubblegun(Pokemon att, Pokemon atted){
		int power = 40;
		double cdamage = ((((2*att.getLevel()/5)+2)*power*(att.getAttack()/atted.getDefense()))/50 +2)* checkType(att, atted) * checkCrit();

		int damage = (int) cdamage;

		int hp = atted.getHp() - damage;
		att.setHp(hp);
	}

	public void vinewhip(Pokemon att, Pokemon atted){
		int power = 40;
		double cdamage = ((((2*att.getLevel()/5)+2)*power*(att.getAttack()/atted.getDefense()))/50 +2)* checkType(att, atted) * checkCrit();

		int damage = (int) cdamage;

		int hp = atted.getHp() - damage;
		att.setHp(hp);
	}

	public void flamethrower(Pokemon att, Pokemon atted){
		int power = 40;
		double cdamage = ((((2*att.getLevel()/5)+2)*power*(att.getAttack()/atted.getDefense()))/50 +2)* checkType(att, atted) * checkCrit();

		int damage = (int) cdamage;

		int hp = atted.getHp() - damage;
		att.setHp(hp);
	}

	// Refresh pokemon health, attack, defense equals to max attack/hp/defense (according to level)
	public void initialise_before_battle(Pokemon att){
		att.setAttack(att.getMaxAttack());
		att.setDefense(att.getMaxDefense());
		att.setHp(att.getMaxHp());
	}

	// Refresh pokemon health, attack, defense equals to initial attack/hp/defense (back to level 5 stat)
	public void initialise_before_game(Pokemon att){
		att.setAttack(att.getInitialAttack());
		att.setDefense(att.getInitialDefense());
		att.setHp(att.getInitialHp());
		att.setExp(att.getInitialExp());
		att.setExptoup(att.getInitialExptoup());
		att.setLevel(att.getInitialLevel());
	}
        
        public int random_enemy_level(Pokemon player){
            int min = player.getLevel() -2;
            int max = player.getLevel() +2;
            int r = rand.nextInt((max-min)+1)+ min;
            
            return r;
        }
}
