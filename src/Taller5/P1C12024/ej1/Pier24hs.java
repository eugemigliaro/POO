package Taller5.P1C12024.ej1;

public class Pier24hs {
    private final String name;
    private final FerryCompany company;
    private final int nDocks;
    private int nFerries;

    public Pier24hs(String name, FerryCompany company, int nDocks){
        this.name = name;
        this.company = company;
        this.nDocks = nDocks;
        this.nFerries = 0;
    }

    public String getName(){
        return name;
    }

    public FerryCompany getCompany(){
        return company;
    }

    public int getNDocks(){
        return nDocks;
    }

    public int getNFerries(){
        return nFerries;
    }

    public void dock(Ferry f) throws RuntimeException {
        if(f.getCompany() == company){
            nFerries++;
            System.out.println("Ferry "+f.getName()+" docked at Port "+name);
        }
        else{
            throw new RuntimeException();
        }
    }

    public void undock(Ferry f) throws RuntimeException {
        if(nFerries > 0 && f.getCompany().equals(company)){
            nFerries--;
            System.out.println("Ferry "+f.getName()+" undocked at Port "+name);
        }
        else{
            throw new RuntimeException();
        }
    }
}
