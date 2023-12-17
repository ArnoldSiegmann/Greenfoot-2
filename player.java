import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class player extends Actor
{
    //Greenfoot.playSound("test.wav");
    static int playerx;
    static int playery;
    static double distanceTOCarKey;
    static double distanceTOHouseKey;
    static double distanceTOPoliceKey;
    static double distanceTOMineKey;
    static double distanceTOCabinetKey;
    static double distanceTOCellarKey;
    static double distanceTOWorkroomKey;
    static double distanceTOGardenScissors;
    static double distanceTOpileOfPictures;
    static int cooldown = 0;
    static boolean ismoving = false;
    
    static int speed;
    static int speedlimit;
    static int changeX;
    static int changeY;
    static boolean changeScene = false;
    static boolean unspeed = false;
    
    static int OfflineX;
    static int OfflineY;
    static int OfflineScene;
    static boolean getLastInf;
    static boolean onScreen = true;
    
    static int counterNeighbour;
    
    
    static boolean goToMine = false;
    static boolean bike = true;
    static boolean goToTelephone = true;
    static boolean GoHome = false;
    static boolean noCall = true;
    static boolean GoToLibrary= false;
    static boolean waitPolice = false;
    static boolean end = false;
    
    static boolean doorlocked = true;
    static boolean door2locked = true;
    static boolean door3locked = true;
    static boolean door4locked = true;
    static int policetimer = 300;
    static boolean countpolice = false;
    static boolean toPolice = false;
    static int MineCounter = 500;
    static boolean CountMine = false;
    static boolean realendcountdown = false;
    static int realendcount = 500;
    static boolean wasInNeighbour = false;
    
    static boolean book1 = true;
    static boolean book2 = true;
    static boolean book3 = true;
    static boolean book4 = true;
    static boolean book5 = true;
    static boolean book6 = true;
    static boolean book7 = true;
    static boolean book8 = true;
    static boolean book9 = true;
    static boolean book10 = true;
    static boolean book11 = true;
    static boolean book12 = true;
    static int bookcounter = 3;
    static boolean Search = true;
    static boolean bikevisible = false;
    static boolean bikeequiped = true;
    static int con = 0;
    static int concounter = 0;
    static boolean onetime = true;
    
    //
    static int Screenwidth = 1280;
    static int Screenheigth = 720;
    static int ScreenRight = Screenwidth - Screenwidth /12;
    static int Screen3_4 = Screenwidth*3/4;
    static int ScreenMiddle  = Screenwidth/2;
    static int Screen1_4 = Screenwidth*1/4;
    static int ScreenLeft = Screenwidth / 12;
    //
    static int ScreenUp = 204;
    static int ScreenMiddleY = Screenheigth/2;
    static int ScreenDown = 380;
    static int ScreenFloor = 462;
    static int PlayerRight = Screenwidth - Screenwidth/11;
    static int Player3_4 = Screenwidth*3/4;
    static int PlayerMiddle  = Screenwidth /2;
    static int Player1_4 = Screenwidth*1/4;
    static int PlayerLeft = Screenwidth/ 11;
    
    static int SceneLeft =Screenwidth /11;
    static int Scene1_4 = Screenwidth*1/4;
    static int SceneMiddle = Screenwidth/2 - Screenwidth/12;
    static int Scene3_4 = Screenwidth*3/4;
    static int SceneRight = Screenwidth - Screenwidth /11;
    
    static boolean onTable = false;
    static int books = 0;
    
    static boolean carpressed = false;
    static boolean deletethisObject = false;
    static boolean lock = true;
    static int wait = 10;
    static int playercount;
    static boolean minecount = false;
    static int minecounter = 1000;
    
    static boolean neighbourinmine = true;
    static boolean trappedMine = false;
    static boolean jumpscare = false;
    
    static int sleepcounter;
    static boolean RealEnd = false;
    static boolean EscapeTown = false;
    static boolean EscapeBush= false;
    static boolean EscapeMine = false;
    static boolean Sleep = false;
    static boolean Save = false;
    static boolean Trapped = false;
    static boolean Trapped2 = false;
    
    
    
    static int RealEndScene = 120;
    static int EscapeTownScene = 121;
    static int EscapeBushScene = 122;
    static int EscapemineScene = 123;
    static int SleepScene = 124;
    static int SaveScene = 126;
    static int TrappedScene = 128;
    static int Trapped2Scene = 129;
    public void getLastInf(){
        OfflineX = getX();
        OfflineY = getY();
        OfflineScene = MyWorld.CurrentScene;
        getLastInf = false;
    }
    public void act()
    {
        if(lock){
            if(deletethisObject){
                getLastInf();
                onScreen = false;
                getWorld().removeObject(this);
                wait = 10;
            }
            lock = false;
        }
        
        if(onScreen){
            
        
            if(changeScene){
                setLocation(changeX, changeY);
                changeScene = false;
            }
            ismoving = false;
            playerx= getX();
            playery=getY();
            if(MyWorld.playermoveable){
                if(Greenfoot.isKeyDown("a"))           
                {
                    moveLeft();
                }
                if(Greenfoot.isKeyDown("d"))           
                {
                    moveRight();
                }
                if(Greenfoot.isKeyDown("LEFT"))           
                {
                    moveLeft();
                }
                if(Greenfoot.isKeyDown("RIGHT"))
                {
                    moveRight();
                }
            }
            
            distanceTOHouseKey = Math.sqrt((HouseKey.keyx - playerx) * (HouseKey.keyx - playerx) + (HouseKey.keyy - playery) * (HouseKey.keyy - playery));   
            distanceTOCarKey = Math.sqrt((CarKey.keyx - playerx) * (CarKey.keyx - playerx) + (CarKey.keyy - playery) * (CarKey.keyy - playery));  
            distanceTOPoliceKey = Math.sqrt((PoliceKey.keyx - playerx) * (PoliceKey.keyx - playerx) + (PoliceKey.keyy - playery) * (PoliceKey.keyy - playery));  
            distanceTOMineKey = Math.sqrt((MineKey.keyx - playerx) * (MineKey.keyx - playerx) + (MineKey.keyy - playery) * (MineKey.keyy - playery));  
            distanceTOpileOfPictures = Math.sqrt((pileOfPictures.x - playerx) * (pileOfPictures.x - playerx) + (pileOfPictures.y - playery) * (pileOfPictures.y - playery));
            distanceTOCabinetKey = Math.sqrt((CabinetKey.keyx - playerx) * (CabinetKey.keyx - playerx) + (CabinetKey.keyy - playery) * (CabinetKey.keyy - playery));
            distanceTOCellarKey = Math.sqrt((CellarKey.keyx - playerx) * (CellarKey.keyx - playerx) + (CellarKey.keyy - playery) * (CellarKey.keyy - playery));
            distanceTOWorkroomKey = Math.sqrt((WorkroomKey.keyx - playerx) * (WorkroomKey.keyx - playerx) + (WorkroomKey.keyy - playery) * (WorkroomKey.keyy - playery));
            distanceTOGardenScissors = Math.sqrt((GardenScissors.keyx - playerx) * (GardenScissors.keyx - playerx) + (GardenScissors.keyy - playery) * (GardenScissors.keyy - playery));
            if(MyWorld.CurrentScene == 1){
                if(getX()<ScreenLeft){
                    setLocation(ScreenLeft, getY());
                }    
                
                //Corridor2up
                if(getX()>ScreenRight){
                    MyWorld.NextScene = "to Corridor";
                    getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 2;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("corridor2up");
                        cooldown = 40;
                        MyWorld.count = true;
                        lock = true;
                        deletethisObject = true;
                        MyWorld.PX = ScreenLeft;
                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()<ScreenRight){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                }
            }
            
            if(MyWorld.CurrentScene == 2){
                getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);//Bedroom
                if(getX()<ScreenLeft){
                    MyWorld.NextScene = "to Bedroom";
                    getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        MyWorld.CurrentScene = 1;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("bedroom");
                        cooldown = 40;
                        MyWorld.count = true;
                        lock = true;
                        deletethisObject = true;
                        MyWorld.PX = ScreenRight;
                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()>ScreenLeft){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                }
                //Bath
                if(getX()>(ScreenMiddle-50)&&getX()<(ScreenMiddle+50)){
                    MyWorld.NextScene = "to Bathroom";
                    getWorldOfType(MyWorld.class).showNextScene(ScreenMiddle,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        MyWorld.CurrentScene = 3;
                        getWorldOfType(MyWorld.class).NshowNextScene(ScreenMiddle,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("bathroom");
                        cooldown = 40;
                        MyWorld.count = true;
                        lock = true;
                        deletethisObject = true;
                        MyWorld.PX = ScreenLeft;
                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()<(ScreenMiddle-50)||getX()>(ScreenMiddle+50)){
                    getWorldOfType(MyWorld.class).NshowNextScene(ScreenMiddle,ScreenMiddleY);
                }
                //Corridorup
                if(getX()>ScreenRight){
                    MyWorld.NextScene = "to Corridor";
                    getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        MyWorld.CurrentScene = 4;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight, ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("corridorup");
                        cooldown = 40;
                        MyWorld.count = true;
                        lock = true;
                        deletethisObject = true;
                        MyWorld.PX = ScreenLeft;
                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()<ScreenRight){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneRight, ScreenMiddleY);
                }
            }
            
            if(MyWorld.CurrentScene == 3){
                //Corridor2up
                if(getX()<ScreenLeft){
                    MyWorld.NextScene = "to Corridor";
                    getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 2;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("corridor2up");
                        cooldown = 40;
                        MyWorld.count = true;
                        lock = true;
                        deletethisObject = true;
                        MyWorld.PX = ScreenMiddle;
                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()>ScreenLeft){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                }
            }
            if(MyWorld.CurrentScene == 4){
                //Corridor2up
                if(getX()<ScreenLeft){
                    MyWorld.NextScene = "to Corridor";
                    getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 2;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("corridor2");
                        cooldown = 40;
                        MyWorld.count = true;
                        lock = true;
                        deletethisObject = true;
                        MyWorld.PX = ScreenRight;
                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()>ScreenLeft){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                }
                //Anne Room
                if(getX()>(ScreenMiddle-50)&&getX()<(ScreenMiddle+50)){
                    MyWorld.NextScene = "to Anne's Room";
                    getWorldOfType(MyWorld.class).showNextScene(ScreenMiddle,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 5;
                        getWorldOfType(MyWorld.class).NshowNextScene(ScreenMiddle,ScreenMiddleY);
                        cooldown = 40;
                        MyWorld.count = true;
                        lock = true;
                        deletethisObject = true;
                        MyWorld.PX = ScreenLeft;
                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()<(ScreenMiddle-50)||getX()>(ScreenMiddle+50)){
                    getWorldOfType(MyWorld.class).NshowNextScene(ScreenMiddle,ScreenMiddleY);
                }
                //Corridor2
                if(getX()>ScreenRight){
                    MyWorld.NextScene = "Downstairs";
                    getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 6;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("corridor2");
                        cooldown = 40;
                        MyWorld.count = true;
                        lock = true;
                        deletethisObject = true;
                        MyWorld.PX = ScreenRight;
                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()<ScreenRight){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                }
            }
            if(MyWorld.CurrentScene == 5){
                //Corridorup
                if(getX()<ScreenLeft){
                    MyWorld.NextScene = "to Corridor";
                    getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 4;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("corridorup");
                        cooldown = 40;
                        MyWorld.count = true;
                        lock = true;
                        deletethisObject = true;
                        MyWorld.PX = ScreenMiddle;
                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()>ScreenLeft){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                }
                
            }
            if(MyWorld.CurrentScene == 6){
                //Corridorup
                if(getX()<ScreenLeft){
                    MyWorld.NextScene = "to Corridor";
                    getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 8;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("corridor");
                        cooldown = 40;
                        MyWorld.count = true;
                        lock = true;
                        deletethisObject = true;
                        MyWorld.PX = ScreenRight;
                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()>ScreenLeft){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                }
                //Workroom
                if(getX()>(ScreenMiddle-50)&&getX()<(ScreenMiddle+50)){
                    MyWorld.NextScene = "to Workroom";
                    getWorldOfType(MyWorld.class).showNextScene(ScreenMiddle,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 7;
                        getWorldOfType(MyWorld.class).NshowNextScene(ScreenMiddle,ScreenMiddleY);
                        cooldown = 40;
                        MyWorld.count = true;
                        lock = true;
                        deletethisObject = true;
                        MyWorld.PX = ScreenLeft;
                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()<(ScreenMiddle-50)||getX()>(ScreenMiddle+50)){
                    getWorldOfType(MyWorld.class).NshowNextScene(ScreenMiddle,ScreenMiddleY);
                }
                //Corridor
                if(getX()>ScreenRight){
                    MyWorld.NextScene = " Upstairs";
                    getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 4;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("corridorup");
                        cooldown = 40;
                        MyWorld.count = true;
                        lock = true;
                        deletethisObject = true;
                        
                        MyWorld.PX = ScreenRight;
                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()<ScreenRight){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                }
            }
            if(MyWorld.CurrentScene == 7){
                //Corridor2
                if(getX()<ScreenLeft){
                    MyWorld.NextScene = "to Corridor";
                    getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 6;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("corridor2");
                        cooldown = 40;
                        MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenMiddle;                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()>ScreenLeft){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                }
            }
            if(MyWorld.CurrentScene == 8){
            //Corridor2
            if(getX()>ScreenRight){
                MyWorld.NextScene = "to Corridor ";
                getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                    getWorldOfType(MyWorld.class).getInfo();
                    MyWorld.CurrentScene = 6;
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                    getWorldOfType(MyWorld.class).SceneUpdate("corridor2");
                    cooldown = 40;
                    MyWorld.count = true;
                    lock = true;                        
                    deletethisObject = true;
                    MyWorld.PX = ScreenLeft; 
                    MyWorld.PY = ScreenFloor;
                }
            }
            if(getX()<ScreenRight){
                getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
            }
            //Livingroom
            if(getX()>Screen3_4-50 && getX()<Screen3_4+50){
                MyWorld.NextScene = "to Livingroom";
                getWorldOfType(MyWorld.class).showNextScene(Screen3_4,ScreenMiddleY);
                if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                    getWorldOfType(MyWorld.class).getInfo();
                    MyWorld.CurrentScene = 9;
                    getWorldOfType(MyWorld.class).NshowNextScene(Screen3_4,ScreenMiddleY);
                    cooldown = 40;
                    MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenLeft;                        MyWorld.PY = ScreenFloor;
                }
            }
            if(getX()<Screen3_4-50||getX()>Screen3_4+50){
                getWorldOfType(MyWorld.class).NshowNextScene(Screen3_4,ScreenMiddleY);
            }
            //kitchen
            if(getX()>Screen1_4 && getX()<Screen1_4 +100){
                MyWorld.NextScene = "to Kitchen";
                getWorldOfType(MyWorld.class).showNextScene(Screen1_4+50,ScreenMiddleY);
                if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                    getWorldOfType(MyWorld.class).getInfo();
                    MyWorld.CurrentScene = 10;
                    getWorldOfType(MyWorld.class).NshowNextScene(Screen1_4+50,ScreenMiddleY);
                    cooldown = 40;
                    MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenLeft;                        MyWorld.PY = ScreenFloor;
                }
            }
            if(getX()<Screen1_4||getX()>Screen1_4+100){
                getWorldOfType(MyWorld.class).NshowNextScene(Screen1_4+50,ScreenMiddleY);
            }
            //street1
            if(getX()<ScreenLeft){
                if(doorlocked){
                    if(HouseKey.isInInventory == false){
                        MyWorld.NextScene4 = "You need a House Key";
                        getWorldOfType(MyWorld.class).showNextScene4(SceneLeft,ScreenMiddleY);
                    }  
                    if(HouseKey.isInInventory){
                        MyWorld.NextScene4 = "Unlock door";
                        getWorldOfType(MyWorld.class).showNextScene4(SceneLeft,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")){
                            doorlocked = false;
                        }
                    }
                }if(doorlocked == false){
                    MyWorld.NextScene = "Outside";
                    getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 11;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("street1");                        cooldown = 40;
                        MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenMiddle;                        MyWorld.PY = ScreenFloor;
                    }
                }
            }
            if(getX()>ScreenLeft){
                getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
            }
                }
            if(MyWorld.CurrentScene == 9){
                //Corridor
                if(getX()<ScreenLeft){
                    MyWorld.NextScene = "to Corridor";
                    getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 8;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("corridor");
                        cooldown = 40;
                        MyWorld.count = true;
                            lock = true;
                            deletethisObject = true;
                            MyWorld.PX = Screen3_4;
                            MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()>ScreenLeft){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                }
            }
            if(MyWorld.CurrentScene == 10){
                //Corridor
                if(getX()<ScreenLeft){
                    MyWorld.NextScene = "to Corridor";
                    getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 8;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("corridor");
                        cooldown = 40;
                        MyWorld.count = true;
                        lock = true;                        
                        deletethisObject = true;
                        MyWorld.PX = Screen1_4+50; 
                        MyWorld.PY = ScreenFloor;                  
                    }
                }        
                if(getX()>ScreenLeft){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                }
            }
            if(MyWorld.CurrentScene == 11){
                if(goToMine && bikeequiped == false){
                    bikevisible = true;
                    MyWorld.NextScene4 = "Take Bike";
                    getWorldOfType(MyWorld.class).showNextScene4(Screen3_4,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        cooldown = 40;
                        bikeequiped = true;
                        bike = true;
                        getWorldOfType(MyWorld.class).NshowNextScene(Screen3_4,ScreenMiddleY);
                    }
                }
                if(getX()<(Screen3_4-50) || getX()>(Screen3_4+50)){
                    getWorldOfType(MyWorld.class).NshowNextScene4(Screen3_4,ScreenMiddleY);
                }
                //Corridor
                if(getX()>(ScreenMiddle-50)&&getX()<(ScreenMiddle+50)){
                    MyWorld.NextScene = "Inside";
                    getWorldOfType(MyWorld.class).showNextScene(ScreenMiddle,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        GoHome = false;
                        goToTelephone = false;
                        if(onetime){
                            countpolice = true;
                            onetime = false;
                        }
                        
                        
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 8;
                        getWorldOfType(MyWorld.class).NshowNextScene(ScreenMiddle,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("corridor");
                        cooldown = 40;
                        MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenLeft;                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()<(ScreenMiddle-50)||getX()>(ScreenMiddle+50)){
                    getWorldOfType(MyWorld.class).NshowNextScene(ScreenMiddle,ScreenMiddleY);
                }
                //street2
                if(getX()<ScreenLeft){
                    MyWorld.NextScene = "to Next Street";
                    getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 12;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("street2");
                        cooldown = 40;
                        MyWorld.count = true;
                        lock = true;
                        deletethisObject = true;
                        MyWorld.PX = ScreenRight;
                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()>ScreenLeft){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                }
                }
            if(MyWorld.CurrentScene == 12){
                //street1
                if(getX()>ScreenRight){
                    MyWorld.NextScene = "to Next Street";
                    getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 11;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("street1");
                        cooldown = 40;
                        MyWorld.count = true;                       
                        lock = true;                      
                        deletethisObject = true;          
                        MyWorld.PX = ScreenLeft;                        
                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()<ScreenRight){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                }
                //telephone
                if(getX()>(ScreenMiddle-50)&&getX()<(ScreenMiddle+50)){
                    MyWorld.NextScene = "to Telephone Box";
                    getWorldOfType(MyWorld.class).showNextScene(ScreenMiddle,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 13;
                        getWorldOfType(MyWorld.class).NshowNextScene(ScreenMiddle,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("telephone");
                        cooldown = 40;
                        MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenLeft;                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()<(ScreenMiddle-50)||getX()>(ScreenMiddle+50)){
                    getWorldOfType(MyWorld.class).NshowNextScene(ScreenMiddle,ScreenMiddleY);
                }
                //street3
                if(getX()<ScreenLeft){
                    if(goToTelephone||GoHome){
                        MyWorld.NextScene4 = "Can't go there yet.";
                        getWorldOfType(MyWorld.class).showNextScene4(SceneLeft,ScreenMiddleY);
                    }
                    if(goToTelephone == false && GoHome == false){
                        MyWorld.NextScene = "to Next Street";
                        getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                    }
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0 && goToTelephone == false&&GoHome == false){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 14;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("street5");                        cooldown = 40;
                            MyWorld.count = true;                    lock = true;                    deletethisObject = true;                    MyWorld.PX = ScreenRight;                    MyWorld.PY = ScreenFloor;   
                    }
                }
                if(getX()>ScreenLeft){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                }
            }
            if(MyWorld.CurrentScene == 13){
                //street2
                if(getX()<ScreenLeft){
                    MyWorld.NextScene = "to Next Street";
                    getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 12;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("street2");
                        cooldown = 40;
                        MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenMiddle;                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()>ScreenLeft){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                }
                //conversation
                if(getX()>ScreenMiddle-50&&getX()<ScreenMiddle+50){
                    if(noCall){
                        MyWorld.NextScene4= "Call Mom";
                        getWorldOfType(MyWorld.class).showNextScene4(ScreenMiddle,ScreenMiddleY);
                    }
                    if(GoHome){
                        MyWorld.NextScene4= "Go  Home";
                        getWorldOfType(MyWorld.class).showNextScene4(ScreenMiddle,ScreenMiddleY);
                    }
                    if(cooldown < 0 && Greenfoot.isKeyDown("Space") && GoHome == false){
                        MyWorld.playermoveable = false;
                        concounter = concounter +1;
                        getWorldOfType(MyWorld.class).NshowNextScene(ScreenMiddle,ScreenMiddleY);
                    }
                    if(concounter == 1){
                        noCall = false;
                        MyWorld.NextScene4= "Man : Hello?, Who is there?";
                        getWorldOfType(MyWorld.class).showNextScene4(ScreenMiddle,ScreenMiddleY);
                    }
                    if(concounter == 2){
                        MyWorld.NextScene4= "Georg : I am Georg.";
                        getWorldOfType(MyWorld.class).showNextScene4(ScreenMiddle,ScreenMiddleY);
                    }if(concounter == 3){
                         MyWorld.NextScene4= "Georg : I am calling because my mom didn't come back from work.";
                        getWorldOfType(MyWorld.class).showNextScene4(ScreenMiddle,ScreenMiddleY);
                    }if(concounter == 4){
                        MyWorld.NextScene4= "Man : Well, she left some time ago. ";
                        getWorldOfType(MyWorld.class).showNextScene4(ScreenMiddle,ScreenMiddleY);
                    }if(concounter == 5){
                        MyWorld.NextScene4= "Man : I am going to send someone to you for your safety. ";
                        getWorldOfType(MyWorld.class).showNextScene4(ScreenMiddle,ScreenMiddleY);
                    }if(concounter == 6){
                        MyWorld.NextScene4= "Georg : Thanks. ";
                        getWorldOfType(MyWorld.class).showNextScene4(ScreenMiddle,ScreenMiddleY);
                    }if(concounter == 7){
                        MyWorld.NextScene4= "Man : If I get some news I will tell you. ";
                        getWorldOfType(MyWorld.class).showNextScene4(ScreenMiddle,ScreenMiddleY);
                    }if(concounter == 8){
                        MyWorld.NextScene4= "Georg : Good Bye. ";
                        getWorldOfType(MyWorld.class).showNextScene4(ScreenMiddle,ScreenMiddleY);
                    }if(concounter == 9){
                        MyWorld.NextScene4= "Man : Take care. ";
                        getWorldOfType(MyWorld.class).showNextScene4(ScreenMiddle,ScreenMiddleY);
                    }if(concounter == 10){
                        noCall = true;
                        MyWorld.playermoveable = true;
                        GoHome = true;
                    }
                    
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        noCall = false;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("street2");
                            cooldown = 40;
                            MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenMiddle;                        MyWorld.PY = ScreenFloor;
                        }
            
                    if(getX()>ScreenLeft){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                    }
                }
                if(getX()<ScreenMiddle-50||getX()>ScreenMiddle+50){
                    getWorldOfType(MyWorld.class).NshowNextScene(ScreenMiddle,ScreenMiddleY);
                }
                
            }
                
                if(MyWorld.CurrentScene == 14){
                    //street2
                    if(getX()>ScreenRight){
                        MyWorld.NextScene = "to Next Street";
                        getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 12;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("street2");
                            cooldown = 40;
                            MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenLeft;                        MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()<ScreenRight){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                    }
                    //Neighbour
                    if(getX()>(ScreenMiddle-50)&&getX()<(ScreenMiddle+50)){
                        MyWorld.NextScene = "to Neighbour";
                        getWorldOfType(MyWorld.class).showNextScene(ScreenMiddle,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 15;
                            getWorldOfType(MyWorld.class).NshowNextScene(ScreenMiddle,ScreenMiddleY);
                            //getWorldOfType(MyWorld.class).SceneUpdate("neighbour");
                            cooldown = 40;
                            MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenLeft;                        MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()<(ScreenMiddle-50)||getX()>(ScreenMiddle+50)){
                        getWorldOfType(MyWorld.class).NshowNextScene(ScreenMiddle,ScreenMiddleY);
                    }
                    //Street4
                    if(getX()<ScreenLeft){
                        MyWorld.NextScene = "to Next Street";
                        getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 31;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("street5");
                            cooldown = 40;
                            MyWorld.count = true;                    lock = true;                    deletethisObject = true;                    MyWorld.PX = ScreenRight;                    MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()>ScreenLeft){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                    }
                }
                if(MyWorld.CurrentScene == 15){
                    MyWorld.playermoveable = false;
                    //Garden
                    if(true){
                        MyWorld.NextScene = "to Garden";
                        getWorldOfType(MyWorld.class).showNextScene(Screen1_4,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("a")||Greenfoot.isKeyDown("left")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 16;
                            getWorldOfType(MyWorld.class).NshowNextScene(Screen1_4,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).NshowNextScene2(Screen3_4,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).NshowNextScene3(ScreenMiddle,ScreenFloor);
                            //getWorldOfType(MyWorld.class).SceneUpdate("garden");
                            cooldown = 40;
                            MyWorld.count = true;                    lock = true;                    deletethisObject = true;                    MyWorld.PX = ScreenRight;                    MyWorld.PY = ScreenFloor;
                            MyWorld.playermoveable = true;
                        }
                    }
                    //House
                    if(true){
                        MyWorld.NextScene2 = "Inside";
                        getWorldOfType(MyWorld.class).showNextScene2(Screen3_4,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("d")||Greenfoot.isKeyDown("right")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 23;
                            getWorldOfType(MyWorld.class).NshowNextScene(Screen1_4,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).NshowNextScene2(Screen3_4,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).NshowNextScene3(ScreenMiddle,ScreenFloor);
                            //getWorldOfType(MyWorld.class).SceneUpdate("neighbourhouse");
                            cooldown = 40;
                            MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenLeft;                        MyWorld.PY = ScreenFloor;
                            MyWorld.playermoveable = true;
                        }
                    }
                    //stree3
                    if(true){
                        MyWorld.NextScene3 = "Back";
                        getWorldOfType(MyWorld.class).showNextScene3(ScreenMiddle,ScreenFloor);
                        if(Greenfoot.isKeyDown("s")||Greenfoot.isKeyDown("down")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 14;
                            getWorldOfType(MyWorld.class).NshowNextScene(Screen1_4,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).NshowNextScene2(Screen3_4,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).NshowNextScene3(ScreenMiddle,ScreenFloor);
                            getWorldOfType(MyWorld.class).SceneUpdate("street5");
                            cooldown = 40;
                            MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenMiddle;                        MyWorld.PY = ScreenFloor;
                            MyWorld.playermoveable = true;
                        }
                    }
                }
                if(MyWorld.CurrentScene == 16){
                    getWorldOfType(MyWorld.class).NshowNextScene(Screen1_4,ScreenMiddleY);
                    getWorldOfType(MyWorld.class).NshowNextScene2(Screen3_4,ScreenMiddleY);
                    getWorldOfType(MyWorld.class).NshowNextScene3(ScreenMiddle,ScreenFloor);
                    //Backhouse
                    if(getX()<SceneLeft){
                        MyWorld.NextScene = "behind the House";
                        getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 17;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                            //getWorldOfType(MyWorld.class).SceneUpdate("backhouse");
                            cooldown = 40;
                            MyWorld.count = true;                    lock = true;                    deletethisObject = true;                    MyWorld.PX = ScreenRight;                    MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()>SceneLeft){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                    }
                    //Neighbour
                    if(getX()>ScreenRight){
                        MyWorld.NextScene = " Back";
                        getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 15;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                            //getWorldOfType(MyWorld.class).SceneUpdate("neighbour");
                            cooldown = 40;
                            MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenMiddle;                        MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()<ScreenRight){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                    }
                }
                if(MyWorld.CurrentScene == 17){
                    //secret1
                    if(getX()>ScreenLeft+50&&getX()<ScreenLeft+150){
                        MyWorld.NextScene = "to Bush";
                        getWorldOfType(MyWorld.class).showNextScene(ScreenLeft+50,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 18;
                            getWorldOfType(MyWorld.class).NshowNextScene(ScreenLeft+50,ScreenMiddleY);
                            //getWorldOfType(MyWorld.class).SceneUpdate("secret1");
                            cooldown = 40;
                            MyWorld.count = true;                    lock = true;                    deletethisObject = true;                    MyWorld.PX = ScreenRight;                    MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()<ScreenLeft+50||getX()>ScreenLeft+150){
                        getWorldOfType(MyWorld.class).NshowNextScene(ScreenLeft+50,ScreenMiddleY);
                    }
                }
                if(MyWorld.CurrentScene == 18){
                    //secret2
                    if(getX()<ScreenLeft){
                        MyWorld.NextScene = " further";
                        getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 19;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                            //getWorldOfType(MyWorld.class).SceneUpdate("secret2");
                            cooldown = 40;
                            MyWorld.count = true;                    lock = true;                    deletethisObject = true;                    MyWorld.PX = ScreenRight;                    MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()>ScreenLeft){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                    }
                    //Backhouse
                    if(getX()>ScreenRight){
                        MyWorld.NextScene = " Back";
                        getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 16;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                            //getWorldOfType(MyWorld.class).SceneUpdate("garden");
                            cooldown = 40;
                            MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenLeft;                        MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()<ScreenRight){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                    }
                }
                if(MyWorld.CurrentScene == 19){
                    //secret3
                    if(getX()<ScreenLeft){
                        MyWorld.NextScene = " further";
                        getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 20;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                            //getWorldOfType(MyWorld.class).SceneUpdate("secret3");
                            cooldown = 40;
                            MyWorld.count = true;                    lock = true;                    deletethisObject = true;                    MyWorld.PX = ScreenRight;                    MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()>ScreenLeft){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                    }
                    //secret1
                    if(getX()>ScreenRight){
                        MyWorld.NextScene = " Back";
                        getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 18;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                            //getWorldOfType(MyWorld.class).SceneUpdate("secret1");
                            cooldown = 40;
                            MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenLeft;                        MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()<ScreenRight){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                    }
                }
                    if(MyWorld.CurrentScene == 20){
                    //phone
                    if(getX()>ScreenMiddle-50&&getX()<ScreenMiddle+50){
                        MyWorld.NextScene4 = "Look";
                        getWorldOfType(MyWorld.class).showNextScene4(ScreenMiddle,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 22;
                            getWorldOfType(MyWorld.class).NshowNextScene4(ScreenMiddle,ScreenMiddleY);
                            //getWorldOfType(MyWorld.class).SceneUpdate("secret3");
                            cooldown = 40;
                            MyWorld.count = true;                    lock = true;                    deletethisObject = true;                    MyWorld.PX = ScreenRight;                    MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()<ScreenMiddle-50||getX()>ScreenMiddle+50){
                        getWorldOfType(MyWorld.class).NshowNextScene(ScreenMiddle,ScreenMiddleY);
                    }
                    //secret4
                    if(getX()<ScreenLeft){
                        MyWorld.NextScene = " further";
                        getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 21;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                            //getWorldOfType(MyWorld.class).SceneUpdate("secret4");
                            cooldown = 40;
                            MyWorld.count = true;                    lock = true;                    deletethisObject = true;                    MyWorld.PX = ScreenRight;                    MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()>ScreenLeft){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                    }
                    //secret2
                    if(getX()>ScreenRight){
                        MyWorld.NextScene = "Back";
                        getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 19;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                            //getWorldOfType(MyWorld.class).SceneUpdate("secret2");
                            cooldown = 40;
                            MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenLeft;                        MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()<ScreenRight){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                    }
                }
                if(MyWorld.CurrentScene == 21){
                    //secret3
                    if(getX()>ScreenRight){
                        MyWorld.NextScene = "Back";
                        getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 20;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                            //getWorldOfType(MyWorld.class).SceneUpdate("secret3");
                            cooldown = 40;
                            MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenLeft;                        MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()<ScreenRight){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                    }
                    if(getX()<Screen1_4){
                        setLocation(Screen1_4, ScreenFloor);
                    }
                    if(getX()<Screen1_4+75){
                        if(GardenScissors.isInInventory == false){
                            MyWorld.NextScene4 = "Maybe there is something I can find.";
                            getWorldOfType(MyWorld.class).showNextScene4(Screen1_4-75,ScreenMiddleY);
                        }
                        if(GardenScissors.isInInventory){
                            MyWorld.NextScene4 = "Cut";
                            getWorldOfType(MyWorld.class).showNextScene4(Screen1_4-75,ScreenMiddleY);
                            if(Greenfoot.isKeyDown("Space")){
                                EscapeBush = true;
                                lock = true;
                                deletethisObject = true;
                            }
                        }
                    }
                    if(getX()>Screen1_4+75){
                        getWorldOfType(MyWorld.class).NshowNextScene4(Screen1_4-75,ScreenMiddleY);
                    }
                }
                if(MyWorld.CurrentScene == 22){
                    setImage("playerin.png");
                    MyWorld.NextScene ="Back";
                    getWorldOfType(MyWorld.class).showNextScene(ScreenMiddle,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("s")|| Greenfoot.isKeyDown("down") && cooldown<0){
                        MyWorld.CurrentScene = 20;
                        getWorldOfType(MyWorld.class).NshowNextScene(ScreenMiddle,ScreenMiddleY);
                        //getWorldOfType(MyWorld.class).SceneUpdate("secret3");
                        cooldown = 40;
                        MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenMiddle;                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(MyWorld.CurrentScene == 23){
                    getWorldOfType(MyWorld.class).NshowNextScene(Screen1_4,ScreenMiddleY);
                    getWorldOfType(MyWorld.class).NshowNextScene2(Screen3_4,ScreenMiddleY);
                    getWorldOfType(MyWorld.class).NshowNextScene3(ScreenMiddle,ScreenFloor);
                    MyWorld.NextScene4 = "[Space] to enter";
                    getWorldOfType(MyWorld.class).showNextScene4(ScreenMiddle,ScreenMiddleY);
                    
                    //corridor1neighbour
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 24;
                            getWorldOfType(MyWorld.class).NshowNextScene(ScreenMiddle,ScreenMiddleY);
                            //getWorldOfType(MyWorld.class).SceneUpdate("corridor1neighbour");
                            cooldown = 40;
                            MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenLeft;                        MyWorld.PY = ScreenFloor;
                        }
                    
                }
                if(MyWorld.CurrentScene == 24){
                    wasInNeighbour = true;
                    //neighbour
                    if(getX()<ScreenLeft){
                        MyWorld.NextScene = "Outside";
                            getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")){
                            
                            if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                                getWorldOfType(MyWorld.class).getInfo();
                                MyWorld.CurrentScene = 15;
                                getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                                //getWorldOfType(MyWorld.class).SceneUpdate("neighbour");
                                cooldown = 40;
                                MyWorld.count = true;                        
                                lock = true;                       
                                deletethisObject = true;                        
                                MyWorld.PX = ScreenMiddle;                        
                                MyWorld.PY = ScreenFloor;
                            }
                        }
                    }
                    if(getX()>ScreenLeft){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                    }
                    //LivingRoom1
                    if(getX()>Screen1_4-50 && getX()<Screen1_4+50){
                        MyWorld.NextScene = "to Living Room";
                        getWorldOfType(MyWorld.class).showNextScene(Screen1_4,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 25;
                            getWorldOfType(MyWorld.class).NshowNextScene(Screen1_4,ScreenMiddleY);
                            //getWorldOfType(MyWorld.class).SceneUpdate("livingroom1neighbour");
                            cooldown = 40;
                            MyWorld.count = true;                        
                            lock = true;                        
                            deletethisObject = true;                        
                            MyWorld.PX = ScreenRight;                        
                            MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()<Screen1_4-50 || getX()>Screen1_4+50){
                        getWorldOfType(MyWorld.class).NshowNextScene(Screen1_4,ScreenMiddleY);
                    }
                    //Corridor2
                    if(getX()>ScreenRight){
                        MyWorld.NextScene = "to Corridor";
                        getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene =27 ;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                            //getWorldOfType(MyWorld.class).SceneUpdate("corridor2neighbour");
                            cooldown = 40;
                            MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenLeft;                        MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()<ScreenRight){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                    }
                }
                if(MyWorld.CurrentScene == 25){
                    //LivingRoom2neighbour
                    if(getX()<ScreenLeft){
                        MyWorld.NextScene = "Further";
                        getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 26;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                            //getWorldOfType(MyWorld.class).SceneUpdate("livingroom2neighbour");
                            cooldown = 40;
                            MyWorld.count = true;                    lock = true;                    deletethisObject = true;                    MyWorld.PX = ScreenRight;                    MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()>ScreenLeft){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                    }
                    //Corridor1
                    if(getX()>ScreenRight-70 && getX()<ScreenRight){
                        MyWorld.NextScene = "to Corridor";
                        getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 24;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                            //getWorldOfType(MyWorld.class).SceneUpdate("corridor1neighbour");
                            cooldown = 40;
                            MyWorld.count = true;
                            lock = true;                    
                            deletethisObject = true;             
                            MyWorld.PX = Screen1_4;                
                            MyWorld.PY = ScreenFloor;
                            
                        }
                    }
                    if(getX()<ScreenRight-70 || getX()>ScreenRight){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                    }
                }
                if(MyWorld.CurrentScene == 26){
                    //Living Room1
                    if(getX()>ScreenRight){
                        MyWorld.NextScene = "Back";
                        getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 25;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                            //getWorldOfType(MyWorld.class).SceneUpdate("livingroom1neighbour");
                            cooldown = 40;
                            MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenLeft;                        MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()<ScreenRight){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                    }
                }
                if(MyWorld.CurrentScene == 27){
                    //Cellar1
                    if(getX()>ScreenRight){
                        if(door4locked){
                            if(CellarKey.isInInventory == false){
                                MyWorld.NextScene4 = "You don't have a Key";
                                getWorldOfType(MyWorld.class).showNextScene4(SceneRight,ScreenMiddleY);
                            }  
                            if(CellarKey.isInInventory){
                                MyWorld.NextScene4 = "Unlock door";
                                getWorldOfType(MyWorld.class).showNextScene4(SceneRight,ScreenMiddleY);
                                if(Greenfoot.isKeyDown("Space")){
                                    door4locked = false;

                                }
                            }
                        }if(door4locked == false){
                            MyWorld.NextScene = "to Cellar";
                            getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                            if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                                getWorldOfType(MyWorld.class).getInfo();
                                MyWorld.CurrentScene = 28;
                                getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                                //getWorldOfType(MyWorld.class).SceneUpdate("cellar1");
                                cooldown = 40;
                                MyWorld.count = true;                        
                                lock = true;                        
                                deletethisObject = true;                        
                                MyWorld.PX = ScreenRight-50;                        
                                MyWorld.PY = ScreenFloor;
                            
                            }
                        }
                        
                    }
                    if(getX()<ScreenRight){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                    }
                    //Corridor1
                    if(getX()<ScreenLeft){
                        MyWorld.NextScene = "Back";
                        getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 24;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                            //getWorldOfType(MyWorld.class).SceneUpdate("corridor1neighbour");
                            cooldown = 40;
                            MyWorld.count = true;                    lock = true;                    deletethisObject = true;                    MyWorld.PX = ScreenRight;                    MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()>ScreenLeft){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                    }
                }
                if(MyWorld.CurrentScene == 28){
                    //Cellar2
                    if(getX()<ScreenLeft){
                        MyWorld.NextScene = "Further";
                        getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 29;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                            //getWorldOfType(MyWorld.class).SceneUpdate("cellar2");
                            cooldown = 40;
                            MyWorld.count = true;                    lock = true;                    deletethisObject = true;                    MyWorld.PX = ScreenRight;                    MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()>ScreenLeft){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                    }
                    //corridor2
                    if(getX()>ScreenRight-50&&getX()<ScreenRight+50){
                        MyWorld.NextScene = "to Corridor";
                        getWorldOfType(MyWorld.class).showNextScene(ScreenRight-50,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 27;
                            getWorldOfType(MyWorld.class).NshowNextScene(ScreenRight-50,ScreenMiddleY);
                            //getWorldOfType(MyWorld.class).SceneUpdate("corridor2");
                            cooldown = 40;
                            MyWorld.count = true;                    lock = true;                    deletethisObject = true;                    MyWorld.PX = ScreenRight;                    MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()<ScreenRight-50||getX()>ScreenRight+50){
                        getWorldOfType(MyWorld.class).NshowNextScene(ScreenRight-50,ScreenMiddleY);
                    }
                }
                if(MyWorld.CurrentScene == 29){
                    //cellar1
                    if(getX()>ScreenRight){
                        MyWorld.NextScene = "Back";
                        getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 28;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                            //getWorldOfType(MyWorld.class).SceneUpdate("cellar1");
                            cooldown = 40;
                            MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenLeft;                        MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()<ScreenRight){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                    }
                }
                if(MyWorld.CurrentScene == 30){
                    
                }
                if(MyWorld.CurrentScene == 31){
                    //stree3
                    if(getX()>ScreenRight){
                        MyWorld.NextScene = "to Next Street";
                        getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 14;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("street5");
                            cooldown = 40;
                            MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenLeft;                        MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()<ScreenRight){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                    }
                    //street5
                    if(getX()<ScreenLeft){
                        MyWorld.NextScene = "to Next Street";
                        getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 32;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("street5");
                            cooldown = 40;
                            MyWorld.count = true;                    lock = true;                    deletethisObject = true;                    MyWorld.PX = ScreenRight;                    MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()>ScreenLeft){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                    }
                }
                if(MyWorld.CurrentScene == 32){
                    //street4
                    if(getX()>ScreenRight){
                        MyWorld.NextScene = "to Next Street";
                        getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 31;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("street5");
                            cooldown = 40;
                            MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenLeft;                        MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()<ScreenRight){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                    }
                    //street6
                    if(getX()<ScreenLeft){
                        MyWorld.NextScene = "to Next Street";
                        getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 33;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                            //getWorldOfType(MyWorld.class).SceneUpdate("street6");
                            cooldown = 40;
                            MyWorld.count = true;                    lock = true;                    deletethisObject = true;                    MyWorld.PX = ScreenRight;                    MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()>ScreenLeft){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                    }
                }
                if(MyWorld.CurrentScene == 33){
                    //street5
                    if(getX()>ScreenRight){
                        MyWorld.NextScene = "to Next Street";
                        getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 32;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("street5");
                            cooldown = 40;
                            MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenLeft;                        MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()<ScreenRight){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                    }
                    //street8
                    if(getX()<ScreenLeft){
                        MyWorld.NextScene = "to Next Street";
                        getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 34;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("street5");
                            cooldown = 40;
                            MyWorld.count = true;                    lock = true;                    deletethisObject = true;                    MyWorld.PX = ScreenRight;                    MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()>ScreenLeft){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                    }
                }
                if(MyWorld.CurrentScene == 34){
                    //street6
                    if(getX()>ScreenRight){
                        MyWorld.NextScene = "to Neighbourhood";
                        getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 33;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("street5");
                            cooldown = 40;
                            MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenLeft;                        MyWorld.PY = ScreenFloor;
                        }
                    }
                    //street7
                    if(getX()>(ScreenMiddle-50)&&getX()<(ScreenMiddle+50)){
                        MyWorld.NextScene = "to Next Street";
                        getWorldOfType(MyWorld.class).showNextScene(ScreenMiddle,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 106;
                            getWorldOfType(MyWorld.class).NshowNextScene(ScreenMiddle,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("street5");
                            cooldown = 40;
                            MyWorld.count = true;                    lock = true;                    deletethisObject = true;                    MyWorld.PX = ScreenRight;                    MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()<(ScreenMiddle-50)||getX()>(ScreenMiddle+50)){
                        getWorldOfType(MyWorld.class).NshowNextScene(ScreenMiddle,ScreenMiddleY);
                    }
                    if(getX()<ScreenRight){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                    }
                    //street10
                    if(getX()<ScreenLeft){
                        MyWorld.NextScene = "to Next Street";
                        getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 35;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("street10");
                            cooldown = 40;
                            MyWorld.count = true;                    lock = true;                    deletethisObject = true;                    MyWorld.PX = ScreenRight;                    MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()>ScreenLeft){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                    }
                }
                if(MyWorld.CurrentScene == 35){
                    //street8
                    if(getX()>ScreenRight){
                        MyWorld.NextScene = "to Next Street";
                        getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 34;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("street8");
                            cooldown = 40;
                            MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenLeft;                        MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()<ScreenRight){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                    }
                    //Street9
                    if(getX()>ScreenMiddle-50 && getX()<ScreenMiddle+50){
                        if(wasInNeighbour){
                            MyWorld.NextScene = "to Next Street";
                            getWorldOfType(MyWorld.class).showNextScene(ScreenMiddle,ScreenMiddleY);
                            if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                                getWorldOfType(MyWorld.class).getInfo();
                                MyWorld.CurrentScene = 36;
                                getWorldOfType(MyWorld.class).NshowNextScene(ScreenMiddle,ScreenMiddleY);
                                getWorldOfType(MyWorld.class).SceneUpdate("street9");
                                cooldown = 40;
                                MyWorld.count = true;                    lock = true;                    deletethisObject = true;                    MyWorld.PX = ScreenRight;                    MyWorld.PY = ScreenFloor;
                            }
                        }
                        if(wasInNeighbour == false){
                            MyWorld.NextScene4 = "Can't go there yet.";
                            getWorldOfType(MyWorld.class).showNextScene4(ScreenMiddle,ScreenMiddleY);
                        }
                        
                    }
                    if(getX()<ScreenMiddle-50||getX()>ScreenMiddle+50){
                        getWorldOfType(MyWorld.class).NshowNextScene(ScreenMiddle,ScreenMiddleY);
                    }
                    //street12
                    if(getX()<ScreenLeft){
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0 && goToMine && bike){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 59;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("street12");
                            cooldown = 40;
                            MyWorld.count = true;                    lock = true;                    deletethisObject = true;                    MyWorld.PX = ScreenRight;                    MyWorld.PY = ScreenFloor;
                        }
                        if(cooldown<0 && goToMine == false){
                            MyWorld.NextScene4 = "Can't go there yet";
                            getWorldOfType(MyWorld.class).showNextScene4(SceneLeft,ScreenMiddleY);
                        }
                        if(cooldown<0 && goToMine && bike == false){
                            MyWorld.NextScene4 = "You need a bike";
                            getWorldOfType(MyWorld.class).showNextScene4(SceneLeft,ScreenMiddleY);
                        }
                        if(cooldown<0 && goToMine && bike){
                            MyWorld.NextScene = "to West Stanley";
                            getWorldOfType(MyWorld.class).showNextScene(SceneLeft+51,ScreenMiddleY);
                            if(Greenfoot.isKeyDown("Space")){
                                getWorldOfType(MyWorld.class).getInfo();
                                MyWorld.CurrentScene = 59;
                                getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft+51,ScreenMiddleY);
                                getWorldOfType(MyWorld.class).SceneUpdate("street12");
                                cooldown = 40;
                                MyWorld.count = true;                    lock = true;                    deletethisObject = true;                    MyWorld.PX = ScreenRight;                    MyWorld.PY = ScreenFloor;
                            }
                        }
                    }
                    if(getX()>ScreenLeft){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).NshowNextScene4(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).NshowNextScene5(SceneLeft+51,ScreenMiddleY);
                    }
                }
            if(MyWorld.CurrentScene == 36){
                //corridor1library
                if(getX()<ScreenLeft){
                    MyWorld.NextScene = "to Library";
                    getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 37;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("corridor1library");
                        cooldown = 40;
                        MyWorld.count = true;                    lock = true;                    deletethisObject = true;                    MyWorld.PX = ScreenRight;                    MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()>ScreenLeft){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                }
                //street10
                if(getX()>ScreenRight){
                    MyWorld.NextScene = "to Next Street";
                    getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 35;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("street10");
                        cooldown = 40;
                        MyWorld.count = true;                        
                        lock = true;                        
                        deletethisObject = true;                        
                        MyWorld.PX = ScreenMiddle;                        
                        MyWorld.PY = ScreenFloor;
                    
                    }
                }
                if(getX()<ScreenRight){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                }
            }
            if(MyWorld.CurrentScene == 37){
                //corridor2library
                if(getX()<ScreenLeft){
                    MyWorld.NextScene = "next Shelf";
                    getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 38;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("corridor2library");
                        cooldown = 40;
                        MyWorld.count = true;                    lock = true;                    deletethisObject = true;                    MyWorld.PX = ScreenRight;                    MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()>ScreenLeft){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                }
                //Bookshelf1
                if(getX()>640&&getX()<1074){
                    MyWorld.NextScene = "to Bookshelf";
                    getWorldOfType(MyWorld.class).showNextScene(857,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 53;
                        getWorldOfType(MyWorld.class).NshowNextScene(857,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("bookshelf1");
                        cooldown = 40;
                        MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenLeft;                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()<640||getX()>1074){
                    getWorldOfType(MyWorld.class).NshowNextScene(857,ScreenMiddleY);
                }
                //bookshelf2
                if(getX()>206&&getX()<640){
                    MyWorld.NextScene = "to Bookshelf";
                    getWorldOfType(MyWorld.class).showNextScene(423,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 56;
                        getWorldOfType(MyWorld.class).NshowNextScene(423,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("bookshelf2");
                        cooldown = 40;
                        MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenLeft;                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()<206||getX()>640){
                    getWorldOfType(MyWorld.class).NshowNextScene(423,ScreenMiddleY);
                }
                //street9
                if(getX()>ScreenRight){
                    MyWorld.NextScene = "Outside";
                    getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 36;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("street9");
                        cooldown = 40;  
                        MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenLeft;                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()<ScreenRight){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                }
            }
            if(MyWorld.CurrentScene == 38){
                //corridor3library
                if(getX()<ScreenLeft){
                    MyWorld.NextScene = "next Shelf";
                    getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 40;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("corridor2library");
                        cooldown = 40;
                        MyWorld.count = true;                    lock = true;                    deletethisObject = true;                    MyWorld.PX = ScreenRight;                    MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()>ScreenLeft){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                }
                //Bookshelf1
                if(getX()>640&&getX()<1074){
                    MyWorld.NextScene = "to Bookshelf";
                    getWorldOfType(MyWorld.class).showNextScene(857,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 47;
                        getWorldOfType(MyWorld.class).NshowNextScene(857,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("bookshelf1");
                        cooldown = 40;
                        MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenLeft;                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()<640||getX()>1074){
                    getWorldOfType(MyWorld.class).NshowNextScene(857,ScreenMiddleY);
                }
                //bookshelf2
                if(getX()>206&&getX()<640){
                    MyWorld.NextScene = "to Bookshelf";
                    getWorldOfType(MyWorld.class).showNextScene(423,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 50;
                        getWorldOfType(MyWorld.class).NshowNextScene(423,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("bookshelf2");
                        cooldown = 40;
                        MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenLeft;                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()<206||getX()>640){
                    getWorldOfType(MyWorld.class).NshowNextScene(423,ScreenMiddleY);
                }
                //corridor1library
                if(getX()>ScreenRight){
                    MyWorld.NextScene = "Back";
                    getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 37;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("corridor1library");
                        cooldown = 40;
                        MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenLeft;                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()<ScreenRight){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                }
            }
            if(MyWorld.CurrentScene == 39){
                //Corridor2library
                if(getX()>ScreenRight){
                    MyWorld.NextScene = "Back";
                    getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 40;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("corridor2library");
                        cooldown = 40;
                        MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenLeft;                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()<ScreenRight){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                }
                //Desk
                if(getX()>(ScreenMiddle-50)&&getX()<(ScreenMiddle+50)){
                    if(books == 3 && Search){
                        MyWorld.NextScene4 = "Search Books";
                        getWorldOfType(MyWorld.class).showNextScene4(ScreenMiddle,ScreenMiddleY);
                    }
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0 && books == 3){
                        cooldown = 40;
                        goToMine = true;
                        MyWorld.NextScene4 = "You found information. Go to West Stanley";
                        getWorldOfType(MyWorld.class).showNextScene4(ScreenMiddle,ScreenMiddleY);
                        Search = false;
                    }
                    if(books != 3){
                        MyWorld.NextScene5 = "Search more books";
                        getWorldOfType(MyWorld.class).showNextScene5(ScreenMiddle,ScreenMiddleY);
                    }
                }
                if(getX()<(ScreenMiddle-50)||getX()>(ScreenMiddle+50)){
                    getWorldOfType(MyWorld.class).NshowNextScene(ScreenMiddle,ScreenMiddleY);
                }
            }
            if(MyWorld.CurrentScene == 40){
                //Desk
                if(getX()<ScreenLeft){
                    MyWorld.NextScene = "to Desk";
                    getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 39;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("desk");
                        cooldown = 40;
                        MyWorld.count = true;                    lock = true;                    deletethisObject = true;                    MyWorld.PX = ScreenRight;                    MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()>ScreenLeft){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                }
                //Bookshelf1
                if(getX()>640&&getX()<1074){
                    MyWorld.NextScene = "to Bookshelf";
                    getWorldOfType(MyWorld.class).showNextScene(857,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 41;
                        getWorldOfType(MyWorld.class).NshowNextScene(857,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("bookshelf1");
                        cooldown = 40;
                        MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenLeft;                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()<640||getX()>1074){
                    getWorldOfType(MyWorld.class).NshowNextScene(857,ScreenMiddleY);
                }
                //Bookshelf2
                if(getX()>206&&getX()<640){
                    MyWorld.NextScene = "to Bookshelf";
                    getWorldOfType(MyWorld.class).showNextScene(423,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 44;
                        getWorldOfType(MyWorld.class).NshowNextScene(423,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("bookshelf2");
                        cooldown = 40;
                        MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenLeft;                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()<206||getX()>640){
                    getWorldOfType(MyWorld.class).NshowNextScene(423,ScreenMiddleY);
                }
                //corridor2library
                if(getX()>ScreenRight){
                    MyWorld.NextScene = "Back";
                    getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 38;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("corridor2library");
                        cooldown = 40;
                        MyWorld.count = true;         
                        lock = true;                    
                        deletethisObject = true;     
                        MyWorld.PX = ScreenLeft;       
                        MyWorld.PY = ScreenFloor;
                        
                    }
                }
                if(getX()<ScreenRight){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                }
                        
            }
            if(MyWorld.CurrentScene == 41){
                //corridor3
                if(getX()<ScreenLeft){
                    MyWorld.NextScene = "Back";
                    getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 40;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("corridor3library");
                        cooldown = 40;
                        MyWorld.count = true;         
                        lock = true;                    
                        deletethisObject = true;     
                        MyWorld.PX = Screen3_4;       
                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()>ScreenLeft){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                }
                //shelf1
                if(getX()>206 && getX()<743){
                    MyWorld.NextScene4 = "Search";
                    getWorldOfType(MyWorld.class).showNextScene4(474,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0 && book1){
                        getWorldOfType(MyWorld.class).NshowNextScene(474,ScreenMiddleY);
                        cooldown = 40;
                        bookcounter = bookcounter +1;
                        book1 = false;
                    }
                }
                if(getX()<206||getX()>743){
                    getWorldOfType(MyWorld.class).NshowNextScene(474,ScreenMiddleY);
                }
                //shelf2
                if(getX()>537&&getX()<1280){
                    MyWorld.NextScene4 = "Search";
                    getWorldOfType(MyWorld.class).showNextScene4(1011,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0 && book2){
                        getWorldOfType(MyWorld.class).NshowNextScene(1011,ScreenMiddleY);
                        cooldown = 40;
                        bookcounter = bookcounter +1;
                        book2 = false;
                    }
                }
                if(getX()<537||getX()>1280){
                    getWorldOfType(MyWorld.class).NshowNextScene(1011,ScreenMiddleY);
                }
            }
            if(MyWorld.CurrentScene == 42){
                
            }
            if(MyWorld.CurrentScene == 43){
                
            }
            if(MyWorld.CurrentScene == 44){
                //corridor3
                if(getX()<ScreenLeft){
                    MyWorld.NextScene = "Back";
                    getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 40;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("corridor3library");
                        cooldown = 40;
                        MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = Screen1_4;                           MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()>ScreenLeft){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                }
                //shelf3
                if(getX()>206 && getX()<743){
                    MyWorld.NextScene4 = "Search";
                    getWorldOfType(MyWorld.class).showNextScene4(474,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0 && book3){
                        getWorldOfType(MyWorld.class).NshowNextScene(474,ScreenMiddleY);
                        cooldown = 40;
                        bookcounter = bookcounter +1;
                        book3 = false;
                    }
                }
                if(getX()<206||getX()>743){
                    getWorldOfType(MyWorld.class).NshowNextScene(474,ScreenMiddleY);
                }
                //shelf4
                if(getX()>537&&getX()<1280){
                    MyWorld.NextScene4 = "Search";
                    getWorldOfType(MyWorld.class).showNextScene4(1011,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0 && book4){
                        getWorldOfType(MyWorld.class).NshowNextScene(1011,ScreenMiddleY);
                        cooldown = 40;
                        bookcounter = bookcounter +1;
                        book4 = false;
                    }
                }
                if(getX()<537||getX()>1280){
                    getWorldOfType(MyWorld.class).NshowNextScene(1011,ScreenMiddleY);
                }
            }
            if(MyWorld.CurrentScene == 45){
                
            }
            if(MyWorld.CurrentScene == 46){
                
            }
            if(MyWorld.CurrentScene == 47){
                //corridor2
                if(getX()<ScreenLeft){
                    MyWorld.NextScene = "Back";
                    getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 38;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("corridor2library");
                        cooldown = 40;
                        MyWorld.count = true;         
                        lock = true;                    
                        deletethisObject = true;     
                        MyWorld.PX = Screen3_4;       
                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()>ScreenLeft){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                }
                //shelf5
                if(getX()>206 && getX()<743){
                    MyWorld.NextScene4 = "Search";
                    getWorldOfType(MyWorld.class).showNextScene4(474,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0 && book5){
                        getWorldOfType(MyWorld.class).NshowNextScene(474,ScreenMiddleY);
                        cooldown = 40;
                        bookcounter = bookcounter +1;
                        book5 = false;
                    }
                }
                if(getX()<206||getX()>743){
                    getWorldOfType(MyWorld.class).NshowNextScene(474,ScreenMiddleY);
                }
                //shelf6
                if(getX()>537&&getX()<1280){
                    MyWorld.NextScene4 = "Search";
                    getWorldOfType(MyWorld.class).showNextScene4(1011,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0 && book6){
                        getWorldOfType(MyWorld.class).NshowNextScene(1011,ScreenMiddleY);
                        cooldown = 40;
                        bookcounter = bookcounter +1;
                        book6 = false;
                    }
                }
                if(getX()<537||getX()>1280){
                    getWorldOfType(MyWorld.class).NshowNextScene(1011,ScreenMiddleY);
                }
            }
            if(MyWorld.CurrentScene == 48){
                
            }
            if(MyWorld.CurrentScene == 49){
                
            }
            if(MyWorld.CurrentScene == 50){
                //corridor2
                if(getX()<ScreenLeft){
                    MyWorld.NextScene = "Back";
                    getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene =38;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("corridor2library");
                        cooldown = 40;
                        MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = Screen1_4;                           MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()>ScreenLeft){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                }
                //shelf7
                if(getX()>206 && getX()<743){
                    MyWorld.NextScene4 = "Search";
                    getWorldOfType(MyWorld.class).showNextScene4(474,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0 && book7){
                        getWorldOfType(MyWorld.class).NshowNextScene(474,ScreenMiddleY);
                        cooldown = 40;
                        bookcounter = bookcounter +1;
                        book7 = false;
                    }
                }
                if(getX()<206||getX()>743){
                    getWorldOfType(MyWorld.class).NshowNextScene(474,ScreenMiddleY);
                }
                //shelf8
                if(getX()>537&&getX()<1280){
                    MyWorld.NextScene4 = "Search";
                    getWorldOfType(MyWorld.class).showNextScene4(1011,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0 && book8){
                        getWorldOfType(MyWorld.class).NshowNextScene(1011,ScreenMiddleY);
                        cooldown = 40;
                        bookcounter = bookcounter +1;
                        book8 = false;
                    }
                }
                if(getX()<537||getX()>1280){
                    getWorldOfType(MyWorld.class).NshowNextScene(1011,ScreenMiddleY);
                }
            }
            if(MyWorld.CurrentScene == 51){
                
            }
            if(MyWorld.CurrentScene == 52){
                
            }
            if(MyWorld.CurrentScene == 53){
                //corridor1
                if(getX()<ScreenLeft){
                    MyWorld.NextScene = "Back";
                    getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 37;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("corridor1library");
                        cooldown = 40;
                        MyWorld.count = true;         
                        lock = true;                    
                        deletethisObject = true;     
                        MyWorld.PX = Screen3_4;       
                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()>ScreenLeft){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                }
                //shelf9
                if(getX()>206 && getX()<743){
                    MyWorld.NextScene4 = "Search";
                    getWorldOfType(MyWorld.class).showNextScene4(474,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0 && book9){
                        getWorldOfType(MyWorld.class).NshowNextScene(474,ScreenMiddleY);
                        cooldown = 40;
                        bookcounter = bookcounter +1;
                        book9 = false;
                    }
                }
                if(getX()<206||getX()>743){
                    getWorldOfType(MyWorld.class).NshowNextScene(474,ScreenMiddleY);
                }
                //shelf10
                if(getX()>743&&getX()<1280){
                    MyWorld.NextScene4 = "Search";
                    getWorldOfType(MyWorld.class).showNextScene4(1011,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0 && book10){
                        getWorldOfType(MyWorld.class).NshowNextScene(1011,ScreenMiddleY);
                        cooldown = 40;
                        bookcounter = bookcounter +1;
                        book10 = false;
                    }
                }
                if(getX()<743||getX()>1280){
                    getWorldOfType(MyWorld.class).NshowNextScene(1011,ScreenMiddleY);
                }
                
                /*
                //
                if(getX()){
                    MyWorld.NextScene = "to ";
                    getWorldOfType(MyWorld.class).showNextScene(Screen,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = ;
                        getWorldOfType(MyWorld.class).NshowNextScene(Screen,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("");
                        cooldown = 40;
                        MyWorld.count = true;         
                        lock = true;                    
                        deletethisObject = true;     
                        MyWorld.PX = Screen3_4;       
                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()){
                    getWorldOfType(MyWorld.class).NshowNextScene(Screen,ScreenMiddleY);
                }
                */
            }if(MyWorld.CurrentScene == 54){
                
            }if(MyWorld.CurrentScene == 55){
                
            }if(MyWorld.CurrentScene == 56){
                //corridor1
                if(getX()<ScreenLeft){
                    MyWorld.NextScene = "Back";
                    getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 37;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("corridor1library");
                        cooldown = 40;
                        MyWorld.count = true;         
                        lock = true;                    
                        deletethisObject = true;     
                        MyWorld.PX = Screen1_4;       
                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()>ScreenLeft){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                }
                //shelf11
                if(getX()>206 && getX()<743){
                    MyWorld.NextScene4 = "Search";
                    getWorldOfType(MyWorld.class).showNextScene4(474,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0 && book11){
                        getWorldOfType(MyWorld.class).NshowNextScene(474,ScreenMiddleY);
                        cooldown = 40;
                        bookcounter = bookcounter +1;
                        book11 = false;
                    }
                }
                if(getX()<206||getX()>743){
                    getWorldOfType(MyWorld.class).NshowNextScene(474,ScreenMiddleY);
                }
                //shelf12
                if(getX()>537&&getX()<1280){
                    MyWorld.NextScene4 = "Search";
                    getWorldOfType(MyWorld.class).showNextScene4(1011,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0 && book12){
                        getWorldOfType(MyWorld.class).NshowNextScene(1011,ScreenMiddleY);
                        cooldown = 40;
                        bookcounter = bookcounter +1;
                        book12 = false;
                    }
                }
                if(getX()<537||getX()>1280){
                    getWorldOfType(MyWorld.class).NshowNextScene(1011,ScreenMiddleY);
                }
            }if(MyWorld.CurrentScene == 57){
                
            }if(MyWorld.CurrentScene == 58){
                
            }if(MyWorld.CurrentScene == 59){
                getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft+51,ScreenMiddleY);
                //street11
                if(getX()<ScreenLeft){
                    MyWorld.NextScene = "to Next Street";
                    getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 60;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("street11");
                        cooldown = 40;
                        MyWorld.count = true;                    
                        lock = true;                    
                        deletethisObject = true;                    
                        MyWorld.PX = ScreenMiddle;                    
                        MyWorld.PY = ScreenFloor;
                        MyWorld.playermoveable = false;
                        setImage("playerin.png");
                    }
                }
                if(getX()>ScreenLeft){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                }
                //street10
                if(getX()>ScreenRight){
                    MyWorld.NextScene4 = "Can't Go Back";
                    getWorldOfType(MyWorld.class).showNextScene4(SceneRight,ScreenMiddleY);
                }
                if(getX()<ScreenRight){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                }
            }if(MyWorld.CurrentScene == 60){
                getWorldOfType(MyWorld.class).NshowNextScene(ScreenMiddle,ScreenUp);
                //Mine
                if(true){
                    MyWorld.NextScene = "to Mine";
                    getWorldOfType(MyWorld.class).showNextScene(Screen1_4,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("a")||Greenfoot.isKeyDown("LEFT")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 61;
                        getWorldOfType(MyWorld.class).NshowNextScene2(Screen3_4,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).NshowNextScene(Screen1_4,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).NshowNextScene3(ScreenMiddle,ScreenFloor);
                        getWorldOfType(MyWorld.class).SceneUpdate("mine");
                        cooldown = 40;
                        MyWorld.count = true;
                            lock = true;
                            deletethisObject = true;
                            MyWorld.PX = ScreenMiddle;
                            MyWorld.PY = ScreenFloor;
                        MyWorld.playermoveable = false;
                        setImage("playerin.png");
                        
                    }
                }
                //Bush
                if(true){
                    MyWorld.NextScene2 = "to Bush";
                    getWorldOfType(MyWorld.class).showNextScene2(Screen3_4,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("d")||Greenfoot.isKeyDown("RIGHT")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 103;
                        getWorldOfType(MyWorld.class).NshowNextScene2(Screen3_4,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).NshowNextScene(Screen1_4,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).NshowNextScene3(ScreenMiddle,ScreenFloor);
                        getWorldOfType(MyWorld.class).SceneUpdate("bushmine");
                        cooldown = 40;
                        MyWorld.count = true;
                            lock = true;
                            deletethisObject = true;
                            MyWorld.PX = ScreenLeft;
                            MyWorld.PY = ScreenFloor;
                        MyWorld.playermoveable = false;
                        setImage("playerin.png");
                    }
                }
                //Street11
                if(true){
                    MyWorld.NextScene3 = "Back";
                    getWorldOfType(MyWorld.class).showNextScene3(ScreenMiddle,ScreenFloor);
                    if(Greenfoot.isKeyDown("s")||Greenfoot.isKeyDown("DOWN")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 59;
                        getWorldOfType(MyWorld.class).NshowNextScene3(ScreenMiddle,ScreenFloor);
                        getWorldOfType(MyWorld.class).NshowNextScene2(Screen3_4,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).NshowNextScene(Screen1_4,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("street11");
                        cooldown = 40;
                        MyWorld.count = true;
                            lock = true;
                            deletethisObject = true;
                            MyWorld.PX = ScreenLeft;
                            MyWorld.PY = ScreenFloor;
                            MyWorld.playermoveable = true;
                            
                    }
                }
            }if(MyWorld.CurrentScene == 61){
                getWorldOfType(MyWorld.class).NshowNextScene2(Screen3_4,ScreenMiddleY);
                getWorldOfType(MyWorld.class).NshowNextScene(Screen1_4,ScreenMiddleY);
                getWorldOfType(MyWorld.class).NshowNextScene3(ScreenMiddle,ScreenFloor);
                //Mine1
                if(true){
                    MyWorld.NextScene = "Further";
                    getWorldOfType(MyWorld.class).showNextScene(ScreenMiddle,ScreenUp);
                    if(Greenfoot.isKeyDown("w") ||Greenfoot.isKeyDown("UP")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 62;
                        getWorldOfType(MyWorld.class).NshowNextScene(ScreenMiddle,ScreenUp);
                        getWorldOfType(MyWorld.class).SceneUpdate("mine1");
                        cooldown = 40;
                        MyWorld.count = true;
                            lock = true;
                            deletethisObject = true;
                            MyWorld.PX = ScreenMiddle;
                            MyWorld.PY = ScreenFloor;
                        setImage("playerin.png");
                    }
                }
                //Street11
                if(true){
                    MyWorld.NextScene = "to Street";
                    getWorldOfType(MyWorld.class).showNextScene(ScreenMiddle,ScreenFloor);
                    if(Greenfoot.isKeyDown("s")||Greenfoot.isKeyDown("DOWN")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 60;
                        getWorldOfType(MyWorld.class).NshowNextScene(ScreenMiddle,ScreenFloor);
                        getWorldOfType(MyWorld.class).SceneUpdate("street11");
                        cooldown = 40;
                        MyWorld.count = true;
                            lock = true;
                            deletethisObject = true;
                            MyWorld.PX = ScreenMiddle;
                            MyWorld.PY = ScreenFloor;
                        MyWorld.playermoveable = false;
                        setImage("playerin.png");
                    }
                }
            }if(MyWorld.CurrentScene == 62){
                //Mine2
                if(true){
                    MyWorld.NextScene = "Left";
                    getWorldOfType(MyWorld.class).showNextScene(Screen1_4,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("a")||Greenfoot.isKeyDown("LEFT")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 63;
                        getWorldOfType(MyWorld.class).NshowNextScene(Screen1_4,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("mine2");
                        cooldown = 40;
                        MyWorld.count = true;
                            lock = true;
                            deletethisObject = true;
                            MyWorld.PX = ScreenMiddle;
                            MyWorld.PY = ScreenFloor;
                        MyWorld.playermoveable = false;
                        setImage("playerin.png");
                    }
                }
                //Mine12
                if(true){
                    MyWorld.NextScene2 = "Right";
                    getWorldOfType(MyWorld.class).showNextScene2(Screen3_4,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("d")||Greenfoot.isKeyDown("RIGHT")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 79;
                        getWorldOfType(MyWorld.class).NshowNextScene(Screen3_4,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("mine12");
                        cooldown = 40;
                        MyWorld.count = true;
                            lock = true;
                            deletethisObject = true;
                            MyWorld.PX = ScreenLeft;
                            MyWorld.PY = ScreenFloor;
                        MyWorld.playermoveable = true;
                        setImage("player.png");
                    }
                }
                //Mine
                if(true){
                    MyWorld.NextScene4 = "Back";
                    getWorldOfType(MyWorld.class).showNextScene4(ScreenMiddle,ScreenFloor);
                    if(Greenfoot.isKeyDown("s")||Greenfoot.isKeyDown("Down")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 61;
                        getWorldOfType(MyWorld.class).NshowNextScene4(ScreenMiddle,ScreenFloor);
                        getWorldOfType(MyWorld.class).SceneUpdate("mine");
                        cooldown = 40;
                        MyWorld.count = true;
                            lock = true;
                            deletethisObject = true;
                            MyWorld.PX = ScreenMiddle;
                            MyWorld.PY = ScreenFloor;
                    }
                }
            }if(MyWorld.CurrentScene == 63){
                getWorldOfType(MyWorld.class).NshowNextScene(Screen1_4,ScreenMiddleY);
                getWorldOfType(MyWorld.class).NshowNextScene(Screen3_4,ScreenMiddleY);
                //Mine3
                if(true){
                    MyWorld.NextScene = "Left";
                    getWorldOfType(MyWorld.class).showNextScene(Screen1_4,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("a")||Greenfoot.isKeyDown("left")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 64;
                        getWorldOfType(MyWorld.class).NshowNextScene(Screen1_4,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("mine3");
                        cooldown = 40;
                        MyWorld.count = true;         
                        lock = true;                    
                        deletethisObject = true;     
                        MyWorld.PX = ScreenRight;       
                        MyWorld.PY = ScreenFloor;
                        MyWorld.playermoveable = true;
                        setImage("player.png");
                    }
                }
                //Mine7
                if(true){
                    MyWorld.NextScene2 = "Right";
                    getWorldOfType(MyWorld.class).showNextScene2(Screen3_4,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("d")||Greenfoot.isKeyDown("RIGHT")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 71;
                        getWorldOfType(MyWorld.class).NshowNextScene2(Screen3_4,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("mine7");
                        cooldown = 40;
                         MyWorld.count = true;         
                        lock = true;                    
                        deletethisObject = true;     
                        MyWorld.PX = ScreenLeft;       
                        MyWorld.PY = ScreenFloor;
                        MyWorld.playermoveable = true;
                        setImage("player.png");
                    }
                }
                //Mine1
                if(true){
                    MyWorld.NextScene4 = "Back";
                    getWorldOfType(MyWorld.class).showNextScene4(ScreenMiddle,ScreenFloor);
                    if(Greenfoot.isKeyDown("s")||Greenfoot.isKeyDown("DOWN")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 62;
                        getWorldOfType(MyWorld.class).NshowNextScene4(ScreenMiddle,ScreenFloor);
                        getWorldOfType(MyWorld.class).SceneUpdate("mine");
                        cooldown = 40;
                         MyWorld.count = true;         
                        lock = true;                    
                        deletethisObject = true;     
                        MyWorld.PX = ScreenMiddle;       
                        MyWorld.PY = ScreenFloor;
                        MyWorld.playermoveable = false;
                        setImage("playerin.png");
                    }
                }
            }if(MyWorld.CurrentScene == 64){
                getWorldOfType(MyWorld.class).NshowNextScene(Screen3_4,ScreenMiddleY);
                getWorldOfType(MyWorld.class).NshowNextScene4(ScreenMiddle,ScreenFloor);
                //Mine2
                if(getX()>ScreenRight){
                    MyWorld.NextScene = "Back";
                    getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 63;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("mine2");
                        cooldown = 40;
                         MyWorld.count = true;         
                        lock = true;                    
                        deletethisObject = true;     
                        MyWorld.PX = ScreenMiddle;       
                        MyWorld.PY = ScreenFloor;
                        MyWorld.playermoveable = false;
                        setImage("playerin.png");
                    }
                }
                if(getX()<ScreenRight){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                }
                //Mine4
                if(getX()<ScreenLeft){
                    MyWorld.NextScene = "Further";
                    getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 65;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("mine4");
                        cooldown = 40;
                        MyWorld.count = true;         
                        lock = true;                    
                        deletethisObject = true;     
                        MyWorld.PX = ScreenRight;       
                        MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()>ScreenLeft){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                }
            }if(MyWorld.CurrentScene == 65){
                getWorldOfType(MyWorld.class).NshowNextScene(Screen1_4,ScreenMiddleY);
                getWorldOfType(MyWorld.class).NshowNextScene2(Screen3_4,ScreenMiddleY);
                getWorldOfType(MyWorld.class).NshowNextScene4(ScreenMiddle,ScreenFloor);
                //Mine5
                if(getX()<ScreenLeft){
                    MyWorld.NextScene = "Further";
                    getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 66;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("mine5");
                        cooldown = 40;
                        MyWorld.count = true;         
                        lock = true;                    
                        deletethisObject = true;     
                        MyWorld.PX = ScreenMiddle;       
                        MyWorld.PY = ScreenFloor;
                        MyWorld.playermoveable = false;
                        setImage("playerin.png");
                    }
                }
                if(getX()>ScreenLeft){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                }
                //Mine6
                if(getX()>(ScreenMiddle-50)&&getX()<(ScreenMiddle+50)){
                    MyWorld.NextScene2 = "Further";
                    getWorldOfType(MyWorld.class).showNextScene2(ScreenMiddle,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 69;
                        getWorldOfType(MyWorld.class).NshowNextScene(ScreenMiddle,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("mine6");
                        cooldown = 40;
                        MyWorld.count = true;         
                        lock = true;                    
                        deletethisObject = true;     
                        MyWorld.PX = ScreenLeft;       
                        MyWorld.PY = ScreenFloor;
                        MyWorld.playermoveable = true;
                        setImage("player.png");
                    }
                }
                if(getX()<(ScreenMiddle-50)||getX()>(ScreenMiddle+50)){
                    getWorldOfType(MyWorld.class).NshowNextScene(ScreenMiddle,ScreenMiddleY);
                }
                //Mine3
                if(getX()>ScreenRight){
                    MyWorld.NextScene3 = "Back";
                    getWorldOfType(MyWorld.class).showNextScene3(SceneRight,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 64;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("mine3");
                        cooldown = 40;
                        MyWorld.count = true;         
                        lock = true;                    
                        deletethisObject = true;     
                        MyWorld.PX = ScreenLeft;       
                        MyWorld.PY = ScreenFloor;
                        MyWorld.playermoveable = true;
                    }
                }
                if(getX()<ScreenRight){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                }
            }if(MyWorld.CurrentScene == 66){
                getWorldOfType(MyWorld.class).NshowNextScene4(ScreenMiddle,ScreenFloor);
                getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                getWorldOfType(MyWorld.class).NshowNextScene2(ScreenMiddle,ScreenMiddleY);
                //Room1
                if(true){
                    MyWorld.NextScene = "Left";
                    getWorldOfType(MyWorld.class).showNextScene(Screen1_4,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("a")||Greenfoot.isKeyDown("LEFT")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 67;
                        getWorldOfType(MyWorld.class).NshowNextScene(Screen1_4,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).NshowNextScene2(Screen3_4,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("room1");
                        cooldown = 40;
                        MyWorld.count = true;         
                        lock = true;                    
                        deletethisObject = true;     
                        MyWorld.PX = ScreenRight;       
                        MyWorld.PY = ScreenFloor;
                        MyWorld.playermoveable = true;
                        setImage("player.png");
                    }
                }
                //Room2
                if(true){
                    MyWorld.NextScene2 = "Right";
                    getWorldOfType(MyWorld.class).showNextScene2(Screen3_4,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("d")||Greenfoot.isKeyDown("RIGHT")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 68;
                        getWorldOfType(MyWorld.class).NshowNextScene(Screen1_4,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).NshowNextScene2(Screen3_4,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("room2");
                        cooldown = 40;
                        MyWorld.count = true;         
                        lock = true;                    
                        deletethisObject = true;     
                        MyWorld.PX = ScreenLeft;       
                        MyWorld.PY = ScreenFloor;
                        MyWorld.playermoveable = true;
                        setImage("player.png");
                    }
                }
                //Mine5
                if(true){
                    MyWorld.NextScene3 = "Back";
                    getWorldOfType(MyWorld.class).showNextScene4(ScreenMiddle,ScreenFloor);
                    if(Greenfoot.isKeyDown("s")||Greenfoot.isKeyDown("DOWN")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 65;
                        getWorldOfType(MyWorld.class).NshowNextScene4(ScreenMiddle,ScreenFloor);
                        getWorldOfType(MyWorld.class).SceneUpdate("mine4");
                        cooldown = 40;
                        MyWorld.count = true;         
                        lock = true;                    
                        deletethisObject = true;     
                        MyWorld.PX = ScreenLeft;       
                        MyWorld.PY = ScreenFloor;
                        MyWorld.playermoveable = true;
                        setImage("player.png");
                    }
                }
            }if(MyWorld.CurrentScene == 67){
                getWorldOfType(MyWorld.class).NshowNextScene(Screen1_4,ScreenMiddleY);
                getWorldOfType(MyWorld.class).NshowNextScene2(Screen3_4,ScreenMiddleY);
                getWorldOfType(MyWorld.class).NshowNextScene4(ScreenMiddle,ScreenFloor);
                //Mine5
                if(getX()>ScreenRight){
                    MyWorld.NextScene = "Back";
                    getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 66;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("mine5");
                        cooldown = 40;
                        MyWorld.count = true;         
                        lock = true;                    
                        deletethisObject = true;     
                        MyWorld.PX = ScreenMiddle;       
                        MyWorld.PY = ScreenFloor;
                        MyWorld.playermoveable =false;
                        setImage("playerin.png");
                    }
                }
                if(getX()<ScreenRight){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                }
            }if(MyWorld.CurrentScene == 68){
                getWorldOfType(MyWorld.class).NshowNextScene(Screen1_4,ScreenMiddleY);
                getWorldOfType(MyWorld.class).NshowNextScene2(Screen3_4,ScreenMiddleY);
                getWorldOfType(MyWorld.class).NshowNextScene4(ScreenMiddle,ScreenFloor);
                //Mine5
                if(getX()<ScreenLeft){
                    MyWorld.NextScene = "Back";
                    getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 66;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("mine5");
                        cooldown = 40;
                        MyWorld.count = true;         
                        lock = true;                    
                        deletethisObject = true;     
                        MyWorld.PX = ScreenMiddle;       
                        MyWorld.PY = ScreenFloor;
                        MyWorld.playermoveable = false;
                        setImage("playerin.png");
                    }
                }
                if(getX()>ScreenLeft){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                }
            }if(MyWorld.CurrentScene == 69){
                //Mine4
                if(getX()<ScreenLeft){
                    MyWorld.NextScene = "Back";
                    getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 65;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("mine4");
                        cooldown = 40;
                        MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenMiddle;                           MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()>ScreenLeft){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                }
                //Room3
                if(getX()>ScreenRight){
                    MyWorld.NextScene = "to Room";
                    getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 70;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("room3");
                        cooldown = 40;
                        MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenLeft;                           MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()<ScreenRight){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                }
            }if(MyWorld.CurrentScene == 70){
                //Mine6
                if(getX()<ScreenLeft){
                    MyWorld.NextScene = "Back";
                    getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 69;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("mine6");
                        cooldown = 40;
                        MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenRight;                           MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()>ScreenLeft){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                }
            }if(MyWorld.CurrentScene == 71){
                getWorldOfType(MyWorld.class).NshowNextScene4(ScreenMiddle,ScreenFloor);
                getWorldOfType(MyWorld.class).NshowNextScene2(Screen3_4,ScreenMiddleY);
                getWorldOfType(MyWorld.class).NshowNextScene(Screen1_4,ScreenMiddleY);
                //Mine8
                if(getX()>ScreenRight){
                    MyWorld.NextScene = "Further";
                    getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 72;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("mine8");
                        cooldown = 40;
                        MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenMiddle;                           MyWorld.PY = ScreenFloor;
                        MyWorld.playermoveable = false;
                        setImage("playerin.png");
                    }
                }
                if(getX()<ScreenRight){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                }
                //Mine2
                if(getX()<ScreenLeft){
                    MyWorld.NextScene = "Back";
                    getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 63;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("mine2");
                        cooldown = 40;
                        MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenMiddle;                           MyWorld.PY = ScreenFloor;
                        MyWorld.playermoveable = false;
                        setImage("playerin.png");
                    }
                }
                if(getX()>ScreenLeft){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                }
            }if(MyWorld.CurrentScene == 72){
                //Room4
                if(true){
                    MyWorld.NextScene = "Left";
                    getWorldOfType(MyWorld.class).showNextScene(Screen1_4,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("a")||Greenfoot.isKeyDown("LEFT")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 73;
                        getWorldOfType(MyWorld.class).NshowNextScene(Screen1_4,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("room4");
                        cooldown = 40;
                        MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenRight;                           MyWorld.PY = ScreenFloor;
                        MyWorld.playermoveable = true;
                        setImage("player.png");
                    }
                }
                //Mine9
                if(true){
                    MyWorld.NextScene2 = "Right";
                    getWorldOfType(MyWorld.class).showNextScene2(Screen3_4,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("d")||Greenfoot.isKeyDown("RIGHT")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 74;
                        getWorldOfType(MyWorld.class).NshowNextScene2(Screen3_4,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("mine9");
                        cooldown = 40;
                        MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenLeft;                           MyWorld.PY = ScreenFloor;
                        MyWorld.playermoveable = true;
                        setImage("player.png");
                    }
                }
                //Mine7
                if(true){
                    MyWorld.NextScene4 = "Back";
                    getWorldOfType(MyWorld.class).showNextScene4(ScreenMiddle,ScreenFloor);
                    if(Greenfoot.isKeyDown("s")||Greenfoot.isKeyDown("DOWN")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 71;
                        getWorldOfType(MyWorld.class).NshowNextScene4(ScreenMiddle,ScreenFloor);
                        getWorldOfType(MyWorld.class).SceneUpdate("mine7");
                        cooldown = 40;
                        MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenRight;                           MyWorld.PY = ScreenFloor;
                        MyWorld.playermoveable = true;
                        setImage("player.png");
                    }
                }
            
            }if(MyWorld.CurrentScene == 73){
                getWorldOfType(MyWorld.class).NshowNextScene4(ScreenMiddle,ScreenFloor);
                getWorldOfType(MyWorld.class).NshowNextScene2(Screen3_4,ScreenMiddleY);
                getWorldOfType(MyWorld.class).NshowNextScene(Screen1_4,ScreenMiddleY);
                //Mine8
                if(getX()>ScreenRight){
                    MyWorld.NextScene = "Back";
                    getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 72;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("mine8");
                        cooldown = 40;
                        MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenMiddle;                           MyWorld.PY = ScreenFloor;
                        MyWorld.playermoveable = false;
                        setImage("playerin.png");
                    }
                }
                if(getX()<ScreenRight){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                }
            }if(MyWorld.CurrentScene == 74){
                if(neighbourinmine){
                    trappedMine = true;
                    jumpscare = true;
        
                    if(cooldown<-1000){
                        MyWorld.CurrentScene = 72;
                        getWorldOfType(MyWorld.class).SceneUpdate("georgnine");
                    }
                }
                getWorldOfType(MyWorld.class).NshowNextScene4(ScreenMiddle,ScreenFloor);
                getWorldOfType(MyWorld.class).NshowNextScene2(Screen3_4,ScreenMiddleY);
                getWorldOfType(MyWorld.class).NshowNextScene(Screen1_4,ScreenMiddleY);
                //Mine8
                if(getX()<ScreenLeft){
                    MyWorld.NextScene = "Back";
                    getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 72;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("mine8");
                        cooldown = 40;
                        MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenMiddle;                           MyWorld.PY = ScreenFloor;
                        MyWorld.playermoveable = false;
                        setImage("playerin.png");
                    }
                }
                if(getX()>ScreenLeft){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                }
                //mine10
                if(getX()>ScreenRight){
                    MyWorld.NextScene = "Further";
                    getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 75;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("mine10");
                        cooldown = 40;
                        MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenLeft;                           MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()<ScreenRight){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                }
            }if(MyWorld.CurrentScene == 75){
                //Room5
                if(getX()>(ScreenMiddle-50)&&getX()<(ScreenMiddle+50)){
                    MyWorld.NextScene = "in Room";
                    getWorldOfType(MyWorld.class).showNextScene(ScreenMiddle,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 76;
                        getWorldOfType(MyWorld.class).NshowNextScene(ScreenMiddle,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("room6");
                        cooldown = 40;
                        MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenLeft;                           MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()<(ScreenMiddle-50)||getX()>(ScreenMiddle+50)){
                    getWorldOfType(MyWorld.class).NshowNextScene(ScreenMiddle,ScreenMiddleY);
                }
                //Mine11
                if(getX()>ScreenRight){
                    MyWorld.NextScene = "Further";
                    getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 77;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("mine11");
                        cooldown = 40;
                        MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenLeft;                           MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()<ScreenRight){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                }
                //Mine9
                if(getX()<ScreenLeft){
                    MyWorld.NextScene = "Back";
                    getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 74;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("");
                        cooldown = 40;
                        MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenRight;                           MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()>ScreenLeft){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                }
            }if(MyWorld.CurrentScene == 76){
                //mine10
                if(getX()<ScreenLeft){
                    MyWorld.NextScene = "Back";
                    getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 75;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("mine10");
                        cooldown = 40;
                        MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenMiddle;                           MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()>ScreenLeft){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                }
            }if(MyWorld.CurrentScene == 77){
                //Room6
                if(getX()>ScreenRight){
                    MyWorld.NextScene = "to Room";
                    getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 78;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("room6");
                        cooldown = 40;
                        MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenLeft;                           MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()<ScreenRight){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                }
                //Mine10
                if(getX()<ScreenLeft){
                    MyWorld.NextScene = "Back";
                    getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                    if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                        getWorldOfType(MyWorld.class).getInfo();
                        MyWorld.CurrentScene = 75;
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        getWorldOfType(MyWorld.class).SceneUpdate("mine10");
                        cooldown = 40;
                        MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenRight;                           MyWorld.PY = ScreenFloor;
                    }
                }
                if(getX()>ScreenLeft){
                    getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                }
                }if(MyWorld.CurrentScene == 78){
                    
                    //Mine11
                    if(getX()<ScreenLeft){
                        if(door3locked){
                            if(MineKey.isInInventory == false){
                                MyWorld.NextScene4 = "You don't have a Key";
                                getWorldOfType(MyWorld.class).showNextScene4(SceneLeft,ScreenMiddleY);
                                realendcountdown = true;
                            }  
                            if(MineKey.isInInventory){
                                MyWorld.NextScene4 = "Unlock door";
                                getWorldOfType(MyWorld.class).showNextScene4(SceneLeft,ScreenMiddleY);
                                if(Greenfoot.isKeyDown("Space")){
                                    door3locked = false;
                                    
                                }
                            }
                        }if(door3locked == false){
                            MyWorld.NextScene = "Outside";
                            getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                            if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                                getWorldOfType(MyWorld.class).getInfo();
                                MyWorld.CurrentScene = 11;
                                getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                                getWorldOfType(MyWorld.class).SceneUpdate("street1");                        cooldown = 40;
                                MyWorld.count = true;                        lock = true;                        deletethisObject = true;                        MyWorld.PX = ScreenMiddle;                        MyWorld.PY = ScreenFloor;
                            }
                        }
                        if(getX()>ScreenLeft){
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                        }
                    
                    }
                }
                if(MyWorld.CurrentScene == 79){
                    getWorldOfType(MyWorld.class).NshowNextScene(Screen1_4,ScreenMiddleY);
                    getWorldOfType(MyWorld.class).NshowNextScene2(Screen3_4,ScreenMiddleY);
                    getWorldOfType(MyWorld.class).NshowNextScene4(ScreenMiddle,ScreenFloor);
                    //Mine13
                    if(getX()>(ScreenMiddle-50)&&getX()<(ScreenMiddle+50)){
                        MyWorld.NextScene = "Further";
                        getWorldOfType(MyWorld.class).showNextScene(ScreenMiddle,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 80;
                            getWorldOfType(MyWorld.class).NshowNextScene(ScreenMiddle,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("mine13");
                            cooldown = 40;
                            MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenRight;                           MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()<(ScreenMiddle-50)||getX()>(ScreenMiddle+50)){
                        getWorldOfType(MyWorld.class).NshowNextScene(ScreenMiddle,ScreenMiddleY);
                    }
                    //Mine1
                    if(getX()<ScreenLeft){
                        MyWorld.NextScene = "Back";
                        getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 62;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("mine1");
                            cooldown = 40;
                            MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenMiddle;                           MyWorld.PY = ScreenFloor;
                            MyWorld.playermoveable = false;
                            setImage("playerin.png");
                        }
                    }
                    if(getX()>ScreenLeft){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                    }
                    //Mine14
                    if(getX()>ScreenRight){
                        MyWorld.NextScene = "Further";
                        getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 82;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("mine14");
                            cooldown = 40;
                            MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenMiddle;                           MyWorld.PY = ScreenFloor;
                            MyWorld.playermoveable = false;
                            setImage("playerin.png");
                        }
                    }
                    if(getX()<ScreenRight){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                    }
                
                }if(MyWorld.CurrentScene == 80){
                    //Mine12
                    if(getX()>ScreenRight){
                        MyWorld.NextScene = "Back";
                        getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 79;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("mine12");
                            cooldown = 40;
                            MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenMiddle;                           MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()<ScreenRight){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                    }
                    //Room8
                    if(getX()<ScreenLeft){
                        MyWorld.NextScene = "in Room";
                        getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 81;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("room8");
                            cooldown = 40;
                            MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenRight;                           MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()>ScreenLeft){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                    }
                }if(MyWorld.CurrentScene == 81){
                    //Mine13
                    if(getX()>ScreenRight){
                        MyWorld.NextScene = "Back";
                        getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 80;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("mine13");
                            cooldown = 40;
                            MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenLeft;                           MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()<ScreenRight){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                    }
                }if(MyWorld.CurrentScene == 82){
                    //Mine15
                    if(true){
                        MyWorld.NextScene = "Left";
                        getWorldOfType(MyWorld.class).showNextScene(Screen1_4,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("a")||Greenfoot.isKeyDown("left")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 83;
                            getWorldOfType(MyWorld.class).NshowNextScene(Screen1_4,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("mine15");
                            cooldown = 40;
                            MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenRight;                           MyWorld.PY = ScreenFloor;
                            MyWorld.playermoveable = true;
                            setImage("player.png");
                        }
                    }
                    //Mine17
                    if(true){
                        MyWorld.NextScene2 = "Right";
                        getWorldOfType(MyWorld.class).showNextScene2(Screen3_4,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("d")||Greenfoot.isKeyDown("RIGHT")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 101;
                            getWorldOfType(MyWorld.class).NshowNextScene2(Screen3_4,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("mine1");
                            cooldown = 40;
                            MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenLeft;                           MyWorld.PY = ScreenFloor;
                            MyWorld.playermoveable = true;
                            setImage("player.png");
                        }
                    }
                    //Mine12
                    if(true){
                        MyWorld.NextScene4 = "Back";
                        getWorldOfType(MyWorld.class).showNextScene4(ScreenMiddle,ScreenFloor);
                        if(Greenfoot.isKeyDown("s")||Greenfoot.isKeyDown("DOWN")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene =79;
                            getWorldOfType(MyWorld.class).NshowNextScene4(ScreenMiddle,ScreenFloor);
                            getWorldOfType(MyWorld.class).SceneUpdate("mine12");
                            cooldown = 40;
                            MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenRight;                           MyWorld.PY = ScreenFloor;
                            MyWorld.playermoveable = true;
                            setImage("player.png");
                        }
                    }
                }if(MyWorld.CurrentScene == 83){
                    getWorldOfType(MyWorld.class).NshowNextScene(Screen1_4,ScreenMiddleY);
                    getWorldOfType(MyWorld.class).NshowNextScene2(Screen3_4,ScreenMiddleY);
                    //Mine14
                    if(getX()>ScreenRight){
                        MyWorld.NextScene = "Back";
                        getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 82;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("mine14");
                            cooldown = 40;
                            MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenMiddle;                           MyWorld.PY = ScreenFloor;
                            MyWorld.playermoveable = false;
                            setImage("playerin.png");
                        }
                    }
                    if(getX()<ScreenRight){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                    }
                    //Mine16
                    if(getX()<ScreenLeft){
                        MyWorld.NextScene = "Further";
                        getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 84;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("mine16");
                            cooldown = 40;
                            MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenRight;                           MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()>ScreenLeft){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                    }
                }if(MyWorld.CurrentScene == 84){
                    //Mine15
                    if(getX()>ScreenRight){
                        MyWorld.NextScene = "Back";
                        getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 83;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("mine15");
                            cooldown = 40;
                            MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenLeft;                           MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()<ScreenRight){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                    }
                    //Room10
                    if(getX()<ScreenLeft){
                        MyWorld.NextScene = "to Room";
                        getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 85;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("room10");
                            cooldown = 40;
                            MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenRight;                           MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()>ScreenLeft){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                    }
                }if(MyWorld.CurrentScene == 85){
                    //Mine16
                    if(getX()>ScreenRight){
                        MyWorld.NextScene = "Back";
                        getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 84;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("mine16");
                            cooldown = 40;
                            MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenLeft;                           MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()<ScreenRight){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                    }
                }if(MyWorld.CurrentScene == 101){
                    getWorldOfType(MyWorld.class).NshowNextScene4(ScreenMiddle,ScreenFloor);
                    getWorldOfType(MyWorld.class).NshowNextScene2(Screen3_4,ScreenMiddleY);
                    getWorldOfType(MyWorld.class).NshowNextScene(Screen1_4,ScreenMiddleY);
                    //Mine14
                    if(getX()<ScreenLeft){
                        MyWorld.NextScene = "Back";
                        getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 82;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("mine14");
                            cooldown = 40;
                            MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenMiddle;                           MyWorld.PY = ScreenFloor;
                            MyWorld.playermoveable = false;
                            setImage("playerin.png");
                        }
                    }
                    if(getX()>ScreenLeft){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                    }
                    //Room9
                    if(getX()>ScreenRight){
                        MyWorld.NextScene = "to Room";
                        getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 102;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("room9");
                            cooldown = 40;
                            MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenLeft;                           MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()<ScreenRight){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                    }
                }if(MyWorld.CurrentScene == 102){
                    //Mine17
                    if(getX()<ScreenLeft){
                        MyWorld.NextScene = "Back";
                        getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 101;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("mine17");
                            cooldown = 40;
                            MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenRight;                           MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()>ScreenLeft){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                    }
                }if(MyWorld.CurrentScene == 103){
                    //Nothing
                    if(true){
                        MyWorld.NextScene = "Left";
                        getWorldOfType(MyWorld.class).showNextScene(Screen1_4,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("LEFT")||Greenfoot.isKeyDown("a")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 104;
                            getWorldOfType(MyWorld.class).NshowNextScene(Screen1_4,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("nothing");
                            cooldown = 40;
                            MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenRight;                           MyWorld.PY = ScreenFloor;
                            MyWorld.playermoveable = true;
                            setImage("player.png");
                        }
                    }
                    //Car
                    if(true){
                        MyWorld.NextScene2 = "Right";
                        getWorldOfType(MyWorld.class).showNextScene(Screen3_4,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("RIGHT")||Greenfoot.isKeyDown("d")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 105;
                            getWorldOfType(MyWorld.class).NshowNextScene2(Screen3_4,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("car");
                            cooldown = 40;
                            MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenLeft;                           MyWorld.PY = ScreenFloor;
                            MyWorld.playermoveable = true;
                            setImage("player.png");
                        }
                    }
                }if(MyWorld.CurrentScene == 104){
                    getWorldOfType(MyWorld.class).NshowNextScene(Screen1_4,ScreenMiddleY);
                    getWorldOfType(MyWorld.class).NshowNextScene2(Screen3_4,ScreenMiddleY);
                    getWorldOfType(MyWorld.class).NshowNextScene3(ScreenMiddle,ScreenFloor);
                    //Bush
                    if(getX()>ScreenRight){
                        MyWorld.NextScene = "Back";
                        getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 103;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("bush");
                            cooldown = 40;
                            MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenMiddle;                           MyWorld.PY = ScreenFloor;
                            MyWorld.playermoveable = false;
                            setImage("playerin.png");
                        }
                    }
                    if(getX()<ScreenRight){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                    }
                }if(MyWorld.CurrentScene == 105){
                    getWorldOfType(MyWorld.class).NshowNextScene(Screen1_4,ScreenMiddleY);
                    getWorldOfType(MyWorld.class).NshowNextScene2(Screen3_4,ScreenMiddleY);
                    getWorldOfType(MyWorld.class).NshowNextScene3(ScreenMiddle,ScreenFloor);
                    //Bush
                    if(getX()<ScreenLeft){
                        MyWorld.NextScene = "Back";
                        getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 103;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("bush");
                            cooldown = 40;
                            MyWorld.count = true;                             lock = true;                                        deletethisObject = true;                         MyWorld.PX = ScreenMiddle;                           MyWorld.PY = ScreenFloor;
                            MyWorld.playermoveable = false;
                            setImage("playerin.png");
                        }
                    }
                    if(getX()>ScreenLeft){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                    }
                    if(getX()>(ScreenMiddle-50)&&getX()<(ScreenMiddle+50)){
                        if(CarKey.isInInventory){
                            if(CarKey.isInInventory){
                                MyWorld.NextScene4 = "Enter vehicle";
                            }
                            if(Greenfoot.isKeyDown("Space")){
                                EscapeMine = true;
                                carpressed = true;
                            }
                            getWorldOfType(MyWorld.class).showNextScene4(ScreenMiddle,ScreenMiddleY);
                        }
                    }
                    if(getX()<(ScreenMiddle-50)||getX()>(ScreenMiddle+50)){
                        getWorldOfType(MyWorld.class).NshowNextScene2(ScreenMiddle,ScreenMiddleY);
                    }
                }if(MyWorld.CurrentScene == 106){
                    //Entry
                    if(getX()<SceneLeft){
                        MyWorld.NextScene = "to Police Station";
                        getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 107;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("entrypolice");
                            cooldown = 40;
                            MyWorld.count = true;         
                            lock = true;                    
                            deletethisObject = true;     
                            MyWorld.PX = ScreenRight;       
                            MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()>SceneLeft){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                    }
                    //Street8
                    if(getX()>SceneRight){
                        MyWorld.NextScene = "to Next Street";
                        getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 34;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("street8");
                            cooldown = 40;
                            MyWorld.count = true;         
                            lock = true;                    
                            deletethisObject = true;     
                            MyWorld.PX = ScreenMiddle;       
                            MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()<SceneRight){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                    }
                }if(MyWorld.CurrentScene == 107){
                    //CorridorPolice
                    if(getX()<SceneLeft){
                        MyWorld.NextScene = "to Corridor";
                        getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 108;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("corridorpolice");
                            cooldown = 40;
                            MyWorld.count = true;         
                            lock = true;                    
                            deletethisObject = true;     
                            MyWorld.PX = ScreenRight;       
                            MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()>SceneLeft){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                    }
                    //street7
                    if(getX()>ScreenRight){
                        if(door2locked){
                            if(PoliceKey.isInInventory == false){
                                MyWorld.NextScene4 = "You need a Key";
                                getWorldOfType(MyWorld.class).showNextScene4(SceneRight,ScreenMiddleY);
                            }  
                            if(PoliceKey.isInInventory){
                                MyWorld.NextScene4 = "Unlock door";
                                getWorldOfType(MyWorld.class).showNextScene4(SceneRight,ScreenMiddleY);
                                if(Greenfoot.isKeyDown("Space")){
                                    door2locked = false;
                                }
                            }
                        }if(door2locked == false){
                            MyWorld.NextScene = "Outside";
                            getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                            if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                                getWorldOfType(MyWorld.class).getInfo();
                                MyWorld.CurrentScene = 106;
                                getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                                getWorldOfType(MyWorld.class).SceneUpdate("street7");
                                cooldown = 40;
                                MyWorld.count = true;         
                                lock = true;                    
                                deletethisObject = true;     
                                MyWorld.PX = ScreenLeft;       
                                MyWorld.PY = ScreenFloor;}
                        }
                    }
                    if(getX()<SceneRight){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                    }
                }if(MyWorld.CurrentScene == 108){
                    //Georgroom
                    if(getX()<SceneLeft){
                        MyWorld.NextScene = "to Room";
                        getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 109;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("georgroom");
                            cooldown = 40;
                            MyWorld.count = true;         
                            lock = true;                    
                            deletethisObject = true;     
                            MyWorld.PX = ScreenRight;       
                            MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()>SceneLeft){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                    }
                    //Office
                    if(getX()>ScreenMiddle-50 && getX()<ScreenMiddle+50){
                        MyWorld.NextScene = "to Office";
                        getWorldOfType(MyWorld.class).showNextScene(ScreenMiddle,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 110;
                            getWorldOfType(MyWorld.class).NshowNextScene(ScreenMiddle,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("policeoffice");
                            cooldown = 40;
                            MyWorld.count = true;         
                            lock = true;                    
                            deletethisObject = true;     
                            MyWorld.PX = ScreenLeft;       
                            MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()<ScreenMiddle-50 || getX()>ScreenMiddle+50){
                        getWorldOfType(MyWorld.class).NshowNextScene(ScreenMiddle,ScreenMiddleY);
                    }
                    //Entry
                    if(getX()>SceneRight){
                        MyWorld.NextScene = "to Entry";
                        getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 107;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("entrypolice");
                            cooldown = 40;
                            MyWorld.count = true;         
                            lock = true;                    
                            deletethisObject = true;     
                            MyWorld.PX = ScreenLeft;       
                            MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()<SceneRight){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                    }
                }if(MyWorld.CurrentScene == 109){
                    //CorridorPolice
                    if(getX()>ScreenRight){
                        MyWorld.NextScene = "to Corridor";
                        getWorldOfType(MyWorld.class).showNextScene(SceneRight,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 108;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("corridorpolice");
                            cooldown = 40;
                            MyWorld.count = true;         
                            lock = true;                    
                            deletethisObject = true;     
                            MyWorld.PX = ScreenLeft;       
                            MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()<ScreenRight){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneRight,ScreenMiddleY);
                    }
                    //Bed
                    if(getX()>ScreenLeft && getX()<ScreenLeft+100){
                        MyWorld.NextScene4 = "Sleep";
                        getWorldOfType(MyWorld.class).showNextScene4(SceneLeft+50,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft+50,ScreenMiddleY);
                            cooldown = 40;
                            sleepcounter = sleepcounter +1;
                        }
                    }
                    if(getX()<ScreenLeft || getX()>ScreenLeft+100){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft+50,ScreenMiddleY);
                    }
                }if(MyWorld.CurrentScene == 110){
                    //Corridor
                    if(getX()<SceneLeft){
                        MyWorld.NextScene = "to Corridor";
                        getWorldOfType(MyWorld.class).showNextScene(SceneLeft,ScreenMiddleY);
                        if(Greenfoot.isKeyDown("Space")&& cooldown<0){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 108;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("corridorpolice");
                            cooldown = 40;
                            MyWorld.count = true;         
                            lock = true;                    
                            deletethisObject = true;     
                            MyWorld.PX = ScreenMiddle;       
                            MyWorld.PY = ScreenFloor;
                        }
                    }
                    if(getX()>SceneLeft){
                        getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                    }
                }if(MyWorld.CurrentScene == 123){
                    getWorldOfType(MyWorld.class).NshowNextScene4(ScreenMiddle,ScreenMiddleY);
                }
        }
                    
                
            if(trappedMine){
                MyWorld.CurrentScene = 78;
                getWorldOfType(MyWorld.class).SceneUpdate("georgmine");
                end = true;
            }
        if(end){
            //getWorldOfType(MyWorld.class).NshowNextScene4(ScreenMiddle,ScreenMiddleY);
        }
        if(sleepcounter >=3){
            Sleep = true;
            lock = true;                    
            deletethisObject = true;    
        }
        if(RealEnd){
            MyWorld.CurrentScene = RealEndScene;
            getWorldOfType(MyWorld.class).SceneUpdate("realend"); 
            end = true;
        }
        if(EscapeTown){
            MyWorld.CurrentScene = EscapeTownScene;
            getWorldOfType(MyWorld.class).SceneUpdate("escapetown"); end = true;
        }   
        if(EscapeBush){
            MyWorld.CurrentScene = EscapeBushScene;
            getWorldOfType(MyWorld.class).setBackground("1_3.png");
            end = true;
            EscapeBush = false;
        }
        if(EscapeMine){
            MyWorld.CurrentScene = EscapemineScene;
            getWorldOfType(MyWorld.class).setBackground("3_3.png");
            EscapeMine = false;
        }
        if(Sleep){
            MyWorld.CurrentScene = SleepScene;
            getWorldOfType(MyWorld.class).SceneUpdate("2_3.png"); 
            end = true;
            Sleep = false;
        }
        if(Save){
            MyWorld.CurrentScene = SaveScene;
            getWorldOfType(MyWorld.class).SceneUpdate("4_7.png"); 
            end = true;
            Save = false;
        }
        if(Trapped){    
            MyWorld.CurrentScene = TrappedScene;
            getWorldOfType(MyWorld.class).SceneUpdate("trapped"); 
            end = true;
        }
        if(Trapped2){
            MyWorld.CurrentScene = Trapped2Scene;
            getWorldOfType(MyWorld.class).SceneUpdate("trapped2.png");
            end = true;
        }
    
        cooldown = cooldown-1;
        speedlimit = speedlimit-25;
        if(speedlimit>1000){
            speedlimit = 1000;
        }if(speedlimit<0){
            speedlimit = 0;
        }
        if(Greenfoot.isKeyDown("T")){
            unspeed = true;
        }
        if(unspeed){
            speedlimit = 0;
            speed = 20;
        }
        if(bookcounter == 4){
            books = 1;
        }
        if(bookcounter == 8){
            books = 2;
        }
        if(bookcounter == 12){
            books = 3;
        }
        if(onTable && books == 3){
            
        }
        
        if(Greenfoot.isKeyDown("g")){
            setImage("player.png");
        }
        if(Greenfoot.isKeyDown("h")){
            setImage("playerin.png");
        }
        
        if(countpolice){
            policetimer = policetimer -1;
        }
        if(policetimer < 0){
            countpolice = false;
            toPolice = true;
            policetimer = 1000000;
        }
        if(toPolice){
                            getWorldOfType(MyWorld.class).getInfo();
                            MyWorld.CurrentScene = 109;
                            getWorldOfType(MyWorld.class).NshowNextScene(SceneLeft,ScreenMiddleY);
                            getWorldOfType(MyWorld.class).SceneUpdate("georgroom");
                            cooldown = 40;
                            MyWorld.count = true;         
                            lock = true;                    
                            deletethisObject = true;     
                            MyWorld.PX = ScreenLeft+100;       
                            MyWorld.PY = ScreenFloor;
                            toPolice = false;
        }
        if(jumpscare){
            Greenfoot.playSound("test.wav");
        }
    }
    public void moveLeft(){
        ismoving = true;
        setLocation(getX()-speed,getY());
        if(bikeequiped){
            speed = 5;
            speedlimit = speedlimit+20;
            if(speedlimit <1000){
                speed = 5;
                if(MyWorld.CurrentScene>37 && MyWorld.CurrentScene  <58){
                    speed = 6;
                    speedlimit = speedlimit-1;
                }
            }   
            if(speedlimit >1000){
                speed = 3;
                if(MyWorld.CurrentScene>37 && MyWorld.CurrentScene  <58){
                    speed = 6;
                    speedlimit = speedlimit-1;
                }
            }
        }
        if(bikeequiped != true){
            speedlimit = speedlimit+20;
            if(speedlimit <1000){
                speed = 3;
            }
            if(speedlimit >1000){
                speed = 2;
            }
        }
    }
    public void moveRight(){
        ismoving = true;
        setLocation(getX()+speed,getY());
        if(bikeequiped){
            speed = 5;
            speedlimit = speedlimit+20;
            if(speedlimit <1000){
                speed = 5;
                if(MyWorld.CurrentScene>37 && MyWorld.CurrentScene  <58){
                    speed = 6;
                    speedlimit = speedlimit-3;
                }
            }   
            if(speedlimit >1000){
                speed = 3;
                if(MyWorld.CurrentScene>37 && MyWorld.CurrentScene  <58){
                    speed = 6;
                    speedlimit = speedlimit-3;
                }
            }
        }
        if(bikeequiped != true){
            speedlimit = speedlimit+20;
            if(speedlimit <1000){
                speed = 3;
            }   
            if(speedlimit >1000){
                speed = 1;
            }
        }
    }  
}

