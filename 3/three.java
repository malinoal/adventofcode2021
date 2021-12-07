import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class three {

    public static void main(String[] args) throws FileNotFoundException {
        part_one();
        part_two();
    }

    public static void part_one() throws FileNotFoundException {
        Scanner input = new Scanner(new File("3/input.txt"));

        char[] line = input.nextLine().toCharArray();
        int length = line.length;
        int[] occurences = new int[length];
        count(line, length, occurences);
        int lines = 1;

        while(input.hasNextLine()) {
            line = input.nextLine().toCharArray();
            count(line, length, occurences);
            lines++;
        }

        int finalLines = lines;
        int gamma = Integer.parseInt(Arrays.stream(occurences).mapToObj(i -> i > finalLines /2 ? "1" : "0").collect(Collectors.joining()), 2);
        int sigma = Integer.parseInt(Arrays.stream(occurences).mapToObj(i -> i > finalLines /2 ? "0" : "1").collect(Collectors.joining()), 2);

        System.out.println(sigma*gamma);
    }

    private static void count(char[] line, int length, int[] occurences) {
        for (int i = 0; i < length; i++) {
            occurences[i] += Integer.parseInt(String.valueOf(line[i]));
        }
    }

    public static void part_two() throws FileNotFoundException {
        Scanner input = new Scanner(new File("3/input.txt"));

        List<char[]> lines = new ArrayList<>();
        char[] line = input.nextLine().toCharArray();
        lines.add(line);
        int length = line.length;
        int[] occurences = new int[length];
        count(line, length, occurences);
        int numlines = 1;

        while(input.hasNextLine()) {
            line = input.nextLine().toCharArray();
            lines.add(line);
            count(line, length, occurences);
            numlines++;
        }

        final int finalNumlines = numlines;
        System.out.println("computing oxygen rating...");
        int oxygen = getRating(lines, '1' , '0');
        System.out.println("computing co2 rating...");
        int co2 = getRating(lines, '0' , '1');

        System.out.println("oxygen: " + oxygen);
        System.out.println("co2: " + co2);
        System.out.println("sum: " + oxygen*co2);

    }

    private static int getRating(List<char[]> lines, char trueBit, char falseBit) {
        List<char[]> oxyCandidates = List.copyOf(lines);
        int pos = 0;
        int length = lines.get(0).length;

        while (oxyCandidates.size() > 1) {
            int[] occurences = new int[length];
            for (char[] candidate : oxyCandidates) {
                count(candidate, length, occurences);
            }
            char bit = occurences[pos] >= oxyCandidates.size() - occurences[pos] ? trueBit : falseBit;
            int finalPos = pos;
            oxyCandidates = oxyCandidates.stream().filter(candidate -> candidate[finalPos] == bit).collect(Collectors.toList());
            pos++;
        }

        String binary = String.valueOf(oxyCandidates.get(0));
        System.out.println(binary);
        return Integer.parseInt(binary, 2);
    }
}
