package co.edu.sena.Proyecto.repository;

import co.edu.sena.Proyecto.model.User;

import java.sql.*;

public class TestUserRepositoryImpl {
    public static void main(String[] args) throws SQLException {
        repository<User> repository = new UserRepositoryImpl();

        System.out.println("========== saveObj Insert =========="); //insert
        User userInsert = new User();
        userInsert.setUser_firstname("Orlando");
        userInsert.setUser_lastname("Castaño");
        userInsert.setUser_email("orlando06@gmail.com");
        userInsert.setUser_password("678901212qwerty");
        repository.saveObj(userInsert);
        userInsert.setUser_firstname("Fernando");
        userInsert.setUser_lastname("Castaño");
        userInsert.setUser_email("fernando07@gmail.com");
        userInsert.setUser_password("asdfg12345");
        repository.saveObj(userInsert);

        System.out.println("========== listAllObj ==========");
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("========== byIdObj ==========");
        System.out.println(repository.byIdObj(1));
        System.out.println();

        System.out.println("========== saveObj ==========");
        User userUpdate = new User();
        userUpdate.setUser_id(2);
        userUpdate.setUser_firstname("Nidia");
        userUpdate.setUser_lastname("Gomez");
        userUpdate.setUser_email("nidia07@gmail.com");
        userUpdate.setUser_password("12345assas");
        repository.saveObj(userInsert);
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("========== deleteObj ==========");
        repository.deleteObj(2);
        repository.listAllObj().forEach(System.out::println);

    }
}