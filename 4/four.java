import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class four {

    public static void main(String[] args) throws FileNotFoundException {
        part_one();
        part_two();
    }

    public static void part_one() throws FileNotFoundException {
        Scanner input = new Scanner(new File("4/input.txt"));
        String firstLine = input.nextLine();

        List<Integer> drawnNumbers = Arrays.stream(firstLine.split(","))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> bingo = new ArrayList<>();

        while(input.hasNext()){
            bingo.add(input.nextInt());
        }

        List<Integer> hitPositions = new ArrayList<>();

        for(int number : drawnNumbers) {
            for (int i = 0; i < bingo.size(); i++) {
                if (bingo.get(i) == number) {
                    hitPositions.add(i);
                }
            }
            hitPositions = hitPositions.stream().sorted().collect(Collectors.toList());
            for (int position : hitPositions) {
                int rowstart = position - (position % 5);
                int[] row = IntStream.range(rowstart, rowstart + 5).toArray();
                int columnPos = position % 5;
                int bingoField = position % 25;
                int columnStart = position - bingoField + columnPos;
                int[] column = {columnStart, columnStart + 5, columnStart + 10, columnStart + 15, columnStart + 20};
                boolean rowBingo = isBingo(hitPositions, row);
                boolean columnBingo = isBingo(hitPositions, column);

                if(rowBingo || columnBingo) {
                    int score = 0;
                    for (int i = position - bingoField; i < position - bingoField + 25; i++) {
                        if (!hitPositions.contains(i)) {
                            score += bingo.get(i);
                        }
                    }
                    score *= number;
                    System.out.println(score);
                    return;
                }
            }
        }
    }

    private static boolean isBingo(List<Integer> hitPositions, int[] row) {
        boolean isBingo = true;
        for (int rowElement : row) {
            if (!hitPositions.contains(rowElement)) {
                isBingo = false;
                break;
            }
        }
        return isBingo;
    }

    public static void part_two() throws FileNotFoundException {

    }
}
