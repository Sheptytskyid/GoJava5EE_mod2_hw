package jdbchomework;

import jdbchomework.utils.ConnectionUtil;
import jdbchomework.utils.InjectorJdbc;

import java.io.IOException;

public class MainWithJdbc {

    public static void main(String[] args) throws IOException {
        InjectorJdbc.getMenuLauncher().consoleMain();
        ConnectionUtil.closeConnection();
    }
}
