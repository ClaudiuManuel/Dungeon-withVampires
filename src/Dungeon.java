import java.util.Scanner;

public class Dungeon {
    private Player player;
    private Map map;
    private Scanner reader;

    public void run() {
        reader = new Scanner(System.in);

        System.out.println("How many vampires would you like in the game?");
        int numVampires = 0;
        try {
            numVampires = Integer.parseInt(reader.nextLine());
        } catch (NumberFormatException var6) {
            var6.printStackTrace();
        }

        System.out.println("Enter the size of the dungeon: ");
        int size = 0;
        try {
            size = Integer.parseInt(reader.nextLine());
        } catch (NumberFormatException var6) {
            var6.printStackTrace();
        }

        System.out.println("Remember the moves! ");
        System.out.println("w to go up\n" +
                "s to go down\n" +
                "a to go left\n" +
                "d to go right\n" +
                "You can give multiple commands for one move(example:\"ssad\")");
        System.out.println("");
        this.map = new Map(size, size);
        this.map.construction();
        this.map.createVampires(numVampires);
        this.player = new Player(numVampires + 2);

        while (true) {
            System.out.println("Moves left: " + this.player.getMoves());
            System.out.println("");
            printStats();
            System.out.println("");
            this.map.printMap();
            System.out.println("");
            this.map.putPoint(player);//placing a dot on player's former position
            String command = this.reader.nextLine(); //string of moves the user has decided to make
            this.player.move(command, this.map.getHeight(), this.map.getLength());
            this.map.replacePoint(player);//placing the player on his new position
            this.map.VampireRemove(player);
            //vampires move randomly for every move the player makes
            this.map.moveVamp();
            if (this.map.getVampires().isEmpty()) {
                printStats();
                this.map.printMap();
                System.out.println("YOU WIN");
                break;
            }

            if (this.player.getMoves() == 0 && !this.map.getVampires().isEmpty()) {
                System.out.println("YOU LOSE");
                break;
            }

        }

    }

    public void printStats() { //printing each position of both player and each vampire
        System.out.println(this.player.toString());
        for (Vampire vampire : this.map.getVampires()) {
            System.out.println(vampire);
        }
    }
}
