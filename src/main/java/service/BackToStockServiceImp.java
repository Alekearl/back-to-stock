package service;

import model.Product;
import model.User;
import storage.Storage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BackToStockServiceImp implements BackToStockService {
    private final Map<Product, Storage> products = new HashMap<>();
    private final Initializer initializer;

    public BackToStockServiceImp() {
        initializer = new InitializerImpl();
    }

    @Override
    public void subscribe(User user, Product product) {
        if (!products.containsKey(product)) {
            products.put(product, new Storage());
        }
        initializer.initializer(products.get(product), user, product);
    }

    @Override
    public List<User> subscribedUsers(Product product) {
        List<User> store = new ArrayList<>();
        Storage storage = products.get(product);
        store.addAll(storage.getPremiums());
        store.addAll(storage.getHeights());
        store.addAll(storage.getMediums());
        store.addAll(storage.getSimplers());
        return store;
    }
}
