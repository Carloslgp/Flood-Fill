package FloodFill;

public class Coordinate {
    public int x;
    public int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public Coordinate getUpperPixel(){
        return new Coordinate(x, y - 1);
    }

    public Coordinate getLowerPixel(){
        return new Coordinate(x, y + 1);
    }

    public Coordinate getRightPixel(){
        return new Coordinate(x + 1, y);
    }

    public Coordinate getLeftPixel(){
        return new Coordinate(x - 1, y);
    }



}
