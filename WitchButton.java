import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WitchButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WitchButton extends Actor
{
    /**
     * Act - do whatever the WitchButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.playSound("witchchoosesnd.mp3");
            Greenfoot.setWorld(new WitchGame());
        }
    }
}
