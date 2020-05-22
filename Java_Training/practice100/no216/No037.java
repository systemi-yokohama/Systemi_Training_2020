package Java_Training.practice100.no216;
import java.util.*;

public class No037 implements Cloneable{

	private List<Date> dateList = new ArrayList<Date>();
	
	@Deprecated
	public static void main(String[] args) {
		
		Date today = new Date();

		No037 dateInstance = new No037();

		dateInstance.dateList.add(today);

		No037 deepCopyDateInstance = dateInstance.clone();

		List<Date> shallowDateList = shallowCopy(dateInstance.dateList);

		dateInstance.dateList.get(0).setDate(1);


		if ( deepCopyDateInstance == null) {
			System.out.println(deepCopyDateInstance);
		} else {
			System.out.println(deepCopyDateInstance.dateList.get(0).getDate());
		}

		
		if (shallowDateList == null) {
			System.out.println(shallowDateList);
		} else {
			System.out.println(shallowDateList.get(0).getDate());
		}

	}

	public No037 clone() {
		try {
			No037 result = (No037)super.clone();

			List<Date> copiedDateList = new ArrayList<Date>();

			if (result.dateList == null) {
                return result;
			}

			for (Date dateInstance : result.dateList) {
                if (dateInstance == null) {
                    copiedDateList.add(null);
                } else {
                    copiedDateList.add(new Date(dateInstance.getTime()));
                }
			}
			
			result.dateList = copiedDateList;

			return result;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
	}
	

	public static List<Date> shallowCopy(List<Date> shallowList) {
        // nullの場合は、nullを返却.
        if (shallowList == null) {
            return null;
        }
        return new ArrayList<Date> (shallowList);
    }
}