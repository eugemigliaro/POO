package SegundosParciales.Repaso.ej6;

public enum QuotaType {
    LIMITED(2, 1), UNLIMITED(-1, -1);

    private final int readLimit;
    private final int writeLimit;

    QuotaType(int readLimit, int writeLimit) {
        this.readLimit = readLimit;
        this.writeLimit = writeLimit;
    }

    public boolean canRead(int currentDayReads){
        if(readLimit == -1){
            return true;
        }
        return currentDayReads < readLimit;
    }

    public boolean canWrite(int currentDayWrites){
        if(writeLimit == -1){
            return true;
        }
        return currentDayWrites < writeLimit;
    }
}

