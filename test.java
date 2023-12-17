import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class test extends Actor
{
    /**
     * Act - do whatever the test wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        /*
         * if(CurrentScene == 1){
            //Corridor2up
            if(getX()>750){
                NextScene = "to Corridor";
                showNextScene(750,300);
                if(Greenfoot.isKeyDown("Space")){
                    CurrentScene = 2;
                    NshowNextScene(750,300);
                }
            }
            if(getX()<750){
                NshowNextScene(750,300);
            }
        }
        if(CurrentScene == 2){
            //Georg
            if(getX()<50){
                NextScene = "to Bedroom";
                showNextScene(50,300);
                if(Greenfoot.isKeyDown("Space")){
                    CurrentScene = 1;
                    NshowNextScene(50,300);
                }
            }
            if(getX()>50){
                NshowNextScene(50,300);
            }
            //Bath
            if(getX()>350 && getX()<450){
                NextScene = "to Bathroom";
                showNextScene(400,300);
                if(Greenfoot.isKeyDown("Space")){
                    CurrentScene = 3;
                    NshowNextScene(400,300);
                }
            }
            if(getX()<350 || getX() >450){
                NshowNextScene(400,300);
            }
            //Corridor
            if(getX()>750){
                NextScene = "to Corridor";
                showNextScene(750,300);
                if(Greenfoot.isKeyDown("Space")){
                    CurrentScene = 4;
                    NshowNextScene(750,300);
                }
            }
            if(getX()<750){
                NshowNextScene(750,300);
            }
        }
        if(CurrentScene == 3){
            if(getX()>750){
                NextScene = "to Corridor";
                showNextScene(750,300);
                if(Greenfoot.isKeyDown("Space")){
                    CurrentScene = 2;
                    NshowNextScene(750,300);
                }
            }
            if(getX()<750){
                NshowNextScene(750,300);
            }
        }
        if(CurrentScene == 4){
            //Corridor2up
            if(getX()<50){
                NextScene = "to Corridor";
                showNextScene(50,300);
                if(Greenfoot.isKeyDown("Space")){
                    CurrentScene = 2;
                    showNextScene(50,300);
                }
            }
            if(getX()>50){
                NshowNextScene(50,300);
            }
            //Anne Room
            if(getX()>350 && getX()<450){
                NextScene = "to Anne's Room";
                showNextScene(400,300);
                if(Greenfoot.isKeyDown("Space")){
                    CurrentScene = 5;
                    showNextScene(400,300);
                }
            }
            if(getX()<350 || getX() >450){
                NshowNextScene(400,300);
            }
            //Corridor2
            if(getX()>750){
                NextScene = "Down";
                showNextScene(750,300);
                if(Greenfoot.isKeyDown("Space")){
                    CurrentScene = 6;
                    showNextScene(750,300);
                }
            }
            if(getX()<750){
                NshowNextScene(750,300);
            }
        }
        if(CurrentScene == 5){
            //Anne's Room
            if(getX()>750){
                NextScene = "to Corridor";
                showNextScene(750,300);
                if(Greenfoot.isKeyDown("Space")){
                    CurrentScene = 4;
                    showNextScene(750,300);
                }
            }
            if(getX()>750){
                NshowNextScene(750,300);
            }
        }
        if(CurrentScene == 6){
            //Corridorup
            if(getX()>750){
                NextScene = "Up";
                showNextScene(750,300);
                if(Greenfoot.isKeyDown("Space")){
                    CurrentScene = 4;
                    showNextScene(750,300);
                }
            }
            if(getX()<750){
                NshowNextScene(750,300);
            }
            //Workroom
            if(getX()>350 && getX()<450){
                NextScene = "to Workroom";
                showNextScene(400,300);
                if(Greenfoot.isKeyDown("Space")){
                    CurrentScene = 7;
                    showNextScene(400,300);
                }
            }
            if(getX()<350 || getX() >450){
                NshowNextScene(400,300);
            }
            //Corridor
            if(getX()<50){
                NextScene = "to Corridor";
                showNextScene(50,300);
                if(Greenfoot.isKeyDown("Space")){
                    CurrentScene = 8;
                    showNextScene(50,300);
                }
            }
            if(getX()>50){
                NshowNextScene(50,300);
            }
        }
        if(CurrentScene == 7){
            //Corridor2
            if(getX()<50){
                NextScene = "to Corridor";
                showNextScene(50,300);
                if(Greenfoot.isKeyDown("Space")){
                    CurrentScene = 6;
                    showNextScene(50,300);
                }
            }
            if(getX()>50){
                NshowNextScene(50,300);
            }
        }
        if(CurrentScene == 8){
            //Corridor2
            if(getX()>750){
                NextScene = "to Corridor";
                showNextScene(750,300);
                if(Greenfoot.isKeyDown("Space")){
                    CurrentScene = 6;
                    showNextScene(750,300);
                }
            }
            if(getX()<750){
                NshowNextScene(750,300);
            }
            //Living Room
            if(getX()>500 && getX()<600){
                NextScene = "to Linving Room";
                showNextScene(550,300);
                if(Greenfoot.isKeyDown("Space")){
                    CurrentScene = 9;
                    showNextScene(550,300);
                }
            }
            if(getX()<500 || getX() >600){
                NshowNextScene(550,300);
            }
            // kitchen
            if(getX()>200 && getX()<300){
                NextScene = "to Kitchen";
                showNextScene(250,300);
                if(Greenfoot.isKeyDown("Space")){
                    CurrentScene = 10;
                    showNextScene(250,300);
                }
            }
            if(getX()<200 || getX() >300){
                NshowNextScene(250,300);
            }
            //Outside
            if(getX()<50){
                NextScene = "Outside";
                showNextScene(50,300);
                if(Greenfoot.isKeyDown("Space")){
                    CurrentScene = 11;
                    showNextScene(50,300);
                }
            }
            if(getX()>50){
                NshowNextScene(50,300);
            }
        }
        if(CurrentScene == 9){
            //Corridor
            if(getX()<50){
                NextScene = "to Corridor";
                showNextScene(50,300);
                if(Greenfoot.isKeyDown("Space")){
                    CurrentScene = 8;
                    showNextScene(50,300);
                }
            }
            if(getX()>50){
                NshowNextScene(50,300);
            }
        }
        if(CurrentScene == 10){
            //Corridor
            if(getX()<50){
                NextScene = "to Corridor";
                showNextScene(50,300);
                if(Greenfoot.isKeyDown("Space")){
                    CurrentScene = 8;
                    showNextScene(50,300);
                }
            }
            if(getX()>50){
                NshowNextScene(50,300);
            }
        }
        if(CurrentScene == 11){
            //House
            if(getX()>350 && getX()<450){
                NextScene = "Inside";
                showNextScene(50,300);
                if(Greenfoot.isKeyDown("Space")){
                    CurrentScene = 8;
                    showNextScene(50,300);
                }
            }
            if(getX()>50){
                NshowNextScene(50,300);
            }
        }
        if(CurrentScene == 12){
            
        }
        if(CurrentScene == 13){
            
        }
        if(CurrentScene == 14){
            
        }
        if(CurrentScene == 15){
            
        }
        if(CurrentScene == 16){
            
        }
        if(CurrentScene == 17){
            
        }
        
         */
        
    }
}
