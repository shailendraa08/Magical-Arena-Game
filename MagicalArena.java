import java.util.Random;
import java.util.Scanner;

public class MagicalArena {

    public static class Player {
        private int health;
        private int strength;
        private int attack;
        private String name;

        public Player(int health, int strength, int attack, String name) {
            if (health <= 0 || strength <= 0 || attack <= 0) {
                throw new IllegalArgumentException("Attributes must be positive integers.");
            }
            this.health = health;
            this.strength = strength;
            this.attack = attack;
            this.name = name;
        }

        public void takeDamage(int damage) {
            health -= damage;
            if (health < 0) {
                health = 0;
            }
        }

        public boolean isAlive() {
            return health > 0;
        }

        public int getHealth() {
            return health;
        }

        public int getStrength() {
            return strength;
        }

        public int getAttack() {
            return attack;
        }

        public String getName() {
            return name;
        }
    }

    public static class Dice {
        private Random random;

        public Dice() {
            random = new Random();
        }

        public int roll() {
            return random.nextInt(6) + 1; // Roll a 6-sided die
        }
    }

    public static class ArenaGame {
        private Player playerA;
        private Player playerB;
        private Dice attackDice;
        private Dice defenseDice;
        private Scanner scanner;

        public ArenaGame(Player playerA, Player playerB, Dice attackDice, Dice defenseDice, Scanner scanner) {
            this.playerA = playerA;
            this.playerB = playerB;
            this.attackDice = attackDice;
            this.defenseDice = defenseDice;
            this.scanner = scanner;
        }

        public void startGame() {
            Player attacker = (playerA.getHealth() < playerB.getHealth()) ? playerA : playerB;
            Player defender = (attacker == playerA) ? playerB : playerA;

            while (playerA.isAlive() && playerB.isAlive()) {
                System.out.println(attacker.getName() + ", press Enter to roll the attack dice.");
                scanner.nextLine();
                int attackRoll = attackDice.roll();

                System.out.println(defender.getName() + ", press Enter to roll the defense dice.");
                scanner.nextLine();
                int defenseRoll = defenseDice.roll();

                int damageDealt = attackRoll * attacker.getAttack();
                int damageDefended = defenseRoll * defender.getStrength();

                int damageTaken = Math.max(0, damageDealt - damageDefended);
                defender.takeDamage(damageTaken);

                System.out.println(attacker.getName() + " attacks with roll " + attackRoll +
                        " and deals " + damageDealt + " damage. " + defender.getName() +
                        " defends with roll " + defenseRoll + " and defends " + damageDefended + " damage. " +
                        defender.getName() + " health reduced to " + defender.getHealth());

                // Switch roles for next round
                Player temp = attacker;
                attacker = defender;
                defender = temp;
            }

            // Determine the winner
            Player winner = playerA.isAlive() ? playerA : playerB;
            System.out.println("Winner: " + winner.getName());
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            try {
                Player playerA = new Player(50, 5, 10, "Player A");
                Player playerB = new Player(100, 10, 5, "Player B");

                Dice attackDice = new Dice();
                Dice defenseDice = new Dice();

                ArenaGame game = new ArenaGame(playerA, playerB, attackDice, defenseDice, scanner);
                game.startGame();
            } finally {
                scanner.close();
            }
        }
    }

    public static void main(String[] args) {
        ArenaGame.main(args);
    }
}
