public class Player {
    private String name;
    private int moves;
    private int x;
    private int y;

    public Player(int moves) {
        this.name = "@";
        this.x = 0;
        this.y = 0;
        this.moves = moves;
    }

    public String getName() {
        return this.name;
    }

    public int getMoves() {
        return this.moves;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void move(String command, int length, int height) {

        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            if (c == 's') {
                if (this.y + 1 < height) {
                    this.y++;
                } else {//if the player can't move  that means the end of the table was reached
                    this.y = height - 1;
                }
            }
            if (c == 'w') {
                if (this.y - 1 > 0) {
                    this.y--;
                } else {//same as above
                    this.y = 0;
                }
            }
            if (c == 'd') {
                if (this.x + 1 < length) {
                    this.x++;
                } else {//same
                    this.x = length - 1;
                }
            }
            if (c == 'a') {
                if (this.x - 1 > 0) {
                    this.x--;
                } else {//same
                    this.x = 0;

                }
            }
        }

        this.moves--;


    }

    @Override
    public String toString() {
        return this.name + " " + this.y + " " + this.x;
    }

}
