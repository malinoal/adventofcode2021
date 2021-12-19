import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class six {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(part_one("6/input.txt", 80));
        System.out.println(part_two("6/input.txt", 256));
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

    public static BigInteger part_two(String filepath, int days) throws FileNotFoundException {
        Scanner input = new Scanner(new File(filepath));
        input.useDelimiter(",");
        List<Integer> fish = new ArrayList<>();
        while (input.hasNextInt()) {
            fish.add(input.nextInt());
        }

        return lanternFishPartTwo(fish, days);
    }

    public static BigInteger lanternFishPartTwo(List<Integer> fishList, int timeLeft) {
        BigInteger[] fish = new BigInteger[9];
        for (int i = 0; i < 9; i++) {
            fish[i] = new BigInteger("0");
        }
        for (int fishy : fishList) {
            fish[fishy] = fish[fishy].add(BigInteger.ONE);
        }
        while (timeLeft-->0) {
            BigInteger newFish = fish[0];
            for (int i = 1; i < 9; i++) {
                fish[i-1] = fish[i];
            }
            fish[8] = newFish;
            fish[6] = fish[6].add(newFish);
        }
        BigInteger result = new BigInteger("0");
        for (int i = 0; i < 9; i++) {
            result = result.add(fish[i]);
        }

        return result;
    }
}
