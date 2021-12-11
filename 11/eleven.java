import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class eleven {
    public static void main(String[] args) throws FileNotFoundException {
        part_one();
        part_two();
    }

    public static void part_one() throws FileNotFoundException {
        Scanner input = new Scanner(new File("11/input.txt"));
        char[][] startLevels = new char[10][10];
        Octopus[][] octopi = new Octopus[10][10];
        FlashCounter flashCounter = new FlashCounter();
        for (int i = 0; i < 10; i++) {
            String line = input.nextLine();
            for (int j = 0; j < 10; j++) {
                startLevels[i][j] = line.charAt(j);
                Octopus current = new Octopus(Integer.parseInt(line.charAt(j) + ""), flashCounter);
                octopi[i][j] = current;
                if (i > 0) {
                    current.addNeighbour(octopi[i-1][j]);
                }
                if (j > 0) {
                    current.addNeighbour(octopi[i][j-1]);
                }
                if (j > 0 && i > 0) {
                    current.addNeighbour(octopi[i-1][j-1]);
                }
                if (i > 0 && j < 9) {
                    current.addNeighbour(octopi[i-1][j+1]);
                }
            }
        }

        for (int t = 0; t < 100; t++) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    octopi[i][j].increaseEnergy();
                }
            }
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    octopi[i][j].countFlash();
                }
            }
        }

        System.out.println(flashCounter.getFlashes());
    }

    public static class FlashCounter {
        private int flashes;

        public FlashCounter() {
            flashes = 0;
        }

        public void countFlash() {
            flashes++;
        }

        public int getFlashes() {
            return flashes;
        }

        public void clearFlashes() {
            flashes = 0;
        }
    }

    public static void part_two() throws FileNotFoundException {
        Scanner input = new Scanner(new File("11/input.txt"));
        char[][] startLevels = new char[10][10];
        Octopus[][] octopi = new Octopus[10][10];
        FlashCounter flashCounter = new FlashCounter();
        for (int i = 0; i < 10; i++) {
            String line = input.nextLine();
            for (int j = 0; j < 10; j++) {
                startLevels[i][j] = line.charAt(j);
                Octopus current = new Octopus(Integer.parseInt(line.charAt(j) + ""), flashCounter);
                octopi[i][j] = current;
                if (i > 0) {
                    current.addNeighbour(octopi[i-1][j]);
                }
                if (j > 0) {
                    current.addNeighbour(octopi[i][j-1]);
                }
                if (j > 0 && i > 0) {
                    current.addNeighbour(octopi[i-1][j-1]);
                }
                if (i > 0 && j < 9) {
                    current.addNeighbour(octopi[i-1][j+1]);
                }
            }
        }

        for (int t = 0; t < 1000; t++) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    octopi[i][j].increaseEnergy();
                }
            }
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    octopi[i][j].countFlash();
                }
            }
            if (flashCounter.getFlashes() > 99) {
                System.out.println(t+1);
                t = 9999999;
            }
            if (flashCounter.getFlashes() < 100) {
                flashCounter.clearFlashes();
            }
        }

    }

}
