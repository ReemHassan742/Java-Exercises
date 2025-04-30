public class WashingMachine implements Comparable<WashingMachine> {
    private String brandName;
    private int productionYear;
    private int capacity;

    public WashingMachine() {
        this.brandName = null;
        this.productionYear = 0;
        this.capacity = 0;
    }

    public WashingMachine(String brandName, int productionYear, int capacity) {
        this.brandName = brandName;
        this.productionYear = productionYear;
        this.capacity = capacity;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "brandName:" + brandName + ", productionYear: " + productionYear + ", capacity" + capacity;
    }

    @Override
    public boolean equals(Object obj) {
        WashingMachine ob = (WashingMachine) obj;
        return (brandName.equals(ob.brandName) && (productionYear == (ob.productionYear)) && (capacity == ob.capacity));
    }

    @Override
    public int compareTo(WashingMachine wash) {
        if (this.productionYear > wash.productionYear)
            return 1;
        else if (this.productionYear < wash.productionYear)
            return -1;
        else
            return 0;
    }
}
