package jdbchomework;

import jdbchomework.utils.HibernateUtil;
import jdbchomework.utils.InjectorHib;

import java.io.IOException;

public class MainWithHibernate {

    public static void main(String[] args) throws IOException {
        InjectorHib.getMenuLauncher().consoleMain();
        HibernateUtil.closeSessionFactory();
    }
}
