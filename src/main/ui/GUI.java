package ui;

import javafx.util.Pair;
import model.*;
import persistence.JsonReader;
import persistence.JsonReaderP;
import persistence.JsonWriter;
import persistence.JsonWriterP;
import ui.tools.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;


public class GUI extends JFrame {
    private JDesktopPane desktop;
    private JInternalFrame controlPanel;
    private Profile profile;
    private WorkoutPlan workoutPlans;
    private SavedProfiles savedProfiles;
    private static ArrayList<Exercise> sortedExercises;
    private String msg = "";

    private static String name;
    private static int age;
    private static int skillLevel;
    private static Profile prof;

    JLabel jlabel;
    JCheckBox cb1;
    JCheckBox cb2;
    JCheckBox cb3;
    JCheckBox cb4;
    JButton jbutton;
    private int amount = 0;


    private static final ArrayList<Exercise> WORKOUT_PLAN = new ArrayList<>();
    private static final String JSON_STORE = "./data/workoutplan.json";
    private static final String JSON_STORE_PROF = "./data/profiles.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private JsonWriterP jsonWriterP;
    private JsonReaderP jsonReaderP;

    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;

    //    private String imagePath = "./data/workout planner.jpeg";
    private String imagePath3 = "./data/wp2.jpg";
    private String imagePath = "./data/wp2.png";
    private String imageP = "./data/Untitled.png";


    public static void main(String[] args) {
        new GUI();
    }

    //**Code modified from AlarmSystem**
    public GUI() {
        launchJson();
        launchDesktop();
        savedProfiles = new SavedProfiles("My Profile");


        controlPanel = new JInternalFrame("Menu", true, false, false, false);
        controlPanel.setPreferredSize(new Dimension(200, HEIGHT - 50));
        controlPanel.setLayout(new BorderLayout());
        setContentPane(desktop);
        setTitle("Workout Planner App");
        setSize(WIDTH, HEIGHT);
        addButtonPanel();
        controlPanel.pack();
        controlPanel.setVisible(true);
        desktop.add(controlPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        centreOnScreen();
        setVisible(true);
    }

    private void launchDesktop() {
        desktop = new JDesktopPane() {

            ImageIcon icon = new ImageIcon(imageP);
            Image image = icon.getImage();

            @Override
            protected void paintComponent(Graphics grphcs) {
                super.paintComponent(grphcs);
                grphcs.drawImage(image, 0, 0, null);
            }
        };
        desktop.setBackground(Color.white);
    }

    private void launchJson() {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriterP = new JsonWriterP(JSON_STORE_PROF);
        jsonReaderP = new JsonReaderP(JSON_STORE_PROF);
    }

    //**Code modified from AlarmSystem**
    private void addButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 1));
        JButton createProfile = new JButton(new CreateProfile());
        buttonPanel.add(createProfile);
        createProfile.setPreferredSize(new Dimension(175, 100));
        buttonPanel.add(new JButton(new LoadProfile()));
        buttonPanel.add(new JButton(new BrowseExercises()));
        buttonPanel.add(new JButton(new PlanWorkout()));
        buttonPanel.add(new JButton(new SaveWorkout()));
        buttonPanel.add(new JButton(new LoadWorkout()));

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
            PlanningUI planningUI = new PlanningUI(workoutPlans, GUI.this);
            planningUI.setLocation(desktop.getWidth() - 675, 250);
            desktop.add(planningUI);
//            desktop.add(new PlanningUI(sortedExercises, GUI.this));


        }
    }

    private class SaveWorkout extends AbstractAction {

        SaveWorkout() {
            super("Save Workout");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            saveWorkoutPlan();
//            desktop.add(new ProfileUI(prof, GUI.this));
        }
    }

    // **Code Modified from JsonSerializationDemo**
    // EFFECTS: saves workoutPlan
    public void saveWorkoutPlan() {
        try {
            jsonWriter.open();
            jsonWriter.write(workoutPlans);
            jsonWriter.close();
            System.out.println("Saved " + workoutPlans.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    private class LoadWorkout extends AbstractAction {

        LoadWorkout() {
            super("Load Workout");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            loadWorkoutPlan();
            msg = WorkoutPlan.messageBuilder(workoutPlans);
            desktop.add(new WorkoutPlanUI(workoutPlans, msg, GUI.this));
        }
    }


    // **Code Modified from JsonSerializationDemo**
    // EFFECTS: loads workoutPlan from file
    public void loadWorkoutPlan() {
        try {
            workoutPlans = jsonReader.read();
            System.out.println("Loaded " + workoutPlans.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    public class PlanningUI extends JInternalFrame implements ActionListener {

        public PlanningUI(WorkoutPlan workoutPlan, Component parent) {
            jlabel = new JLabel("What exercises would you like to add?");
            jlabel.setBounds(50, 25, 300, 20);
            cb1 = new JCheckBox("Seated Rows (Back) -- 4s8r");
            cb1.setBounds(50, 75, 300, 20);
            cb2 = new JCheckBox("DeadLift (Glutes) -- 3s10r");
            cb2.setBounds(50, 100, 300, 20);
            cb3 = new JCheckBox("Barbell Squat (Quads) -- 4s8r");
            cb3.setBounds(50, 125, 300, 20);
            cb4 = new JCheckBox("Shoulder Press (Shoulders) -- 4s15r");
            cb4.setBounds(50, 150, 300, 20);
            jbutton = new JButton("Add to Plan");
            jbutton.setBounds(75, 200, 200, 30);
            jbutton.addActionListener(this);
            add(jlabel);
            add(cb1);
            add(cb2);
            add(cb3);
            add(cb4);
            add(jbutton);
            setSize(400, 300);
            setLayout(null);
            setVisible(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            workoutPlans = new WorkoutPlan("My Workout Plan");
            if (cb1.isSelected()) {
                amount += 1;
                msg = "Seated Rows (Back) -- 4s8r\n";
                WorkoutPlan.addExerciseSeatedRows(workoutPlans);
            }
            if (cb2.isSelected()) {
                amount += 1;
                msg += "DeadLift (Glutes) -- 3s10r\n";
                WorkoutPlan.addExerciseDeadLift(workoutPlans);
            }
            if (cb3.isSelected()) {
                amount += 1;
                msg += "Barbell Squat (Quads) -- 4s8r\n";
                WorkoutPlan.addExerciseBarbellSquat(workoutPlans);
            }
            if (cb4.isSelected()) {
                amount += 1;
                msg += "Shoulder Press (Shoulders) -- 4s15r\n";
                WorkoutPlan.addExerciseShoulderPress(workoutPlans);
            }
            msg += "-----------------\n" + "Total Exercises: " + amount;
            desktop.add(new WorkoutPlanUI(workoutPlans, msg, GUI.this));
        }
    }


}
