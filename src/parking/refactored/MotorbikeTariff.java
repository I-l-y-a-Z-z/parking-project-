package parking.refactored;

public class MotorbikeTariff implements Tariff {
    public String name() { return "MOTORBIKE"; }
    public double fee(int hours) { return hours * 2.0; }
}
