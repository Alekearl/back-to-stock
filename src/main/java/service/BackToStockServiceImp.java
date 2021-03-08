package service;

import model.Product;
import model.User;
import storage.Storage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BackToStockServiceImp implements BackToStockService {
    private final Map<Product, List<User>> products = new HashMap<>();
    private final Initializer initializer;

    public BackToStockServiceImp() {
        initializer = new InitializerImpl();
    }

    @Override
    public void subscribe(User user, Product product) {
        if (!products.containsKey(product)) {
            products.put(product, new ArrayList<>());
        }
        initializer.initializer(user, product);
    }

    @Override
    public List<User> subscribedUsers(Product product) {
        List<User> store = products.get(product);
        store.addAll(Storage.getPremiums());
        store.addAll(Storage.getMediums());
        store.addAll(Storage.getSimplers());
        return store;
    }
}
