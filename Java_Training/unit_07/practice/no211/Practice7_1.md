- クラスの修飾子にprotectedは使えない  
protected class PClass{} → final class PClass{}

- クラス内の変数定義ではvarは使えない  
public var data = 10; → public int data = 10;  

- フィールドにアクセスする際はthi.を使う  
var data = 0; → this.data = 0;  
