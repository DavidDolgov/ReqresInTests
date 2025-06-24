package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Doctor {
    private long id;
    private String surname;
    private String name;
    private String patronymic;
    private String medicalSpecialty;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        if (surname.equals(doctor.getSurname()) &&
                name.equals(doctor.getName()) &&
                patronymic.equals(doctor.getPatronymic()) &&
                medicalSpecialty.equals(doctor.getMedicalSpecialty())) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, patronymic, medicalSpecialty);
    }
}
