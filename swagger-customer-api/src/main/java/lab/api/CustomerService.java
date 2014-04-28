package lab.api;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import lab.domain.Customer;
import lab.domain.Customers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class CustomerService {

    private static final String EMPTY_STRING = "";

    private final Map<String, Customer> customerMap = Collections.synchronizedMap(new HashMap<String, Customer>());

    private int customerIdSequence = 2;

    public CustomerService() {

        final Customer c1 = new Customer();
        c1.setId("1");
        c1.setFirstName("Bob");
        c1.setLastName("Brown");
        c1.setAddress("27 Coventry Street");

        customerMap.put(c1.getId(), c1);
    }

    public Customer newCustomer(final Customer customer) {

        if (customer.getId() == null || EMPTY_STRING.equals(customer.getId().trim())) {
            customer.setId(String.valueOf(customerIdSequence));
            customerIdSequence++;
        }

        if (customerMap.containsKey(customer.getId()))
            throw new IllegalArgumentException("Customer already exists for id: " + customer.getId());

        customerMap.put(customer.getId(), customer);

        return customer;
    }

    public Customer updateCustomer(final Customer customer) {

        if (customerMap.containsKey(customer.getId())) {
            customerMap.put(customer.getId(), customer);
        } else throw new IllegalArgumentException("Customer cannot be updated, not found");

        return customer;
    }

    public Customer findCustomer(final String customerId) {

        if (customerMap.containsKey(customerId)) return customerMap.get(customerId);

        return null;
    }

    public Customers allCustomers() {

        final Customers customers = new Customers();

        for (final Customer customer : customerMap.values()) {
            customers.addCustomer(customer);
        }

        return customers;
    }

    public Customer deleteCustomer(final String customerId) {

        return customerMap.remove(customerId);
    }

}
