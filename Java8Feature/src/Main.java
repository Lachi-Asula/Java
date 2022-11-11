import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Integer[] x = {1,3,5,6};
        int y = 10;
        Integer z= y;
        List<Integer> i = Arrays.asList(x);
        Collections.reverse(i);
        System.out.println(x);
        System.out.println("Hello world!");
    }
}