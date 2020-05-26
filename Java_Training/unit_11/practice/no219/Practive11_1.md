1.  synchroizedブロックで囲まれた処理は、複数のスレッドから同時に呼び出されることがなくなります。ほぼ同時に呼び出された場合にも、先に呼び出されたほうの処理を優先し、あとから呼び出された側は先行する処理が終わるまで待ちの状態になります。同時実行によるデータの不整合を防ぐ
2.  var sche = Executors.newScheduoleThreadPool(2);
    sche.scheduleAtFixedRate(()->{
        System.out.println(LocalDateTime.now());
    }, 0.5, TimeUnit.SECOUNDS);
    try{
        Thread.sleep(10000);

    } catch (InterruptedException e){
        e.printStackTrace();
    }
    sche.shutdown();