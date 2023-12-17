import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CarKey here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class pileOfPictures extends items
{
    static int x;
    static int y;
    static int NrOfItem;
    static int cooldown;
    
    static int OfflineX;
    static int OfflineY;
    static int OfflineScene;
    static boolean getLastInf = false;
    static boolean onScreen = false;
    static boolean deleteObject = false;
    static boolean lock = true;
    static boolean deletethisObject = false;
    
    public void act()
    {
        if(lock){
            if(deletethisObject){
                onScreen = false;
                getWorld().removeObject(this);
            }
            lock = false;
        }
        
        if(onScreen){
            x = getX();
            y = getY();
        
        
            MyWorld.showPictures = true;
            if(Greenfoot.isKeyDown("e") && player.distanceTOpileOfPictures <50){ 
                getWorldOfType(MyWorld.class).addPicture();
                picture.onScreen = true;
                picture.start = true;
                picture.stop = false;
                MyWorld.playermoveable = false;
                if(cooldown < 0){
                    MyWorld.addpicture = true;
                    MyWorld.picturesecure = true;
                }
                
                picture.NrOfPic= 1;
                cooldown = 100;
            }
            if(MyWorld.showPictures && Greenfoot.isKeyDown("space")){
                picture.start = false;
                picture.stop = true;
                MyWorld.playermoveable = true;
                MyWorld.addpicture = false;
                MyWorld.picturesecure = false;
            }
            cooldown = cooldown -1;
        }
        
    }
}
