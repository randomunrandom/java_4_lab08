import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class MyLayout extends Frame implements ActionListener {
    int WIDTH = 0;
    int HEIGHT = 0;

    MyLayout(int width, int height) {
        WIDTH = width;
        HEIGHT = height;
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        LayoutManager mgr = new GridLayout(6, 4);
        setLayout(mgr);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });

        Button close = new Button("Close");
//        close.setBounds(0, 0, 3, 2);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        add(close);


        Button HW = new Button("Hello World");
        HW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Hello, World!");
            }
        });
        add(HW);



//        add(b, BorderLayout.EAST);
//        for (int i = 0; i < 10; i++) {
//            b = new Button(String.valueOf(i));
//            add(b);
//        }

        String[] s = {"reb", "blue", "green", "white", "black"};
//
        List l = new List();
        for(String color:s) l.add(color);
//        l.setBounds(70, 100, 100, 200);
//        add(l);
//        add(l, BorderLayout.NORTH);
//
        Choice c = new Choice();
        for(String color:s) c.add(color);
//        c.setBounds(200, 100, 100, 200);
//        add(c);
//        add(c, BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.exit(0);

    }
}

class MyWindow {
    MyWindow() {

    }

    public static void main(String[] args) {
        new MyLayout(1366/2, 768/2);
    }
}