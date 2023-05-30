import java.util.*;

public class CustomerManage {
    private static List<Customer> customers = new ArrayList<>();

    static {
        initCustomer();
    }

    private static void initCustomer() {
        Customer customer1 = new Customer(1, "Le trung hieu", "0772658658", "a@gmail.com");
        Customer customer2 = new Customer(2, "asdasd", "0772658658", "a@gmail.com");
        Customer customer3 = new Customer(3, "34543dfgdfg", "0772658658", "a@gmail.com");
        Customer customer4 = new Customer(4, "dfgdfg", "0772658658", "a@gmail.com");
        Customer customer5 = new Customer(5, "546gfhh", "0772658658", "a@gmail.com");
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);
    }

    public static Customer getCustomer(int customerId) {
        return customers.get(customerId);
    }

    public static void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public static List<Customer> getAllCustomer() {
        return customers;
    }
    public static void deleteById(int id){
        for (Customer customer : customers) {
            if (customer.getId() == id){
                customers.remove(customer);
            }
        }
    }
}
