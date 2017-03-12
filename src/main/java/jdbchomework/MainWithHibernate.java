package jdbchomework;

import jdbchomework.utils.HibernateUtil;
import jdbchomework.utils.InjectorHibTest;

import java.io.IOException;

public class MainWithHibernate {


    public static void main(String[] args) throws IOException {
        InjectorHibTest.getConsoleMain().consoleMain();
        HibernateUtil.closeSessionFactory();
    }


}
