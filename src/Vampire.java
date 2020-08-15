import java.util.Random;

public class Vampire {
    private String name;
    private int x;
    private int y;

    public Vampire(int lenght, int height) {
        this.x = new Random().nextInt(lenght);
        this.y = new Random().nextInt(height);
        this.name = "v";
    }

    public void move(int length, int height) {
        boolean isMoving = false;
        int num = new Random().nextInt(3);
        while (!isMoving) {
            switch (num) {                //vampire tries to make a random move;if the move is impossible,the vampire tries another position
                case 0:
                    if (this.x + 1 < length) {
                        this.x++;
                        isMoving = true;
                        break;
                    }
                case 1:
                    if (this.x - 1 >= 0) {
                        this.x--;
                        isMoving = true;
                        break;
                    }
                case 2:
                    if (this.y + 1 < height) {
                        this.y++;
                        isMoving = true;
                        break;
                    }
                case 3:
                    if (this.y - 1 >= 0) {
                        this.y--;
                        isMoving = true;
                        break;
                    } else {
                        num = 0;
                    }
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString() {
        return this.name + " " + this.x + " " + this.y;
    }

}
