package co.edu.sena.Proyecto.repository;

import java.sql.*;
import java.util.*;

public interface repository<T> {
    List<T> listAllObj() throws SQLException;
    T byIdObj(Integer id) throws SQLException;

    Integer saveObj(T t) throws SQLException;

    void deleteObj(Integer id) throws  SQLException;

    T createObj(ResultSet rs) throws SQLException;
}
