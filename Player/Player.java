public class Player implements Comparable <Player> {
    private int playerNo ;
    private String lastName;
    private int yearOfBirth;
    


    public Player() {
    }

    
    public Player(int playerNo, String lastName, int yearOfBirth) {
        this.playerNo = playerNo;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
    }


    public int getPlayerNo() {
        return playerNo;
    }
    public void setPlayerNo(int playerNo) {
        this.playerNo = playerNo;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getYearOfBirth() {
        return yearOfBirth;
    }
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }


    @Override
    public String toString() {
        return "Player [playerNo=" + playerNo + ", lastName=" + lastName + ", yearOfBirth=" + yearOfBirth + "]";
    }


    @Override
    public boolean equals(Object obj) {
        Player player = (Player) obj ;
        return (getPlayerNo() == player.getPlayerNo() && getLastName().equals(player.getLastName()) && getYearOfBirth() == player.getYearOfBirth());

    }


    @Override
    public int compareTo(Player o) {
        return getLastName().compareTo(o.getLastName());
    }

    



    

    

    
}