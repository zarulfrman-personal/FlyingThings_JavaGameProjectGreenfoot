import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RestartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RestartButton extends Actor
{
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.playSound("buttonclicksnd.wav");
            Greenfoot.setWorld(new StartInterface());
        }
    }
}
