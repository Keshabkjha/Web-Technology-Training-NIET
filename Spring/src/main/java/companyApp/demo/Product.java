package companyApp.demo;
public class Product {
    private String prod_name;
    private String prod_des;
    public Product(String prod_name, String prod_des) {
        this.prod_name = prod_name;
        this.prod_des = prod_des;
    }
    public void show()
    {
        System.out.println("Product Name:" + prod_name + " Product Description: " + prod_des);
    }
}