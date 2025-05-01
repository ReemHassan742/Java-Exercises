public class Room implements Comparable<Room> {
    private int roomNo;
    private int numberOfBeds;
    private int price;

    public Room() {
    }

    public Room(int roomNo, int numberOfBeds, int price) {
        this.roomNo = roomNo;
        this.numberOfBeds = numberOfBeds;
        this.price = price;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room{" + "roomNo=" + roomNo + ", numberOfBeds=" + numberOfBeds + ", price=" + price + '}';
    }

    @Override
    public boolean equals(Object obj) {
        Room r = (Room) obj;
        return (roomNo == r.roomNo && numberOfBeds == r.numberOfBeds && price == r.price);
    }

    @Override
    public int compareTo(Room r) {
        if (roomNo > r.roomNo) {
            return 1;
        } else if (roomNo < r.roomNo) {
            return -1;
        } else {
            return 0;
        }
    }
}