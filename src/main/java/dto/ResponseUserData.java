package dto;

import java.util.Objects;

public class ResponseUserData  {
    private String name;
    private String job;
    private Integer id;
    private String createdAt;

    public ResponseUserData() {
    }

    public ResponseUserData(String name, String job, Integer id, String createdAt) {
        this.name = name;
        this.job = job;
        this.id = id;
        this.createdAt = createdAt;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseUserData that = (ResponseUserData) o;
        return Objects.equals(name, that.name) && Objects.equals(job, that.job) && Objects.equals(id, that.id) && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, job, id, createdAt);
    }
}
