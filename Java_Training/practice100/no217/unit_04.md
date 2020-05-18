### 054：コアAPI：java.util.stream      
Practice_054.java
```
import java.util.stream.IntStream;
public class Main {
    public static void main(final String[] args) {
        System.out.println(IntStream.rangeClosed(1, 100).filter(x -> x % 2 == 0).sum());
    }
}
```