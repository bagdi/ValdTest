package graphics.service;

import graphics.output.format.IFormat;
import graphics.painter.GraphicPainter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PackageToArray {

    private Coordinate coordinate;
    private GraphicPainter painter;
    private List x = new ArrayList();
    private List y = new ArrayList();
    private String name;

    public PackageToArray() {
    }

    public PackageToArray(String name) {
        this.name = name;
    }

    public void addDeltaAndError(double firstParameter, double secondParameter) {
        x.add(firstParameter);
        y.add(secondParameter);
    }

    public void packageData() {
        coordinate = new Coordinate(this);
        for(int i = 0; i < x.size(); i++) {
            coordinate.getXData()[i] = Double.parseDouble(x.get(i).toString());
            coordinate.getYData()[i] = Double.parseDouble(y.get(i).toString());
        }
    }

    public void packageDrawAndSave(IFormat format) throws IOException {
        this.packageData();
        painter = new GraphicPainter(this.getCoordinate());
        painter.paint();
        painter.save(format, name, painter);
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public List getX() {
        return x;
    }


    public List getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public GraphicPainter getPainter() {
        return painter;
    }
}
