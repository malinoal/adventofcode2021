import java.util.ArrayList;
import java.util.List;

public class Cave {

    private String name;
    private boolean small;
    private List<Cave> neighbours;

    public Cave(String name) {
        this.name = name;
        this.small = Character.isLowerCase(name.charAt(0));
        neighbours = new ArrayList<>();
    }

    public void addNeighbour(Cave neighbour) {
        neighbours.add(neighbour);
    }

    public boolean isSmall() {
        return small;
    }

    public List<Cave> getNeighbours() {
        return neighbours;
    }

    public String getName() {
        return name;
    }
}
