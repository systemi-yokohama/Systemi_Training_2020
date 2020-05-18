変数strがnullの場合、endsWithメソッド呼び出しはNullPointerException例外の原因となるので、
endsWithメソッドだけを呼び出すコードは不可。
if(str.endsWith(".java")){~~~}
→
if(str != null && str.endsWith(".java")){~~~}