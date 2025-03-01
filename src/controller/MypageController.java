package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dto.Applicant_d;
import dto.Applicant_e;
import dto.Donation;
import dto.Exchange;
import dto.LoginInfo;
import service.BookmarkService;
import service.MypageService;

@Controller
public class MypageController {

	@Autowired
	private MypageService mypageSvc;

	// 내가 쓴 글(기부) 보여주는 컨트롤러
	@RequestMapping("mypage/mywrite_donation")
	public String form1(Model model, HttpSession session) {
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		ArrayList<Donation> mywriteDonationList = mypageSvc.mywriteDonationList(loginInfo.getId());
		model.addAttribute("mywriteDonationList", mywriteDonationList);
		return "mypage/mywrite_donation";
	}

	// 내가 쓴 글(교환) 보여주는 컨트롤러
	@RequestMapping("mypage/mywrite_exchange")
	public String form2(Model model, HttpSession session) {
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		ArrayList<Exchange> mywriteExchangeList = mypageSvc.mywriteExchangeList(loginInfo.getId());
		model.addAttribute("mywriteExchangeList", mywriteExchangeList);
		return "mypage/mywrite_exchange";
	}

	// 기부 글 스크랩 보여주는 컨트롤러
	@RequestMapping("mypage/bm_donation")
	public String form3(Model model, HttpSession session) {
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		ArrayList<Donation> bmDonationList = mypageSvc.bmDonationList(loginInfo.getId());
		model.addAttribute("bmDonationList", bmDonationList);
		return "mypage/bm_donation";
	}

	// 교환 글 스크랩 보여주는 컨트롤러
	@RequestMapping("mypage/bm_exchange")
	public String form4(Model model, HttpSession session) {
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		ArrayList<Exchange> bmExchangeList = mypageSvc.bmExchangeList(loginInfo.getId());
		model.addAttribute("bmExchangeList", bmExchangeList);
		return "mypage/bm_exchange";
	}

	// 신청한글(기부) 보여주는 컨트롤러
	@RequestMapping("mypage/myapply_donation")
	public String form5(Model model, HttpSession session) {
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		ArrayList<Applicant_d> myApplyDonationList = mypageSvc.myApplyDonationList(loginInfo.getId());
		model.addAttribute("myApplyDonationList", myApplyDonationList);
		return "mypage/myapply_donation";
	}

	// 신청한글(교환) 보여주는 컨트롤러
	@RequestMapping("mypage/myapply_exchange")
	public String form6(Model model, HttpSession session) {
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		ArrayList<Applicant_e> myApplyExchangeList = mypageSvc.myApplyExchangeList(loginInfo.getId());
		model.addAttribute("myApplyExchangeList", myApplyExchangeList);
		return "mypage/myapply_exchange";
	}
}
