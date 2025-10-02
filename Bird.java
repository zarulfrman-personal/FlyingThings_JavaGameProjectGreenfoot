import greenfoot.Greenfoot;

public class Bird extends Obstacle
{
    private int localTime = 0;
    private double FPS = 60.00;
    private double eggSpawnRate = 0.5;
    private int speed;
    private boolean isBertelur = false;
    private int score;

    public Bird(int speed, int score) {
        super(speed, score);
        this.speed = speed;
        this.score = score;
    }

    @Override
    public void act() {

        localTime++;

        moveObstacle();
        incrementScore();

        if (Math.floor(localTime % (FPS * eggSpawnRate)) == (double) 0 && !isBertelur) {
            spawnEgg();
            isBertelur = true;
        }

        if (isOffScreen()) {
            getWorld().removeObject(this);
        }

    }

    private void spawnEgg() {
        getWorld().addObject(new Egg(5, 5), getX(), getY());
    }

}
