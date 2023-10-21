import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        String folderPath = "/Users/pavelchernobay/skillboxJava";
        File file = new File(folderPath);
        long start = System.currentTimeMillis();
        FolderSizeCalculator calculator = new FolderSizeCalculator(file);
        ForkJoinPool pool = new ForkJoinPool();
        long size = pool.invoke(calculator);
        System.out.println(size);
        //System.out.println(getFolderSize(file));
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
}