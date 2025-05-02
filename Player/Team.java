import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.io.*;


public class Team {
    private ArrayList <Player> players ;

    public Team() {
    }

    public void addDataFromFile(String fileName){
        int playerNo , yearOfBirth ;
        String lastName;

        try{
            File file = new File(fileName);
            Scanner sc = new Scanner(fileName);
            Player p;
            while (sc.hasNext()) {
                playerNo = sc.nextInt();
                lastName = sc.next();
                yearOfBirth = sc.nextInt();
                p = new Player(playerNo, lastName, yearOfBirth);
                if ((players.contains(p)))
                    System.out.println("error: this player has been added before");
                else
                   players.add(p); 
            }
            sc.close();
        } catch (Exception e){
            System.out.println(e);
        }
    public int youngerThan(int yearOfBirth){
        int counter = 0;
        for (Player p :players)
          if(p.getYearOfBirth() > yearOfBirth)
             counter ++ ;
        return counter;
      }
      public void prinSorted(){
        Collections.sort(players);
        for(Player p: players)
           System.out.println(p);

      }
        
            
            

                
            
    }
    
    
}    

