import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cloud extends Actor
{
    // Cloud's movement speed
    private final int speed = 3;

    public Cloud(int scaleRatio) {
        GreenfootImage image = getImage();

        // Scale the cloud's current size according to the scaleRatio
        image.scale(image.getWidth() * scaleRatio, image.getHeight() * scaleRatio);
    }

    public void act()
    {
        // Move the cloud towards left side of the screen linearly
        setLocation(getX() - speed, getY());

        // If the current cloud is located outside the screen, simply remove the cloud to remove unnecessary calculation
        if (isOffScreen()) {
            getWorld().removeObject(this);
        }

    }

    // A method to check if the current cloud is located outside of user's screen
    public boolean isOffScreen()
    {
        return getX() < -getImage().getWidth() / 2 ||
                getX() > getWorld().getWidth() + getImage().getWidth() / 2 ||
                getY() < -getImage().getHeight() / 2 ||
                getY() > getWorld().getHeight() + getImage().getHeight() / 2;
    }

}
