package Taller5.P1C12024.ej1;

import java.time.LocalTime;

public class PierTimedStack extends PierTimed {
    private Ferry last;

    public PierTimedStack(String name, FerryCompany company, int nDocks, LocalTime openTime, LocalTime closeTime) {
        super(name, company, nDocks, openTime, closeTime);
    }

    public Ferry getLast() {
        return last;
    }

    @Override
    public void dock(Ferry f) throws RuntimeException {
        super.dock(f);
        last = f;
    }

    @Override
    public void undock(Ferry f) throws RuntimeException {
        if(last.equals(f)) {
            super.undock(f);
            last = null;
            super.undock(f);
        } else {
            throw new RuntimeException();
        }
    }

}
