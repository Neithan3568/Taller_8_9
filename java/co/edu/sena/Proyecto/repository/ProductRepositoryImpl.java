package co.edu.sena.Proyecto.repository;

import co.edu.sena.Proyecto.model.Product;
import co.edu.sena.Proyecto.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements repository<Product>{

    private String sql = null;

    @Override
    public List<Product> listAllObj() throws SQLException {
        sql = "select p.product_name, p.product_value, p.category_id " + "from products_tbl p order by p.product_name, p.product_value ";
        List<Product> product = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Product p = createObj(rs);
                product.add(p);
            }

        }
        return product;
    }

    @Override
    public Product byIdObj(Integer id) throws SQLException {
        sql =  sql = "select p.product_id, p.product_name, p.product_value, p.category_id " + "from products_tbl p where p.product_id=? ";
        Product product = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    product = createObj(rs);
                }
            }
        }
        return product;
    }

    @Override
    public Integer saveObj(Product product) throws SQLException {
        int rowsAffected = 0;
        if(product.getProduct_id() != null && product.getProduct_id() > 0) {
            sql = "update products_tbl set product_name = ?, product_value = ?, category_id = ? " + "where product_id =?";
        }
        else{
            sql= "insert into products_tbl (product_name, product_value, category_id)"+"values (upper(?),?,?)";
        }
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, product.getProduct_name());
            ps.setFloat(2, product.getProduct_value());
            ps.setInt(3,product.getCategory_id());
            if(product.getProduct_id() != null && product.getProduct_id() > 0){
                ps.setInt(4, product.getProduct_id());
            }

            rowsAffected = ps.executeUpdate();
        }

        return rowsAffected;
    }

    @Override
    public void deleteObj(Integer id) throws SQLException {
        sql= "delete from products_tbl where product_id =?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.execute();
        }
    }

    @Override
    public Product createObj(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setProduct_id(rs.getInt("product_id"));
        product.setProduct_name(rs.getString("product_name"));
        product.setProduct_value(rs.getFloat("product_value"));
        product.setCategory_id(rs.getInt("category_id"));
        return product;
    }
}
