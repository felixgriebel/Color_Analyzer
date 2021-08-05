import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicSliderUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgramGUI extends JFrame {

    /*TODO add crossmode
        differ between cross and full mode and real mid mode
        add tabs
        add save option
     */
    private static final int WIDTH=800;
    private static final int HEIGHT=400;

    private JButton startButton;
    private JButton stopButton;
    private boolean analysing = true;

    private JPanel canvas;
    private JTextPane textPane;
    private JTextPane currentSizePane;
    private JSlider slider;
    private JPanel toolbar;

    private int size;





    public ProgramGUI() throws HeadlessException {
        super("Color Analyser");

        //sets attributes for the frame
        this.setSize(WIDTH,HEIGHT);
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        //sets toolbar
        toolbar = new JPanel();
        toolbar.setBackground(new Color(200,200,200));
        FlowLayout l = new FlowLayout();
        l.setHgap(WIDTH/25);
        toolbar.setLayout(l);
        toolbar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        toolbar.setPreferredSize(new Dimension(WIDTH,HEIGHT/10));
        //TODO größe setzen für panel

        //sets start and stop button
        startButton = new JButton("START");
        startButton.setToolTipText("Start the analysing of colors");
        stopButton = new JButton("PAUSE");
        stopButton.setToolTipText("Stop the analysing of colors");
        startButton.setBackground(Color.WHITE);
        stopButton.setBackground(Color.WHITE);
        //TODO größe setzten für buttons

        //sets textpane
        size = 1;

        currentSizePane = new JTextPane();
        currentSizePane.setEditable(false);
        currentSizePane.setText("radius: 1");
        currentSizePane.setToolTipText("Displays the current radius of the tool");
        //TODO größe und passende FOnt setzen

        //set canvas
        canvas = new JPanel();
        canvas.setBackground(Color.WHITE);
        canvas.setLayout(new GridLayout());
        canvas.setToolTipText("Displays the analysed color");
        //TODO größe setzen


        //set textpane
        textPane = new JTextPane();
        textPane.setText("#ffffff");
        textPane.setEditable(false);
        textPane.setToolTipText("Displays the hex-code\n of the analysed color");
        //TODO größe und passende FOnt setzen


        //set slider
        slider = new JSlider();
        slider.setMinimum(0);
        slider.setMaximum(10);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setValue(0);
        slider.setUI(new BasicSliderUI());
        slider.setToolTipText("Adjust the radius of the tool");
        slider.setBackground(new Color(200,200,200));
        //TODO set size

        toolbar.add(startButton);
        toolbar.add(stopButton);
        toolbar.add(currentSizePane);
        toolbar.add(slider);



        //TODO adds machen

        this.add(toolbar,BorderLayout.NORTH);
        this.add(canvas,BorderLayout.CENTER);


        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);


        //Listener
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                analysing = true;
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                analysing = false;
            }
        });

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                size=slider.getValue();
                currentSizePane.setText("radius: "+size);
            }
        });
    }

    private void update(){
        Color g = ColorGetter.getColor(size);
        canvas.setBackground(g);
        textPane.setText(ColorGetter.getHEX(g));
    }

    public static void main(String[] args) {
        new ProgramGUI();
    }
}
