import java.io.Serializable;

/**
 * Created by julia on 01-Mar-17.
 */

public class Product implements Serializable
{

    private String name;
    private double price;
    private int quantity;

    /**
     Constructs a product with empty name and 0 price and
     quantity.
     */
    public Product()
    {
        name = "";
        price = 0;
        quantity = 0;
    }

    /**
     Constructs a product with the given name, price and
     quantity.
     @param aName product name
     @param aPrice product price
     @param aQuantity product quantity
     */
    public Product(String aName, double aPrice, int aQuantity)
    {
        name = aName;
        price = aPrice;
        quantity = aQuantity;
    }

    /**
     Returns the product name.
     @return the product name
     */
    public String getName()
    {
        return name;
    }

    /**
     Returns the product price.
     @return the product price
     */
    public double getPrice()
    {
        return price;
    }

    /**
     Returns the product quantity.
     @return the product quantity
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     Sets the product price.
     @param newPrice the new product price
     */
    public void setPrice(double newPrice)
    {
        price = newPrice;
    }

    /**
     Sets the product quantity.
     @param newQuantity the new product quantity
     */
    public void setQuantity(int newQuantity)
    {
        quantity = newQuantity;
    }

    public String toString() {
        return super.toString()+" : "+ this.name + " (" +this.price+" , "+this.quantity+")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (Double.compare(product.getPrice(), getPrice()) != 0) return false;
        if (getQuantity() != product.getQuantity()) return false;
        return getName() != null ? getName().equals(product.getName()) : product.getName() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getName() != null ? getName().hashCode() : 0;
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getQuantity();
        return result;
    }
}

