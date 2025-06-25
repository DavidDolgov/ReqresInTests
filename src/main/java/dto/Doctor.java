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
    private String name;
    private String surname;
    private String medicalSpecialty;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return name.equals(doctor.getName()) && surname.equals(doctor.getSurname()) &&
                medicalSpecialty.equals(doctor.getMedicalSpecialty());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, medicalSpecialty);
    }
}
