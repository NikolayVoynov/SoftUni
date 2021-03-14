package P05JediGalaxy;

public class Enemy {
    private Galaxy galaxy;

    public Enemy(Galaxy galaxy) {
        this.galaxy = galaxy;
    }

    public void deleteStars(int row, int col) {
        while (row >= 0 && col >= 0) {
            if (row < this.galaxy.getLength() && col < this.galaxy.getInnerLength(row)) {
                this.galaxy.setStar(row, col, 0);
            }
            row--;
            col--;
        }
    }
}
