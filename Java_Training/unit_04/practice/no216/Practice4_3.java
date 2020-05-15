package Java_Training.unit_04.practice.no216;

public class Practice4_3 {
    public static void main(String[] args) {
        var oddSum = 0;

        for (var i = 100; i <= 200; i++) {

            if(i % 2 != 0) {
                
                oddSum += i;
            }
            continue;
        }
        System.out.println(oddSum);
    }
}