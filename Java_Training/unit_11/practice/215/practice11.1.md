1. マルチスレッドにおいて処理の途中でほかのスレッドによる割込みが発生してしまうと
    演算結果が正しく反映されない可能性がある。そこでsynchronizedブロックにより、
    複数のスレッドが同時に呼び出されることを防ぐ。
2. * scheduleではなくscheduleAtFixedRate
   * satrtではなくsleep
   * stopではなくshutdown