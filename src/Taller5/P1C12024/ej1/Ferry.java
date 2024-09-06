package Taller5.P1C12024.ej1;

public class Ferry {
    private final String name;
    private final FerryCompany company;
    public Ferry(String name, FerryCompany c) {
        this.name = name;
        this.company = c;
    }
    public FerryCompany getCompany() {
        return company;
    }
    @Override
    public String toString() {
        return "Ferry %s".formatted(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ferry ferry = (Ferry) o;
        if(!name.equals(ferry.name)){
            return false;
        }
        if(!company.equals(ferry.company)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + company.hashCode();
    }
}
