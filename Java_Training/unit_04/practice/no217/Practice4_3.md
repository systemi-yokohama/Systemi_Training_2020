### 第四章 制御構文 理解度チェック       
1. コードの空欄を埋める       
    1. for      
    2. args     
    3. value        
    4. i
2. while文に書き換える                  
    ```
    int i = 1;
    int sum = 0;
    while(i <= 100){
        sum += i;
        if(sum > 1000){
            break;
        }
        i++;
    }     
    System.out.println("合計が1000を超えるのは、1~" + i + "を加算したときです");
    ```
3. forとcontinueを使って奇数の合計を求める      
    ```
    var = 0
    for(var i = 100; i <= 200; i++) {
        if(i %2 == 0) {
            continue;
        }
        sum += i;
    }
    System.out.println(sum);
    ```
4. switch文(Practice4_3_1.java)       
    ```
    var language = "---";
    switch(language) {
        case "Scala":
        case "Kotlin":
        case "Groovy":
            System.out.println("JVM言語");
            break;
        case "C#":
        case "Visuale Basic":
        case "F#":
            System.out.println(".NET言語");
            break;
        default:
            System.out.println("不明");
    }
5. if文(Practice4_3_2.java)     
    ```     
    var language = "";
    if(language == "Scala" || language == "Kotlin" || language == "Groovy"){
       System.out.println("JVM言語"); 
    } else if (language == "C#" || language == "Visuale Basic" || language == "F#"){
        System.out.println(".NET言語");
    } else {
        System.out.println("不明");
    }
    ``` 