package jdbchomework;

import jdbchomework.utils.HibernateUtil;
import jdbchomework.utils.InjectorJdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static BufferedReader getReader() {
        return reader;
    }

    public static void main(String[] args) throws IOException {
        InjectorJdbc.getConsoleMain().consoleMain();
        reader.close();
        HibernateUtil.closeSessionFactory();
    }
}
