package Chapter4;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class KazuateForm implements Serializable{
	private static final long serialVersionUID = 1L;

    @NotNull(message = "この項目は必須入力です。")
    @Max(value = 99, message = "{value} 以下の数値を入力してください。")
    @Min(value = 0, message = "{value} 以上の数値を入力してください。")
    private String num;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}