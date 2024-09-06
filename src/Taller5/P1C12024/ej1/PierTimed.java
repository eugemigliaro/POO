package Taller5.P1C12024.ej1;

import java.time.LocalTime;

public class PierTimed extends Pier24hs {
    private final LocalTime openTime;
    private final LocalTime closeTime;

    public PierTimed(String name, FerryCompany company, int nDocks, LocalTime openTime, LocalTime closeTime) {
        super(name, company, nDocks);
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    public LocalTime getOpenTime() {
        return openTime;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }

    @Override
    public String toString() {
        return super.toString() + " opens at " + openTime + " and closes at " + closeTime;
    }

    @Override
    public void dock(Ferry f) throws RuntimeException {
        if(LocalTime.now().isAfter(openTime) && LocalTime.now().isBefore(closeTime)) {
            super.dock(f);
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public void undock(Ferry f) throws RuntimeException {
        if(LocalTime.now().isAfter(openTime) && LocalTime.now().isBefore(closeTime)) {
            super.undock(f);
        } else {
            throw new RuntimeException();
        }
    }
}
