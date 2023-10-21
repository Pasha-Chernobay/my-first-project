import java.io.File;

public class Main {
    public static void main(String[] args) {
        String folderPath = "/Users/pavelchernobay/skillboxJava";
        File file = new File(folderPath);
        System.out.println(getFolderSize(file));
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