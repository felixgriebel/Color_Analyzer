import javax.swing.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;

public class Programframe extends JFrame {
    //TODO


    private static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width / 3;
    private static final int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height / 3;


    public Programframe() throws HeadlessException {
        super("Color Analyser");
        this.setLayout(new GridLayout(1, 1));
        this.setResizable(false);
        this.setSize(1000, 500);


        JTabbedPane pane = new JTabbedPane();
        pane.setUI(new BasicTabbedPaneUI());
        pane.setBackground(Color.WHITE);
        pane.add(new ProgramTabPanel());
        pane.add(new ProgramTabPanel());
        pane.add(new ProgramTabPanel());
        pane.add(new ProgramTabPanel());
        pane.add(new ProgramTabPanel());
        pane.add(new ProgramTabPanel());
        pane.add(new ProgramTabPanel());
        pane.add(new ProgramTabPanel());
        pane.add(new ProgramTabPanel());
        pane.add(new ProgramTabPanel());

        pane.setTitleAt(0, "1");
        pane.setTitleAt(1, "2");
        pane.setTitleAt(2, "3");
        pane.setTitleAt(3, "4");
        pane.setTitleAt(4, "5");
        pane.setTitleAt(5, "6");
        pane.setTitleAt(6, "7");
        pane.setTitleAt(7, "8");
        pane.setTitleAt(8, "9");
        pane.setTitleAt(9, "10");

        pane.setForegroundAt(0, Color.RED);
        pane.setForegroundAt(1, new Color(255, 100, 100));
        pane.setForegroundAt(2, new Color(255, 200, 2));
        pane.setForegroundAt(3, Color.GREEN);
        pane.setForegroundAt(4, Color.CYAN);
        pane.setForegroundAt(5, new Color(0, 100, 255));
        pane.setForegroundAt(6, Color.BLUE);
        pane.setForegroundAt(7, new Color(100, 0, 255));
        pane.setForegroundAt(8, Color.magenta);
        pane.setForegroundAt(9, Color.pink);


        pane.setToolTipText("If the analysing doesn't work \n try to click on START");
        this.add(pane);

        this.getContentPane().setSize(WIDTH, HEIGHT);
        this.pack();

        this.getContentPane().setSize(pane.getSize());


        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Programframe();
    }
}
