package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dto.LoginInfo;
import dto.Note;
import dto.NoteCommand;
import service.MessageService;

@Controller
public class MessageController {

//	CREATE TABLE note (no INT AUTO_INCREMENT PRIMARY KEY, to_id VARCHAR(10) NOT NULL, from_id VARCHAR(10) NOT NULL, content VARCHAR(1000) NOT NULL, cre_date TIMESTAMP default now(), readyn INT(1) DEFAULT 2, del_to int(1) default 2, del_from int(1) default 2);
	// https://docs.google.com/spreadsheets/d/1H9iSFXTgyT8AKyEmpUNx1ON4M43ZmsqqUI8h2F00Trs/edit#gid=1111517957
	
	@Autowired
	private MessageService messageSvc;

	// 아이디 클릭 시 해당 아이디가 받는사람으로 입력 된 쪽지 작성창으로 이동
	@RequestMapping("/message/write&{id}")
	public String form(@PathVariable("id") String id, Model model,HttpSession session) {
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		if (loginInfo == null ) { // 로그인하지 않은 경우 로그인 창으로 이동
			return "redirect:/login";
		}
		model.addAttribute("toId", id);
		return "message/write";
	}

	// 쪽지 작성 시 DB에 입력 후 받은 쪽지함으로 이동
	@RequestMapping(value = "/message/sendResult", method = RequestMethod.POST)
	public String write(NoteCommand noteComn, Model model) {
		messageSvc.writeNote(noteComn);
//		int result = messageSvc.writeNote(noteComn);
//		model.addAttribute("result", result);
		return "redirect:/message/sent";
	}

	// 받은쪽지함 목록
	@RequestMapping("/message/inbox")
	public String inbox(Model model, HttpSession session) {
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		if (loginInfo == null ) { // 로그인하지 않은 경우 로그인 창으로 이동
			return "redirect:/login";
		}
		ArrayList<Note> inboxList = messageSvc.inbox(loginInfo.getId());
		model.addAttribute("inboxList", inboxList);
		return "message/inbox";
	}

	// 받은쪽지함  세부 사항 출력
	@RequestMapping("/message/inbox&{no}")
	public String readNote(@PathVariable("no") int no, Model model, HttpSession session) {
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		if (loginInfo == null ) { // 로그인하지 않은 경우 로그인 창으로 이동
			return "redirect:/login";
		}
		Note noteDetail = messageSvc.noteDetail(no); 
		if(noteDetail.getReadYn() == 2) { // 쪽지 상태가 읽지않음 일 경우 읽음으로 변경
			messageSvc.setReadY(no);
		}
		model.addAttribute("noteDetail", noteDetail);
		model.addAttribute("who", "보낸사람");
		model.addAttribute("time", "받은날짜");
		return "message/readNote";
	}
	
	// 보낸쪽지함 목록
	@RequestMapping("/message/sent")
	public String sent(Model model, HttpSession session) {
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		if (loginInfo == null ) { // 로그인하지 않은 경우 로그인 창으로 이동
			return "redirect:/login";
		}
		ArrayList<Note> sentList = messageSvc.sent(loginInfo.getId());
		model.addAttribute("sentList", sentList);
		return "message/sent";
	}
	
	// 보낸쪽지함 세부 사항 출력
	@RequestMapping("/message/sent&{no}")
	public String readNote2(@PathVariable("no") int no, Model model, HttpSession session) {
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		if (loginInfo == null ) { // 로그인하지 않은 경우 로그인 창으로 이동
			return "redirect:/login";
		}
		Note noteDetail = messageSvc.noteDetail(no); 
		model.addAttribute("noteDetail", noteDetail);
		model.addAttribute("who", "받는사람");
		model.addAttribute("time", "보낸날짜");
		return "message/readNote";
	}
	
	/**
	 * 쪽지 삭제할 때 사용  
	 * @param del_no 삭제할 쪽지의 고유번호 
	 * @return 로그인 되지 않은 경우 로그인 페이지로, 로그인한 사용자일 경우 서비스 수행 후 받은편지함으로 이동
	 */
	@RequestMapping(value="/message/delete&{noteType}")
	public String delete(@PathVariable("noteType") String noteType, @RequestParam("del_no") int[] del_no, HttpSession session) {
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		if (loginInfo == null ) { // 로그인하지 않은 경우 로그인 창으로 이동
			return "redirect:/login";
		}
		for(int no : del_no) {
			messageSvc.deleteNote(noteType, no);
		}
		
		if(noteType.equals("del_from")) {
			return "redirect:/message/sent";
		}
		
		return "redirect:/message/inbox";
	}
	
}
