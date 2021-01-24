import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Obstacle extends JComponent {
    private Level lev;

    public boolean isOnCorrectPlace = false;
    public double xpos;
    public double ypos;

    public double width;
    public double height;

    public int prefWidth = 50;
    public int prefHeight = 50;

    public boolean rightCollision = false;
    public boolean downCollision = false;
    public boolean leftCollision = false;
    public boolean upCollision = false;

    public boolean rightWall = false;
    public boolean leftWall = false;
    public boolean upWall = false;
    public boolean downWall = false;


//    nowy konstruktor
    public Obstacle(int levelNumber, int index) throws IOException {
        width = prefWidth;
        height = prefHeight;
        lev = Reader.makeLevel(levelNumber);
        xpos = lev.obstaclesPosition.elementAt(index).a;
        ypos = lev.obstaclesPosition.elementAt(index).b;
    }


    @Override
    public void paintComponent(Graphics g) {
        setDoubleBuffered(true);
        if(isOnCorrectPlace)
        {
            g.setColor(Color.ORANGE);
            g.fillRect((int) (width * xpos), (int) (height * ypos), (int) width, (int) height);
            g.setColor(Color.BLACK);
            g.drawRect((int) (width * xpos), (int) (height * ypos), (int) width, (int) height);
        }
        else {
            g.setColor(Color.RED);
            g.fillRect((int) (width * xpos), (int) (height * ypos), (int) width, (int) height);
            g.setColor(Color.BLACK);
            g.drawRect((int) (width * xpos), (int) (height * ypos), (int) width, (int) height);
        }
    }
}
