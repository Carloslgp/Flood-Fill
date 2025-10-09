package FloodFill;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import Queue.*;
import javax.imageio.ImageIO;

public class FloodFill {
    Coordinate coordenada;
    MyColor cor;
    int newColor;
    Queue<Coordinate> queue = new Queue<Coordinate>();

    public FloodFill(int x, int y, int newColor) {
        this.coordenada = new Coordinate(x, y);
        this.cor = new MyColor(coordenada);
        cor.setCurrentColor();
        this.newColor = newColor;
    }

//    public void  FillQueue(){
//        EnqueuePixels();
//        while (!queue.isEmpty()) {
//            Coordinate coordenadaNew = queue.dequeue();
//            if(verifyColor(coordenadaNew)){
//                paint
//            }else{
//                not
//            }
//
//            if(queue.){}
//        }
//
//
//
//    }

    private void paintPixel(Coordinate coordenadaToPaint){
        try {
            BufferedImage img = cor.getImage(); // ainda abre a imagem toda vez
            img.setRGB(coordenadaToPaint.getX(), coordenadaToPaint.getY(), newColor);
            ImageIO.write(img, "png", new File("edited_pikachu.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private boolean verifyColor(Coordinate coordenadaNew){
        MyColor myColor = new MyColor(coordenadaNew);
        myColor.setCurrentColor();
        return cor.getRGB() == myColor.getRGB();
    }


    public void EnqueuePixels(){
        paintPixel(coordenada);
        queue.enqueue(coordenada.getUpperPixel());
        queue.enqueue(coordenada.getRightPixel());
        queue.enqueue(coordenada.getLowerPixel());
        queue.enqueue(coordenada.getLeftPixel());
    }

}
