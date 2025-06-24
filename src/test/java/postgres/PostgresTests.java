package postgres;

import dto.CRUDUtils;
import dto.Doctor;
import dto.ListDoctors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

public class PostgresTests {
    public static ListDoctors listDoctors = new ListDoctors();

    @BeforeEach
    public void setUp() {
        CRUDUtils.deleteDoctorsTable();
        CRUDUtils.createDoctorsTable();
        for(int i=0; i<=9; i++) {
            CRUDUtils.createDoctor(listDoctors.getDoctors().get(i));
        }
    }

    @Test
    public void createTableTest() {
        Assertions.assertTrue(CRUDUtils.createDoctorsTable());
    }

    @Test
    public void dropTableTest() {
        Assertions.assertTrue(CRUDUtils.deleteDoctorsTable());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/doctorsTest.csv")
    public void createDoctorTest(int id, String surname, String name, String patronymic, String medicalSpecialty) {
        Doctor doctor = new Doctor();
        doctor.setSurname(surname);
        doctor.setName(name);
        doctor.setPatronymic(patronymic);
        doctor.setMedicalSpecialty(medicalSpecialty);

        CRUDUtils.createDoctor(doctor);

        Doctor actualDoctor = CRUDUtils.getDoctors("SELECT * FROM doctors ORDER BY id DESC LIMIT 1").getFirst();

        Assertions.assertEquals(doctor, actualDoctor);
    }

    @Test
    public void readDoctorTest() {

        List<Doctor> actualDoctors = CRUDUtils.getDoctors("SELECT * FROM doctors");

        Assertions.assertEquals(listDoctors.getDoctors(), actualDoctors);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/doctorsTest.csv")
    public void updateDoctorSurnameTest(int id, String surname) {
        CRUDUtils.updateDoctorsSurname(id, surname);

        String actualSurname = CRUDUtils.getDoctors("SELECT * FROM doctors WHERE id = " + id).getFirst().getSurname();

        Assertions.assertEquals(surname, actualSurname);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/doctorsTest.csv")
    public void deleteDoctorTest(int id) {
        CRUDUtils.deleteDoctors(id);
        int expectedSize = listDoctors.getDoctors().size() - 1;
        int actualSize = CRUDUtils.getDoctors("SELECT * FROM doctors").size();

        Assertions.assertEquals(expectedSize, actualSize);
    }

}
