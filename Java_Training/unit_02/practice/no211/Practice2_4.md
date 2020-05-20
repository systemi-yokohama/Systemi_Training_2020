    int m = 10;  
    long i = m;

longはintよりも値範囲が広いので、  
long→intは縮小変換であり、エラーがでる。

→  
(long m = 10;  
int i = * (int) * m;)
