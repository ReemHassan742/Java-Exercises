public class WashingMachine extends Machine implements Comparable<WashingMachine> {
    private int capacity;

    public WashingMachine(String brandName, int productionYear, int capacity) {
        super(brandName, productionYear);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return super.toString() + "WashingMachine{" + "capacity=" + capacity + '}';
    }

    @Override
    public boolean equals(Object obj) {
        WashingMachine ob = (WashingMachine) obj;
        return (getBrandName().equals(ob.getBrandName()) && getProductionYear() == ob.getProductionYear()
                && getCapacity() == ob.getCapacity());
    }

    @Override
    public int compareTo(WashingMachine wash) {
        return this.getBrandName().compareTo(wash.getBrandName());
    }
}
