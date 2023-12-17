import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.World;

/**
 * Write a description of class picture here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class picture extends items
{
    static boolean start = false;
    static boolean stop = false;
    static int NrOfPic= 1;
    static int cooldown = 50;
    static int x;
    static int y;
    static boolean onScreen = false;
    /**
     * Act - do whatever the picture wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act()
    {
        if(onScreen){
            x = getX();
            y = getY();
            if(start){
                getWorldOfType(MyWorld.class).showLeave();
                if(cooldown<-50){
                    if(Greenfoot.isKeyDown("d")||Greenfoot.isKeyDown("RIGHT")){
                        NrOfPic = NrOfPic +1;
                        cooldown = 50;
                    }
                    if(Greenfoot.isKeyDown("a")||Greenfoot.isKeyDown("LEFT")){
                        NrOfPic = NrOfPic -1;
                        cooldown = 50;
                    }
                }
                
                if(NrOfPic == 1){
                    setImage("P1.jpeg");
                }
                if(NrOfPic == 2){
                    setImage("P2.jpeg");
                }
                if(NrOfPic == 3){
                    setImage("P3.jpeg");
                }
                if(NrOfPic == 4){
                    setImage("P4.jpeg");
                }
                if(NrOfPic == 5){
                    setImage("P5.jpeg");
                }
                if(NrOfPic == 6){
                    setImage("P6.jpeg");
                }
                if(NrOfPic == 7){
                    setImage("P7.jpeg");
                }
                if(NrOfPic == 8){
                    setImage("P8.jpeg");
                }
                if(NrOfPic == 9){
                    setImage("P9.jpeg");
                }
                if(NrOfPic == 10){
                    setImage("P10.jpeg");
                }
                if(NrOfPic<1){
                    NrOfPic = 1;
                }
                if(NrOfPic>10){ 
                    NrOfPic = 10;
                }
                cooldown = cooldown-1;
            }
            if(stop){
                getWorldOfType(MyWorld.class).showLeaveBlank();
                getWorld().removeObject(this);
                start = false;
            }
        }
        
    }
}