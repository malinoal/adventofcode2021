import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class twelve {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(part_one("12/input.txt"));
        System.out.println(part_two("12/input.txt"));
    }

    public static int part_one(String filePath) throws FileNotFoundException {
        Scanner input = new Scanner(new File(filePath));
        List<Cave> caves = new ArrayList<>();

        while(input.hasNextLine()) {
            String line = input.nextLine();
            String[] caveNames = line.split("-");
            Cave cave1 = caves.stream().filter(cave -> cave.getName().equals(caveNames[0])).findFirst().orElse(new Cave(caveNames[0]));
            Cave cave2 = caves.stream().filter(cave -> cave.getName().equals(caveNames[1])).findFirst().orElse(new Cave(caveNames[1]));
            cave1.addNeighbour(cave2);
            cave2.addNeighbour(cave1);
            caves.add(cave1);
            caves.add(cave2);
        }

        Cave start = caves.stream().filter(cave -> cave.getName().equals("start")).findFirst().get();

        return getNumPaths(start, Collections.emptyList());
    }

    public static int getNumPaths(Cave start, List<String> previsited) {
        int numPaths = 0;
        List<String> visited = new ArrayList<>(previsited);
        if (start.isSmall()) {
            visited.add(start.getName());
        }
        for (Cave neighbour : start.getNeighbours()) {
            if (neighbour.getName().equals("end")) {
                numPaths++;
            } else if (!visited.contains(neighbour.getName())) {
                numPaths += getNumPaths(neighbour, visited);
            }
        }
        return numPaths;
    }

    public static int part_two(String filePath) throws FileNotFoundException {
        Scanner input = new Scanner(new File(filePath));
        List<Cave> caves = new ArrayList<>();

        while(input.hasNextLine()) {
            String line = input.nextLine();
            String[] caveNames = line.split("-");
            Cave cave1 = caves.stream().filter(cave -> cave.getName().equals(caveNames[0])).findFirst().orElse(new Cave(caveNames[0]));
            Cave cave2 = caves.stream().filter(cave -> cave.getName().equals(caveNames[1])).findFirst().orElse(new Cave(caveNames[1]));
            cave1.addNeighbour(cave2);
            cave2.addNeighbour(cave1);
            caves.add(cave1);
            caves.add(cave2);
        }

        Cave start = caves.stream().filter(cave -> cave.getName().equals("start")).findFirst().get();

        return getNumPathsPartTwo(start, Collections.emptyList(), false);
    }

    public static int getNumPathsPartTwo(Cave start, List<String> previsited, boolean visitedTwice) {
        int numPaths = 0;
        List<String> visited = new ArrayList<>(previsited);
        if (start.isSmall()) {
            visited.add(start.getName());
        }
        for (Cave neighbour : start.getNeighbours()) {
            if (neighbour.getName().equals("end")) {
                numPaths++;
            } else if (!visited.contains(neighbour.getName())) {
                numPaths += getNumPathsPartTwo(neighbour, visited, visitedTwice);
            } else if (visited.contains(neighbour.getName()) && !visitedTwice && !neighbour.getName().equals("start")) {
                numPaths += getNumPathsPartTwo(neighbour, visited, true);
            }
        }
        return numPaths;
    }


}
