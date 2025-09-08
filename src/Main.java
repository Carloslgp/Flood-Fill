import FloodFill.*;

class Main{
    public static void main(String[] args) {
        Coordinate coordinate = new Coordinate(435, 276);
        MyColor color = new MyColor(coordinate);
        color.setCurrentColor();

        System.out.println(color.getRed());
        System.out.println(color.getGreen());
        System.out.println(color.getBlue());
        System.out.println(color.getAlpha());




    }
}

