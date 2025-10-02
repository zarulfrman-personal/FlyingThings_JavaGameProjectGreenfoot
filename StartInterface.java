import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class StartInterface extends World
{
    public StartInterface()
    {
        super(1000, 700, 1); 
        addObject(new StartButton(), 500, 500);
    }
}
