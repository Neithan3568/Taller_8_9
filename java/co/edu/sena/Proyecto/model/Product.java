package co.edu.sena.Proyecto.model;

public class Product {
    private Integer product_id;
    private String product_name;

    private Float product_value;
    private Integer category_id;

    public Product(){

    }

    public Product(Integer product_id, String product_name, Float product_value, Integer category_id) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_value = product_value;
        this.category_id = category_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Float getProduct_value() {
        return product_value;
    }

    public void setProduct_value(Float product_value) {
        this.product_value = product_value;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", product_value=" + product_value +
                ", category_id=" + category_id +
                '}';
    }
}
