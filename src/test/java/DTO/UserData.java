package DTO;

import java.util.Objects;

public class UserData {
    private String name;
    private String job;

    public UserData() {
    }

    public UserData(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData userData = (UserData) o;
        return Objects.equals(name, userData.name) && Objects.equals(job, userData.job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, job);
    }
}
