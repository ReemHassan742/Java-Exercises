public abstract class Machine {
    private String brandName;
    private int productionYear;

    public Machine() {
    }

    public Machine(String brandName, int productionYear) {
        this.brandName = brandName;
        this.productionYear = productionYear;
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

    @Override
    public String toString() {
        return "Machine{" + "brandName=" + brandName + ", productionYear=" + productionYear + '}';
    }

}