package internetshop.dao.impl;

import internetshop.dao.Storage;
import internetshop.dao.UserDao;
import internetshop.lib.Dao;
import internetshop.model.User;

import java.util.List;
import java.util.NoSuchElementException;

@Dao
public class UserDaoImpl implements UserDao {
    @Override
    public User add(User user) {
        Storage.users.add(user);
        return user;
    }

    @Override
    public User get(Long id) {
        return Storage.users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Can't find user with id " + id));
    }

    @Override
    public User update(User newUser) {
        User user = get(newUser.getId());
        user.setBucket(newUser.getBucket());
        user.setOrders(newUser.getOrders());
        return user;
    }

    @Override
    public void delete(Long id) {
        Storage.users
                .removeIf(user -> user.getId().equals(id));
    }

    @Override
    public List<User> getAll() {
        return Storage.users;
    }
}
