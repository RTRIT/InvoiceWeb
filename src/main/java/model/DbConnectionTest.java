//package model;
//
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DbConnectionTest {
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @PostConstruct
//    public void testConnection() {
//        System.out.println("Inside testConnection method");
//        try {
//            Integer result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
//            System.out.println("Database connected successfully, test query result: " + result);
//        } catch (Exception e) {
//            System.out.println("Failed to connect to the database: " + e.getMessage());
//        }
//    }
//}
