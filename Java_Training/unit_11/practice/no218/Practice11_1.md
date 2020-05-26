1. synchronizedブロックの役割について説明してください
  複数のスレッドから同時に呼び出させることがなくなる。

2. 5秒おきに現在時刻を出力するコードですが、誤りがいくつあります。誤りを正して、正しいコードにしてください。
  ```
  var sche = Executors.newScheduledThreadPool(2);
  sche.schedule() -> {
    System.out.println(LocalDateTime.now());
  }, 0, 5, TimeUnit.SECONDS);

  try{
      Thread.start(10000);
  } catch(InterruptedException e){
      e.printStackTrace();
  }
  sche.stop();
  ```
  ↓
  ```
  var sche = Executors.newScheduledThreadPool(2);
  sche.schedule() -> {
    System.out.println(LocalDateTime.now());
  }, 0, 5, TimeUnit.SECONDS);

  try{
      Thread.sleep(10000); →sleepで休止
  } catch(InterruptedException e){
      e.printStackTrace();
  }
  sche.shutdown(); →シャットダウン
  ```