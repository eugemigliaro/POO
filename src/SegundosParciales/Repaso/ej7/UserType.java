package SegundosParciales.Repaso.ej7;

public enum UserType {
    ALUMNO(2), RESPONSABLE(12), JEFE(11), AYUDANTE(10);

    private int loanTime;

    UserType(int loanTime) {
        this.loanTime = loanTime;
    }

    public int getLoanTime() {
        return loanTime;
    }
}
