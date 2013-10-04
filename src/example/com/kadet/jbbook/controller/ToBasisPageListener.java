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
 * Time: 2:18
 * To change this template use File | Settings | File Templates.
 */
public class ToBasisPageListener implements ActionListener {

    private final static String BASIS = "Basis";
    private final static String SERVICE_ERROR = "Service Error!";
    private final static String REMOTE_ERROR = "Remote Error!";

    private MainPanel mainPanel;
    private Model model;


    public ToBasisPageListener (MainPanel mainPanel) {
        this.mainPanel = mainPanel;
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
            String text = model.getInfo(BASIS);
            mainPanel.makeBasisPanel(text);
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
