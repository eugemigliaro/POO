package SegundosParciales.Repaso.ej6;

public class UserData {
    private int reads;
    private int writes;

    public UserData() {
        this.reads = 0;
        this.writes = 0;
    }

    public void incrementReads() {
        this.reads++;
    }

    public void incrementWrites() {
        this.writes++;
    }

    public int getReads() {
        return this.reads;
    }

    public int getWrites() {
        return this.writes;
    }
}
