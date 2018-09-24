package ui;

import javax.swing.*;
import java.awt.*;

public class ProFrame extends JFrame {

    static int width = 800;
    static int height = 600;




    public static void main (String... args) {

       ProFrame proFrame = new ProFrame();

       proFrame.init(width, height);
    }


    private void init(int width, int height) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(width, height);
        setTitle("Programovani 2");

        JPanel toolbar = new JPanel();
        add(toolbar, BorderLayout.NORTH);

        JButton button = new JButton();
        button.setText("Přidat poznámku");
        toolbar.add(button);

        JTable table = new JTable();
        add(new JScrollPane(table),BorderLayout.CENTER);
        pack();


    }

}
