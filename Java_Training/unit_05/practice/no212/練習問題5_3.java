[1]
import java.time.LocalDateTime;

var dt = LocalDateTime.now();
System.out.println(dt.getMonthValue() + "月");
System.out.println(dt.getMinute() + "分");

[2]
import java.time.LocalDate;
import java.time.Period;

var dt = LocalDateTime.now();
var period = Period.ofDays(20);
System.out.println("20日後は" + dt.plus(period));