
import greenfoot.*;

/**
 * A rocket that can be controlled by the arrowkeys: up, left, right.
 * The gun is fired by hitting the 'space' key. 'z' releases a proton wave.
 * 
 * @author Poul Henriksen
 * @author Michael Kölling
 * 
 * @version 1.1
 */
public class Rocket extends SmoothMover
{
    //TODO (91): Declare a static integer instance constant called GUN_RELOAD_TIME initialized to 10
    private static final int GUN_RELOAD_TIME = 11;
    
    //TODO (92): Declare a static integer instance constant called WAVE_RELOAD_TIME initialized to 500
    private static final int WAVE_RELOAD_TIME = 500; 

    //TODO (93): Declare an integer instance variable called reloadDelayCount
    private int reloadDelayCount;
    
    //TODO (94): Declare an integer instance variable called waveDelayCount
    private int waveDelayCount;

    /**
     * Rocket is the constructor for objects of type Rocket
     * 
     * @param None There are not parameters
     * @return Nothing is returned
     */
    public Rocket()
    {
        
        Vector startMotion = new Vector(getRotation(), 0.7);
        addToVelocity(startMotion);
        
        //TODO (95): Initialize reloadDelayCount to 10
        reloadDelayCount = 10;

        //TODO (96): Initialize waveDelayCount to 500
        waveDelayCount = 500;
    }

    /**
     * Do what a rocket's gotta do. (Which is: mostly flying about, and turning,
     * accelerating and shooting when the right keys are pressed.)
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act()
    {
        //TODO (113): Remove the two slashes in front of this line of code
        checkWin();
        
        move();
        
        //TODO (25): Make a call to the method that checks if the user has pressed keys
        
        checkKeys();
        //TODO (77): Make a call to the method that checks if the user has collided with an asteroid
        checkCollision();

        //TODO (97): Increase reloadDelayCount and waveDelayCount by 1 each
        reloadDelayCount++;
        waveDelayCount++;
    }
    
    /**
     * checkWin checks to see if there are no more asteroids in the world,
     * which means that the game has been won
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    /**
     * chechWin checks if the player has won by checking if the rocket hit a asteroid
     * 
     * @param none there are no parameters
     * @return nothing is returned
     */
    private void checkWin()
    {
        Space world = (Space)getWorld();
        
        if( world.getObjects(Asteroid.class).size() == 0 )
        {
            world.gameWon();
        }
    }
    
    /**
     * TODO (11): Declare a method called checkKeys that does not
     *          return anything and has not parameters
     *          
     * TODO (109): If the user presses the space key...
     * 
     *      TODO (110): Fire bullets
     *      
     * TODO (12): If the user presses the left key...
     * 
     *      TODO (13): Turn left 5 degrees
     *      
     * TODO (14): If the user presses the right key...
     * 
     *      TODO (15): Turn right 5 degrees
     *      
     * TODO (111): If the user presses the z key...
     * 
     *      TODO (112): Start a proton wave
     *      
     * TODO (24): Make a method call to ignite using Greenfoot.isKeyDown("up") as a parameter
     */
    /**
     * checkKeys checks what key is being pressed and does the action linked to that key
     * if space is clicked fire a bullet
     * if left arrow key is clicked turn left 5 degrees
     * if right arrow key is clicked turn right 5 degrees
     * also links the up key to the boosters
     * 
     * @param none there are no parameters
     * @return nothing is returned
     */
    private void checkKeys(){
     
        if(Greenfoot.isKeyDown("space") == true){
            fire();
        }
        if(Greenfoot.isKeyDown("left")== true){
            turn(-  5);
        }
        if(Greenfoot.isKeyDown("right") == true){
            turn(5);
        }
        if(Greenfoot.isKeyDown("z") == true){
            startProtonWave();
        }
        ignite(Greenfoot.isKeyDown("up"));
        
    }

