import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class Main {
    private static final String[] sizes = {"b", "kb", "Mb", "Gb", "Tb"};

    public static void main(String[] args) {
        String folderPath = "/Users/pavelchernobay/skillboxJava";
        File file = new File(folderPath);
        long start = System.currentTimeMillis();
        FolderSizeCalculator calculator = new FolderSizeCalculator(file);
        ForkJoinPool pool = new ForkJoinPool();
        long size = pool.invoke(calculator);
        System.out.println(size);
        //System.out.println(getFolderSize(file));
        System.out.println(getHumanReadableSize(size));
        System.out.println(System.currentTimeMillis() - start);
    }

    public static long getFolderSize(File folder) {
        long size = 0;
        if (folder.isFile()) {
            return folder.length();
        }
        File[] files = folder.listFiles();
        for (File file : files) {
            size += getFolderSize(file);
        }
        return size;
    }

    public static String getHumanReadableSize(long size) {
        for (int i = 0; i < sizes.length; i++) {
            double value = size / Math.pow(1024, i);
            if (value < 1024) {
                double val = Math.round(value * 100) / 100.;
                return val + " " + sizes[i];
            }
        }
        return "";
    }

    public static long getSizeFromHumanReadable(String size) {
        return 0;
    }
}