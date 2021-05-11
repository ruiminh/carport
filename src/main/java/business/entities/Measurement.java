package business.entities;

import java.util.ArrayList;
import java.util.List;

public class Measurement {
    public static List<Integer> carportLengths = new ArrayList<>();
    public static List<Integer> carportWidths = new ArrayList<>();
    public static List<Integer> shedLengths = new ArrayList<>();
    public static List<Integer> shedWidths = new ArrayList<>();

    public static List<Integer> getCarportLengths() {
        int n = 240;
        while (n<781) {
            carportLengths.add(n);
            n+=30;
        }
        return carportLengths;
    }
    public static List<Integer> getCarportWidths() {
        int n = 240;
        while (n<751) {
            carportWidths.add(n);
            n+=30;
        }
        return carportWidths;
    }
    public static List<Integer> getShedLengthsLengths() {
        int n = 150;
        while (n<691) {
            shedLengths.add(n);
            n+=30;
        }
        return shedLengths;
    }
    public List<Integer> getShedWidths() {
        int n = 210;
        while (n<721) {
            carportLengths.add(n);
            n+=30;
        }
        return shedWidths;
    }
}
