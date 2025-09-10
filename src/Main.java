import FloodFill.*;

import javax.xml.transform.Source;
import java.awt.*;

class Main{
    public static void main(String[] args) {


        Color cor = new Color(0, 255, 0); // verde
        FloodFill floodFill = new FloodFill(1, 275, cor.getRGB());
        floodFill.FillStack();




    }
}

