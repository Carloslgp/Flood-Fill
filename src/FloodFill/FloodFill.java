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
        limparArquivosAntigos();
        int frameCounter = 0;
        int saveInterval = 700;

        new File("frames").mkdirs();

        queue.enqueue(coordenada);
        int contador = 0;
        while (!queue.isEmpty()) {
            contador++;
            Coordinate coordenadaNew = queue.dequeue();
            if ((verifyColor(coordenadaNew))) {
                img.setRGB(coordenadaNew.getX(), coordenadaNew.getY(), newColor);
                coordenada = coordenadaNew;
                EnqueuePixels();
            }
            if (contador % saveInterval == 0) {
                try {
                    String filename = String.format("frames/frame_%04d.png", frameCounter++);
                    ImageIO.write(img, "png", new File(filename));
                } catch (Exception e) {
                    System.out.println("Erro ao salvar frame");
                }
            }
        }
        generateAnimation(frameCounter);

    }

    public void FillStack(){
        limparArquivosAntigos();
        int frameCounter = 0;
        int saveInterval = 700;

        new File("frames").mkdirs();

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
            if (contador % saveInterval == 0) {
                try {
                    String filename = String.format("frames/frame_%04d.png", frameCounter++);
                    ImageIO.write(img, "png", new File(filename));
                } catch (Exception e) {
                    System.out.println("Erro ao salvar frame");
                }
            }
        }
        generateAnimation(frameCounter);

    }

    private void generateAnimation(int frameCounter){
        try {
            String filename = String.format("frames/frame_%04d.png", frameCounter++);
            ImageIO.write(img, "png", new File(filename));
        } catch (Exception e) {
            System.out.println("Erro ao salvar último frame");
        }
        try {
            String cmdVideo = "ffmpeg -framerate 100 -i frames/frame_%04d.png -pix_fmt yuv420p -y animacao.mp4";

            Runtime.getRuntime().exec(cmdVideo).waitFor();

            System.out.println("Vídeo gerado!");
        } catch (Exception e) {
            System.out.println("Erro ao gerar animação: " + e.getMessage());
        }
    }

    private void limparArquivosAntigos() {
        File framesDir = new File("frames");
        if (framesDir.exists() && framesDir.isDirectory()) {
            File[] files = framesDir.listFiles();
            if (files != null) {
                for (File file : files) {
                    file.delete();
                }
            }
        }

        new File("animacao.mp4").delete();
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
