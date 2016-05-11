package graphics.output.format;

import graphics.painter.GraphicPainter;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IFormat{

    public void save(String fileName, GraphicPainter painter) throws IOException;
    public void writeTXT(String strToWrite) throws FileNotFoundException;
}
