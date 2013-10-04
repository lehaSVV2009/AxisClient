package example.com.kadet.jbbook.controller;

import example.com.kadet.jbbook.model.Model;
import example.com.kadet.jbbook.view.MainPanel;

import javax.xml.rpc.ServiceException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import static example.com.kadet.jbbook.model.Model.getInstance;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 04.10.13
 * Time: 2:19
 * To change this template use File | Settings | File Templates.
 */
public class ToInfoPageListener implements ActionListener{

    private final static String SERVICE_ERROR = "Service Error!";
    private final static String REMOTE_ERROR = "Remote Error!";

    private MainPanel mainPanel;
    private String theme;
    private Model model;


    public ToInfoPageListener (MainPanel mainPanel, String theme) {
        this.mainPanel = mainPanel;
        this.theme = theme;
        try {
            model = getInstance();

        } catch (ServiceException e) {
            mainPanel.makeErrorPanel(SERVICE_ERROR);
            revalidateAndRepaint();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String text = model.getInfo(theme);
            mainPanel.makeInfoPanel(text);
            revalidateAndRepaint();

        } catch (RemoteException e1) {
            mainPanel.makeErrorPanel(REMOTE_ERROR);
            revalidateAndRepaint();
        }
    }

    private void revalidateAndRepaint () {
        mainPanel.revalidate();
        mainPanel.repaint();
    }

}
