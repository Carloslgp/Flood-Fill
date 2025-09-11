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
            this.arquivo = new File("images/Pikachu2.png");
            this.image = ImageIO.read(arquivo);

            RGB = image.getRGB(coordinate.getX(), coordinate.getY());


        } catch (Exception e) {
            System.out.println("Erro ao abrir imagem");
        }
    }

    public String getColor(){
        return "" + red + green + blue + alpha;
    }

    public int getRGB(){
        return RGB;
    }

    public BufferedImage getImage() {
        return image;
    }


}
