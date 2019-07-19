import java.awt.*;
import java.awt.event.*;

//import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;

public class Painter extends Frame implements ActionListener, MouseMotionListener {
    int WIDTH = 0;
    int HEIGHT = 0;
    int x;
    int y;
    Color col = Color.black;

    public static void main(String[] args) {
        Painter Instance;
        Instance = new Painter(1366/2, 768/2);
    }

    Painter(int w, int h) {
        WIDTH = w;
        HEIGHT = h;
        setSize(WIDTH, HEIGHT);
        setVisible(true);
//        LayoutManager mgr = new GridLayout(6, 4);
        setLayout(null);
//        addActionListener(this);


//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {

        Button close = new Button("Close");
        close.setBounds(WIDTH-100, HEIGHT-100, 100, 100);
        close.addActionListener(this);
        add(close);

//        Button clear = new Button("clear");
//        clear.setBounds(WIDTH-200, HEIGHT-100, 100, 100);
//        clear.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                repaint();
//            }
//        });
//        add(clear);

        MenuBar mb = new MenuBar();
        setMenuBar(mb);

        Menu clear = new Menu("clear");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("!");
                repaint();
            }
        });
        mb.add(clear);
        mb.add();

        Menu menu = new Menu("select Color");
        mb.add(menu);
        String strs[] = {
                "black",
                "white",
                "red",
                "green",
                "blue"
        };
        Color[] colors = {
                Color.black,
                Color.white,
                Color.red,
                Color.green,
                Color.blue
        };
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            Color color = colors[i];
//            Graphics g = getGraphics();
//            System.out.println(str+color);
            MenuItem mi = new MenuItem(str);
            menu.add(mi);
            mi.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
//                    System.out.println(str+"\t"+color);
//                    Graphics g = getGraphics();
//                    g.setColor(color);
                    col = color;
                }
            });

        }

//        Panel panel = new Panel();
//        panel.setBounds(100,0,100, 100);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                x = mouseEvent.getX();
                y = mouseEvent.getY();
            }
        });
        addMouseMotionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.exit(0);
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        int last_x = mouseEvent.getX();
        int last_y = mouseEvent.getY();
        Graphics g = getGraphics();
        g.setColor(col);
        g.drawLine(x, y, last_x, last_y);
        x = last_x;
        y = last_y;
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
