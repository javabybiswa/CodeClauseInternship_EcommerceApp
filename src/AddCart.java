import java.util.List;
import java.util.ArrayList;

public class AddCart {

    private List<Item> items;

    public AddCart() {
        this.items = new ArrayList<>();
    }


    public void addProducts(Product product,int quentity)
    {
        for(Item item:items){

            if(item.getProduct().getId()==product.getId()){

                item.setQuantity(item.getQuantity()+quentity);
                return;
            }
        }
        items.add(new Item(product,quentity));

    }
        public void removeProduct(int ProductId){

             items.removeIf(item -> item.getProduct().getId()==ProductId);

        }

         public void updateQuantity(int ProductId, int quantity){

        for(Item item:items){
              if(item.getProduct().getId()==ProductId){
                  item.setQuantity(quantity);
                    return;
              }
        }
         }

          public double getTotalCost(){
           return items.stream().mapToDouble(Item::getQuantity).sum();


          }

           public List<Item> getItems(){
        return items;
           }
             public void clearItems(){
                   items.clear();
             }

              public String toString(){

        StringBuilder s=new StringBuilder("cart items:\n");
           for (Item item : items) {
               s.append(item).append("\n");

           }
             s.append("Total Amount: $").append(getTotalCost()).append("\n");

              return s.toString();

              }

}
