package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonReaderP;
import persistence.JsonWriter;
import persistence.JsonWriterP;
import ui.tools.CatalogueUI;
import ui.tools.PlanningUI;
import ui.tools.ProfileUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class GUI extends JFrame {
    private JDesktopPane desktop;
    private JInternalFrame controlPanel;
    private Profile profile;
    private WorkoutPlan workoutPlans;
    private SavedProfiles savedProfiles;
    private static ArrayList<Exercise> sortedExercises;

    private static String name;
    private static int age;
    private static int skillLevel;
    private static Profile prof;

    private static final ArrayList<Exercise> WORKOUT_PLAN = new ArrayList<>();
    private static final String JSON_STORE = "./data/workoutplan.json";
    private static final String JSON_STORE_PROF = "./data/profiles.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private JsonWriterP jsonWriterP;
    private JsonReaderP jsonReaderP;

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public static void main(String[] args) {
        new GUI();
    }

    //**Code modified from AlarmSystem**
    public GUI() {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriterP = new JsonWriterP(JSON_STORE_PROF);
        jsonReaderP = new JsonReaderP(JSON_STORE_PROF);
        workoutPlans = new WorkoutPlan("My Workout Plan");
        savedProfiles = new SavedProfiles("My Profile");
        desktop = new JDesktopPane();
        desktop.setBackground(Color.LIGHT_GRAY);
        controlPanel = new JInternalFrame("Menu", true, false, false, false);
        controlPanel.setPreferredSize(new Dimension(200, 400));
        controlPanel.setLayout(new BorderLayout());

        setContentPane(desktop);
        setTitle("Workout Planner App");
        setSize(WIDTH, HEIGHT);

        addButtonPanel();
//        addMenu();

        controlPanel.pack();
        controlPanel.setVisible(true);
        desktop.add(controlPanel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        centreOnScreen();
        setVisible(true);
//        JFrame t = new JFrame("Workout Tracker");
//
//        JButton cp = new JButton("Create Profile");
//        cp.setBounds(50, 100, 195, 30);
//        cp.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                final JTextField tf = new JTextField();
//                tf.setBounds(50,50, 150,20);
//                t.add(tf);
////                createProfileGui(t);
//            }
//        });
//
//        t.add(cp);
//        t.setSize(400, 400);
//        t.setLayout(null);
//        t.setVisible(true);
    }

    //**Code modified from AlarmSystem**
    private void addButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1));
        JButton createProfile = new JButton(new CreateProfile());
        buttonPanel.add(createProfile);
        createProfile.setPreferredSize(new Dimension(175, 100));
        buttonPanel.add(new JButton(new LoadProfile()));
        buttonPanel.add(new JButton(new BrowseExercises()));
        buttonPanel.add(new JButton(new PlanWorkout()));
//        buttonPanel.add(new JButton(new SaveWorkout()));
//        buttonPanel.add(new JButton(new LoadWorkout()));

        controlPanel.add(buttonPanel, BorderLayout.WEST);
    }

    //**Code modified from AlarmSystem**
    private void centreOnScreen() {
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        setLocation((width - getWidth()) / 2, (height - getHeight()) / 2);
    }

    //**Code modified from AlarmSystem**
    private class CreateProfile extends AbstractAction {

        CreateProfile() {
            super("Create Profile");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            String profileNLoc = JOptionPane.showInputDialog(null,
                    "Name?",
                    "Enter Name",
                    JOptionPane.QUESTION_MESSAGE);
            String profileALoc = JOptionPane.showInputDialog(null,
                    "Age?",
                    "Enter Age",
                    JOptionPane.QUESTION_MESSAGE);
            String profileSLoc = JOptionPane.showInputDialog(null,
                    "Skill Level on a scale of 1-4?",
                    "Enter Skill Level",
                    JOptionPane.QUESTION_MESSAGE);
            profile = new Profile(profileNLoc, Integer.valueOf(profileALoc), Integer.valueOf(profileSLoc));
            SavedProfiles.addToList(savedProfiles, profile);
            saveProfile();
            desktop.add(new ProfileUI(profile, GUI.this));
        }
    }

    private class LoadProfile extends AbstractAction {

        LoadProfile() {
            super("Load Profile");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            loadProfiles();
            SavedProfiles.assignValues(savedProfiles);
            desktop.add(new ProfileUI(prof, GUI.this));
        }
    }

    // **Code Modified from JsonSerializationDemo**
    // EFFECTS: saves profile
    public void saveProfile() {
        try {
            jsonWriterP.open();
            jsonWriterP.write(savedProfiles);
            jsonWriterP.close();
            System.out.println("Saved " + savedProfiles.getName() + " to " + JSON_STORE_PROF);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE_PROF);
        }
    }

    // **Code Modified from JsonSerializationDemo**
    // EFFECTS: loads profile from file
    public void loadProfiles() {
        try {
            savedProfiles = jsonReaderP.read();
            System.out.println("Loaded " + savedProfiles.getName() + " from " + JSON_STORE_PROF);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE_PROF);
        }
    }

    //EFFECTS: assigns values from loaded profile to current profile
    public static void assignValuesUI(Profile profile) {
        name = profile.getName();
        age = profile.getAge();
        skillLevel = profile.getSkillLevelInt();
        prof = new Profile(name, age, skillLevel);

    }

    //**Code modified from AlarmSystem**
    private class BrowseExercises extends AbstractAction {

        BrowseExercises() {
            super("Exercise Catalogue");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            browseExercises();
            desktop.add(new CatalogueUI(sortedExercises, GUI.this));
        }
    }

    //EFFECTS: instantiates catalogue
    public static void browseExercises() {
        ExerciseCatalogue catalogue = new ExerciseCatalogue();
        sortedExercises = ExerciseCatalogue.sortList(catalogue);
    }

    //**Code modified from AlarmSystem**
    private class PlanWorkout extends AbstractAction {

        PlanWorkout() {
            super("Plan a Workout");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
//            browseExercises();
            desktop.add(new PlanningUI(GUI.this));
//            desktop.add(new PlanningUI(sortedExercises, GUI.this));
        }
    }
}
