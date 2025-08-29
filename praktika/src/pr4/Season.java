package pr4;

public enum Season {
    SUMMER(14),
    WINTER(-9),
    SPRING(5),
    AUTUMN(2)
    ;
    private final int avTemp;
    private Season(int at) {
        this.avTemp = at;
    }

    public int getAvTemp() {
        return this.avTemp;
    }
    public String getDescription(){
        if (this == SUMMER) return "Теплое время года";
        return "Холодное время года";
    }
}

