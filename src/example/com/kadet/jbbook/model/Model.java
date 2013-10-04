package example.com.kadet.jbbook.model;

import kadet.HandBookServiceLocator;
import kadet.HandBook_PortType;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 04.10.13
 * Time: 3:27
 * To change this template use File | Settings | File Templates.
 */
public class Model {

    private static Model model;

    public static Model getInstance () throws ServiceException {
        if (model == null) {
            model = new Model();
        }
        return model;
    }

    private HandBookServiceLocator locator;
    private HandBook_PortType service;

    public Model() throws ServiceException {
        locator = new HandBookServiceLocator();
        service = locator.getHandBook();
    }

    public String getInfo (String theme) throws RemoteException {
        return service.getInfo(theme);
    }

}
