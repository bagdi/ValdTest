package graphics.output.format;

import graphics.painter.GraphicPainter;
import org.knowm.xchart.BitmapEncoder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class JPG extends AbstractFormat {

    private PrintWriter out;
    private String dir;

    public JPG() {
    }

    @Override
    public void save(String fileName, GraphicPainter painter) throws IOException {
        dir = createDir("JPG") + "" + fileName;
        BitmapEncoder.saveBitmap(painter.getChart(), dir, BitmapEncoder.BitmapFormat.JPG);
    }

    @Override
    public void writeTXT(String strToWrite) throws FileNotFoundException {

    }
}
