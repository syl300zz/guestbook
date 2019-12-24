package guestbook.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import guestbook.dao.GuestbookDAO;
import guestbook.vo.Guestbook;

public class GuestbookUI {
    
    Scanner sc = new Scanner(System.in);
    GuestbookDAO dao = new GuestbookDAO();
    
    public GuestbookUI() {
        
        while(true) {
            int num = 0;
            printMenu();
        
        try {
            num = Integer.parseInt(sc.nextLine());
        } catch(NumberFormatException e) {
            System.out.println("잘못 된 입력");
            continue;
        }
        
        switch (num) {
        case 1:
            insert();
            break;
        case 2:
            list();
            break;
        case 3:
            delete();
            break;
        case 4:
            update();
            break;
        case 5:
            search();
            break;
        case 0:
            System.out.println("프로그램 종료");
            return; //0번 return;
        default:
            System.out.println("잘못된 입력");
            break;
        }
        }
    }
    
    public void printMenu() {
        System.out.println();
        System.out.println("[메인 메뉴]");
        System.out.println("1. 방명록 등록");
        System.out.println("2. 방명록 조회");
        System.out.println("3. 방명록 삭제");
        System.out.println("4. 방명록 수정");
        System.out.println("5. 방명록 검색");
        System.out.println("0. 프로그램 종료");
        System.out.println("번호 입력");
    }
    
    public void insert() {
        String author = null;
        String content = null;
        
        System.out.println();
        System.out.println("글쓴이 입력");
        author = sc.nextLine();
        System.out.println("내용 입력");
        content = sc.nextLine();
        
        Guestbook book = new Guestbook();
        book.setAuthor(author);
        book.setContent(content);
        
        int num = 0;
        num = dao.insertbook(book);
        
        if(num == 1) System.out.println("등록 되었습니다.");
        else System.out.println("등록 실패");
    }
    
    public void list() {
        ArrayList<Guestbook> list = null;
        System.out.println();
        System.out.println("전체 방명록 조회");
        
        list = dao.listbook();
        
        for(Guestbook g : list) {
            System.out.println("글쓴이 "+g.getAuthor());
            System.out.println("내용 "+g.getContent());
        }
    }
    
    public void delete() {
        int num = 0;
        
        try {
            System.out.println();
            System.out.println("삭제할 방명록 번호 입력");
            num = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            e.printStackTrace();
            //return;
        }
        int sn = dao.deletebook(num);
        
        if(sn == 1) System.out.println("삭제 성공");
        else System.out.println("삭제 실패");
    }
    
    public void update() {
        int num = 0;
        String author = null;
        String content = null;
        
        try {
        System.out.println();
        System.out.println("수정 할 방명록 번호를 입력하세요");
        // 수정은 <방명록 번호>를 입력!
        num = Integer.parseInt(sc.nextLine());
        System.out.println("글쓴이 수정");
        author = sc.nextLine();
        System.out.println("내용 수정");
        content = sc.nextLine();
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        Guestbook book = new Guestbook();
        // 수정할 방명록 번호 Sn도 set에 같이 넣어줌!
        book.setSn(num);
        book.setAuthor(author);
        book.setContent(content);
        int result = dao.updatebook(book);
        
        if(result == 1) System.out.println("수정 완료");
        else System.out.println("수정 실패");
    }
    
    public void search() {
        
        int col = 0;
        String word = null;
        ArrayList<Guestbook> list = null;
        
        try {
        System.out.println();
        System.out.println("검색 할 요소를 선택하시오  1. 글쓴이 2. 내용 ");
        col = Integer.parseInt(sc.nextLine());
        System.out.println("검색 내용을 입력하시오");
        word = sc.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // UI에서는 map이 필요없다! 
        // col값과 word만 넘겨준다!
        list = dao.searchbook(col, word.toUpperCase());
        
        if(list == null || list.size() == 0)
            System.out.println("검색 결과 없음");
        else 
            for(Guestbook g : list) {
                System.out.println(g.getAuthor());
                System.out.println(g.getContent());
            }
    }
}
