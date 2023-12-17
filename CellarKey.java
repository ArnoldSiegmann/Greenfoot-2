import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class CellarKey here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CellarKey extends items
{
    static boolean isInInventory = false;
    static int keyx;
    static int keyy;
    static int NrOfItem;
    static int cooldown;
    static boolean isfalling;

    static int OfflineX;
    static int OfflineY;
    static int OfflineScene;
    static boolean getLastInf = false;
    static boolean onScreen = false;
    static boolean deletethisObject = false;
    static boolean lock = true;
    
    public void getLastInf(){
        OfflineX = getX();
        OfflineY = getY();
        onScreen = true;
        getLastInf = false;
    }
    public void act()
    {      
        if(lock){
            if(deletethisObject){
                getLastInf();
                onScreen = false;
                getWorld().removeObject(this);
            }
            lock = false;
        }
        if(onScreen){
            keyx = getX();
            keyy = getY();
            
            if(Greenfoot.isKeyDown("space")&& player.distanceTOCellarKey <50 && cooldown <0){
                if(MyWorld.slot1isused && cooldown < 0){
                    if(MyWorld.slot2isused && cooldown < 0){
                        if(MyWorld.slot3isused && cooldown < 0){
                            if(MyWorld.slot4isused){
                                
                            }
                            if(MyWorld.slot4isused == false){
                                MyWorld.NameOfItem4 = "CellarKey";
                                isInInventory = true;
                                NrOfItem = 4;
                                MyWorld.slot4isused = true;
                            }
                            cooldown = 5;
                        }
                        if(MyWorld.slot3isused == false){
                            MyWorld.NameOfItem3 = "CellarKey";
                            isInInventory = true;
                            NrOfItem = 3;
                            MyWorld.slot3isused = true;
                        }
                        cooldown = 5;
                    }
                    if(MyWorld.slot2isused == false){
                        MyWorld.NameOfItem2 = "CellarKey";
                        isInInventory = true;
                        NrOfItem = 2;
                        MyWorld.slot2isused = true;
                    }
                    cooldown = 5;
                }
                if(MyWorld.slot1isused == false){
                    MyWorld.NameOfItem1 = "CellarKey";
                    isInInventory = true;
                    NrOfItem = 1;
                    MyWorld.slot1isused = true;
                
                }
                cooldown = 100;
            }
            if(Greenfoot.isKeyDown("q") && MyWorld.SlotSel == NrOfItem){
                OfflineX = getX();
                OfflineY = getY();
                OfflineScene = MyWorld.CurrentScene;
                isInInventory = false;
                setLocation(player.playerx, player.playery-50);
                if(MyWorld.SlotSel == 1){
                    MyWorld.NameOfItem1 = "No Item";
                    MyWorld.slot1isused = false;
                }
                if(MyWorld.SlotSel == 2){
                    MyWorld.NameOfItem2 = "No Item";
                    MyWorld.slot2isused = false;
                }
                if(MyWorld.SlotSel == 3){
                    MyWorld.NameOfItem3 = "No Item";
                    MyWorld.slot3isused = false;
                }
                if(MyWorld.SlotSel == 4){
                    MyWorld.NameOfItem4 = "No Item";
                    MyWorld.slot4isused = false;
                }
                
                NrOfItem = 0;
                
            }
            if(isInInventory == false){
                setLocation(getX(),getY()+5);
                isfalling = true;
                if(getY()>player.ScreenFloor){
                    setLocation(getX(),player.ScreenFloor);
                    isfalling = false;
                }
                
            }
            if(isInInventory){
                setLocation(NrOfItem*100,100);
            }
            cooldown = cooldown -1;
        }
    }
}
