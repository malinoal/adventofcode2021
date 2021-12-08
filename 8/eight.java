import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class eight {
    public static void main(String[] args) throws FileNotFoundException {
        part_one();
        part_two();
    }

    public static void part_one() throws FileNotFoundException {
        Scanner input = new Scanner(new File("8/input_preprocessed.txt")); // already cut out everything before the pipe with vim

        int occurrences = 0;
        while (input.hasNext()) {
            String word = input.next();
            if (word.length() != 5 && word.length() != 6) {
                occurrences++;
            }
        }

        System.out.println(occurrences);

    }


    public static void part_two() throws FileNotFoundException {
        Scanner input = new Scanner(new File("8/input.txt"));
        /**
         * lengths:
         * 1: 2
         * 4: 4
         * 7: 3
         * 8: 7
         * 0, 6, 9: 6
         * 2, 3, 5: 5
         */

        int result = 0;

        while(input.hasNext()) {
            List<String> currentLineDigits = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                currentLineDigits.add(input.next());
            }
            String bar = input.next();
            List<String> output = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                output.add(input.next());
            }

            StringBuilder code = new StringBuilder();

            for (String digit : output) {
                if (digit.length() == 2) {
                    code.append(1);
                }
                else if (digit.length() == 4) {
                    code.append(4);
                }
                else if (digit.length() == 3) {
                    code.append(7);
                }
                else if (digit.length() == 7) {
                    code.append(8);
                }
                else if (digit.length() == 6) {
                    zeroSixOrNine(currentLineDigits, code, digit);
                }
                else if (digit.length() == 5) {
                    twoThreeOrFive(currentLineDigits, code, digit);
                }
            }

            result += Integer.parseInt(code.toString());
        }

        System.out.println(result);

    }

    private static void twoThreeOrFive(List<String> currentLineDigits, StringBuilder code, String digit) {
        char[] one = currentLineDigits.stream().filter(s -> s.length() == 2).findFirst().get().toCharArray();
        boolean three = true;
        for (char c : one) {
            if (!digit.contains(c + "")) {
                three = false;
            }
        }
        if (three) {
            code.append(3);
        } else {
            twoOrFive(currentLineDigits, code, digit);

        }
    }

    private static void twoOrFive(List<String> currentLineDigits, StringBuilder code, String digit) {
        char[] four = currentLineDigits.stream().filter(s -> s.length() == 4).findFirst().get().toCharArray();
        int mishits = 0;
        for (char c : four) {
            if (!digit.contains(c + "")) {
                mishits++;
            }
        }
        if (mishits == 1) {
            code.append(5);
        } else if (mishits == 2) {
            code.append(2);
        }
    }

    private static void zeroSixOrNine(List<String> currentLineDigits, StringBuilder code, String digit) {
        char[] one = currentLineDigits.stream().filter(s -> s.length() == 2).findFirst().get().toCharArray();
        boolean zero = true;
        for (char c : one) {
            if (!digit.contains(c + "")) {
                zero = false;
            }
        }
        if (zero) {
            zeroOrNine(currentLineDigits, code, digit);
        } else {
            code.append(6);
        }
    }

    private static void zeroOrNine(List<String> currentLineDigits, StringBuilder code, String digit) {
        char[] four = currentLineDigits.stream().filter(s -> s.length() == 4).findFirst().get().toCharArray();
        boolean nine = true;
        for (char c : four) {
            if (!digit.contains(c + "")) {
                nine = false;
            }
        }
        if (nine) {
            code.append(9);
        } else {
            code.append(0);
        }
    }
}
