package guestbook.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import guestbook.vo.Guestbook;

public class GuestbookDAO {
	
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	public int insertbook(Guestbook guestbook) {
	    int cnt = 0;
	    SqlSession session = null;
	    
	    try {
	        session = factory.openSession();
	        GuestbookMapper mapper = session.getMapper(GuestbookMapper.class);
	        cnt = mapper.insertbook(guestbook);
	        session.commit();
	    } catch(Exception e) {
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return cnt;
	}
	
	public ArrayList<Guestbook> listbook() {
	        SqlSession session = null;
	        ArrayList<Guestbook> list = null; 
        try {
            session = factory.openSession();
            GuestbookMapper mapper = session.getMapper(GuestbookMapper.class);
            list = mapper.listbook();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
	}
	
	public int deletebook(int sn) {
	    SqlSession session = null;
        int cnt = 0;
        try {
            session = factory.openSession();
            GuestbookMapper mapper = session.getMapper(GuestbookMapper.class);
            cnt = mapper.deletebook(sn);
            session.commit();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return cnt;
	}
	
	public int updatebook(Guestbook guestbook) {
	    SqlSession session = null;
	    Guestbook book = new Guestbook();
	    int cnt = 0;
	    
        try {
            session = factory.openSession();
            GuestbookMapper mapper = session.getMapper(GuestbookMapper.class);
            cnt = mapper.updatebook(guestbook);
            session.commit();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return cnt;
	}
	
	public ArrayList<Guestbook> searchbook(int col, String word) {
	    SqlSession session = null;
	    HashMap<String, Object> map = null;
	    ArrayList<Guestbook> list = null;
        
        try {
            session = factory.openSession();
            GuestbookMapper mapper = session.getMapper(GuestbookMapper.class);
            map = new HashMap<>();
            map.put("abc", col);
            map.put("def", word);
            list = mapper.searchbook(map);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
	    return list;
	}
}

