class Robot {
    int width, height;
    int x = 0, y = 0;
    int dir = 0;      // 0 = East,1 = North,2 = West,3 = South
    int perimeter;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.perimeter = 2 * (width + height) - 4;
    }

    public void step(int num) {
        num %= perimeter;

        if (num == 0 && (x == 0 && y == 0)) {
            dir = 3;     // South
            return;
        }

        while (num-- > 0) {

            if (dir == 0) {      // East
                if (x + 1 < width) x++;
                else { dir = 1; y++; }
            }
            else if (dir == 1) {     // North
                if (y + 1 < height) y++;
                else { dir = 2; x--; }
            }
            else if (dir == 2) {     // West
                if (x - 1 >= 0) x--;
                else { dir = 3; y--; }
            }
            else {     // South
                if (y - 1 >= 0) y--;
                else { dir = 0; x++; }
            }
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        if (dir == 0) return "East";
        if (dir == 1) return "North";
        if (dir == 2) return "West";
        return "South";
    }
}


/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */