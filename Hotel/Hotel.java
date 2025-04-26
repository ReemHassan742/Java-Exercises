public class Hotel extends Building implements Comparable<Hotel> {
    private int noOfRooms;

    public Hotel(String address, int noOfFloors, int noOfRooms) {
        super(address, noOfFloors);
        this.noOfRooms = noOfRooms;
    }

    public int getnoOfRooms() {
        return noOfRooms;
    }

    public void setnoOfRooms(int noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    @Override
    public String toString() {
        return super.toString() + "number of rooms: " + noOfRooms;
    }

    @Override
    public boolean equals(Object obj) {
        Hotel hotel = (Hotel) obj;
        return (getAddress().equals(hotel.getAddress()) && getonOfFloors() == (hotel.getonOfFloors())
                && getnoOfRooms() == hotel.getnoOfRooms());

    }

    @Override
    public int compareTo(Hotel hot) {
        if (this.getonOfFloors() > hot.getonOfFloors()) {
            return 1;
        } else if (this.getonOfFloors() < hot.getonOfFloors()) {
            return -1;
        } else {
            return 0;
        }
    }

}
