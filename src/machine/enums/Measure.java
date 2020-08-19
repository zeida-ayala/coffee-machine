package machine.enums;

public enum Measure {
    MILILITROS("ml"),
    GRAMOS("g");

    String abreviation;

    Measure(String abreviation) {
        this.abreviation = abreviation;
    }

    public String getAbreviation() {
        return abreviation;
    }
}
