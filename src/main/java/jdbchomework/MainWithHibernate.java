package jdbchomework;

import jdbchomework.utils.HibernateUtil;
import jdbchomework.utils.InjectorHibTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainWithHibernate {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static BufferedReader getReader() {
        return reader;
    }

    public static void main(String[] args) throws IOException {
        InjectorHibTest.getConsoleMain().consoleMain();
        reader.close();
        HibernateUtil.closeSessionFactory();
    }


}