    /**
     * TODO (98): Declare a method called fire that does not
     *            return anything and has no parameters
     * 
     * TODO (99): Declare a local Bullet variable called bullet that
     *            is initialized to a new Bullet object that uses
     *            getVelocity() and getRotation() as parameters
     * 
     * TODO (100): If reloadDelayCount is greater than or equal to GUN_RELOAD_TIME...
     * 
     *      TODO (101): Add the bullet object at the current X location and the current Y location
     *      
     *      TODO (102): Access the move method of bullet
     *      
     *      TODO (103): Set the reloadDelayCount equal to 0
     */
    /**
     * fire fire's bullet startight 
     * 
     * @param none there are no parameters
     * @return nothing is returned
     */
    private void fire(){
        Bullet bullet = new Bullet(getVelocity(),getRotation());
        if(reloadDelayCount >= GUN_RELOAD_TIME){
            getWorld().addObject(bullet,getX(),getY());
            bullet.move();
            reloadDelayCount = 0;
        }
    }

    /**
     * TODO (104): Declare a method called startProtonWave that does not
     *            return anything and has no parameters
     *          
     * TODO (105): Declare a local ProtonWave variable called wave that is
     *            initialized to a new ProtonWave object
     *          
     * TODO (106): If waveDelayCount is greater than or equal to WAVE_RELOAD_TIME...
     * 
     *      TODO (107): Add wave to the current X location and the current Y location
     *      
     *      TODO (108): Set the waveDelayCount equal to 0
     */
    /**
     * startProtonWave starts a proton wave at the current location of the rocket when called
     * also starts the delay counter again
     * 
     * @param none there are no parameters
     * @return nothing is returned
     */
    private void startProtonWave(){
        ProtonWave wave = new ProtonWave();
        if(waveDelayCount >= WAVE_RELOAD_TIME){
            getWorld().addObject(wave,getX(),getY());
            waveDelayCount = 0;
        }
    }

    /**
     * TODO (16): Declare a method called ignite that does not
     *            return anything and has a boolean parameter
     *            called boosterOn
     *          
     * TODO (17): Declare a local GreenfootImage variable called
     *            rocket that is initialized to a new GreenfootImage
     *            object using the rocket.png file
     *          
     * TODO (18): Declare a local GreenfootImage variable called
     *            rocketWithThrust that is initialized to a new
     *            GreenfootImage object using the rocketWithThrust.png file
     *          
     * TODO (19): If boosterOn is true...
     * 
     *      TODO (20): Set the image to rocketWithThrust
     *      
     *      TODO (21): Make a method call to addToVelocity using a new
     *                 Vector object with parameters getRotation() and 0.3
     *               
     * TODO (22): Otherwise...
     * 
     *      TODO (23): Set the image to rocket
     */
    /**
     * ignite sets the image to a rocket boost image when called and also changes the velocity so its faster
     * 
     * @param boosterOn is a boolean data type (thats referenced) to turn on booster
     * @return nothing is returned
     */
    private void ignite(boolean boosterOn){
        GreenfootImage rocket = new GreenfootImage("rocket.png");
        GreenfootImage rocketWithThrust = new GreenfootImage("rocketWithThrust.png");
        if(boosterOn == true){
            setImage(rocketWithThrust);
            addToVelocity(new Vector(getRotation(),0.3));
        }
        else{
            setImage(rocket);
        }
    }

    /**
     * TODO (70): Declare a method called checkCollision that does not
     *          return anything and has no parameters
     *          
     * TODO (71): Declare a local Space variable called space that
     *          stores a reference to the world
     *          
     * TODO (72): Declare a local Actor variable called currentAsteroid
     *          that is initialized to get one intersectinf object of
     *          class Asteroid
     *          
     * TODO (73): If currentAsteroid is not nothing...
     * 
     *      TODO (74): Add a new Explosion object at the current X location and the current Y location
     *      
     *      TODO (75): Remove this object
     *      
     *      TODO (76): Make a method call to space's game over method
     */
    /**
     * checkCollision checks if a rocket collided with a asteroid 
     * if a rocket has collided end the game with an expolosion
     * 
     * @param none there are no parameters
     * @return nothing is returned
     */
    private void checkCollision(){
        Space space = (Space) getWorld();
        Actor currentAsteroid = getOneIntersectingObject(Asteroid.class);
        if (currentAsteroid != null){
            space.addObject(new Explosion(),getX(),getY());
            space.removeObject(this);
            space.gameOver();
        }
    }
}