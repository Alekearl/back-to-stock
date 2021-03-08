package service;

import model.Product;
import model.ProductCategory;
import model.User;
import storage.Storage;

public class InitializerImpl implements Initializer {

    @Override
    public void initializer(User user, Product product) {
        switch (product.getCategory()) {
            case BOOKS:
            case DIGITAL:
                if (user.isPremium()) {
                    Storage.addPremium(user);
                    break;
                }
                if (user.getAge() >= 70) {
                    Storage.addMediums(user);
                    break;
                }
                if (!(user.isPremium()) && user.getAge() < 70) {
                    Storage.addSimple(user);
                    break;
                }
            case MEDICAL:
                if (user.isPremium()) {
                    Storage.addPremium(user);
                    break;
                }
                if (user.getAge() >= 70 && product.getCategory().equals(ProductCategory.MEDICAL)) {
                    Storage.addMediums(user);
                    break;
                }
                if (!(user.isPremium()) && user.getAge() < 70) {
                    Storage.addSimple(user);
                    break;
                }
        }
    }
}
