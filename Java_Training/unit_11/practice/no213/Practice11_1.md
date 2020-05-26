[1]<br>
synchronizedブロックは複数のスレッドがある中で割り込みが起きないようにする役割を持つ<br>
先に呼び出された処理を優先して他のスレッドは先に呼び出された処理が終わるまで待ち状態になる<br>
優先される処理を占有することをロックといって、ロックが働くため矛盾が生じないようになる<br>

[2]<br>
var sche = Executors.newScheduledThreadPool(2);<br>
sche.scheduleAtFixedRate(() -> {<br>
    System.out.println(LocalDateTime.now());<br>
}, 0, 5, TimeUnit.SECONDS);<br>
try{<br>
    Thread.sleep(10000);<br>
} catch (InterruptedException e) {<br>
    e.printStrackTrace();<br>
}<br>
sche.shutdown();<br>