import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;

/**
 * Klasa glownego okna gry
 */
public class MainWindow extends JFrame {
    public int currentWidth;
    public int currentHeight;

    public int prefWidth;
    public int prefHeight;

    private final Game game;

    public static int totalScore = 0;
    public Keys keys;

    /**
     * Konstruktor
     * @param game aktualna gra
     */
    MainWindow(Game game){
        keys = new Keys(game.getPlayer(), game);
        this.game = game;
        Reader.getPrefSize();
        prefHeight = Reader.prefHeight;
        prefWidth = Reader.prefWidth;
        this.setTitle("Sokoban");
        this.setSize(new Dimension(Reader.prefWidth, Reader.prefHeight));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.add(game);
        this.addKeyListener(keys);
        this.setVisible(true);
        game.start();
        initComponents(game);
    }


    /**
     * Metoda wywolujaca skalowanie elementow gry
     * @param game aktualna gra
     */
    private void initComponents(Game game) {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                currentWidth = e.getComponent().getSize().width;
                currentHeight = e.getComponent().getSize().height;

                game.resizeAll();
            }
        });
    }

    /**
     * Metoda tworzaca okna {@link NextLevelMenu} lub {@link EndGameMenu} w zaleznosci od postepu gry
     * @param levelNr numer obecnego poziomu
     * @throws IOException
     */
    public void makeLevel(int levelNr) throws IOException {
        this.dispose();
        totalScore += game.score;
        if(levelNr <= Reader.getNumberOfLevels()){
            NextLevelMenu nextLevel = new NextLevelMenu(levelNr, game.nickname, (int) game.score);
        }
        else{
            EndGameMenu endGameMenu = new EndGameMenu(game.nickname, totalScore, (int) game.score);
        }
    }
}
