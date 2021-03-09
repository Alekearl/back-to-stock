package service;

import java.util.List;
import model.Product;
import model.User;

public interface BackToStockService {
    void subscribe(User user, Product product);

    List<User> subscribedUsers(Product product);
}
