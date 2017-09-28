import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by julia on 01-Mar-17.
 */
public class Tester {

    @Test
    public void TestIt(){
        Product p1 = new Product("A", 1.5, 11);
        Product p2 = new Product("B", 2.5, 22);
        Product p3 = new Product("C", 3.5, 33);
        Product p4 = new Product("D", 4.5, 44);
        Product p5 = new Product("E", 5.5, 55);
        Product p6 = new Product("F", 6.5, 66);
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p6);
        String filename = "c:\\temp\\products.bin";
        try {
            FileOutputStream fileOut =
                    new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(products);
            out.close();
            fileOut.close();
        }
        catch (Exception ex){

        }
        ArrayList<Product> newProducts=null;
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            newProducts  = (ArrayList<Product>) in.readObject();
            in.close();
            fileIn.close();
        }catch(Exception c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }
        Assert.assertTrue(newProducts!=null);
        Assert.assertTrue(newProducts.size()==products.size());
        Assert.assertTrue(newProducts.equals(products));
        for(int i = 0; i<newProducts.size();i++)
            Assert.assertTrue(newProducts.get(i).equals(products.get(i)));
    }
}
