package Java_Training.practice100.no216.No44;

public class Date implements Comparable<Date> {
		int date;
	
		public int compareTo(Date obj) {
			if (this.date < obj.date) {
				return -1;
			}
			if (this.date > obj.date) {
				return 1;
			}
			return 0;
		}
}
