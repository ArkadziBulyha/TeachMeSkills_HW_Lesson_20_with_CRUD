package util;

import model.Student;
import model.TownStudent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Util {

    public static void fullInformationAboutAll(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        boolean isGetResult = statement.execute("select  students.id, name, surname, city from students join location on location_id=location.id;");
        if (isGetResult) {
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + " " +
                        resultSet.getString("surname") +
                        " " + resultSet.getString("city")
                );
            }
        }
        connection.close();
    }

    public static void addNewStudent(Connection connection) throws SQLException {
        System.out.println("Enter new student ID");
        int studentID = new Scanner(System.in).nextInt();
        System.out.println("Enter new student Name");
        String studentName = new Scanner(System.in).nextLine();
        System.out.println("Enter new student Surname");
        String studentSurname = new Scanner(System.in).nextLine();
        Student student = new Student();
        student.setID(studentID);
        student.setName(studentName);
        student.setSurname(studentSurname);
        Statement statement = connection.createStatement();
        try {
            statement.executeUpdate("insert into students (ID,name,surname) " +
                    "values ("+student.getID()+",'"+student.getName()+"','"+student.getSurname()+"') ");
        } catch (SQLException e) {
            System.out.println("This ID number is already reserved for another student");
            System.out.println(e);
        } finally {
            System.out.println("Operation is success");
        }

        connection.close();
    }

    public static void deleteStudentByName(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Student name to delete");
        String studentNameToDelete = scanner.nextLine();
        Statement statement = connection.createStatement();
        try {
            statement.executeUpdate("DELETE FROM students WHERE name like " + "('" + studentNameToDelete + "')");
        } catch (SQLException e) {
            System.out.println("Name not found");
        } finally {
            System.out.println("Operation is success");
        }
        scanner.close();
        connection.close();
    }

    public static void deleteStudentByID(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number ID to delete");
        int numberIDToDelete = scanner.nextInt();
        Statement statement = connection.createStatement();
        try {
            statement.executeUpdate("DELETE FROM students WHERE ID like " + "('" + numberIDToDelete + "')");
        } catch (SQLException e) {
            System.out.println("Name not found by this ID");
        } finally {
            System.out.println("Operation is success");
        }
        scanner.close();
        connection.close();
    }

    public static void addNewTown(Connection connection) throws SQLException {
        System.out.println("Enter id for New Town");
        int idTown = new Scanner(System.in).nextInt();
        System.out.println("Enter new Town");
        String townName = new Scanner(System.in).nextLine();
        TownStudent town = new TownStudent();
        town.setId(idTown);
        town.setNameTown(townName);
        Statement statement = connection.createStatement();
        try {
            statement.executeUpdate("insert into location (id, city ) " +
                    "values  ("+town.getId()+",'"+town.getNameTown()+ "')");
        } catch (SQLException e) {
            System.out.println("This ID number is already reserved for another town");
        } finally {
            System.out.println("Operation is success");
        }
        connection.close();
    }

    public static void deleteTownByName(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Town to delete");
        String townToDelete = scanner.nextLine();
        Statement statement = connection.createStatement();
        try {
            statement.executeUpdate("DELETE FROM location WHERE city like " + "('" + townToDelete + "')");
        } catch (SQLException e) {
            System.out.println("Town was not found");
        } finally {
            System.out.println("Operation is success");
        }
        scanner.close();
        connection.close();
    }

    public static void deleteTownById(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID Town to delete");
        int townToDeleteById = scanner.nextInt();
        Statement statement = connection.createStatement();
        try {
            statement.executeUpdate("DELETE FROM location WHERE id like " + "('" + townToDeleteById + "')");
        } catch (SQLException e) {
            System.out.println("No was found Town with this ID");
            System.out.println(e);
        } finally {
            System.out.println("Operation is success");
        }
        scanner.close();
        connection.close();
    }
}