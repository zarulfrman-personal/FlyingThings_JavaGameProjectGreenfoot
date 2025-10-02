import greenfoot.Actor;

public class Obstacle extends Actor
{
    private final int speed;
    private final int score;
    private boolean passedRocket = false;

    public Obstacle(int speed, int score) {
        this.speed = speed;
        this.score = score;
    }

    public void act()
    {
        moveObstacle();
        incrementScore();
        checkObjectLocation();
    }

    // A method to check if the current obstacle is located outside of user's screen
    public boolean isOffScreen()
    {
        return getX() < -getImage().getWidth() / 2 ||
                getX() > getWorld().getWidth() + getImage().getWidth() / 2 ||
                getY() < -getImage().getHeight() / 2 ||
                getY() > getWorld().getHeight() + getImage().getHeight() / 2;
    }

    public void incrementScore() {
        // If the obstacle's current X position is same as the rocket's current X position, increment user's score
        // by calling the incrementScore method of RocketGame class
        if (getX() < getWorld().getObjects(Character.class).get(0).getCharacterX() && !passedRocket) {
            MainWorld mainGame = (MainWorld) getWorld();
            mainGame.incrementScore(score);
            passedRocket = true;
        }
    }

    public void moveObstacle() {
        // Get the new xPosition for the obstacle by subtracting with speed variable over time. This will result in
        // a linear motion
        int xPosition = getX() - speed;

        // Set the new location for the obstacle using the new xPosition value
        setLocation(xPosition, getY());
    }

    public void checkObjectLocation() {
        // If obstacle is passing the boundaries of user's screen, remove the obstacle to remove unnecessary calculation
        // of the obstacle's position
        if (isOffScreen()) {
            getWorld().removeObject(this);
        }
    }

}
