package labOne;

abstract class Weapon {
    private static int counter = 0; // Статическая переменная для подсчета созданных объектов
    private String name;
    private int damage;
    private int weight;

    public Weapon(String name, int damage, int weight) {
        this.name = name;
        this.damage = damage;
        this.weight = weight;
        counter++;
    }

    public abstract String attack();
    public abstract String display();

    // Геттеры и сеттеры
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getDamage() { return damage; }
    public void setDamage(int damage) { this.damage = damage; }
    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }
    public static int getCounter() { return counter; }
}

// Класс Меч
class Sword extends Weapon {
    private int length;

    public Sword(String name, int damage, int weight, int length) {
        super(name, damage, weight);
        this.length = length;
    }

    public String attack() {
        return "Swinging the " + getName() + " for " + getDamage() + " damage!";
    }

    public String display() {
        return "Sword: " + getName() + ", Damage: " + getDamage() + ", Weight: " + getWeight() + ", Length: " + length;
    }
}

// Класс Лук
class Bow extends Weapon {
    private int range;

    public Bow(String name, int damage, int weight, int range) {
        super(name, damage, weight);
        this.range = range;
    }

    public String attack() {
        return "Shooting an arrow from " + getName() + " for " + getDamage() + " damage!";
    }

    public String display() {
        return "Bow: " + getName() + ", Damage: " + getDamage() + ", Weight: " + getWeight() + ", Range: " + range;
    }
}

// Класс Волшебная палочка
class MagicWand extends Weapon {
    private String spell;

    public MagicWand(String name, int damage, int weight, String spell) {
        super(name, damage, weight);
        this.spell = spell;
    }

    public String attack() {
        return "Casting " + spell + " with " + getName() + " for " + getDamage() + " damage!";
    }

    public String display() {
        return "Magic Wand: " + getName() + ", Damage: " + getDamage() + ", Weight: " + getWeight() + ", Spell: " + spell;
    }
}

