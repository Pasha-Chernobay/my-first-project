import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        String folderPath = "/Users/pavelchernobay/skillboxJava";
        File file = new File(folderPath);
        Node root = new Node(file);

        long start = System.currentTimeMillis();

        FolderSizeCalculator calculator = new FolderSizeCalculator(root);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(calculator);

        System.out.println(root);

        System.out.println(System.currentTimeMillis() - start);
    }
}