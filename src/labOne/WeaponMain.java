package labOne;

public class WeaponMain {
    public static void main(String[] args) {
        Sword sword = new Sword("Excalibur", 50, 5, 100);
        Bow bow = new Bow("Longbow", 40, 2, 200);
        MagicWand magicWand = new MagicWand("Elder Wand", 100, 1, "Avada Kedavra");

        System.out.println(sword.attack());
        System.out.println(bow.attack());
        System.out.println(magicWand.attack());
        System.out.println(sword.display());
        System.out.println(bow.display());
        System.out.println(magicWand.display());

        System.out.println("Total weapons created: " + Weapon.getCounter());
    }
}
