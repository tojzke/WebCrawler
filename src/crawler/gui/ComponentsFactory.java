package crawler.gui;

import javax.swing.*;
import java.awt.*;

public class ComponentsFactory {

    private static final Dimension DEFAULT_LABEL_SIZE = new Dimension(SizeConstants.DEFAULT_LABEL_WIDTH, SizeConstants.ROW_HEIGHT);
    private static final Dimension DEFAULT_TEXT_FIELD_SIZE = new Dimension(SizeConstants.DEFAULT_TEXT_FIELD_WIDTH, SizeConstants.ROW_HEIGHT);

    public static JLabel createLabel(String name, String text) {
        return createLabel(name, text, DEFAULT_LABEL_SIZE);
    }

    public static JLabel createLabel(String name, String text, Dimension size) {
        JLabel label = new JLabel();

        label.setName(name);
        label.setPreferredSize(size);
        label.setText(text);

        return label;
    }
    
    public static JTextField createTextField(String name) {
        return createTextField(name, DEFAULT_TEXT_FIELD_SIZE);
    }
    
    public static JTextField createTextField(String name, Dimension size) {
        JTextField textField = new JTextField();

        textField.setName(name);
        textField.setPreferredSize(size);
        textField.setEnabled(true);
        textField.setEditable(true);

        return textField;
    }

    public static JCheckBox createCheckBox(String name, String text) {
        JCheckBox checkBox = new JCheckBox();

        checkBox.setName(name);
        checkBox.setText(text);

        return checkBox;
    }

    public static JPanel createPanel(String name, Component... components) {
        JPanel panel = new JPanel();

        panel.setName(name);
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        for (var component : components) {
            panel.add(component);
        }

        return panel;
    }

    public static JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        return mainPanel;
    }
}
