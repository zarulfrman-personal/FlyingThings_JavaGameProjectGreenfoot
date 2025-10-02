import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Egg here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Egg extends Obstacle
{
    private double GRAVITY = 0.1;
    private double deltaY = 0.5;

    public Egg(int speed, int score) {
        super(speed, score);
    }

    @Override
    public void act() {
        super.act();
        deltaY += deltaY * GRAVITY;
        setLocation(getX(), (int) (getY() + deltaY));

        if (isOffScreen()) {
            getWorld().removeObject(this);
        }
    }
}
