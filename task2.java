

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task2 {

   public static int[] Functionrandom() {
       Random rand = new Random();
       int arr[] = new int[5];
       for (int i = 0; i < arr.length; i++) {
           arr[i] = rand.nextInt(10);
           System.out.print(arr[i] + " ");
       }
       System.out.println("");
       return arr;
   }
   public static int[] Functionsorted(int arr[]) throws IOException {
       Logger loger = Logger.getLogger(task2.class.getName());
       FileHandler handl = new FileHandler("Seminar-2.txt");
       SimpleFormatter format = new SimpleFormatter();
       handl.setFormatter(format);
       loger.addHandler(handl);

       int temp;
       for (int i = arr.length - 1; i >= 0; i--) {
           for (int j = 0; j < arr.length - 1; j++) {
               if (arr[j] < arr[j + 1]) {
                   temp = arr[j];
                   arr[j] = arr[j + 1];
                   arr[j + 1] = temp;
               }
           }
           loger.info(Arrays.toString(arr));
       }
       return arr;
   }
   public static void print(int[] arr) {
       for (int i = 0; i < arr.length; i++) {
           System.out.print(arr[i] + " ");
       }
   }
   public static void main(String[] args) throws IOException {
       print(Functionsorted(Functionrandom()));
   }
}