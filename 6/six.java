import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class six {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(part_one("6/input.txt", 80));
        System.out.println(part_two("6/input.txt"));
    }

    public static int part_one(String filepath, int days) throws FileNotFoundException {
        Scanner input = new Scanner(new File(filepath));
        input.useDelimiter(",");
        List<Integer> fish = new ArrayList<>();
        while (input.hasNextInt()) {
            fish.add(input.nextInt());
        }

        return lanternFish(fish, days);
    }

    public static int lanternFish(int startValue, int timeLeft) {
        System.out.println("time left: " + timeLeft);
        int result = 1;
        System.out.println("current result: " + result);
        timeLeft -= startValue + 1;
        result++;
        System.out.println("time left: " + timeLeft);
        System.out.println("current result: " + result);
        startValue = 6;
        while (timeLeft >= 8) {
            timeLeft -= startValue + 1;
            result++;
            startValue = 6;
            timeLeft -= 2;
            startValue -= 2;
            result += (result - 2);
            System.out.println("time left: " + timeLeft);
            System.out.println("current result: " + result);
            System.out.println("time until next fish: " + startValue);
        }

        if(timeLeft >= startValue) {
            result++;
        }

        return result;
    }

    public static int lanternFish(List<Integer> fishList, int timeLeft) {
        int[] fish = new int[9];
        for (int fishy : fishList) {
            fish[fishy]++;
        }
        while (timeLeft-->0) {
            int newFish = fish[0];
            for (int i = 1; i < 9; i++) {
                fish[i-1] = fish[i];
            }
            fish[8] = newFish;
            fish[6] += newFish;
        }
        int result = 0;
        for (int i = 0; i < 9; i++) {
            result += fish[i];
        }

        return result;
    }

    public static int part_two(String filepath) throws FileNotFoundException {
        Scanner input = new Scanner(new File(filepath));

        return -1;
    }
}
