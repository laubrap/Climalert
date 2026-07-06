package ar.edu.utn.frba.ddsi.climalert.utils;

public class SecuentialIdGenerator {
    private long next;

    public SecuentialIdGenerator() {
        this(1L);
    }

    public SecuentialIdGenerator(long intialValue) {
        this.next = intialValue;
    }

    public long next() {
        return next++; //post incremento, devuelve next y luego le suma 1
    }
}

