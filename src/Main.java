import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //Succesful checkout
        /*
        Product cheese = new Product("Cheese", 50, 3, new Expiring(LocalDate.now()), new Shippable(12));
        Product TV = new Product("TV", 150, 1, new Expiring(LocalDate.now()), new Shippable(100));
        Customer customer = new Customer("name", 1300);
        Cart cart = new Cart();
        PaymentService paymentService = new PaymentService();

        cart.add(cheese, 2);
        cart.add(TV, 1);
        paymentService.checkOut(customer, cart);
        */

        //Empty Cart
        /*
        Product cheese = new Product("Cheese", 50, 3, new Expiring(LocalDate.now()), new Shippable(12));
        Product TV = new Product("TV", 150, 1, new Expiring(LocalDate.now()), new Shippable(100));
        Customer customer = new Customer("name", 1300);
        Cart cart = new Cart();
        PaymentService paymentService = new PaymentService();
        paymentService.checkOut(customer, cart);
         */

        //Adding quantity greater than stock
        /*
        Product cheese = new Product("Cheese", 50, 3, new Expiring(LocalDate.now()), new Shippable(12));
        Product TV = new Product("TV", 150, 1, new Expiring(LocalDate.now()), new Shippable(100));
        Customer customer = new Customer("name", 1300);
        Cart cart = new Cart();
        cart.add(TV, 2);
        PaymentService paymentService = new PaymentService();
        paymentService.checkOut(customer, cart);
         */

        //Customer balance less than subTotal
        /*
        Product cheese = new Product("Cheese", 50, 3, new Expiring(LocalDate.now()), new Shippable(12));
        Product TV = new Product("TV", 150, 1, new Expiring(LocalDate.now()), new Shippable(100));
        Customer customer = new Customer("name", 200);
        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(TV, 1);
        PaymentService paymentService = new PaymentService();
        paymentService.checkOut(customer, cart);
         */
    }
}