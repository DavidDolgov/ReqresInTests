package postgres;

import com.github.javafaker.Faker;
import dto.CRUDUtils;
import dto.DataGenerator;
import dto.Doctor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class UserPostgresTest {
    public static Faker faker = new Faker(new Locale("en"));
    public static List<Doctor> registerDoctors = DataGenerator.generateDoctors(10);

    @BeforeEach
    public void setUp() {
        CRUDUtils.deleteDoctorsTable();
        CRUDUtils.createDoctorsTable();
        for (Doctor registerDoctor : registerDoctors) {
            CRUDUtils.createDoctor(registerDoctor);
        }
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForCreateDoctor")
    public void createDoctorTest(String name, String surname, String medicalSpecialty) {
        Doctor doctor = new Doctor();
        doctor.setName(name);
        doctor.setSurname(surname);
        doctor.setMedicalSpecialty(medicalSpecialty);

        CRUDUtils.createDoctor(doctor);

        Doctor actualDoctor = CRUDUtils.getDoctors("SELECT * FROM doctors ORDER BY id DESC LIMIT 1").getFirst();

        Assertions.assertEquals(doctor, actualDoctor);
    }

    @Test
    public void readDoctorTest() {

        List<Doctor> actualDoctors = CRUDUtils.getDoctors("SELECT * FROM doctors");

        Assertions.assertEquals(registerDoctors, actualDoctors);
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForUpdateDoctor")
    public void updateDoctorSurnameTest(int id, String name) {
        CRUDUtils.updateDoctorsName(id, name);

        String actualSurname = CRUDUtils.getDoctors("SELECT * FROM doctors WHERE id = " + id).getFirst().getName();

        Assertions.assertEquals(name, actualSurname);
    }

    @ParameterizedTest
    @MethodSource("provideIntID")
    public void deleteDoctorTest(int id) {
        CRUDUtils.deleteDoctor(id);
        int expectedSize = registerDoctors.size() - 1;
        int actualSize = CRUDUtils.getDoctors("SELECT * FROM doctors").size();

        Assertions.assertEquals(expectedSize, actualSize);
    }

    public static Stream<Arguments> provideArgumentsForCreateDoctor() {
        String test = "TEEEEEEEEEEEEEEEEST";
        return Stream.of(
                Arguments.of(faker.name().firstName(),
                        faker.name().lastName(),
                        faker.medical().medicineName()),
                Arguments.of(String.valueOf(faker.name().firstName().charAt(1)),
                        String.valueOf(faker.name().lastName().charAt(1)),
                        String.valueOf(faker.medical().medicineName().charAt(1))),
                Arguments.of(test,test,test + test),
                Arguments.of(faker.funnyName().name(),
                        faker.funnyName().name(),
                        faker.funnyName().name())
        );
    }

    public static Stream<Arguments> provideArgumentsForUpdateDoctor() {
        String test = "TEEEEEEEEEEEEEEEEST";
        return Stream.of(
                Arguments.of(faker.number().numberBetween(1, 10),faker.name().firstName()),
                Arguments.of(1, String.valueOf(faker.name().firstName().charAt(1))),
                Arguments.of(10, test),
                Arguments.of(faker.number().numberBetween(1, 10), faker.funnyName().name())
        );
    }

    public static Stream<Integer> provideIntID() {
        return Stream.of(faker.number().numberBetween(1,10),
                1,
                10,
                faker.number().numberBetween(1,10));
    }

}
