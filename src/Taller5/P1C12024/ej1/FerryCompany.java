package Taller5.P1C12024.ej1;

public class FerryCompany {
    private final String name;

    public FerryCompany(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FerryCompany other = (FerryCompany) obj;
        return this.name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
