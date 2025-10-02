import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class rocketButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RocketButton extends Actor
{
    /**
     * Act - do whatever the rocketButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.playSound("rocketsnd.wav");
            Greenfoot.setWorld(new RocketGame());
        }
    }
}
