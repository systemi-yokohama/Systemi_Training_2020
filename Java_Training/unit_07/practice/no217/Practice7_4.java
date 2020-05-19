package Java_Training.unit_07.practice.no217;

public class Practice7_4 {
        public static double getAverage(double... values) {
          var result = 0.0;
          for (var value : values) {
            result += value;
          }
          return result / values.length;
        }
        public static void main(String[] args) {
          System.out.println(Practice7_4.getAverage(1, 2, 3, 4));
        }
      }