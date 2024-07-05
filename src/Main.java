import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private List<Product> products;
    private AddCart cart;
    private Scanner scanner;


    public Main() {

        this.products = new ArrayList<Product>();
        this.cart = new AddCart();
        this.scanner = new Scanner(System.in);
        populateProducts();
    }

        private void populateProducts() {
           products.add(new Product(1,"Bat",999.99,"MRF"));
           products.add(new Product(2,"Ball",956.22,"Kookabura"));
           products.add(new Product(3,"Gloves",456.00,"SG"));
    }

       public void displayProducts() {
           System.out.println("Items are Available in our store");
           for (Product product : products) {

               System.out.println(product);
           }

       }

          public void start(){

          boolean running = true;
            while (running) {
                System.out.println("Please enter your choice");
                 System.out.println("1. Product");
                 System.out.println("2. Add Cart");
                 System.out.println("3. addProductToCart();");
                 System.out.println("4. ProductQuantityInCart");
                 System.out.println("5. RemoveProductFromCart");
                 System.out.println("6. checkout");
                 System.out.println("7. Exit");

                 int choice = scanner.nextInt();
                 scanner.nextLine();
                 switch (choice) {
                     case 1:
                         displayProducts();
                         break;
                         case 2:
                             System.out.println(cart);
                             break;
                     case 3:
                         addProductToCart();
                         break;
                     case 4:
                         updateProductQuantityInCart();
                         break;
                     case 5:
                         removeProductFromCart();
                         break;
                     case 6:
                         checkout();
                         break;
                     case 7:
                         running = false;
                         break;
                     default:
                         System.out.println("Invalid choice. Please try again.");

                 }

            }

          }

    private void addProductToCart() {
        System.out.print("Enter Product ID to add: ");
        int productId = scanner.nextInt();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Product product = findProductById(productId);
        if (product != null) {
            cart.addProducts(product, quantity);
            System.out.println("Product added to cart.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private void updateProductQuantityInCart() {
        System.out.print("Enter Product ID to update: ");
        int productId = scanner.nextInt();
        System.out.print("Enter new Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        cart.updateQuantity(productId, quantity);
        System.out.println("Product quantity updated.");
    }
    private void removeProductFromCart() {
        System.out.print("Enter Product ID to remove: ");
        int productId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        cart.removeProduct(productId);
        System.out.println("Product removed from cart.");
    }

    private void checkout() {
        System.out.println("Checkout");
        System.out.println(cart);
        System.out.println("Enter 'yes' to confirm purchase or 'no' to cancel:");
        String confirmation = scanner.nextLine();
        if (confirmation.equalsIgnoreCase("yes")) {
            System.out.println("Purchase confirmed. Thank you!");
            cart.clearItems();
        } else {
            System.out.println("Purchase canceled.");
        }
    }

    private Product findProductById(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }


    public static void main(String[] args) {
       Main m=new Main();
        m.start();
    }
}