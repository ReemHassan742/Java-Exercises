public abstract class Building {
    private String address;
    private int noOfFloors;

    public Building() {
        this.address = null;
        this.noOfFloors = 0;
    }

    public Building(String address, int noOfFloors) {
        this.address = address;
        this.noOfFloors = noOfFloors;
    }

    public String getAddress() {
        return address;
    }

    public int getonOfFloors() {
        return noOfFloors;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setnoOfFloors(int noOfFloors) {
        this.noOfFloors = noOfFloors;
    }

    @Override
    public String toString() {
        return "Building{" + "address" + address + ", noOfFloors" + noOfFloors + "}";
    }
}