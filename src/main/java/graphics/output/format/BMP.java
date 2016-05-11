package graphics.output.format;

import graphics.painter.GraphicPainter;
import org.knowm.xchart.BitmapEncoder;
import java.io.IOException;
import java.io.PrintWriter;

public class BMP extends AbstractFormat {

    private PrintWriter out;
    private String dir;

    public BMP() {
    }

    @Override
    public void save(String fileName, GraphicPainter painter) throws IOException {
        dir = createDir("BMP") + "" + fileName;
        BitmapEncoder.saveBitmap(painter.getChart(), dir, BitmapEncoder.BitmapFormat.BMP);
    }

    @Override
    public void writeTXT(String strToWrite) {

    }
}
