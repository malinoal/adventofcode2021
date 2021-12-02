import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class two {

    public static void main(String[] args) throws FileNotFoundException {
        part_one();
        part_two();
    }

    public static void part_one() throws FileNotFoundException {
        Scanner input = new Scanner(new File("2/input.txt"));
        int depth = 0;
        int horizontal = 0;
        while (input.hasNext()) {
            String direction = input.next();
            if (direction.equals("forward")) {
                horizontal += input.nextInt();
            }
            else if (direction.equals("down")) {
                depth += input.nextInt();
            }
            else if (direction.equals("up")) {
                depth -= input.nextInt();
            }
        }

        System.out.println(depth*horizontal);
    }

    public static void part_two() throws FileNotFoundException {
        Scanner input = new Scanner(new File("2/input.txt"));
        int depth = 0;
        int horizontal = 0;
        int aim = 0;
        while (input.hasNext()) {
            String direction = input.next();
            if (direction.equals("forward")) {
                int x = input.nextInt();
                horizontal += x;
                depth += aim * x;
            }
            else if (direction.equals("down")) {
                aim += input.nextInt();
            }
            else if (direction.equals("up")) {
                aim -= input.nextInt();
            }
        }

        System.out.println(depth*horizontal);
    }
}
