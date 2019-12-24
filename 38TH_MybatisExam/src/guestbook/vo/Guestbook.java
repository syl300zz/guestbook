package guestbook.vo;

public class Guestbook {
    
    int sn;
    String author;
    String content;
    String indate;
    public Guestbook() {
        super();
    }
    public Guestbook(int sn, String author, String content, String indate) {
        super();
        this.sn = sn;
        this.author = author;
        this.content = content;
        this.indate = indate;
    }
    public int getSn() {
        return sn;
    }
    public void setSn(int sn) {
        this.sn = sn;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getIndate() {
        return indate;
    }
    public void setIndate(String indate) {
        this.indate = indate;
    }
}


