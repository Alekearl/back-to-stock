package service;

import model.Product;
import model.ProductCategory;
import model.User;
import storage.Storage;

public class InitializerImpl implements Initializer {

    @Override
    public void initializer(Storage storage, User user, Product product) {
        switch (product.getCategory()) {
            case BOOKS:
            case DIGITAL:
                if (user.isPremium()) {
                    storage.addPremium(user);
                    break;
                }
                if (user.getAge() >= 70) {
                    storage.addMediums(user);
                    break;
                }
                if (!(user.isPremium()) && user.getAge() < 70) {
                    storage.addSimple(user);
                    break;
                }
            case MEDICAL:
                if (user.isPremium()) {
                    storage.addPremium(user);
                    break;
                }
                if (user.getAge() >= 70 && product.getCategory().equals(ProductCategory.MEDICAL)) {
                    storage.addHeights(user);
                    break;
                }
                if (!(user.isPremium()) && user.getAge() < 70) {
                    storage.addSimple(user);
                    break;
                }
        }
    }
}
