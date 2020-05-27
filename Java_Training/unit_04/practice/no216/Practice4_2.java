package Java_Training.unit_04.practice.no216;

public class Practice4_2 {
    public static void main (String[] args) {
        int i = 1;
        int sum = 0;

        while (i <= 100) {
          sum += i;
          
          if (sum > 1000) {
            break;
          }
          i++;
        }
    }
}