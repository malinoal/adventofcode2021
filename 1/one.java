import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class one {

    public static void first_part() throws FileNotFoundException {
        Scanner input = new Scanner(new File("1/input.txt"));

        int oldScan = input.nextInt();
        int newScan;
        int increases = 0;

        while(input.hasNextInt()) {
            newScan = input.nextInt();
            if (newScan > oldScan) {
                increases++;
            }
            oldScan = newScan;
        }

        System.out.println(increases);

        input.close();
    }

    public static void second_part() throws FileNotFoundException {
        Scanner input = new Scanner(new File("1/input.txt"));

        int one = input.nextInt();
        int two = input.nextInt();
        int three = input.nextInt();
        int newScan;
        int increases = 0;

        while(input.hasNextInt()) {
            newScan = input.nextInt();
            if (newScan + two + three > one + two + three) {
                increases++;
            }
            one = two;
            two = three;
            three = newScan;
        }

        System.out.println(increases);

        input.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        first_part();
        second_part();
    }
}
