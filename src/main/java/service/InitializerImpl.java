package service;

import java.util.NoSuchElementException;
import model.Product;
import model.ProductCategory;
import model.User;
import storage.Storage;

public class InitializerImpl implements Initializer {
    private static final int AGE = 70;

    @Override
    public void initializer(Storage storage, User user, Product product) {
        switch (product.getCategory()) {
            case BOOKS:
            case DIGITAL:
                if (user.isPremium()) {
                    storage.addPremium(user);
                    break;
                }
                if (user.getAge() >= AGE) {
                    storage.addMediums(user);
                    break;
                }
                if (!(user.isPremium()) && user.getAge() < AGE) {
                    storage.addSimple(user);
                    break;
                }
                break;
            case MEDICAL:
                if (user.isPremium()) {
                    storage.addPremium(user);
                    break;
                }
                if (user.getAge() >= AGE
                        && product.getCategory().equals(ProductCategory.MEDICAL)) {
                    storage.addHeights(user);
                    break;
                }
                if (!(user.isPremium()) && user.getAge() < AGE) {
                    storage.addSimple(user);
                    break;
                }
                break;
            default:
                throw new NoSuchElementException("Something went wrong. "
                + "Can't find " + product.getCategory() + "category.");
        }
    }
}
