package FloodFill;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import Queue.*;
import javax.imageio.ImageIO;
import Stack.*;

public class FloodFill {
    Coordinate coordenada;
    MyColor cor;
    int newColor;
    Queue<Coordinate> queue = new Queue<Coordinate>();
    Stack<Coordinate> stack = new Stack<Coordinate>();
    BufferedImage img;

    public FloodFill(int x, int y, int newColor) {
        this.coordenada = new Coordinate(x, y);
        this.cor = new MyColor(coordenada);
        cor.setCurrentColor();
        this.newColor = newColor;
        this.img = cor.getImage();
    }

    public void FillQueue(){
        queue.enqueue(coordenada);
        int contador = 0;
        while (!queue.isEmpty()) {
            contador++;
            System.out.println(contador);
            Coordinate coordenadaNew = queue.dequeue();
            if((verifyColor(coordenadaNew))){
                img.setRGB(coordenadaNew.getX(), coordenadaNew.getY(), newColor);
                coordenada = coordenadaNew;
                EnqueuePixels();
            }else{
                continue;
            }

        }
        try {
            ImageIO.write(img, "png", new File("edited_pikachu.png"));
        }catch (Exception e){
            System.out.println("Erro ao salvar imagem");
        }

    }

    public void FillStack(){
        stack.push(coordenada);
        int contador = 0;
        while (!stack.isEmpty()) {
            contador++;
            System.out.println(contador);
            Coordinate coordenadaNew = stack.pop();
            if((verifyColor(coordenadaNew))){
                img.setRGB(coordenadaNew.getX(), coordenadaNew.getY(), newColor);
                coordenada = coordenadaNew;
                StackPixels();
            }
        }
        try {
            ImageIO.write(img, "png", new File("edited_pikachu.png"));
        }catch (Exception e){
            System.out.println("Erro ao salvar imagem");
        }
    }


    private boolean verifyColor(Coordinate coordenadaNew){
        int pixelColor = img.getRGB(coordenadaNew.getX(), coordenadaNew.getY());
        return pixelColor == cor.getRGB();
    }

    private boolean coordinateExists(Coordinate coordenada){
        int width = img.getWidth();
        int height = img.getHeight();

        int x = coordenada.getX();
        int y = coordenada.getY();

        return (x >= 0 && x < width && y >= 0 && y < height);
    }


    public void EnqueuePixels(){
        if( coordinateExists(coordenada.getUpperPixel())){
            queue.enqueue(coordenada.getUpperPixel());
        }
        if( coordinateExists(coordenada.getLowerPixel())){
            queue.enqueue(coordenada.getLowerPixel());
        }
        if( coordinateExists(coordenada.getRightPixel())){
            queue.enqueue(coordenada.getRightPixel());
        }
        if( coordinateExists(coordenada.getLeftPixel())){
            queue.enqueue(coordenada.getLeftPixel());
        }

    }

    public void StackPixels(){
        if(coordinateExists(coordenada.getUpperPixel())){
            stack.push(coordenada.getUpperPixel());
        }
        if(coordinateExists(coordenada.getLowerPixel())){
            stack.push(coordenada.getLowerPixel());
        }
        if(coordinateExists(coordenada.getRightPixel())){
            stack.push(coordenada.getRightPixel());
        }
        if(coordinateExists(coordenada.getLeftPixel())){
            stack.push(coordenada.getLeftPixel());
        }

    }

}
