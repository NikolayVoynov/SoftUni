package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

public abstract class PlayerImpl implements Player{
    private String username;
    private int health;
    private int armor;
    private boolean isAlive;
    private Gun gun;

    protected PlayerImpl(String username, int health, int armor, Gun gun) {
        this.setUsername(username);
        this.setHealth(health);
        this.setArmor(armor);
        this.setGun(gun);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public int getHealth() {
        return 0;
    }

    @Override
    public int getArmor() {
        return 0;
    }

    @Override
    public Gun getGun() {
        return null;
    }

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public void takeDamage(int points) {

    }
}
