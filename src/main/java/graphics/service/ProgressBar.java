package graphics.service;

public class ProgressBar {

    private static ProgressBar bar = null;
    private static StringBuilder progressString;
    private static int counter = 0;
    private static int size;

    private ProgressBar(int size) {
        this.size = size;
        this.progressString = new StringBuilder();
        for(int i = 0; i < size; i++) {
            progressString.append("-");
        }
    }

    public static void progress() {
        System.out.write(13);
        progressString.setCharAt(counter, '#');
        counter++;
        System.out.print(progressString);
        System.out.print(" " + (100 * counter) / size + "%");
    }

    public static ProgressBar getInstance(int size) {
        if(bar == null) {
            bar = new ProgressBar(size);
        }
        return bar;
    }
}
