package ui;

import model.TableModel;
import model.ToDoItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.List;

public class ProFrame extends JFrame {

    static int width = 800;
    static int height = 600;
    private TableModel model;




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

        JButton buttonUloz = new JButton();
        buttonUloz.setText("Ulož");
        toolbar.add(buttonUloz);


        JButton buttonNacti = new JButton();
        buttonNacti.setText("Načti");
        toolbar.add(buttonNacti);

        button.addActionListener(e -> {
            ToDoItem item = new ToDoItem("Test obsah");
            model.add(item);
                });


        buttonUloz.addActionListener(e -> {
            saveItems();
        });


        buttonNacti.addActionListener(e -> {
            loadItems();
        });


        model = new TableModel();


        JTable table = new JTable(model);
        add(new JScrollPane(table),BorderLayout.CENTER);
        pack();

        setLocationRelativeTo(null); //center okna na obrazovce


    }


    private void loadItems() {
        try {
            ObjectInputStream stream = new ObjectInputStream(new FileInputStream(new File("our.db")));
            List<ToDoItem> items = (List<ToDoItem>) stream.readObject();
            stream.close();
            model.setItems(items);
            model.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveItems(){
        try {
            ObjectOutput stream = new ObjectOutputStream(new FileOutputStream(new File("our.db")));
            stream.writeObject(model.getItems());
            stream.flush();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
