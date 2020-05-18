変数strがnullであり、endWithメソッドの呼び出しではnullが例外だから。  

String str = null;  
if(str !=null && str.endWith(".java")){  
    System.out.println("拡張子は.javaです。");  
    }