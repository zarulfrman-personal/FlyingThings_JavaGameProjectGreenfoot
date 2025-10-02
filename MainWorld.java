import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class MainWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainWorld extends World
{
    private final double FRAME_PER_SECOND = 60.00;
    private final int TOP_SPACING = 10;
    private final int BOTTOM_SPACING = 10;

    private int time = 0;
    private int score = 0;
    private double birdSpawnRate = 1.00; // Per second
    private double cloudSpawnRate = 0.5;

    final int MIN_CLOUD_SCALE = 1;
    final int MAX_CLOUD_SCALE = 4;
    final int CLOUD_SPACING_TOP = 10;

    private int birdSpeed = 10;
    private double SPAWN_RATE_INCREMENT = 0.20;
    private double SPAWN_RATE_INCREMENT_INTERVAL = 10.0; // At what second spawn rate will increase by SPAWN_RATE_INCREMENT variable

    private double SPEED_RATE_INCREMENT = 1;
    private double SPEED_RATE_INCREMENT_INTERVAL = 10.0; // At what second speed rate will be increased by SPEED_RATE_INCREMENT variable
    
    private Actor character;

    public MainWorld(Actor character)
    {
        super(1000, 700, 1, false);
        this.character = character;
        prepare();
    }

    public void act() {

        // Game time counter
        time++;

        // Bird spawner per time based on the birdSpawnRate value
        if (Math.floor(time % (FRAME_PER_SECOND / birdSpawnRate)) == (double) 0) {
            // Generate a random Y position for the bird with a bit of space from the top and bottom screen by the
            // TOP_SPACING and BOTTOM_SPACING variables
            int randomPos = Greenfoot.getRandomNumber(getHeight() - TOP_SPACING - BOTTOM_SPACING) + TOP_SPACING;
            Bird birdObstacle = new Bird(birdSpeed, 10);
            addObject(birdObstacle, getWidth(), randomPos);
        }

        // Cloud spawner per time based on the cloudSpawnRate value
        if (Math.floor(time % (FRAME_PER_SECOND / cloudSpawnRate)) == (double) 0) {
            // Generate a random Y position for the cloud with a bit of space from user's top screen by the
            // CLOUD_SPACING_TOP variable
            int cloudRandomYPos = Greenfoot.getRandomNumber(getHeight()/2) + CLOUD_SPACING_TOP;

            // Generate a random scale ratio for the spawned cloud between MIN_CLOUD_SCALE and MAX_CLOUD_SCALE
            int cloudRandomScale = MIN_CLOUD_SCALE + Greenfoot.getRandomNumber(MAX_CLOUD_SCALE - MIN_CLOUD_SCALE);
            addObject(new Cloud(cloudRandomScale), getWidth(), cloudRandomYPos);
        }

        // Every SPAWN_RATE_INCREMENT_INTERVAL, birdSpawnRate will be incremented by SPAWN_RATE_INCREMENT
        if ((double) time % (SPAWN_RATE_INCREMENT_INTERVAL * FRAME_PER_SECOND) == (double) 0) {
            birdSpawnRate += SPAWN_RATE_INCREMENT;
        }

        // Every SPEED_RATE_INCREMENT_INTERVAL, birdSpawnRate will be incremented by SPEED_RATE_INCREMENT
        if ((double) time % (SPEED_RATE_INCREMENT_INTERVAL * FRAME_PER_SECOND) == (double) 0) {
            birdSpeed += SPEED_RATE_INCREMENT;
        }

        // Set image order so that rocket will not fly behind clouds
        setPaintOrder(Character.class, Obstacle.class, Cloud.class);

        // Shows the current spawn rate for the bird at the top of the screen
        showText("Bird spawn rate: " + birdSpawnRate + " per second", getWidth()/2, 70);

        showText("Bird current speed: " + birdSpeed, getWidth()/2, 90);

    }

    private void prepare()
    {
        // One hardcoded cloud to start the game
        int cloudRandomYPos = Greenfoot.getRandomNumber(getHeight()/2);
        addObject(new Cloud(2), getWidth(), cloudRandomYPos + CLOUD_SPACING_TOP);

        addObject(character, 175, 350);
        showScore();
    }
    public void incrementScore(int scoreToAdd) {
        score += scoreToAdd;
        showScore();
    }

    public void showScore() {
        showText("Score: " + score, getWidth() / 2, 50);
    }

    public int getScore() { return score; }
}
