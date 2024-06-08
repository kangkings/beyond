package org.example;

public enum Week {
    MON(1),
    TUE(2),
    WEB(3),
    THU(4),
    FRI(5),
    SAT(6),
    SUN(7);


    Integer num;

    Week(Integer num) {
        this.num = num;
    }
}
