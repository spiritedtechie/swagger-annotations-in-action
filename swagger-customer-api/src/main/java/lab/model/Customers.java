package lab.model;

import io.swagger.annotations.ApiModel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@ApiModel(value = "Customers", description = "Model for the customers")
public class Customers {

    private List<Customer> customers = new ArrayList();

    @XmlElementWrapper(name = "list")
    @XmlElement(name = "customer")
    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(final List<Customer> customers) {
        this.customers = customers;
    }

    public void addCustomer(final Customer customer) {
        customers.add(customer);
    }

}
