import java.io.File;

public class SizeCalculator {
    private static final String[] sizes = {"b", "kb", "Mb", "Gb", "Tb"};

    public static String getHumanReadableSize(long size) {
        for (int i = 0; i < sizes.length; i++) {
            double value = size / Math.pow(1024, i);
            if (value < 1024) {
                double val = Math.round(value * 100) / 100.;
                return val + " " + sizes[i];
            }
        }
        return "Very big!";
    }

    public static long getSizeFromHumanReadable(String size) {
        return 0;
    }
}
