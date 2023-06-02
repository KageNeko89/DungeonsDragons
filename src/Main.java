public class Main {
    public static void main(String[] args) {
        Sorcerer a = new Sorcerer(Gender.MAN, Race.HALFELF, 21, "Kage", "");
        a.speak();
        for (int i=1; i<=20; i++) {
            a.printStats();
            System.out.println();
            a.levelUp();
        }
        a.die();
        a.printStats();
    }
}
