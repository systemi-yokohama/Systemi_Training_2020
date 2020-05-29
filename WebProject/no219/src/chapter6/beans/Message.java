package WebProject.no219.src.chapter6.beans;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {

    private int id;
    private int userId;
    private String text;
    private Date createdDate;
    private Date updatedDate;

    // getter/setterは省略されているので、自分で記述しましょう。
}