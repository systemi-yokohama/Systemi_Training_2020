package Java_Training.practice100.no211;
import java.util.ArrayList;

public class No022 {

	public void usage(String... strs){
		var count = 0;
		var list = new ArrayList<String>(4);
		for(var str : strs){
			count += 1;
		}

		if(count == 3){
			list.add(strs[0]);
			list.add(strs[1]);
		}
		else if(count == 5){
			list.add(strs[1]);
			list.add(strs[2]);
			list.add(strs[4]);
		}
		else if(count == 7){
			list.add(strs[0]);
			list.add(strs[3]);
			list.add(strs[5]);
			list.add(strs[6]);
		}
		else{
			list.add("usage");
		}

		for(var str : list){
			System.out.println(str);
		}
	}
}

/**
 * 022の解答です.
 *
 * @author jsfkdt
 *
 public class Answer022 {
    *
     * 022の解答です.
     * 定められた条件の引数を標準出力する.
       * 
     * @param arguments
     *
    public static void main(final String[] args) {
		mainにString配列を渡す(?)final=再代入禁止
        * 引数の個数 
        final int len = args.length;
        
        if (len == 3) {
            listNames(args[0], args[1]);
        } else if (len == 5) {
            listNames(args[1], args[2], args[4]);
        } else if (len == 7) {
            listNames(args[0], args[3], args[5], args[6]);
        } else {
            // USAGEを出力.
            System.err.println("Usage : 引数の数を3個、5個、7個のいずれかにして再実行してください");
            // 終了コードを2として、強制終了.
            System.exit(2);
        }
    }
    
    /**
     * 入力された引数の一部を標準出力する.
     *
     * @param  names 引数の値
     *
    private static void listNames(String... names) {
        for (String name : names) {
            System.out.println(name);
        }
    }
}
*/
