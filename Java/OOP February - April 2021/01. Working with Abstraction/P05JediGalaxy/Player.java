package P05JediGalaxy;

public class Player {
    private Galaxy galaxy;
    private long collectedPoints;

    public Player(Galaxy galaxy) {
        this.galaxy = galaxy;
    }

    public void collectStars(int row, int col) {
        while (row >= 0 && col < this.galaxy.getInnerLength(1)) {
            if (row < this.galaxy.getLength() && col >= 0 && col < this.galaxy.getInnerLength(0)) {
                this.collectedPoints += galaxy.getStar(row, col);
            }
            row--;
            col++;
        }
    }

    public long getCollectedPoints() {
        return this.collectedPoints;
    }
}
