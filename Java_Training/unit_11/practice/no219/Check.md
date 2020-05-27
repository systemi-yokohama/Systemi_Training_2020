1.  X   X   X   X   X
2.  newSingleThreadExecutor
    ()->
    Random
    sleep
    get
3.  public class MyRunner implements Runnable{...}
    〇
    var sche =Executors.newScheduledThreadPool(2);
    〇
    open module mylib{...}
4.  CompletableFuture
    thenApplyAsync
    (data)->
    thenAcceptAsync