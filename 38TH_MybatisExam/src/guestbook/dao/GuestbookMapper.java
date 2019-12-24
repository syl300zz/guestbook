package guestbook.dao;

import java.util.ArrayList;
import java.util.HashMap;

import guestbook.vo.Guestbook;


public interface GuestbookMapper {
    
    public int insertbook(Guestbook guestbook);
    public ArrayList<Guestbook> listbook();
    public int deletebook(int sn);
    public int updatebook(Guestbook guestbook);
    public ArrayList<Guestbook> searchbook(HashMap<String, Object> map);
}
