package mc.sn.reivew.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mc.sn.reivew.member.service.MemberService;
import mc.sn.reivew.member.vo.MemberVO;

@Controller("memberController")
//@EnableAspectJAutoProxy
public class MemberControllerImpl implements MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberControllerImpl.class);
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberVO memberVO ;
	
	@RequestMapping(value = { "/login/loginForm.do", "/member/memberForm.do" }, method =  RequestMethod.GET)
//	@RequestMapping(value = "/member/*Form.do", method =  RequestMethod.GET)
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		System.out.println(viewName);
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/login/result.do", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("member") MemberVO member,
				              RedirectAttributes rAttr,
		                       HttpServletRequest request, HttpServletResponse response) throws Exception {
	ModelAndView mav = new ModelAndView();
	String viewName = this.getViewName(request);
	System.out.println(viewName);
	memberVO = memberService.login(member);
	System.out.println(member.getId()+","+member.getPwd());	
		
	if(memberVO != null) {
	    HttpSession session = request.getSession();
	    session.setAttribute("member", memberVO);
	    //session.setAttribute("isLogOn", true);
		//request.setAttribute("member", memberVO);
	    System.out.println(memberVO.getId()+"/"+memberVO.getPwd());
	    //mav.setViewName("redirect:/member/listMembers.do");
	}else {
	    //rAttr.addAttribute("result","loginFailed");
	    //mav.setViewName("redirect:/member/loginForm.do");
		System.out.println(member.getId()+","+member.getPwd()+" 해당되는 정보가 없습니다.");
	}
	mav.setViewName(viewName);	
	return mav;
	
	}

	
	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String viewName = uri.substring(begin, end);
		if (viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
		}
		if (viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring(viewName.lastIndexOf("/", 1), viewName.length());
		}
		return viewName;
	}


}
