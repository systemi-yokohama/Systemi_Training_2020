/* [1]
	×
	×
	〇
	×
	×
	
   [2]
	①<T>
	②<? super T>
	③T...
	④add
	⑤result

   [3]
	①implements Cloneable
	②@Override
	③Person
	④(Person).super clone()
	⑤this.memos.clone()
	⑥CloneNotSupportedExpection*/

package Java_Training.unit_09.practice.no213;

public class Check9 {
	public class Person{
		private String firstName;
		private String lastName;

		public String toString() {
			return String.format("Person:%s %s", this.firstName, this.lastName);
		}
	}

	public class Weekday {
			var week = Weekday.valueof("Monday");
			System.out.println(week instanceof Weekday);
	}

	public class Trycatch {
		try {

		} catch (IOException | SQLException e) {

		}
	}

	public class Main {
		private static class Sub {

		}
	}

	public class List {
		public static <E> ArrayList<E> newArrayList(T... t) {
			return new ArrayList<E>(t);
		}
	}
}