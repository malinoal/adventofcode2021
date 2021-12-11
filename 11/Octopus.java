import java.util.LinkedHashSet;
import java.util.Set;

public class Octopus {

    private int energyLevel;
    private Set<Octopus> neighbours;
    private eleven.FlashCounter flashCounter;
    private boolean hasFlashed;

    public Octopus(int startLevel, eleven.FlashCounter flashCounter) {
        this.energyLevel = startLevel;
        this.neighbours = new LinkedHashSet<>();
        this.flashCounter = flashCounter;
        this.hasFlashed = false;
    }

    public void increaseEnergy() {
        if (!hasFlashed) {
            energyLevel++;
            if (energyLevel > 9) {
                energyLevel = 0;
                flash();
            }
        }
    }

    public void addNeighbour(Octopus neighbour) {
        neighbours.add(neighbour);
        neighbour.addNeighbourOneWay(this);
    }

    public void addNeighbourOneWay(Octopus neighbour) {
        neighbours.add(neighbour);
    }

    public void flash() {
        hasFlashed = true;
        for (Octopus neighbour : neighbours) {
            neighbour.increaseEnergy();
        }
    }

    public void countFlash() {
        if (hasFlashed) {
            hasFlashed = false;
            flashCounter.countFlash();
        }
    }
}
