import FloodFill.*;
import java.awt.*;

class Main{
    public static void main(String[] args) {
        Color preto = new Color(0, 0, 0);
        Color amarelo = new Color(255, 227, 15);

        FloodFill floodFill2 = new FloodFill(450, 300, amarelo.getRGB());

        floodFill2.FillStack();
    }
}

