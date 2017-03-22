package jdbchomework.console;

import jdbchomework.controller.CustomerController;
import org.slf4j.LoggerFactory;

public class CustomersMenu extends AbstractMenu {

    private static final String CUSTOMER_NOT_FOUND = "Customer not found";
    private static final String PLEASE_ENTER_CUSTOMER_ID = "Please enter customer ID: ";
    private static final String PLEASE_ENTER_CUSTOMER_NAME = "Please enter customer name: ";

    private CustomerController customerController;

    public CustomersMenu(MenuContents menuContents, CustomerController customerController) {
        super(LoggerFactory.getLogger(CustomersMenu.class), menuContents);
        this.menuContents = menuContents;
        this.customerController = customerController;
    }

    public void menu() {
        mark:
        while (true) {
            printListInConsole(menuContents.getServiceHeaderCustomer(),
                menuContents.getServiceCustomersMenu());
            int action = readInt(CHOOSE_ACTION);
            switch (action) {
                case 1:
                    printListInConsole(null, customerController.getAllCustomers());
                    break;
                case 2:
                    String name = readString(PLEASE_ENTER_CUSTOMER_NAME);
                    customerController.addCustomer(name);
                    System.out.println("Customer successfully added");
                    break;
                case 3:
                    int id = readInt(PLEASE_ENTER_CUSTOMER_ID);
                    System.out.println(customerController.getCustomerById(id));
                    break;
                case 4:
                    id = readInt(PLEASE_ENTER_CUSTOMER_ID);
                    name = readString(PLEASE_ENTER_CUSTOMER_NAME);
                    if (customerController.updateCustomerById(id, name)) {
                        System.out.println("Customer successfully updated");
                    } else {
                        System.out.println(CUSTOMER_NOT_FOUND);
                    }
                    break;
                case 5:
                    id = readInt(PLEASE_ENTER_CUSTOMER_ID);
                    if (customerController.deleteCustomerById(id)) {
                        System.out.println("Customer successfully deleted");
                    } else {
                        System.out.println(CUSTOMER_NOT_FOUND);
                    }
                    break;
                case (6):
                    printSplitLine();
                    break mark;
                default:
                    printSplitLine();
                    System.out.println(ERROR_INCORRECT_MENU_ITEM_SELECTED);
            }
        }
    }
}
