package E05CarSalesman;

public class Engine {
    private String modelEng;
    private int powerEng;

    private int displacementEng;
    private String efficiencyEng;

    public Engine(String modelEng, int powerEng, int displacementEng, String efficiencyEng) {
        this.modelEng = modelEng;
        this.powerEng = powerEng;
        this.displacementEng = displacementEng;
        this.efficiencyEng = efficiencyEng;
    }

    public Engine(String modelEng, int powerEng) {
        this(modelEng, powerEng, 0, "n/a");
    }

    public Engine(String modelEng, int powerEng, int displacementEng) {
        this(modelEng, powerEng, displacementEng, "n/a");
    }

    public Engine(String modelEng, int powerEng, String efficiencyEng) {
        this(modelEng, powerEng, 0, efficiencyEng);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.modelEng);

        sb.append(":")
                .append(System.lineSeparator());
        sb.append("Power: ")
                .append(this.powerEng)
                .append(System.lineSeparator());
        sb.append("Displacement: ")
                .append(this.displacementEng == 0 ? "n/a" : this.displacementEng)
                .append(System.lineSeparator());
        sb.append("Efficiency: ")
                .append(this.efficiencyEng)
                .append(System.lineSeparator());

        return sb.toString().trim();
    }



}
