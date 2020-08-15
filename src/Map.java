import java.util.ArrayList;

public class Map {
    private String[][] map;
    private int length, height;
    private ArrayList<Vampire> vampires;
    private int numVampires;

    public Map(int length, int height) {
        this.map = new String[height][length];
        this.length = length;
        this.height = height;
        this.vampires = new ArrayList<Vampire>();

    }

    public void construction() { //placing dots on the entire surface of the map
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.length; j++) {
                this.map[i][j] = ".";
            }
        }
        this.map[0][0]="@"; //initializing player ar starting position
    }

    public void createVampires(int numVampires) {
        this.numVampires=numVampires;
        for (int i = 0; i < this.numVampires; i++) {
            Vampire vampire = new Vampire(this.length, this.height);
            while (this.map[vampire.getX()][vampire.getY()].equals("v")||this.map[vampire.getX()][vampire.getY()].equals("@")) {
                vampire.move(this.map.length,this.map.length); //making sure that all of the vampires are spawned in different positions
            }
            this.vampires.add(vampire);
            this.map[vampire.getX()][vampire.getY()] = "v";

        }


    }


    public void moveVamp() {
        for (Vampire vampire : this.vampires) {
            int x = vampire.getX();
            int y = vampire.getY();
            vampire.move(length, height);
            if (this.map[vampire.getX()][vampire.getY()].equals(".")) {
                this.map[vampire.getX()][vampire.getY()] = "v";
                this.map[x][y] = "."; //placing a dot on vampire's former position
            } else { //if the random move he tried is not possible(out of map/not a free spot) the vampire resets his position
                vampire.setX(x);
                vampire.setY(y);
            }
        }
    }

    public void printMap() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.length; j++) {
                System.out.print(this.map[i][j]);
            }
            System.out.println("");
        }

    }

    public void putPoint(Player player) {
        int x = player.getX();
        int y = player.getY();
        this.map[y][x] = ".";
    }

    public void replacePoint(Player player) {
        this.map[player.getY()][player.getX()] = player.getName();
    }

    public void VampireRemove(Player player) {
        ArrayList<Vampire> toBeRemoved = new ArrayList<Vampire>();
        for (Vampire vampire : this.vampires) {
            if (vampire.getX() == player.getY() && vampire.getY() == player.getX()) {
                toBeRemoved.add(vampire);
            }
        }
        this.vampires.removeAll(toBeRemoved); //removing the vampire the player caught in his path

    }


    public int getLength() {
        return this.length;
    }

    public int getHeight() {
        return this.height;
    }

    public ArrayList<Vampire> getVampires() {
        return this.vampires;
    }


}
