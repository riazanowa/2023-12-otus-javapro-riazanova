package homework;

import java.util.Objects;

public class Customer implements Comparable<Customer>, Cloneable{
    private final long id;
    private String name;
    private long scores;

    public Customer(long id, String name, long scores) {
        this.id = id;
        this.name = name;
        this.scores = scores;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getScores() {
        return scores;
    }

    public void setScores(long scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name='" + name + '\'' + ", scores=" + scores + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return id == customer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public int compareTo(Customer customer) {
        int result = Long.compare(this.scores, customer.scores);
        if (result == 0) {
            return Long.compare(this.id, customer.id);
        } else {
            return result;
        }
    }

    @Override
    protected Object clone() {
        Customer customer;
        try {
            customer = (Customer) super.clone();
        } catch (CloneNotSupportedException e) {
            customer = new Customer(this.id, this.name, this.scores);
        }
        return customer;
    }
}
