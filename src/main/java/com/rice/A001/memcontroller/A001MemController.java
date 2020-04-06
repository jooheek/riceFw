package com.rice.A001.memcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rice.A001.memdao.A001MemDAO;
import com.rice.A001.memservice.A001MemService;
import com.rice.A001.memvo.A001MemVO;

@Controller
@RequestMapping("/member/*")
public class A001MemController { 
	private static final Logger logger = LoggerFactory.getLogger(A001MemController.class);
	
	@Autowired
	private A001MemService a001MemService;
	@Autowired
	private A001MemDAO a001MemDAO;
	
	// GET 로그인, 로그인 페이지 이동
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin(Model model, HttpServletRequest request, HttpServletResponse response) {
		logger.info("get login");
		return "Alogin";
	}
	
	// POST 로그인, 로그인 check 
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postLogin(A001MemVO vo, Model model,HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("post login");
		HttpSession session = request.getSession();
		
		A001MemVO login = null;
		login = a001MemService.login(vo);
		
		if(login == null) {	// 로그인 실패
			logger.info("login fail");
			session.setAttribute("member", null);
			model.addAttribute("loginMsg", "false");
			return "redirect:/member/login";		// 로그인 실패 메시지, 로그인 실패 메시지. 보여주기
		} else {		// 로그인 성공
			logger.info("login ok");
			session.setAttribute("member", login);
		}
		
		return "redirect:/";
	}
	
	// GET Account 회원가입 선택
	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public String account(Model model, HttpServletRequest request, HttpServletResponse response) {
		logger.info("get account");
		return "Aaccount";
	}
	
	// 회원가입 GET, 회원가입 페이지 이동
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String getSignup(Model model, HttpServletRequest request, HttpServletResponse response) {
		logger.info("get signup");
		return "Asignup";
	}
	
