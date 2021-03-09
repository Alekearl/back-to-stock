package service;

import model.Product;
import model.ProductCategory;
import model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class BackToStockServiceImpTest {
    BackToStockService backToStockService;
    User edward = new User();
    User jason = new User();
    User michael = new User();
    User samuel = new User();

    @BeforeEach
    public void setUp() {
        backToStockService = new BackToStockServiceImp();
        edward.setName("Edward");
        edward.setPremium(false);
        edward.setAge(25);
        jason.setName("Jason");
        jason.setPremium(false);
        jason.setAge(70);
        michael.setName("Michael");
        michael.setPremium(false);
        michael.setAge(20);
        samuel.setName("Samuel");
        samuel.setPremium(true);
        samuel.setAge(30);
    }
    @Test
    public void bookUserTest_Ok() {
        Product book = new Product("1", ProductCategory.BOOKS);
        backToStockService.subscribe(edward, book);
        backToStockService.subscribe(jason, book);
        List<User> users = backToStockService.subscribedUsers(book);
        Assertions.assertEquals(List.of(jason, edward), users);
    }

    @Test
    public void digitalUserTest_Ok() {
        Product digital = new Product("2", ProductCategory.DIGITAL);
        backToStockService.subscribe(edward, digital);
        backToStockService.subscribe(jason, digital);
        backToStockService.subscribe(samuel, digital);
        List<User> users = backToStockService.subscribedUsers(digital);
        Assertions.assertEquals(List.of(samuel, jason, edward), users);
    }

    @Test
    public void medicalUserTest_Ok() {
        Product medical = new Product("3", ProductCategory.MEDICAL);
        backToStockService.subscribe(edward, medical);
        backToStockService.subscribe(jason, medical);
        backToStockService.subscribe(michael, medical);
        backToStockService.subscribe(samuel, medical);
        List<User> users = backToStockService.subscribedUsers(medical);
        Assertions.assertEquals(List.of(samuel, jason, edward, michael), users);
    }
}
