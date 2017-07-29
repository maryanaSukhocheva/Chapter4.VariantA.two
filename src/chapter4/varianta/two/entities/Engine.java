package chapter4.varianta.two.entities;

/**
 *
 * @author Sukhocheva Maryana
 */
public class Engine extends CarPart {
    private final static String PART_TYPE = "Двигатель";
    private float volume;
    private int cylinders;
    private boolean isRunning;

    /**
     * Empty constructor. Constructs some engine
     * TODO replace with EngineBuilder.class
     */
    public Engine() {
        super();
    }

    // Setters
    public Engine setBrand(String brand) {
        super.setBrand(brand);
        return this;
    }

    public Engine setPartNumber(String partNumber) {
        super.setPartNumber(partNumber);
        return this;
    }

    public Engine setDescription(String description) {
        super.setDescription(description);
        return this;
    }

    public Engine setWeight(float weight) {
        super.setWeight(weight);
        return this;
    }

    public Engine setPrice(float price) {
        super.setPrice(price);
        return this;
    }

    public Engine setVolume(float volume) {
        this.volume = volume;
        return this;
    }

    public Engine setCylinders(int cylinders) {
        this.cylinders = cylinders;
        return this;
    }

    // Getters
    public float getVolume() {
        return volume;
    }

    public int getCylinders() {
        return cylinders;
    }

       /**
     * Returns state of engine (running or not)
     * @return - boolean running or not
     */
    public boolean isRunning(){
        return isRunning;
    }

    

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }
   

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Engine engine = (Engine) o;

        if (Float.compare(engine.getVolume(), getVolume()) != 0) return false;
        return getCylinders() == engine.getCylinders();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 23 * result + (getVolume() != +0.0f ? Float.floatToIntBits(getVolume()) : 0);
        result = 23 * result + getCylinders();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append(String.format("%-15s","Двигатель: "))
                .append(super.toString())
                .append(String.format(", объем %-1.2f литра, %d цилиндров ", volume, cylinders));
        return sb.toString();
    }
}
