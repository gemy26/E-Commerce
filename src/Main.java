import Models.Customer;

import Models.Strategies.Expiring;
import Models.Product;
import Models.Strategies.Shippable;
import Services.OrderingService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //Succesful checkout
        Product cheese = new Product("Cheese", 50, 3, new Expiring(LocalDate.now()), new Shippable(12));
        Product TV = new Product("TV", 150, 1, new Expiring(LocalDate.now()), new Shippable(100));
        Customer customer = new Customer("name", 1300);
        OrderingService orderingService = new OrderingService();

        customer.getCart().add(cheese, 2);
        customer.getCart().add(TV, 1);
        orderingService.checkOut(customer);



        //Empty Models.Cart

        /*
        Models.Product cheese = new Models.Product("Cheese", 50, 3, new Models.Strategies.Expiring(LocalDate.now()), new Models.Shippable(12));
        Models.Product TV = new Models.Product("TV", 150, 1, new Models.Strategies.Expiring(LocalDate.now()), new Models.Shippable(100));
        Models.Customer customer = new Models.Customer("name", 1300);
        Models.Cart cart = new Models.Cart();
        Services.OrderingService orderingService = new Services.OrderingService();
        orderingService.checkOut(customer, cart);
         */

        //Adding quantity greater than stock
        /*
        Models.Product cheese = new Models.Product("Cheese", 50, 3, new Models.Strategies.Expiring(LocalDate.now()), new Models.Shippable(12));
        Models.Product TV = new Models.Product("TV", 150, 1, new Models.Strategies.Expiring(LocalDate.now()), new Models.Shippable(100));
        Models.Customer customer = new Models.Customer("name", 1300);
        Models.Cart cart = new Models.Cart();
        cart.add(TV, 2);
        PaymentService orderingService = new PaymentService();
        orderingService.checkOut(customer, cart);
         */

        //Models.Customer balance less than subTotal
        /*
        Models.Product cheese = new Models.Product("Cheese", 50, 3, new Models.Strategies.Expiring(LocalDate.now()), new Models.Shippable(12));
        Models.Product TV = new Models.Product("TV", 150, 1, new Models.Strategies.Expiring(LocalDate.now()), new Models.Shippable(100));
        Models.Customer customer = new Models.Customer("name", 200);
        Models.Cart cart = new Models.Cart();
        cart.add(cheese, 2);
        cart.add(TV, 1);
        PaymentService orderingService = new PaymentService();
        orderingService.checkOut(customer, cart);
         */
    }
}