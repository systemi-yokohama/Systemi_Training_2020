package Java_Training.practice100.no214;
import java.io.IOException;
import java.util.Date;
//import sun.security.*;
/*private static final No067 instance = new No067();
    private int releaseTicketId = 0;// チケットに付与する通し番
    public static No067 getInstance() {
        return instance;
    }
    // チケットを発行する
    public No067 publishConcertTicket(String userName, Date date) {
        Tiket tiket = new ConcertTiket(userName, date, releaseTicketId);
        // チケットの登録処理（省略）
        // ...
        // ...
        // ...
        this.releaseTicketId += 1;        
        return tiket;
    }
    // チケットを破棄（無効化）する
    public void deleteConcertTicket(int releaseTicketId) {
        // チケットの無効化処理（省略）
        // ...
        // ...
        // ...
    }    
} */
//ticketにするとインポート出てきてしまう

//複合(7)
//以下は、チケット発行処理プログラムの一部である。問題点を指摘し、修正せよ
public class No067{
    private static final No067 instance = new No067();
    private volatile Integer releaseTicketId = 0;// チケットに付与する通し番
    
    private No067() {
    }//instance化防止
    public static No067 getInstance() {
        return instance;
    }
    // チケットを発行する
    public Ticket publishConcertTicket(String userName, Date date) {
        synchronized (releaseTicketId) {
        Ticket ticket = new ConcertTicket(userName, date, releaseTicketId);
        
        // チケットの登録処理（省略）
        // ...
        // ...
        // ...

        try {
            this.releaseTicketId ++;
            if (0>=ticket-this.releaseTicketId) {//チケット上限
               
            }
        } catch (IOException e) {
            System.err.println("エラー原因：チケットIDが上限を超えたため");
            e.printStackTrace();
        }
        return ticket;
    }
       
    }
    // チケットを破棄（無効化）する
    public void deleteConcertTicket(int releaseTicketId) {
        // チケットの無効化処理（省略）
        // ...
        // ...
        // ...
    }    
} 
