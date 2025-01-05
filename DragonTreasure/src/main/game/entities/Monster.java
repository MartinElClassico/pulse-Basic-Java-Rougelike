package main.game.entities;

public class Monster {

    private static final String ATTACKED_MONSTER_MESSAGE = "Du attackerar odjuret och gör %d skada %n";
    private static final String ATTACKED_DRAGON_MESSAGE = "Du attackerar draken och gör %d skada %n";
    private static final String ATTACK_MONSTER_MESSAGE = "Ett odjur attackerar dig och gör %d skada";
    private static final String ATTACK_DRAGON_MESSAGE = "En drake attackerar dig och gör %d skada";
    private static final String DEFEAT_MONSTER_MESSAGE = "Du besegrar odjutet";
    private static final String DEFEAT_DRAGON_MESSAGE = "Du besegrar draken";

    private static final int DAMAGE = 1; //monster/drake skada är en konstant

    private String name; //typ av monster
    private int healthPoints;
    private int maxHealthPoints;
    private String monsterDesc;
    private boolean defeated;

    
    //constructor
    public Monster(String name, int maxHealthPoints, String monsterDesc) {
        this.name = name;
        this.healthPoints = maxHealthPoints;
        this.maxHealthPoints = maxHealthPoints;
        this.monsterDesc = monsterDesc;
        this.defeated = false;
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
       return healthPoints;  
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    public int getDamage() {
        return DAMAGE;
    }

    public String getMonsterDesc() {
        return monsterDesc;
    }

    public boolean isDefeated() [
        return defeated;
    ]

//metod för att hantera att spelaren tar skada
public void attackPlayer(Player player) {
    if (!defeated) {
    player.takeDamage(DAMAGE); 
    if (name.equals("Monster")) {
        System.out.printf(ATTACK_MONSTER_MESSAGE, DAMAGE);
    } else {
        System.out.printf(ATTACK_DRAGON_MESSAGE, DAMAGE);
    }
  }
}

// metod för att hantera att monster tar skada
public void takeDamage(int damage) {
    if (!defeated) {
        healthPoints = healthPoints - damage;

    if (healthPoints <= 0) {
            defeated = true;

    if (name.equals("Monster")) {
        System.out.println(DEFEAT_MONSTER_MESSAGE);
    } else {
        System.out.println(DEFEAT_DRAGON_MESSAGE);
      }
    }
  }
}




    




    
}
