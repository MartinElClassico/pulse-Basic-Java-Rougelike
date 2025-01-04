package main.game.entities;

public class Monster {

    private static final String ATTACKED_MESSAGE = "Du attackerar odjuret och gör %d skada %n";
    private static final String ATTACK_MESSAGE = "Ett odjur attackerar dig och gör %d skada";
    private static final String DEFEAT_MESSAGE = "Du besegrar odjutet";
    private static final int DAMAGE = 1; //monster damage is a constant

    private String name;
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



public void takeDamage(int damage) {
    if (!defeated); {
        healthpoints = healthpoints - damage;
        System.out.printf(ATTACK_MESSAGE, damage);
        if (healthPoints <= 0) {
            defeated = true;
            System.out.println(DEFEAT_MESSAGE);
        }
    }

     }


    //skapa en metod som minskar healthPoints
    // hp 0 ska trigga defeat print
    // kontrollera om monsterattack-meddelanden i denna klass?
    //skapa ex boolean för när healthPoints = 0 är monstret besegrat
    




    
}
