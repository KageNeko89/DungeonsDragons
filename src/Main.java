public class Main {
    public static void main(String[] args) {
        Sorcerer a = new Sorcerer(Gender.MAN, Race.TIEFLING, 21, "Kage", "");
        a.speak();
        a.levelUp();
        a.levelUp();
        a.levelUp();
        a.printStats();

    }
}
