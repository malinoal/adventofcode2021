import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class ten {
    public static void main(String[] args) throws FileNotFoundException {
        part_one();
        part_two();
    }

    public static void part_one() throws FileNotFoundException {
        Scanner input = new Scanner(new File("10/input.txt"));

        int points = 0;
        List<BigInteger> completionScores = new ArrayList<>();

        while (input.hasNextLine()) {
            String line = input.nextLine();
            int round = 0;
            int corner = 0;
            int swirly = 0;
            int pointy = 0;
            Stack<Character> nextClose = new Stack<>();

            currentLine: for (char c : line.toCharArray()) {
                switch (c) {
                    case '(':
                        round++;
                        nextClose.push(')');
                        break;
                    case '[':
                        corner++;
                        nextClose.push(']');
                        break;
                    case '{':
                        swirly++;
                        nextClose.push('}');
                        break;
                    case '<':
                        pointy++;
                        nextClose.push('>');
                        break;
                    case ')':
                        round--;
                        if (round < 0 || nextClose.peek() != c) {
                            points += 3;
                            nextClose.clear();
                            break currentLine;
                        }
                        nextClose.pop();
                        break;
                    case ']':
                        corner--;
                        if (corner < 0 || nextClose.peek() != c) {
                            points += 57;
                            nextClose.clear();
                            break currentLine;
                        }
                        nextClose.pop();
                        break;
                    case '}':
                        swirly--;
                        if (swirly < 0 || nextClose.peek() != c) {
                            points += 1197;
                            nextClose.clear();
                            break currentLine;
                        }
                        nextClose.pop();
                        break;
                    case '>':
                        pointy--;
                        if (pointy < 0 || nextClose.peek() != c) {
                            points += 25137;
                            nextClose.clear();
                            break currentLine;
                        }
                        nextClose.pop();
                        break;
                }

            }

            if (!nextClose.isEmpty()) {
                BigInteger completionScore = BigInteger.valueOf(0);
                while (!nextClose.isEmpty()) {
                    completionScore = completionScore.multiply(BigInteger.valueOf(5));
                    char c = nextClose.pop();
                    switch (c) {
                        case ')' -> completionScore = completionScore.add(BigInteger.valueOf(1));
                        case ']' -> completionScore = completionScore.add(BigInteger.valueOf(2));
                        case '}' -> completionScore = completionScore.add(BigInteger.valueOf(3));
                        case '>' -> completionScore = completionScore.add(BigInteger.valueOf(4));
                    }
                }
                completionScores.add(completionScore);
            }

        }

        System.out.println(points);
        BigInteger finalScore = completionScores.stream().sorted().collect(Collectors.toList()).get((completionScores.size() / 2));
        System.out.println(finalScore);

    }

    public static void part_two() throws FileNotFoundException {

    }

}
