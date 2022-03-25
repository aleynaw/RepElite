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

    //EFFECTS: creates new text area with printed exercise catalogue, middle top section of the window
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


    //EFFECTS: converts arraylist of exercises into a string list of exercises
    private String toString(ArrayList<Exercise> ec) {
        ArrayList<String> str = new ArrayList<>();
        for (Exercise e : ec) {
            str.add("\n" + e.getExerciseName() + " - " + e.getCategoryName() + "\n");
        }
        String listString = String.join("", str);
        return listString;
    }

    //EFFECTS: sets position of internal frame
    private void setPosition(Component parent) {
        setLocation(parent.getWidth() - 675, 0);
    }
}
