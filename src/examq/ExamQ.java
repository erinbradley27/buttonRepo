/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examq;

import java.util.Arrays;

/**
 *
 * @author Erin
 */
public class ExamQ {

    public static void main(String[] args) {
        String[] songs = {"2002/American Idiot/Green Day/rock/3:68",
                          "2014/Shake it Off/Taylor Swift/pop/2:14",
                          "1978/Grapevine/Marvin Gaye/pop/2:45",
                          "1984/Guitar Weeps/Beatles/rock/3:15",
                          "2003/Whats Up/Blondies/pop/4:00",
                          "1995/Linger/Cranberies/rock/3:20",
                          "1998/Closing Time/Semisonic/rock/3:00",
                          "1950/Hound Dog/Evlis/pop/2:58"};
        
        songProcessor(songs, "pop");
        songProcessor(songs, "rock");
        }
    
     public static void songProcessor(String[] songs, String genre)
     {
        String[][] songData = new String[8][5];
        for(int i = 0; i < 8; i++)
        {
            songData[i] = songs[i].split("/");
        }
        
        int totalTime = 0;
        String[] time = new String[2];
        String[] temp;
        
        for(int i = 0; i < 8; i++)
        {
                time = songData[i][4].split(":");
                songData[i][4] = String.valueOf(Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]));
                totalTime += Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
        }
     
        for(int i = 0; i < 8; i++)
        {
            for(int j = i + 1; j < 8; j++)
            {
                if(Integer.parseInt(songData[i][0]) > Integer.parseInt(songData[j][0]))
                {
                    temp = songData[i];
                    songData[i] = songData[j];
                    songData[j] = temp;
                }
            }
        }
        
        for(int i = 0; i < 8; i++)
        {
            if(songData[i][3].equals(genre))
            System.out.printf("%s - %s (%s seconds)%n", songData[i][0], songData[i][1], songData[i][4]);
        }
        System.out.printf("The total time of %s songs is %d seconds%n%n", genre, totalTime);
    
    }
}
