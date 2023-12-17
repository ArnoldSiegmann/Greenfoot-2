
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class nachbar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class nachbar extends Actor
{
    static int speed = 3;
    static int x;
    static int y;
    static boolean isfollowing = false;
    public void act()
    {
        x= getX();
        y= getY();
        if(Greenfoot.isKeyDown("t")){
            isfollowing = true;
        }
        if(Greenfoot.isKeyDown("z")){
            isfollowing = true;
        }
        follow();
    }
    public void follow(){
        if(isfollowing){
            if(player.playerx > x){
                setLocation(getX()+3,getY());
            }if(player.playerx < x){
                setLocation(getX()-3,getY());
            }
        }
        
        
    }
}