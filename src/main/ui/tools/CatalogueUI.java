package ui.tools;

import model.Exercise;
import model.ExerciseCatalogue;
import model.Profile;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CatalogueUI extends JInternalFrame {
    private JTextArea catalogueDisplay;
    private static ArrayList<Exercise> exerciseCatalogue;

    private static final int LOC = 100;
    private static final int WIDTH = 300;
    private static final int HEIGHT = 400;

    public CatalogueUI(ArrayList<Exercise> ec, Component parent) {
//        profileDisplay = new JTextField("Your Name: " + p.getName());
        catalogueDisplay = new JTextArea("Exercises: \n" + toString(ec));
        catalogueDisplay.setEditable(false);
        catalogueDisplay.setAlignmentX(CENTER_ALIGNMENT);

//        JButton openClose = new JButton(new OpenCloseAction());
//        openClose.setAlignmentX(CENTER_ALIGNMENT);
        Container cp = getContentPane();
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
        cp.add(catalogueDisplay);
//        cp.add(openClose);
        setSize(WIDTH, HEIGHT);
        setPosition(parent);
        setVisible(true);
    }

    public static void printCatalogue(ArrayList<Exercise> ec) {
        exerciseCatalogue = ec;
    }

    private String toString(ArrayList<Exercise> ec) {
        ArrayList<String> str = new ArrayList<>();
        for (Exercise e : ec) {
            str.add(e.getExerciseName() + " - " + e.getCategoryName() + "\n");
        }
        String listString = String.join("", str);
        return listString;
    }

    private void setPosition(Component parent) {
        setLocation(parent.getWidth() - 600, 0);
    }
}
