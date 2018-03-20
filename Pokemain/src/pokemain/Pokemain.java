
package pokemain;

import java.util.Scanner;
import java.util.Random;

public class Pokemain {

    /**
     * @param args the command line arguments
     */
    
    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();
    Action action = new Action();
    
    public static void main(String[] args) {
        Pokemain program = new Pokemain();
        program.start();
    }
    
    public Pokemon generateEnemy(Pokemon player){
        int r = rand.nextInt(3)+1;
        if (r == 1){
            Bulbasaur enemy = new Bulbasaur();
            enemy.setLevel(action.random_enemy_level(player));
            System.out.println("Your enemy is Bulbasaur level "+enemy.getLevel());
            return enemy;
        }
        else if (r == 2) {
            Charmander enemy = new Charmander();
            enemy.setLevel(action.random_enemy_level(player));
            System.out.println("Your enemy is Charmander level "+enemy.getLevel());
            return enemy;
        }
        else {
            Squirtle enemy = new Squirtle();
            enemy.setLevel(action.random_enemy_level(player));
            System.out.println("Your enemy is Squirtle level "+enemy.getLevel());
            return enemy;
        }
    }
    
    public void Action(int op, String type, Pokemon att, Pokemon atted){
        if (op == 1) {
            action.tackle(att,atted);
            System.out.println("Tackle!");
        }
        else if (op == 2) {
            action.growl(atted);
            System.out.println("Growl!");
        }
        else if (op == 3) {
            action.tailwhip(atted);
            System.out.println("Tailwhip!");
        }
        else if (op == 4){
            if (type == "Grass") {
                action.vinewhip(att,atted);
                System.out.println("Vine Whip!");
            }
            else if (type == "Fire") {
                action.flamethrower(att,atted);
                System.out.println("Flamethrower!");
            }
            else if (type == "Water") {
                action.bubblegun(att,atted);
                System.out.println("Bubble Gun!");
            }
        }
    }
    
    public void PlayerTurn(Pokemon player, Pokemon enemy){
        if (player.getType() == "Grass"){
            System.out.println("1.Tackle  2.Growl  3.Tail Whip  4.Vine Whip");
            int op = scanner.nextInt();
            Action(op,player.getType(),player,enemy);
        }
        else if (player.getType() == "Fire"){
            System.out.println("1.Tackle  2.Growl  3.Tail Whip  4.Flamethrower");
            int op = scanner.nextInt();
            Action(op,player.getType(),player,enemy);
        }
        else if (player.getType() == "Water"){
            System.out.println("1.Tackle  2.Growl  3.Tail Whip  4.Bubble Gun");
            int op = scanner.nextInt();
            Action(op,player.getType(),player,enemy);
        }
        System.out.println("");
    }
    
    public void EnemyTurn(Pokemon player, Pokemon enemy){
        if (enemy.getType() == "Grass"){
            int r = rand.nextInt(4)+1;
            Action(r,enemy.getType(),enemy,player);
        }
        else if (enemy.getType() == "Fire"){
            int r = rand.nextInt(4)+1;
            Action(r,enemy.getType(),enemy,player);
        }
        else if (enemy.getType() == "Water"){
            int r = rand.nextInt(4)+1;
            Action(r,enemy.getType(),enemy,player);
        }
    }
    
    public void game(Pokemon player){
        System.out.println("Your pokemon level : "+player.getLevel());
        Pokemon enemy = generateEnemy(player);
        System.out.println("\n|Battle Start|\n");
        while (true){
            PlayerTurn(player,enemy);
            System.out.println("Enemy HP : "+enemy.getHp()+"\n");
            if (enemy.getHp() <= 0){
                Win(player);
                System.out.println("You Win");
                game(player);//
            }
            EnemyTurn(player,enemy);
            System.out.println("Your HP  : "+player.getHp()+"\n");
            if (player.getHp() <= 0){
                Lose(player);
                System.out.println("You Lose");
                break;
            }
        }
    }
    
    public void Win(Pokemon player){
        player.setExp(player.getExp()+50);
        action.initialise_before_battle(player);
    }
    
    public void Lose(Pokemon player){
        System.out.println("Play Again?\n1.Yes  2.No");
        int op = scanner.nextInt();
        if (op == 1) start();
        else if (op == 2) {
            System.out.println("GOODBYE");
        }
    }
    
    public void start(){
        System.out.println("=========\nChoose Your Pokemon\n=========");
        System.out.println("1. Bulbasaur   2. Charmander   3. Squirtle");
        int op = scanner.nextInt();
        if (op == 1){
            Bulbasaur player = new Bulbasaur();
            game(player);
        }
        else if (op == 2) {
            Charmander player = new Charmander();
            game(player);
        }
        else if (op == 3) {
            Squirtle player = new Squirtle();
            game(player);
        }
    }
    
}
