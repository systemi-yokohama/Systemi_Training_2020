1. public class MyRunner imprements Thread {...}  
→ public class MyRunner imprements Runnable {...}  

2. synchronized void increment() {...}  
→ 正しい  

3. var sche = Executor.newSingleThreadScheduledExecutor(3);  
→ var sche = Executor.newScheduledThreadPool(3);  

4. @Override  
public String toString() {...}  
→ 正しい  

5. opens module mylib {...}  
→ open module mylib {...}  