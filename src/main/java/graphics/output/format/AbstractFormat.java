package graphics.output.format;

import graphics.painter.GraphicPainter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class AbstractFormat implements IFormat {

    @Override
    public abstract void save(String fileName, GraphicPainter painter) throws IOException;
    
    @Override
    public abstract void writeTXT(String strToWrite) throws FileNotFoundException;

    public String createDir(String dirName) {
        String baseDir = null;
        File file;
        try {
            baseDir = new File(".").getCanonicalPath() + "\\" + dirName + "\\";
            file = new File(baseDir);
            file.mkdirs();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baseDir;
    }
}
