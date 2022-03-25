package ui.tools;

import javax.swing.*;

public class TestUI {

    public TestUI() {
        JFrame f = new JFrame();
        JTextArea area = new JTextArea("Welcome to javatpoint");
        area.setBounds(10, 30, 200, 200);
        f.add(area);
        f.setSize(300, 300);
        f.setLayout(null);
        f.setVisible(true);

    }
}
