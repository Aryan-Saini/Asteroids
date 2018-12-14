import greenfoot.*;

/**
 * The ScoreBoard is used to display results on the screen. It can display some
 * text and a score.
 * 
 * @author M Kölling
 * @version 1.0
 */
public class ScoreBoard extends Actor
{
    private static final double FONT_SIZE = 48.0;
    
    private static final int WIDTH = 400;
    
    private static final int HEIGHT = 300;

    /**
     * Create a score board for the final result.
     * 
     * @param message is a string data type (thats referenced) to message that should be on the image
     * @param score is a int data type (thats referenced) to the score that was on the image
     * @return nothing is returned
     */
    public ScoreBoard(String message, int score)
    {
        makeImage(message, "Score: ", score);
    }
    
    /**
     * Make the score board image.
     * 
     * @param title is a string paramameter (thats referenced) to the text in the image
     * @param prefix is a string paramameter (thats referenced) to the text in the image
     * @param score is a int parameter (thats referenced) to the score which updates in the image
     */
    private void makeImage(String title, String prefix, int score)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
        Font font = image.getFont();

        image.setColor(new Color(255,255,255, 128));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        
        image.setColor(new Color(0, 0, 0, 128));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        
        font = font.deriveFont( (float)FONT_SIZE );
        
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(title, 60, 100);
        image.drawString(prefix + score, 60, 200);
        setImage(image);
    }
}
