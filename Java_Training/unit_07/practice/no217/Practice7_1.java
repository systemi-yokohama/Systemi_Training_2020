package Java_Training.unit_07.practice.no217;

public class Practice7_1 {
        public int data = 10;

        public void hoge(int data) {
                if (data < 0) {
                data = 0;
                }
                System.out.println(data);
        }
        public static void main(String[] args) {
                var p = new Practice7_1();
                p.hoge(10);
                p.hoge(-10);
        }
}