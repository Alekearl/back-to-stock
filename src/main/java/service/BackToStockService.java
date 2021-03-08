package service;

import model.Product;
import model.User;

import java.util.List;

public interface BackToStockService {
    void subscribe(User user, Product product);

    List<User> subscribedUsers(Product product);
}
