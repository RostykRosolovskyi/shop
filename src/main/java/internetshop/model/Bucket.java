package internetshop.model;

import internetshop.idstorage.BucketIdGenerator;

import java.util.ArrayList;
import java.util.List;

public class Bucket {
    private Long id;
    private List<Item> items;
    private User user;

    public Bucket(User user) {
        this.id = BucketIdGenerator.generateId();
        items = new ArrayList<>();
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
