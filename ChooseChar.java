import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class chooseChar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChooseChar extends World
{

    /**
     * Constructor for objects of class chooseChar.
     * 
     */
    public ChooseChar()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        addObject(new RocketButton(), 175, 330);
        addObject(new WitchButton(), 500, 330);
        addObject(new SuperheroButton(), 825, 330);
    }

}
