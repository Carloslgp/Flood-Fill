package FloodFill;
import java.awt.*;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class MyColor {
    Coordinate coordinate;
    int red;
    int green;
    int blue;
    int alpha;
    int RGB;
    File arquivo;
    BufferedImage image;

    public MyColor(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setCurrentColor(){
        try {
            // Abrindo a imagem
            this.arquivo = new File("images/Pikachu.png");
            this.image = ImageIO.read(arquivo);

            RGB = image.getRGB(coordinate.getX(), coordinate.getY());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getColor(){
        return "" + red + green + blue + alpha;
    }

//    public int getRed() {
//        return red;
//    }
//
//    public int getGreen() {
//        return green;
//    }
//
//    public int getBlue() {
//        return blue;
//    }
//
//    public int getAlpha() {
//        return alpha;
//    }

    public int getRGB(){
        return RGB;
    }

    public BufferedImage getImage() {
        return image;
    }


}
