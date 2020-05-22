package Java_Training.practice100.no211;

public class No018 {
	public enum Eto{
		NE(1,"子"),
		USI(2,"丑"),
		TRA(3,"寅"),
		U(4,"卯"),
		TATU(5,"辰"),
		MI(6,"巳"),
		UMA(7,"午"),
		HITUJI(8,"未"),
		SARU(9,"申"),
		TORI(10,"酉"),
		INU(11,"戌"),
		I(12,"亥");

		final int id;
		final String jpName;
		//→privateは付けなくてよい、fainlはつける

		private Eto(int id, String jpName){
			this.id = id;
			this.jpName = jpName;
		}

		public int toEtoValue(){
			return this.id;
		}

		public String toString(){
			return this.jpName;
		}


		//→
		/**
         * 固有のIDに紐付く十二支のインスタンスを取得する.
         *
         * @param  id  固有のID
         * @return 該当のIDに紐付く十二支のインスタンス. 該当しない場合はnull.
         */
        public static Eto getInstanceFromId(final int id) {
            for (final Eto instance : Eto.values()) {
                if (instance.id == id) {
                    return instance;
                }
            }
            return null;
        }
        
        /**
         * 十二支の名前に紐付くインスタンスを取得する.
         *
         * @param  name  十二支の名前
         * @return 該当の名前に紐付く十二支のインスタンス. 該当しない場合はnull.
         */
        public static Eto getInstanceFromName(final String name) {
            for (final Eto instance : Eto.values()) {
                if (instance.jpName == name) {
                    return instance;
                }
            }
            return null;
		}
		//関連付けてコンストラクタの値から値を引き出せるようにする。
	}

	public static void main(String[] args) {
		System.out.println(Eto.NE);
		System.out.println(Eto.NE.toEtoValue());
		System.out.println(Eto.NE.toString());
	}
}