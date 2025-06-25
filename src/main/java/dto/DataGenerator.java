package dto;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DataGenerator {
    private static Faker faker = new Faker(new Locale("en"));
    private DataGenerator() {
    }

    //RegistrationOfQuantityDoctors
    public static List<Doctor> generateDoctors(int quantity) {
        List<Doctor> doctors = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            Doctor doctor = new Doctor();
            doctor.setName(faker.name().firstName());
            doctor.setSurname(faker.name().lastName());
            doctor.setMedicalSpecialty(faker.medical().medicineName());
            doctors.add(doctor);
        }
        return doctors;
    }
}
