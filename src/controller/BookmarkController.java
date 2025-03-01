package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.Bookmark;
import dto.LoginInfo;
import service.BookmarkService;

@Controller
@RequestMapping("/bookmark")
public class BookmarkController {

	@Autowired
	private BookmarkService bookmarkSvc;

	/**
	 * 북마크 설정/해제
	 * @param board_no 게시물 번호
	 * @param board_id 게시판 번호 ( 1= 기부 , 2 = 교환) 
	 * @return type String, 0 = 비로그인 유저 / 1 = 로그인유저+북마크한경우 해제 / 2 = 로그인유저+북마크안한경우 설정
	 */
	@ResponseBody
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public String bookmark(HttpSession session, @RequestParam("no") int board_no,
			@RequestParam("board_id") int board_id) {
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		String result = "0";
		// 로그인이 되어 있으 경우
		if (loginInfo != null) {
			String id = loginInfo.getId();
			// 북마크 정보가 있을 경우 해제 
			Bookmark bookmark = bookmarkSvc.checkbookmark(id, board_no, board_id);
			if (bookmark.getId() != null) {
				bookmarkSvc.removeBookmark(id, board_no, board_id);
				return result = "1";
			// 북마크 정보가 없을 경우 설정 
			} else {
				bookmarkSvc.addBookmark(id, board_no, board_id);
				return result = "2";
			}
		// 로그인이 되어 있지 않은 경우
		} else {
			return result;
		}
	}
}
