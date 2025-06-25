package dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtils {
    private static String CREATE_DOCTORS_TABLE = "CREATE TABLE IF NOT EXISTS doctors (" +
                                                                        "id SERIAL PRIMARY KEY," +
                                                                        "name VARCHAR(20) NOT NULL," +
                                                                        "surname VARCHAR(20) NOT NULL," +
                                                                        "medical_specialty VARCHAR(40) NOT NULL)";
    private static String DELETE_DOCTORS_TABLE = "DROP TABLE IF EXISTS doctors";
    private static String INSERT_DOCTOR = "INSERT INTO doctors(name, surname, medical_specialty) values(?,?,?)";
    private static String UPDATE_DOCTOR = "UPDATE doctors SET name = ? WHERE id = ?";
    private static String DELETE_DOCTOR = "DELETE FROM doctors WHERE id = ?";


    public static List<Doctor> getDoctors(String query) {
        List<Doctor> doctors = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String medicalSpecialty = rs.getString("medical_specialty");

                doctors.add(new Doctor(id, name, surname,  medicalSpecialty));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return doctors;
    }

    public static void createDoctor(Doctor doctor) {

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT_DOCTOR)) {

            ps.setString(1, doctor.getName());
            ps.setString(2, doctor.getSurname());
            ps.setString(3, doctor.getMedicalSpecialty());
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void updateDoctorsName(int doctorId, String doctorName) {

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE_DOCTOR)) {

            ps.setString(1, doctorName);
            ps.setInt(2, doctorId);
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void deleteDoctor(int doctorId) {

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(DELETE_DOCTOR)) {

            ps.setInt(1, doctorId);
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void createDoctorsTable() {

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(CREATE_DOCTORS_TABLE)) {
            ps.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void deleteDoctorsTable() {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(DELETE_DOCTORS_TABLE)) {
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}