import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class StartButton extends Actor
{
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.playSound("buttonclicksnd.wav");
            Greenfoot.setWorld(new ChooseChar());
        }

    }
}
