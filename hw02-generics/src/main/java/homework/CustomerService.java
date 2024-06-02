package homework;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class CustomerService {
    private final NavigableMap<Customer, String> customerStringMap = new TreeMap<>();

    public Map.Entry<Customer, String> getSmallest() {
        return copyOf(customerStringMap.firstEntry());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        Map.Entry<Customer, String> entry = customerStringMap.higherEntry(customer);
        if (entry != null) {
            return copyOf(entry);
        }
        return null;
    }

    public void add(Customer customer, String data) {
        customerStringMap.put(customer, data);
    }

    private Map.Entry<Customer,String> copyOf(Map.Entry<Customer,String> e) {
        return Map.entry((Customer) e.getKey().clone(), e.getValue());
    }
}
