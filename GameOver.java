import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameOver extends World
{
    int finalScore;

    public GameOver(int score)
    {
        super(1000, 700, 1);
        this.finalScore = score;
        Greenfoot.playSound("gameover2snd.wav");
        addObject(new RestartButton(), getWidth()/2, (3 * getHeight())/4 + 50);

        // Prints the user's final score to the screen
        showText("Your final score is: " + score, getWidth()/2, 100);
    }
}
