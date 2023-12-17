import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (Arnold) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    static boolean main = true;
    static int CurrentScene = 0;
    static int start = 0;
    static boolean slot1isused = false;
    static boolean slot2isused = false;
    static boolean slot3isused = false;
    static boolean slot4isused = false;
    static String NameOfItem1;
    static String NameOfItem2;
    static String NameOfItem3;
    static String NameOfItem4;
    static int InventorySlotSel;
    static boolean SlotSelected1 = true;
    static boolean SlotSelected2 = false;
    static boolean SlotSelected3 = false;
    static boolean SlotSelected4 = false;
    static int SlotSel;
    static int cooldown;
    static boolean showPictures=false;
    static boolean playermoveable = true;
    static boolean addpicture = false;
    static boolean picturesecure = true;
    static boolean SceneChangeable = false;
    static int StartPos;
    static int OldScene;
    static String currentObject;
    static boolean showNextStage = false;
    
    static String NextScene;
    static String NextScene2;
    static String NextScene3;
    static String NextScene4;
    static String NextScene5;

    static int playercounter = 5;
    static boolean count = false;
    static boolean SceneChange;
    static boolean newplayer = false;
    static int PX;
    static int PY;
    public MyWorld()
    {    
        // Create a new world with 1280x720 cells with a cell size of 1x1 pixels.
        super(player.Screenwidth, player.Screenheigth, 1); 
        addObject(new player(), player.Screen1_4,player.ScreenFloor);
        SceneChangeable = true;
        cooldown=100;
        CurrentScene = 1;
        
        CarKey.OfflineX = player.Screen1_4;
        CarKey.OfflineY = player.ScreenFloor;
        CarKey.OfflineScene = 104;
        //
        HouseKey.OfflineX = player.ScreenMiddle;
        HouseKey.OfflineY = player.ScreenFloor;
        HouseKey.OfflineScene = 10;
        //
        MineKey.OfflineX = player.ScreenMiddle;
        MineKey.OfflineY = player.ScreenFloor;
        MineKey.OfflineScene =102;
        //
        PoliceKey.OfflineX = player.Screen3_4;
        PoliceKey.OfflineY = player.ScreenFloor;
        PoliceKey.OfflineScene = 110;
        //
        pileOfPictures.OfflineX = player.SceneLeft;
        pileOfPictures.OfflineY = player.ScreenFloor;
        pileOfPictures.OfflineScene = 29;
        
        CabinetKey.OfflineX = player.Screen3_4;
        CabinetKey.OfflineY = player.ScreenFloor;
        CabinetKey.OfflineScene = 5;
        
        CellarKey.OfflineX = player.Screen1_4;
        CellarKey.OfflineY = player.ScreenFloor;
        CellarKey.OfflineScene = 26;
        
        WorkroomKey.OfflineX = player.ScreenMiddle;
        WorkroomKey.OfflineY = player.ScreenFloor;
        WorkroomKey.OfflineScene = 9;
        
        GardenScissors.OfflineX = player.ScreenMiddle;
        GardenScissors.OfflineY = player.ScreenFloor;
        GardenScissors.OfflineScene = 28;

        
        playermoveable = true;
        NameOfItem1 = "Not";
        NameOfItem2 = "Not";
        NameOfItem3 = "Not";
        NameOfItem4 = "Not";
        slot1isused = false;
        slot2isused = false;
        slot3isused = false;
        slot4isused = false;
        InventorySlotSel = 1;
        SlotSelected1 = true;        
        SlotSelected2 = false;
        SlotSelected3 = false;
        SlotSelected4 = false;
        SlotSel = 1;
        currentObject = "No Object";
    }
    public void addObjects(){
        if(CarKey.onScreen == false && CarKey.OfflineScene == CurrentScene){
            addObject(new CarKey(), CarKey.OfflineX, CarKey.OfflineY);
            CarKey.getLastInf = true;
            CarKey.onScreen = true;
        }if(HouseKey.onScreen == false && HouseKey.OfflineScene==CurrentScene){
            addObject(new HouseKey(), HouseKey.OfflineX, HouseKey.OfflineY);
            HouseKey.onScreen = true;
        }if(PoliceKey.onScreen == false && PoliceKey.OfflineScene==CurrentScene){
            addObject(new PoliceKey(), PoliceKey.OfflineX, PoliceKey.OfflineY);
            PoliceKey.onScreen = true;
        }if(MineKey.onScreen == false && MineKey.OfflineScene==CurrentScene){
            addObject(new MineKey(), MineKey.OfflineX, MineKey.OfflineY);
            MineKey.onScreen = true;
        }if(pileOfPictures.onScreen == false && pileOfPictures.OfflineScene==CurrentScene){
            addObject(new pileOfPictures(), pileOfPictures.OfflineX, pileOfPictures.OfflineY);
            pileOfPictures.onScreen = true;
        }if(CabinetKey.onScreen == false && CabinetKey.OfflineScene==CurrentScene){
            addObject(new CabinetKey(), CabinetKey.OfflineX, CabinetKey.OfflineY);
            CabinetKey.onScreen = true;
        }if(CellarKey.onScreen == false && CellarKey.OfflineScene==CurrentScene){
            addObject(new CellarKey(), CellarKey.OfflineX, CellarKey.OfflineY);
            CellarKey.onScreen = true;
        }if(GardenScissors.onScreen == false && GardenScissors.OfflineScene==CurrentScene){
            addObject(new GardenScissors(), GardenScissors.OfflineX, GardenScissors.OfflineY);
            GardenScissors.onScreen = true;
        }if(WorkroomKey.onScreen == false && WorkroomKey.OfflineScene==CurrentScene){
            addObject(new WorkroomKey(), WorkroomKey.OfflineX, WorkroomKey.OfflineY);
            WorkroomKey.onScreen = true;
        }
    }
    public void deleteObjects(){
        if(CarKey.isInInventory != true && CarKey.OfflineScene != CurrentScene){
            if(CarKey.onScreen){
                CarKey.lock = true;
                CarKey.getLastInf = true;
                CarKey.deletethisObject = true;
            }
        }if(HouseKey.isInInventory != true && HouseKey.OfflineScene != CurrentScene){
            if(HouseKey.onScreen){
                HouseKey.lock = true;
                HouseKey.getLastInf = true;
                HouseKey.deletethisObject = true;
            }
        }if(PoliceKey.isInInventory != true && PoliceKey.OfflineScene != CurrentScene){
            if(PoliceKey.onScreen){
                PoliceKey.lock = true;
                PoliceKey.getLastInf = true;
                PoliceKey.deletethisObject = true;
            }
        }if(MineKey.isInInventory != true && MineKey.OfflineScene != CurrentScene){
            if(MineKey.onScreen){
                MineKey.lock = true;
                MineKey.getLastInf = true;
                MineKey.deletethisObject = true;
            }
        }
        if(pileOfPictures.onScreen && pileOfPictures.OfflineScene != CurrentScene){
            if(pileOfPictures.onScreen){
                pileOfPictures.onScreen = false;
                pileOfPictures.lock = true;
                pileOfPictures.deletethisObject = true;
            }
        }
        if(CabinetKey.isInInventory != true && CabinetKey.OfflineScene != CurrentScene){
            if(CabinetKey.onScreen){
                CabinetKey.lock = true;
                CabinetKey.getLastInf = true;
                CabinetKey.deletethisObject = true;
            }
        }
        if(CellarKey.isInInventory != true && CellarKey.OfflineScene != CurrentScene){
            if(CellarKey.onScreen){
                CellarKey.lock = true;
                CellarKey.getLastInf = true;
                CellarKey.deletethisObject = true;
            }
        }
        if(GardenScissors.isInInventory != true && GardenScissors.OfflineScene != CurrentScene){
            if(GardenScissors.onScreen){
                GardenScissors.lock = true;
                GardenScissors.getLastInf = true;
                GardenScissors.deletethisObject = true;
            }
        }
        if(WorkroomKey.isInInventory != true && WorkroomKey.OfflineScene != CurrentScene){
            if(WorkroomKey.onScreen){
                WorkroomKey.lock = true;
                WorkroomKey.getLastInf = true;
                WorkroomKey.deletethisObject = true;
            }
        }
    }
    public void getInfo(){
        CarKey.getLastInf = true;
        HouseKey.getLastInf = true;
        PoliceKey.getLastInf = true;
        MineKey.getLastInf = true;
        pileOfPictures.getLastInf = true;
        player.getLastInf = true;
        CabinetKey.getLastInf = true;
        CellarKey.getLastInf = true;
        GardenScissors.getLastInf = true;
        WorkroomKey.getLastInf = true;
    }
    
    public void addPicture(){
        addObject(new picture(),500,300);
        if(picture.onScreen == false){
            showLeaveBlank();
        }
    }
    public void resetall(){
        
    }
    public void act(){
        if(CurrentScene == 0){
            SceneUpdate("Main");
        }    
        if(main){
            if(Greenfoot.isKeyDown("Space")){
                resetall();
            }
            if(Greenfoot.isKeyDown("c")){
                SceneUpdate("Controls");
            }
            if(Greenfoot.isKeyDown("")){
                
            }
        }
        
        
        addObjects();
        deleteObjects();
        
        
        if(player.distanceTOHouseKey>50){
            showText("", HouseKey.keyx, HouseKey.keyy-20);
        }if(player.distanceTOCarKey>50){
            showText("", CarKey.keyx, CarKey.keyy-20);
        }if(player.distanceTOPoliceKey>50){
            showText("", PoliceKey.keyx, PoliceKey.keyy-20);
        }if(player.distanceTOMineKey>50){
            showText("", MineKey.keyx, MineKey.keyy-20);
        }if(player.distanceTOpileOfPictures>50){
            showText("", pileOfPictures.x, pileOfPictures.y-20);
        }if(player.distanceTOGardenScissors>50){
            showText("", GardenScissors.keyx, GardenScissors.keyy-20);
        }if(player.distanceTOCabinetKey>50){
            showText("", CabinetKey.keyx, CabinetKey.keyy-20);
        }if(player.distanceTOCellarKey>50){
            showText("", CellarKey.keyx, CellarKey.keyy-20);
        }if(player.distanceTOWorkroomKey>50){
            showText("", WorkroomKey.keyx, WorkroomKey.keyy-20);
        }
        
        
        if(player.distanceTOCarKey<50){
            CarKey();
        }if(player.distanceTOHouseKey<50){
            HouseKey();
        }if(player.distanceTOPoliceKey<50){
            PoliceKey();
        }if(player.distanceTOMineKey<50){
            MineKey();
        }if(player.distanceTOpileOfPictures<50){
            pileOfPictures();
        }if(player.distanceTOCabinetKey<50){
            CabinetKey();
        }if(player.distanceTOCellarKey<50){
            CellarKey();
        }if(player.distanceTOGardenScissors<50){
            GardenScissors();
        }if(player.distanceTOWorkroomKey<50){
            WorkroomKey();
        }
        
        
        
        
        if(Greenfoot.isKeyDown("1")){
            SlotSel = 1;
            InventorySlotSel = 1;
        }if(Greenfoot.isKeyDown("2")){
            SlotSel = 2;
            InventorySlotSel = 2;
        }if(Greenfoot.isKeyDown("3")){
            SlotSel = 3;
            InventorySlotSel = 3;
        }if(Greenfoot.isKeyDown("4")){
            SlotSel = 4;
            InventorySlotSel = 4;
        }
        if(SlotSel == 1){
            currentObject = NameOfItem1;
        }
        if(SlotSel == 2){
            currentObject = NameOfItem2;
        }
        if(SlotSel == 3){
            currentObject = NameOfItem3;
        }
        if(SlotSel == 4){
            currentObject = NameOfItem4;
        }
        
        showText();
        showslot1();
        showslot2();
        showslot3();
        showslot4();
        
        cooldown = cooldown-1;
        
        
        showText("Scene: "+ CurrentScene,300,300);
        showText("Speedlimit: "+ player.speedlimit + "/1000",300,320);
        showText("Unlimited speed press T" ,300,340);
        showText("count"+ playercounter, 300,280);
    
        if(count){
            playercounter = playercounter -1;
        }
        if(playercounter <0){
            CreateNewPlayer(PX, PY);
            count = false;
            playercounter = 5;
        }
    }
    void CreateNewPlayer(int X, int Y){
        addObject(new player(),X, Y);
        SceneChange = false;
        player.onScreen = true;
        player.playercount = player.playercount+1;
    }
    public void showNextScene(int X, int Y){
        showText("Go "+ NextScene, X, Y);
    }
    public void NshowNextScene(int X, int Y){
        showText("", X, Y);
    }
    public void showNextScene2(int X, int Y){
        showText("Go "+ NextScene2, X, Y);
    }
    public void NshowNextScene2(int X, int Y){
        showText("", X, Y);
    }
    public void showNextScene3(int X, int Y){
        showText("Go "+ NextScene3, X, Y);
    }
    public void NshowNextScene3(int X, int Y){
        showText("", X, Y);
    }
    public void showNextScene4(int X, int Y){
        showText(""+ NextScene4, X, Y);
    }
    public void NshowNextScene4(int X, int Y){
        showText("", X, Y);
    }
    public void showNextScene5(int X, int Y){
        showText(""+ NextScene5, X, Y);
    }
    public void NshowNextScene5(int X, int Y){
        showText("", X, Y);
    }
    
    public void SceneUpdate(String Scene){
        setBackground(Scene+".png");
    }
    
    
    
    public void showText() {
        showText("Current Object: " + currentObject, 500,500);
    }
    public void showLeave(){
        showText("Space to leave", picture.x, picture.y+120);
    }
    public void showLeaveBlank(){
        showText("", picture.x, picture.y+120);
    }
    public void HouseKey(){
        if(player.distanceTOHouseKey<50 ){
            if(HouseKey.isfalling == false && HouseKey.onScreen){
                showText("Pick Up", HouseKey.keyx, HouseKey.keyy-20);
            }
            
        }if(player.distanceTOHouseKey > 50){
            showText("", HouseKey.keyx, HouseKey.keyy-20);
        }
        if(Greenfoot.isKeyDown("space")){
            showText("", HouseKey.keyx, HouseKey.keyy-20);
        }
        cooldown = 20;
    }
    public void CarKey(){
        if(player.distanceTOCarKey<50){
            if(CarKey.isfalling == false&& CarKey.onScreen){
                showText("Pick Up", CarKey.keyx, CarKey.keyy-20);
            }
        }if(player.distanceTOCarKey > 50){
            showText("", CarKey.keyx, CarKey.keyy-20);
        }
        if(Greenfoot.isKeyDown("space")){
            showText("", CarKey.keyx, CarKey.keyy-20);
        }
        cooldown = 20;
    }
    public void PoliceKey(){
        if(player.distanceTOPoliceKey<50){
            if(PoliceKey.isfalling == false && PoliceKey.onScreen){
                showText("Pick Up", PoliceKey.keyx, PoliceKey.keyy-20);
            }
            
        }if(player.distanceTOPoliceKey > 50){
            showText("", PoliceKey.keyx, PoliceKey.keyy-20);
        }
        if(Greenfoot.isKeyDown("space")){
            showText("", PoliceKey.keyx, PoliceKey.keyy-20);
        }
        cooldown = 20;
    }
    public void MineKey(){
        if(player.distanceTOMineKey<50){
            if(MineKey.isfalling == false && MineKey.onScreen){
                showText("Pick Up", MineKey.keyx, MineKey.keyy-20);
            }
            
        }
        if(player.distanceTOMineKey > 50){
            showText("", MineKey.keyx, MineKey.keyy-20);
        }
        if(Greenfoot.isKeyDown("space")){
            showText("", MineKey.keyx, MineKey.keyy-20);
        }
        cooldown = 20;
        
    }
    public void pileOfPictures(){
        if(pileOfPictures.onScreen ){
            if(player.distanceTOpileOfPictures<50){
                showText("E to interact", pileOfPictures.x, pileOfPictures.y-20);
            }
        }
        
        if(player.distanceTOpileOfPictures > 50){
            showText("", pileOfPictures.x, pileOfPictures.y-20);
        }
        if(Greenfoot.isKeyDown("space")){
            showText("", pileOfPictures.x, pileOfPictures.y-20);
        }
        cooldown = 20;
    }
    public void CabinetKey(){
        if(player.distanceTOCabinetKey<50 ){
            if(CabinetKey.isfalling == false && CabinetKey.onScreen){
                showText("Pick Up", CabinetKey.keyx, CabinetKey.keyy-20);
            }
            
        }if(player.distanceTOCabinetKey > 50){
            showText("", CabinetKey.keyx, CabinetKey.keyy-20);
        }
        if(Greenfoot.isKeyDown("space")){
            showText("", CabinetKey.keyx, CabinetKey.keyy-20);
        }
        cooldown = 20;
    }
    public void GardenScissors(){
        if(player.distanceTOGardenScissors<50 ){
            if(GardenScissors.isfalling == false && GardenScissors.onScreen){
                showText("Pick Up", GardenScissors.keyx, GardenScissors.keyy-20);
            }
            
        }if(player.distanceTOGardenScissors > 50){
            showText("", GardenScissors.keyx, CabinetKey.keyy-20);
        }
        if(Greenfoot.isKeyDown("space")){
            showText("", GardenScissors.keyx, GardenScissors.keyy-20);
        }
        cooldown = 20;
    }
    public void WorkroomKey(){
        if(player.distanceTOWorkroomKey<50 ){
            if(WorkroomKey.isfalling == false && WorkroomKey.onScreen){
                showText("Pick Up", WorkroomKey.keyx, WorkroomKey.keyy-20);
            }
            
        }if(player.distanceTOWorkroomKey > 50){
            showText("", WorkroomKey.keyx, WorkroomKey.keyy-20);
        }
        if(Greenfoot.isKeyDown("space")){
            showText("", WorkroomKey.keyx, WorkroomKey.keyy-20);
        }
        cooldown = 20;
    }
    public void CellarKey(){
        if(player.distanceTOCellarKey<50 ){
            if(CellarKey.isfalling == false && CellarKey.onScreen){
                showText("Pick Up", CellarKey.keyx, CellarKey.keyy-20);
            }
            
        }if(player.distanceTOCellarKey > 50){
            showText("", CellarKey.keyx, CellarKey.keyy-20);
        }
        if(Greenfoot.isKeyDown("space")){
            showText("", CellarKey.keyx, CellarKey.keyy-20);
        }
        cooldown = 20;
    }
    public void showslot1(){
        showText(NameOfItem1 , 100, 80);
    }
    public void showslot2(){
        showText(NameOfItem2 , 200, 80);
    }
    public void showslot3(){
        showText(NameOfItem3 , 300, 80);
    }
    public void showslot4(){
        showText(NameOfItem4 , 400, 80);
    }
}
