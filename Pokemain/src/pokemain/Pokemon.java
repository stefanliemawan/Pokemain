package pokemain;

import java.util.Random;

public class Pokemon {
    private String name;
	private String type;
	private int level;
	private int exp;
	private int exptoup;
	private int hp;
	private int max_hp;
	private int attack;
	private int max_attack;
	private int defense;
	private int max_defense;
    private Random rand = new Random();

    // For Initialisation
	private int initial_hp;
	private int initial_attack;
	private int initial_defense;
    private int initial_level;
    private int initial_exp;
    private int initial_exptoup;

    Pokemon(String name, String type, int level, int exp, int exptoup, int hp, int attack, int defense){
        this.name = name;
        this.type = type;
        this.level = level;
        this.initial_level = level;
        this.exp = exp;
        this.initial_exp = exp;
        this.exptoup = exptoup;
        this.initial_exptoup = exptoup;
        this.hp = hp + ((this.level - 5)/50 * hp);;
        this.max_hp = hp + ((this.level - 5)/50 * hp);;
        this.initial_hp = hp;
        this.attack = attack + ((this.level - 5)/50 * attack);
        this.max_attack = attack + ((this.level - 5)/50 * attack);
        this.initial_attack = attack;
        this.defense = defense + ((this.level - 5)/50 * defense);
        this.max_defense = defense + ((this.level - 5)/50 * defense);
        this.initial_defense = defense;
	};

    Pokemon(){};

	// SET
	public void setName(String Name){
		this.name = Name;
	}
	public void setLevel(int Level){
		this.level = Level;
	}
	public void setExp(int Exp){
		this.exp = Exp;
	}
	public void setExptoup(int Exptoup){
		this.exptoup = Exptoup;
	}
	public void setHp(int Hp){
		this.hp = Hp;
	}
	public void setAttack(int Attack){
		this.attack = Attack;
	}
	public void setDefense(int Defense){
		this.defense = Defense;
	}


	// GET
	public String getName(){
            return this.name;
	}
	public String getType(){
            return this.type;
	}
	public int getLevel(){
            return this.level;
	}
	public int getExp(){
            return this.exp;
	}
	public int getExptoup(){
            return this.exptoup;
	}
	public int getHp(){
            return this.hp;
	}
	public int getAttack(){
            return this.attack;
	}
	public int getDefense(){
            return this.defense;
	}
	public int getMaxAttack(){
            return this.max_attack;
        }
    public int getMaxDefense(){
            return this.max_defense;
        }
    public int getMaxHp(){
            return this.max_hp;
        }
    public int getInitialAttack(){
            return initial_attack;
        }
    public int getInitialDefense(){
            return initial_defense;
        }
    public int getInitialHp(){
            return initial_hp;
        }
    public int getInitialExp(){
            return initial_exp;
        }
    public int getInitialExptoup(){
            return initial_exptoup;
        }
    public int getInitialLevel(){
            return initial_level;
        }


    // Refresh pokemon health, attack, defense equals to max attack/hp/defense (according to level)
    public void initialise_before_battle(){
        this.setAttack(this.getMaxAttack());
        this.setDefense(this.getMaxDefense());
        this.setHp(this.getMaxHp());
    }

    // Refresh pokemon health, attack, defense equals to initial attack/hp/defense (back to level 5 stat)
    public void initialise_before_game(){
        this.setAttack(this.getInitialAttack());
        this.setDefense(this.getInitialDefense());
        this.setHp(this.getInitialHp());
        this.setExp(this.getInitialExp());
        this.setExptoup(this.getInitialExptoup());
        this.setLevel(this.getInitialLevel());
    }

    public int random_enemy_level(Pokemon player){
        int min = player.getLevel() -2;
        int max = player.getLevel() +2;
        int r = rand.nextInt((max-min)+1)+ min;

        return r;
    }


}