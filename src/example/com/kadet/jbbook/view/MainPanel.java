package example.com.kadet.jbbook.view;

import example.com.kadet.jbbook.controller.ToBasisPageListener;
import example.com.kadet.jbbook.controller.ToInfoPageListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 03.10.13
 * Time: 22:59
 * To change this template use File | Settings | File Templates.
 */
public class MainPanel extends JPanel{

    private final static String BUTTON_RULE_1 = "Концепции";
    private final static String BUTTON_RULE_2 = "BDK";
    private final static String BUTTON_RULE_3 = "Написание простого Бина";
    private final static String BUTTON_RULE_4 = "Простые свойства";
    private final static String BUTTON_RULE_5 = "Связанные свойства";
    private final static String BUTTON_BASIS = "На главную";

    private final static String THEME_1 = "Rule1";
    private final static String THEME_2 = "Rule2";
    private final static String THEME_3 = "Rule3";
    private final static String THEME_4 = "Rule4";
    private final static String THEME_5 = "Rule5";
    private final static String BASIS = "Basis";


    private JEditorPane textArea;
    private JPanel buttonsPanel;

    public MainPanel() {
        initialize();
        createComponents();
        addComponents();
    }

    private void initialize () {
        setLayout(new BorderLayout());
    }

    private void createComponents () {
        textArea = new JEditorPane();
        textArea.setContentType("text/html");
//        textArea.setMinimumSize(new Dimension(300, 300));
        textArea.setEditable(false);
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
    }

    private void addComponents () {
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
    }

    private void removeAllButtons () {
        buttonsPanel.removeAll();
    }

    private void addButton (JButton button) {
        buttonsPanel.add(button);
    }

    public void setText (String text) {
        textArea.setText(text);
    }

    public void makeErrorPanel (String error) {
        setText(error);
        removeAllButtons();
    }

    public void makeInfoPanel (String text) {
        setText(text);
        removeAllButtons();
        addButton(createButton(BUTTON_BASIS, new ToBasisPageListener(this)));
    }

    public void makeBasisPanel (String text) {
        setText(text);
        removeAllButtons();
        addButton(createButton(BUTTON_RULE_1, new ToInfoPageListener(this, THEME_1)));
        addButton(createButton(BUTTON_RULE_2, new ToInfoPageListener(this, THEME_2)));
        addButton(createButton(BUTTON_RULE_3, new ToInfoPageListener(this, THEME_3)));
        addButton(createButton(BUTTON_RULE_4, new ToInfoPageListener(this, THEME_4)));
        addButton(createButton(BUTTON_RULE_5, new ToInfoPageListener(this, THEME_5)));
    }

    private JButton createButton (String buttonText, ActionListener listener) {
        JButton button = new JButton();
        button.setText(buttonText);
        button.addActionListener(listener);
        return button;
    }

}

