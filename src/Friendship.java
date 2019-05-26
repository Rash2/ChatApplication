import java.sql.Date;

public class Friendship {
    private int user1;
    private int user2;
    private java.sql.Date date;

    public Friendship(int user1, int user2, Date date) {
        this.user1 = user1;
        this.user2 = user2;
        this.date = date;
    }

    public int getUser1() {
        return user1;
    }

    public void setUser1(int user1) {
        this.user1 = user1;
    }

    public int getUser2() {
        return user2;
    }

    public void setUser2(int user2) {
        this.user2 = user2;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
