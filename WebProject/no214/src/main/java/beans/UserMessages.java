package beans ;
import java.io.Serializable;
 import java.util.Date;

 public class UserMessages implements Serializable {
 	private static final long serialVersionUID=1L;
     private int id;
     private String account;
     private String name;
     private int userId;
     private String text;
 	private Date created_date;
	public int getId(){
 		return id;
 	}
 	public void setId(int id){
 		this.id=id;
 	}
 	public String getAccount(){
 		return account;
	}
 	public void setAccount(String account){
 		this.account=account;
 	}
 	public String getName(){
		return name;
 	}
 	public void setName(String name){
 		this.name=name;
 	}
 	public int getUserId(){
 		return userId;
 	}
	public void setUserId(int userId){
 		this.userId=userId;
 	}
 	public String getText(){
 		return text;
 	}
 	public void setText(String text){
 		this.text=text;
 	}
 	public Date getCreated_date(){
 		return created_date;
 	}
 	public void setCreated_date(Date created_date){
 		this.created_date=created_date;
 	}
 }