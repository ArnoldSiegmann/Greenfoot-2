import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bike here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bike extends Actor
{
    /**
     * Act - do whatever the bike wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {   
        if(player.bikevisible){
            setImage("bike.png");
        }
        if(player.bikevisible != true){
            setImage("bikein.png");
        }
    }
}