	// 회원가입 POST, 회원가입 시도
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String postSignup(A001MemVO vo,Model model, HttpServletRequest request, HttpServletResponse response) {
		logger.info("post signup");
		try {
			a001MemService.signup(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("signupMsg", "false");	// 회원가입 실패 메시지, "회원가입 실패했습니다"
			return "redirect:/member/signup"; 
		}
		
		return "redirect:/member/login";
	}
	
	// POST memId 중복체크, ajax
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	@ResponseBody
	public String idCheck(@RequestBody String memId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("post idCheck");
		String idCheck = "1";
		idCheck = Integer.toString(a001MemService.idCheck(memId));

		return idCheck;
	}

	// GET NAVER callback page 넘기기
	@RequestMapping(value = "/naverlogin", method = RequestMethod.GET)
	public String getNaver(Model model, HttpServletRequest request, HttpServletResponse response) {
		return "AnaverCallback";
	}
	
	// POST NAVER 로그인
	@RequestMapping(value = "/naverlogin", method = RequestMethod.POST)
	@ResponseBody
	public String postNaver(@RequestBody A001MemVO vo,Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("post naverlogin");
		
		HttpSession session = request.getSession();
		A001MemVO login = null;
		
		String snsId = vo.getSnsId();
		if(a001MemService.snsIdCheck(snsId) == 0) {	// 가입된적 없는 SNS ID 일 경우
			try {
				a001MemService.snsSignup(vo);	//	SNS 회원가입 
				login = a001MemService.snsLogin(vo);	// SNS 로그인 				
				if(login == null) {	// 로그인 실패
					logger.info("login fail");
					session.setAttribute("member", null);
					model.addAttribute("loginMsg", "false");
					return "false";		// 로그인 실패 메시지, 로그인 실패 메시지. 보여주기
				} else {		// 로그인 성공
					logger.info("login ok");
					session.setAttribute("member", login);
				}
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("signupMsg", "false");	// 회원가입 실패 메시지, 회원가입 실패했습니다. 보여주기
				return "false"; 
			}
		} else {	// 이미 가입된 SNS ID 일 경우
			login = a001MemService.snsLogin(vo);
			
			if(login == null) {	// 로그인 실패
				logger.info("login fail");
				session.setAttribute("member", null);
				model.addAttribute("loginMsg", "false");
				return "false";		// 로그인 실패 메시지, 로그인 실패 메시지. 보여주기
			} else {		// 로그인 성공
				logger.info("login ok");
				session.setAttribute("member", login);
			}
		}
		
		return "true";
	}
	
	// POST KAKAO 로그인
	@RequestMapping(value = "/kakaologin", method = RequestMethod.POST)
	@ResponseBody
	public String postKakao(@RequestBody A001MemVO vo, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("post kakaologin");		
		HttpSession session = request.getSession();
		A001MemVO login = null;
		
		String snsId = vo.getSnsId();
		if(a001MemService.snsIdCheck(snsId) == 0) {	// 가입된적 없는 SNS ID 일 경우
			try {
				a001MemService.snsKakaoSignup(vo);	//	SNS 회원가입 
				login = a001MemService.snsLogin(vo);	// SNS 로그인 				
				if(login == null) {	// 로그인 실패
					logger.info("login fail");
					session.setAttribute("member", null);
					model.addAttribute("loginMsg", "false");
					return "false";		// 로그인 실패 메시지, 로그인 실패 메시지. 보여주기
				} else {		// 로그인 성공
					logger.info("login ok");
					session.setAttribute("member", login);
				}
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("signupMsg", "false");	// 회원가입 실패 메시지, 회원가입 실패했습니다. 보여주기
				return "false";
			}
		} else {	// 이미 가입된 SNS ID 일 경우
			login = a001MemService.snsLogin(vo);
			
			if(login == null) {	// 로그인 실패
				logger.info("login fail");
				session.setAttribute("member", null);
				model.addAttribute("loginMsg", "false");
				return "false";		// 로그인 실패 메시지, 로그인 실패 메시지. 보여주기
			} else {		// 로그인 성공
				logger.info("login ok");
				session.setAttribute("member", login);
			}
		}
		
		return "true";
	}
	
	
	// GET modify/info, 회원정보수정 페이지 이동
	@RequestMapping(value = "/modify/info", method = RequestMethod.GET)
	public String getModifyInfo(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("get /modify/info");
		HttpSession session = request.getSession();
		A001MemVO vo = (A001MemVO) session.getAttribute("member");
		if(vo == null) {
			return "redirect:/";
		}
		else {
			String memNum = vo.getMemNum();
			A001MemVO result = null;
			result = a001MemService.memInfo(memNum);
			model.addAttribute("memInfo", result);
		}
		return "Amodify";
	}
	
	// POST /modify/info 회원 정보 수정
	@RequestMapping(value = "/modify/info", method = RequestMethod.POST)
	public String postModifyInfo(A001MemVO vo, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer result = 0;
		if(vo != null) {
			result = a001MemService.updateInfo(vo);
		}
		
		if(result == 0) {
			model.addAttribute("modifyMsg", false);
		} else {
			model.addAttribute("modifyMsg", "info");
		}
		return "redirect:/member/modify/info";
	}
	
	// POST /modify/pwd 비밀번호 수정
	@RequestMapping(value = "/modify/pwd", method = RequestMethod.POST)
	public String postModifyPwd(A001MemVO vo, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer result = 0;
		if(vo != null) {
			result = a001MemService.updatePwd(vo);
		}
		if(result == 0) {
			model.addAttribute("modifyMsg", false);
		} else {
			model.addAttribute("modifyMsg", "pwd");
		}
		return "redirect:/member/modify/info";
	}
	
	// POST /modify/auth 강사로 권한 변경
	@RequestMapping(value = "/modify/auth", method = RequestMethod.POST)
	public String postModifyAuth(A001MemVO vo, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer result = 0;
		if(vo != null) {
			result = a001MemService.updateAuth(vo);
		}
		if(result != 0) {
			model.addAttribute("modifyMsg", "auth");
		} else {
			model.addAttribute("modifyMsg", false);
		}
		return "redirect:/member/modify/info";
	}
	
}