package CounterStriker.models.guns;

public abstract class GunImpl implements Gun{
    private String name;
    private int bulletsCount;

    protected GunImpl(String name, int bulletsCount) {
        this.setName(name);
        this.setBulletsCount(bulletsCount);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setBulletsCount(int bulletsCount) {
        this.bulletsCount = bulletsCount;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getBulletsCount() {
        return 0;
    }

    @Override
    public int fire() {
        return 0;
    }
}
