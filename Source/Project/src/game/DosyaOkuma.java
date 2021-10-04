/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author WE
 */
public class DosyaOkuma {

    static int  harita_kaynak[][] = new int[11][13];

    public static void Okuma() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader("src/game/harita.txt")));

 
        int satir = 0;

        while (sc.hasNextLine()) {
            String satir_str = sc.nextLine();
            if (satir_str.startsWith("Karakter")) {
                String[] dizi1 = satir_str.split(",");
                System.out.println(dizi1[0].split(":")[1]);
                 System.out.println(dizi1[1].split(":")[1]);
                 Main.dosya_dusman.put(dizi1[1].split(":")[1],dizi1[0].split(":")[1]);
            }
            else{
            
                           int sira = 0;
                Scanner scanner = new Scanner(satir_str);
                while (scanner.hasNextInt()) {

                    harita_kaynak[satir][sira] = scanner.nextInt();
                    sira++;
                }

                satir++;
            
            }
       

            


    }
    }
    public void yazdirma(int gelenkaynak[][]) {

        for (int i = 0; i < 11; i++) {

            for (int j = 0; j < 13; j++) {

                System.out.print(harita_kaynak[i][j] + " ");

            }
            System.out.println(" ");
        }
    }

    public static int[][] getHarita_kaynak() {
        return harita_kaynak;
    }

    public static void setHarita_kaynak(int[][] harita_kaynak) {
        DosyaOkuma.harita_kaynak = harita_kaynak;
    }

   
}
