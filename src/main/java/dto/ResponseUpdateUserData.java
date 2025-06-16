package dto;

import java.util.Objects;

public class ResponseUpdateUserData {
    private String name;
    private String job;
    private String updatedAt;

    public ResponseUpdateUserData() {
    }

    public ResponseUpdateUserData(String name, String job, String updatedAt) {
        this.name = name;
        this.job = job;
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseUpdateUserData that = (ResponseUpdateUserData) o;
        return Objects.equals(name, that.name) && Objects.equals(job, that.job) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, job, updatedAt);
    }
}
