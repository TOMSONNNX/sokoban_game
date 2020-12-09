import java.io.IOException;
import java.util.*;

public class Level {

    Level()
    {
        try
        {
            var quintet = GetValuesFromReader.getPropValues();
            numberOfObstacles = quintet.e;
            levelNumber = quintet.d;
            for(int i = 0; i<quintet.c.length; i += 2)
            {
                obstaclesPosition.add(new Pair<>(quintet.c[i], quintet.c[i + 1]));
            }
            for(int i = 0; i<quintet.b.length; i += 2)
            {
                wallsPosition.add(new Pair<>(quintet.b[i], quintet.b[i + 1]));
            }
            for(int i = 0; i<quintet.a.length; i += 2)
            {
                playerPosition.add(new Pair<>(quintet.a[i], quintet.a[i + 1]));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    int numberOfObstacles = 0;
    int levelNumber = 0;
    Vector<Pair<Integer, Integer>> obstaclesPosition = new Vector<>();
    Vector<Pair<Integer, Integer>> wallsPosition = new Vector<>();
    Vector<Pair<Integer, Integer>> playerPosition = new Vector<>();
}