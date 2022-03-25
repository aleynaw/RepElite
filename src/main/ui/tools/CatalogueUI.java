package ui.tools;

import model.Exercise;
import model.ExerciseCatalogue;
import model.Profile;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CatalogueUI extends JInternalFrame {
    private JTextArea catalogueDisplay;

    private static final int LOC = 100;
    private static final int WIDTH = 300;
    private static final int HEIGHT = 200;

    public CatalogueUI(ArrayList<Exercise> ec, Component parent) {
        catalogueDisplay = new JTextArea("Exercises: \n" + toString(ec));
        catalogueDisplay.setEditable(false);
        catalogueDisplay.setAlignmentX(CENTER_ALIGNMENT);

        Container cp = getContentPane();
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
        cp.add(catalogueDisplay);
        setSize(WIDTH, HEIGHT);
        setPosition(parent);
        setVisible(true);
    }


    private String toString(ArrayList<Exercise> ec) {
        ArrayList<String> str = new ArrayList<>();
        for (Exercise e : ec) {
            str.add("\n" + e.getExerciseName() + " - " + e.getCategoryName() + "\n");
        }
        String listString = String.join("", str);
        return listString;
    }

    private void setPosition(Component parent) {
        setLocation(parent.getWidth() - 675, 0);
    }
}
