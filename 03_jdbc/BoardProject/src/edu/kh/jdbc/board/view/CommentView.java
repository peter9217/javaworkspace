package edu.kh.jdbc.board.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.board.model.dto.Comment;
import edu.kh.jdbc.board.model.service.CommentService;
import edu.kh.jdbc.common.Session;

public class CommentView {
	private Scanner sc = new Scanner(System.in);
	   
	   private CommentService service = new CommentService();
	   
	   /** 댓글 메뉴
	    * @param boardNo(상세 조회 중인 게시글 번호)
	    */
	   public void commentMenu(int boardNo) {
	      
	      int input = -1;
	      
	         try {
	            System.out.println("\n=== 댓글 기능 ===\n");
	            System.out.println("1) 댓글 등록");
	            System.out.println("2) 댓글 수정");
	            System.out.println("3) 댓글 삭제");
	            
	            System.out.println("0. 댓글 기능 종료");
	            
	            System.out.print("\n선택 : ");
	            input = sc.nextInt();
	            sc.nextLine(); 
	            
	            
	            switch(input) {
	            case 1: insertComment(boardNo); break; 
	            // 댓글 등록
	            // !wq가 입력 될 때까지 댓글 내용을 입력 받고
	            // 내용, 게시글 번호, 로그인 회원 번호를 이용해 
	            // 댓글 삽입 서비스 호출
	            
	            case 2: updateComment(boardNo); break; // 댓글 수정
	            // 댓글 번호를 입력 받아서 
	            // 1) 해당 댓글이 현재 게시글의 댓글이며 로그인한 회원이 쓴 댓글이 맞는지 확인
	            // 2-1) 1번 결과가 맞지 않으면 "작성한 댓글만 수정할 수 있습니다" 출력
	            // 2-2) !wq가 입력될 때 까지 내용 입력 후 댓글번호, 내용을 이용해 댓글을 수정하는 서비스 호출
	            	            	            
	            case 3: deleteComment(boardNo); break; // 댓글 삭제
	            // 1) 해당 댓글이 현재 게시글의 댓글이며 로그인한 회원이 쓴 댓글이 맞는지 확인
	            // 2-1) 1번 결과가 맞지 않으면 "작성한 댓글만 삭제할 수 있습니다" 출력
	            // 2-2) "정말로 삭제 하시겠습니까?(Y/N) : " 출력 후 Y 입력 시 : 삭제 서비스 호출(댓글 번호)
	            // N 입력 시 : "취소되었습니다"
	            
	            
	            case 0: return;
	            default: System.out.println("\n*** 메뉴 번호만 입력 해주세요 ***\n");  
	            }
	            
	            
	         }catch (InputMismatchException e) {
	            System.out.println("\n*** 입력 형식이 올바르지 않습니다***\n");
	            sc.nextLine(); 
	            input = -1; // while문 종료 방지
	         }
	         
	   }



	private void insertComment(int boardNo) {
		System.out.println("댓글 내용 : ");
		StringBuffer sb = new StringBuffer();
		System.out.println("<!wq 입력 시 종료>");
		while(true) {
			String str = sc.nextLine();
			if(str.equals("!wq"))	break;
			sb.append(str);
			sb.append("\n"); // 줄바꿈 추가
		}
		
		try {
			int i = CommentService.insertComment(boardNo, sb.toString(), Session.loginMember.getMemberNo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			
		
	}
	
	private void updateComment(int boardNo) {
		System.out.println("댓글 번호 : ");
		int input = sc.nextInt();
		try {
			List<Comment> board = CommentService.board(boardNo);
			int ch=0;
			for(Comment c : board) {
				if(input==c.getCommentNo()) {
					ch++;
				}
			}
			if(ch == 0) {
				System.out.println("해당 글에 있는 댓글이 아닙니다.");
				return;
			}
			
			int check = CommentService.checkComment(input);
			if(check != Session.loginMember.getMemberNo()) {
				System.out.println("작성한 댓글만 수정할 수 있습니다.");
			}else {
				System.out.println("수정할 댓글 내용 : ");
				StringBuffer sb = new StringBuffer();
				System.out.println("<!wq 입력 시 종료>");
				while(true) {
					String str = sc.nextLine();
					if(str.equals("!wq"))	break;
					sb.append(str);
					sb.append("\n"); // 줄바꿈 추가
				}
				int i = CommentService.reComment(sb.toString(), input);
				if(i>0) System.out.println("변경되었습니다");
				else System.out.println("변경 중 취소되었습니다.");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 1) 해당 댓글이 현재 게시글의 댓글이며 로그인한 회원이 쓴 댓글이 맞는지 확인
        // 2-1) 1번 결과가 맞지 않으면 "작성한 댓글만 수정할 수 있습니다" 출력
        // 2-2) !wq가 입력될 때 까지 내용 입력 후 댓글번호, 내용을 이용해 댓글을 수정하는 서비스 호출
		
		
		//if(Session.loginMember.getMemberNo())
		
	}
	
	private void deleteComment(int boardNo) {
		System.out.println("댓글 번호 : ");
		int input = sc.nextInt();
		try {
			int check = CommentService.checkComment(input);
			if(check != Session.loginMember.getMemberNo()) {
				System.out.println("작성한 댓글만 삭제할 수 있습니다.");
			}else {
				while(true) {
					System.out.println("정말 삭제?");
					char real = sc.next().toUpperCase().charAt(0);
					if(real=='N') {
						System.out.println("삭제 취소");
						return;
					}
					if(real !='Y') {
						System.out.println("잘못 입력");
						continue;
					}
					break;
				}
				try {
					int result = CommentService.deleteComment(input);
					if(result>0) System.out.println("삭제 되었");
					else System.out.println("삭제 실패");
					
				}catch(Exception e) {
					System.out.println("댓글 삭제 중 예외 발생");
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 // 1) 해당 댓글이 현재 게시글의 댓글이며 로그인한 회원이 쓴 댓글이 맞는지 확인
    // 2-1) 1번 결과가 맞지 않으면 "작성한 댓글만 삭제할 수 있습니다" 출력
    // 2-2) "정말로 삭제 하시겠습니까?(Y/N) : " 출력 후 Y 입력 시 : 삭제 서비스 호출(댓글 번호)
    // N 입력 시 : "취소되었습니다"
}
