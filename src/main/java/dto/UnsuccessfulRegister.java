package dto;

import java.util.Objects;

public class UnsuccessfulRegister {
    private String error;

    public UnsuccessfulRegister() {
    }

    public UnsuccessfulRegister(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnsuccessfulRegister that = (UnsuccessfulRegister) o;
        return Objects.equals(error, that.error);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(error);
    }
}
