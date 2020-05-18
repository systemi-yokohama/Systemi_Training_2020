package Java_Training.unit_04.practice.no212;

var sum = 0;
for(var i =100; i <= 200; i++){
	if(i % 2 == 0){
		continue;
	}
	sum += i;
}
System.out.println("合計値は" + sum);