package dto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ListDoctors {
    private final List<Doctor> doctors = new ArrayList<>();

    public ListDoctors() {
        Doctor doctor1 = new Doctor();
        doctor1.setSurname("Медведева");
        doctor1.setName("Елизавета");
        doctor1.setPatronymic("Эриковна");
        doctor1.setMedicalSpecialty("Терапевт");
        this.doctors.add(doctor1);

        Doctor doctor2 = new Doctor();
        doctor2.setSurname("Николаева");
        doctor2.setName("Елизавета");
        doctor2.setPatronymic("Фёдоровна");
        doctor2.setMedicalSpecialty("Терапевт участковый");
        this.doctors.add(doctor2);

        Doctor doctor3 = new Doctor();
        doctor3.setSurname("Лебедева");
        doctor3.setName("Виктория");
        doctor3.setPatronymic("Руслановна");
        doctor3.setMedicalSpecialty("Хирург");
        this.doctors.add(doctor3);

        Doctor doctor4 = new Doctor();
        doctor4.setSurname("Тихонов");
        doctor4.setName("Леон");
        doctor4.setPatronymic("Артемьевич");
        doctor4.setMedicalSpecialty("Офтальмолог");
        this.doctors.add(doctor4);

        Doctor doctor5 = new Doctor();
        doctor5.setSurname("Козлов");
        doctor5.setName("Даниил");
        doctor5.setPatronymic("Макарович");
        doctor5.setMedicalSpecialty("Уролог");
        this.doctors.add(doctor5);

        Doctor doctor6 = new Doctor();
        doctor6.setSurname("Лебедева");
        doctor6.setName("Софья");
        doctor6.setPatronymic("Данииловна");
        doctor6.setMedicalSpecialty("Акушер-гинеколог");
        this.doctors.add(doctor6);

        Doctor doctor7 = new Doctor();
        doctor7.setSurname("Михайлова");
        doctor7.setName("Александра");
        doctor7.setPatronymic("Данииловна");
        doctor7.setMedicalSpecialty("Оториноларинголог");
        this.doctors.add(doctor7);

        Doctor doctor8 = new Doctor();
        doctor8.setSurname("Макарова");
        doctor8.setName("Ксения");
        doctor8.setPatronymic("Максимовна");
        doctor8.setMedicalSpecialty("Стоматолог-терапевт");
        this.doctors.add(doctor8);

        Doctor doctor9 = new Doctor();
        doctor9.setSurname("Волкова");
        doctor9.setName("Ева");
        doctor9.setPatronymic("Денисовна");
        doctor9.setMedicalSpecialty("Стоматолог-хирург");
        this.doctors.add(doctor9);

        Doctor doctor10 = new Doctor();
        doctor10.setSurname("Филатов");
        doctor10.setName("Марк");
        doctor10.setPatronymic("Егорович");
        doctor10.setMedicalSpecialty("Педиатр");
        this.doctors.add(doctor10);
    }

}
