package FloodFill;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;



public class MyColor {
    Coordinate coordinate;


    int red;
    int green;
    int blue;
    int alpha;

    public MyColor(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setCurrentColor(){
        try {
            // Abrindo a imagem
            File arquivo = new File("images/Pikachu.png");
            BufferedImage img = ImageIO.read(arquivo);

            int corRGB = img.getRGB(coordinate.getX(), coordinate.getY());

            // Quebrando os canais manualmente
            this.alpha = (corRGB >> 24) & 0xff;
            this.red   = (corRGB >> 16) & 0xff;
            this.green = (corRGB >> 8) & 0xff;
            this.blue  = corRGB & 0xff;


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public int getAlpha() {
        return alpha;
    }




}
