package example.com.kadet.jbbook.view;

import example.com.kadet.jbbook.controller.ToBasisPageListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 03.10.13
 * Time: 22:59
 * To change this template use File | Settings | File Templates.
 */
public class MainFrame extends JFrame {

    private final static String TITLE = "Java Beans Handbook";

    private final static int HEIGHT = 1200;
    private final static int WIDTH = 600;


    private MainPanel mainPanel;

    public MainFrame() throws HeadlessException {
        initialize();
        createMainPanel();
        addMainPanel();
    }

    private void initialize () {
        setMinimumSize(new Dimension(HEIGHT, WIDTH));
        setTitle(TITLE);
    }

    private void createMainPanel () {
        mainPanel = new MainPanel();
        new ToBasisPageListener(mainPanel).actionPerformed(null);
    }

    private void addMainPanel () {
        setContentPane(mainPanel);
    }

}
