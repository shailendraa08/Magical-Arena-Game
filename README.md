
## Classes

## `Player`

The `Player` class models the attributes and behavior of a player in the arena. Each player has:

- `health`: The player's health points.
- `strength`: The player's defensive capability.
- `attack`: The player's offensive capability.
- `name`: The player's name.

## Methods:
- `Player(int health, int strength, int attack, String name)`: Constructor to initialize player attributes.
- `void takeDamage(int damage)`: Reduces the player's health by the damage taken.
- `boolean isAlive()`: Checks if the player is still alive.
- `int getHealth()`: Returns the player's health.
- `int getStrength()`: Returns the player's strength.
- `int getAttack()`: Returns the player's attack.
- `String getName()`: Returns the player's name.

## `Dice`

The `Dice` class simulates a 6-sided dice roll.

## Methods:
- `Dice()`: Constructor to initialize the random number generator.
- `int roll()`: Returns a random number between 1 and 6.

## `ArenaGame`

The `ArenaGame` class manages the game logic, including player turns and determining the winner.

## Methods:
- `ArenaGame(Player playerA, Player playerB)`: Constructor to initialize the game with two players.
- `void startGame()`: Manages the game loop where players take turns attacking and defending until one player's health reaches zero.

