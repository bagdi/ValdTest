package graphics.output.format;

import graphics.painter.GraphicPainter;
import org.knowm.xchart.BitmapEncoder;
import java.io.IOException;
import java.io.PrintWriter;

public class PNG extends AbstractFormat {

    private PrintWriter out;
    private String dir;

    public PNG() {
    }

    @Override
    public void save(String fileName, GraphicPainter painter) throws IOException {
        dir = createDir("PNG") + "" + fileName;
        BitmapEncoder.saveBitmap(painter.getChart(), dir, BitmapEncoder.BitmapFormat.PNG);
    }

    @Override
    public void writeTXT(String strToWrite) {

    }
}
