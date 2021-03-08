package service;

import model.Product;
import model.User;
import storage.Storage;

public interface Initializer {
    void initializer(Storage storage, User user, Product product);
}
