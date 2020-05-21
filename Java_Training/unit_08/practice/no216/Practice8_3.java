package Java_Training.unit_08.practice.no216;

public class Practice8_3 {
	//アクセサーメソッドのためpublicじゃない
	private String name;
	private int age;

	//戻り値を持たないためvoid削除
	public Practice8_3() {
		//○コンストラクターのオーバーロードを呼び出す
		this("名無権兵衛", 0);
	}

	public Practice8_3(String name, int age) {
		//○ローカル変数とフィールド名が一致するためthis
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	//○セッターの戻り値型はvoid
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		if (age < 0) {
			age = 0;
		}
		this.age = age;
	}

	public String intro() {
		//%s, %d
		return String.format("私の名前は%s。%d歳です。", getName(), getAge());
	}
}