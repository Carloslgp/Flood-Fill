package FloodFill;
import Queue.*;

public class FloodFill {
    Coordinate coordenada;
    MyColor cor;

    public FloodFill(int x, int y){
        this.coordenada = new Coordinate(x, y);
        this.cor = new MyColor(coordenada);
    }

    public void FillQueue(){
        Queue<Coordinate> queue = new Queue<Coordinate>();

    }

}
