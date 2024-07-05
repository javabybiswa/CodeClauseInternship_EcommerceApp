public class Product {

    private int id;
    private String name;
    private double price;
    private String OrderDetails;

    public Product(int id, String name, double price, String orderDetails) {
        this.id = id;
        this.name = name;
        this.price = price;
        OrderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", OrderDetails='" + OrderDetails + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOrderDetails() {
        return OrderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        OrderDetails = orderDetails;
    }
}
