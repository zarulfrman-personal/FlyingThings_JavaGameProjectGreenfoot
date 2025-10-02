import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character extends Actor
{
    // These values are customizable according to your preference
    private final double FRICTION = 0.05;
    private final double ROTATION_THRESHOLD = 1.75;
    private final double VELOCITY_FACTOR = 0.75;

    // This variable is responsible to the change of rocket's velocity and rotation
    private double deltaY = 0;
    
    public int getCharacterX() {
        return getImage().getWidth() / 2;
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("up"))
        {
            // If user holds down the "up" keyboard button, deltaY will continue to decrement by linear
            deltaY -= VELOCITY_FACTOR;
        }
        else if(Greenfoot.isKeyDown("down"))
        {
            // If user holds down the "down" keyboard button, deltaY will continue to increment by linear
            deltaY += VELOCITY_FACTOR;
        }

        // If the rocket collides with any obstacle, set the game to game over state
        if(isTouching(Obstacle.class))
        {
            removeTouching(Obstacle.class);
            setGameOver();
        }

        // If user tries to move the rocket outside game screen, set the game to game over state
        if (getY() > getWorld().getHeight() || getY() < 0) {
            setGameOver();
        }

        // Normally, if deltaY is 0, rocket will fly straight to the right side of the screen. If there are any changes
        // to the deltaY variable, the game will try to resist the change and get back to the normal state of the rocket
        if (deltaY != 0) {

            // Only change the Y position of the rocket according to the deltaY value
            setLocation(getX(), getY() + (int)deltaY);

            // Rotate the rocket according to the deltaY value.
            // Note: Since the deltaY value is small, ROTATION_THRESHOLD is multiplied to the deltaY value, so that
            // the rotation of the rocket can be seen by the user. If the value of ROTATION_THRESHOLD is higher, so the
            // rotation effect on the rocket will be much stronger
            setRotation((int) (deltaY * ROTATION_THRESHOLD));

            if (deltaY > 0) {
                // Firstly we calculate the friction amount from the normal deltaY value,
                // then we can decrease the deltaY value gradually by the friction value over time until it reaches 0.
                // This will make the rocket slightly have inertia feeling when the user releases their keyboard.
                double change = FRICTION * deltaY;
                deltaY -= change;
            }
            else if (deltaY < 0) {
                // Firstly we calculate the friction amount from the normal deltaY value,
                // then we can decrease the deltaY value gradually by the friction value over time until it reaches 0.
                // This will make the rocket slightly have inertia feeling when the user releases their keyboard.
                double change = FRICTION * deltaY;
                deltaY -= change;
            }
        }

    }

    // A simple game over method
    private void setGameOver() {
        MainWorld world = (MainWorld) getWorld();
        Greenfoot.setWorld(new GameOver(world.getScore()));
    }
}
