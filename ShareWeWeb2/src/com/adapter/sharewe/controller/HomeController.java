package com.adapter.sharewe.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.adapter.sharewe.dto.CommentVO;
import com.adapter.sharewe.dto.EvaluateVO;
import com.adapter.sharewe.dto.MemberInfoVO;
import com.adapter.sharewe.dto.MessageVO;
import com.adapter.sharewe.dto.TMHashtagVO;
import com.adapter.sharewe.dto.TMRequestVO;
import com.adapter.sharewe.dto.TMinfoVO;
import com.adapter.sharewe.service.impl.CommentServiceImpl;
import com.adapter.sharewe.service.impl.EvaluateServiceImpl;
import com.adapter.sharewe.service.impl.GraphBarServiceImpl;
import com.adapter.sharewe.service.impl.MemberCheckServiceImpl;
import com.adapter.sharewe.service.impl.MemberServiceImpl;
import com.adapter.sharewe.service.impl.MessageServiceImpl;
import com.adapter.sharewe.service.impl.TMHashtagServiceImpl;
import com.adapter.sharewe.service.impl.TMRequestServiceImpl;
import com.adapter.sharewe.service.impl.TMinfoServiceImpl;
import com.adapter.sharewe.utils.MailingSender;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class HomeController {

	@Autowired
	private MemberServiceImpl memberServiceImpl;
	@Autowired
	private MemberCheckServiceImpl memberCheckServiceImpl;
	@Autowired
	private TMinfoServiceImpl tminfoServletImpl;
	@Autowired
	private TMHashtagServiceImpl tmhashtagSerciveImpl;
	@Autowired
	private CommentServiceImpl commentServiceImpl;
	@Autowired
	private MessageServiceImpl messageServiceImpl;
	@Autowired
	private EvaluateServiceImpl evaluateServiceImpl;
	@Autowired
	private TMRequestServiceImpl tmrequestServiceImpl;
	@Autowired
	private GraphBarServiceImpl graphBarServiceImpl;

	

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	// 시작 메인화면.
	@RequestMapping("/main.do")
	public ModelAndView maindddd(Locale locale, Model model) {
		logger.info("Welcome main.", locale);

		// view 화면인 main.jsp에 DB로부터 읽어온 데이터를 보여준다.
		ModelAndView result = new ModelAndView();
		// addObject view에 넘어가는 데이터
		List<MemberInfoVO> memberList = memberServiceImpl.getAllMembers();
		result.addObject("result", memberList);
		result.setViewName("result");
		return result;
	}

	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String main(TMinfoVO tiVO, Locale locale, Model model) {
		List<String> cssItems = new ArrayList<String>();
		List<String> jsItems = new ArrayList<String>();
		List<TMinfoVO> tminfoVo = null;

		if ("".equals(tiVO.getTalent()) || tiVO.getTalent() == null) {
			tminfoVo = tminfoServletImpl.selectAllList();
		} else {
			tminfoVo = tminfoServletImpl.wishTalentSearch(tiVO.getTalent());
		}

		cssItems.add("css/sw_main.css");
		jsItems.add("js/sw_main.js");

		model.addAttribute("cssItems", cssItems);
		model.addAttribute("jsItems", jsItems);

		model.addAttribute("articleList", tminfoVo);

		return "/sw_index";
	}

	@RequestMapping(value = "/search.do", method = RequestMethod.POST)
	public String mainService(TMinfoVO tInfo, Model model, HttpServletRequest request) {
		String talent = request.getParameter("talent");
		System.out.println(talent);
		List<TMinfoVO> articleList = tminfoServletImpl.wishTalentSearch(talent);

		model.addAttribute("articleList", articleList);

		return "/sw_index";
	}

	@RequestMapping(value = "intro.do", method = RequestMethod.GET)
	public String intro(Locale locale, Model model) {

		List<String> cssItems = new ArrayList<String>();
		List<String> jsItems = new ArrayList<String>();

		cssItems.add("css/reset.css");
		cssItems.add("css/sw_intro.css");
		cssItems.add("css/sw_common.css");
		jsItems.add("js/jquery-1.11.1.min.js");
		jsItems.add("js/sw_intro.js");
		jsItems.add("js/sw_intro_login_form.js");

		model.addAttribute("cssItems", cssItems);
		model.addAttribute("jsItems", jsItems);

		return "sw_intro";
	}

	@RequestMapping(value = "/write.do", method = RequestMethod.GET)
	public String right(Locale locale, Model model) {

		List<String> cssItems = new ArrayList<String>();
		List<String> jsItems = new ArrayList<String>();

		cssItems.add("css/sw_writing_form.css");
		jsItems.add("js/sw_writing_form.js");

		/* TMinfoVO selectTminfo = tminfoServletImpl.updateTMInfoVO(tVo); */

		model.addAttribute("cssItems", cssItems);
		model.addAttribute("jsItems", jsItems);

		return "/sub/sw_writing_form";
	}

	@RequestMapping(value = "/write.do", method = RequestMethod.POST)
	public String rightService(TMinfoVO tInfo, Model model, HttpServletRequest req) {
		System.out.println("폼에서 입력한 글 정보:" + tInfo);
		MemberInfoVO loginUser = (MemberInfoVO) req.getSession().getAttribute("loginUser");
		String email = loginUser.getEmail();
		tInfo.setEmail(email);

		TMinfoVO fff = tminfoServletImpl.getNextSeq();
		
		System.out.println("시퀀스를 담고 있는 " + fff);

		tInfo.setTextid(fff.getSeq());
		tminfoServletImpl.insertWriting(tInfo);
		tmhashtagSerciveImpl.insertWritingHashtag(tInfo);

		return "redirect:index.do";
	}

	@RequestMapping(value = "/writeView.do", method = RequestMethod.GET)
	public String rightView(Locale locale, Model model, HttpServletRequest req) {

		List<String> cssItems = new ArrayList<String>();

		cssItems.add("css/sw_view_proposal.css");

		model.addAttribute("cssItems", cssItems);

		logger.info("writeView.do called!!!");

		String textid = req.getParameter("textid");
		String email = req.getParameter("email");

		System.out.println(email);

		TMinfoVO selectContent = tminfoServletImpl.selectArticleByTextId(textid);
		TMinfoVO dateMember = tminfoServletImpl.selectTminfoDate(textid);
		List<TMHashtagVO> hslist = tmhashtagSerciveImpl.selectTalentsMeByTextId(textid);
		List<TMHashtagVO> ylist = tmhashtagSerciveImpl.selectTalentsYouByTextId(textid);

		model.addAttribute("article", selectContent);
		model.addAttribute("tmdate", dateMember);
		model.addAttribute("talentMe", hslist);
		model.addAttribute("talentYou", ylist);
		// 댓글
		List<CommentVO> clist = commentServiceImpl.selectComment(textid);
		model.addAttribute("commentView", clist);

		return "/sub/sw_view_proposal";
	}

	@RequestMapping(value = "/writeView.do", method = RequestMethod.POST)
	public String rightViewService(TMHashtagVO tmhtVo, TMinfoVO tmIfVo, Model model) {

		return "/sub/sw_view_proposal";
	}

	@RequestMapping(value = "/mypage.do", method = RequestMethod.GET)
	public String mypage(Locale locale, HttpServletRequest request, Model model) {

		List<String> cssItems = new ArrayList<String>();
		List<String> jsItems = new ArrayList<String>();

		cssItems.add("css/sw_mypage.css");
		cssItems.add("css/sw_join_form.css");

		jsItems.add("js/sw_mypage.js");
		//jsItems.add("js/sw_join_form.js");

		model.addAttribute("cssItems", cssItems);
		model.addAttribute("jsItems", jsItems);

		HttpSession session = request.getSession();
		MemberInfoVO loginUser = (MemberInfoVO) session.getAttribute("loginUser");

		String email = loginUser.getEmail();
		String del[] = request.getParameterValues("del");
		String textid = request.getParameter("textid");

		// 담아둔 재능
		List<TMinfoVO> tmlist = tminfoServletImpl.getMyScrap(email);
		model.addAttribute("scrapProfile", tmlist);
		// 제안한 재능
		List<TMinfoVO> OfferList = tminfoServletImpl.getMyOffer(email);
		model.addAttribute("offerProfile", OfferList);

		model.addAttribute("myInfo", memberServiceImpl.getMyInfo(loginUser));
		model.addAttribute("messages", messageServiceImpl.selectreceiver(loginUser.getEmail()));
		model.addAttribute("comment", evaluateServiceImpl.getMyComment(loginUser.getEmail()));
		
		/*
		 * model.addAttribute("messages",
		 * messageServiceImpl.selectChecked(loginUser.getEmail()));
		 */ /*
			 * String messageid = request.getParameter("del");
			 * messageServiceImpl.setMessageChecked(messageid);
			 * messageServiceImpl.selectChecked(loginUser.getEmail());
			 */

		return "/sub/sw_mypage";

	}

	@RequestMapping(value = "/deletemessage.do", method = RequestMethod.POST)
	public String deletemessage(Locale locale, HttpServletRequest request, Model model) {
		List<String> cssItems = new ArrayList<String>();
		List<String> jsItems = new ArrayList<String>();

		cssItems.add("css/sw_mypage.css");
		cssItems.add("css/sw_join_form.css");

		jsItems.add("js/sw_mypage.js");
		//jsItems.add("js/sw_join_form.js");

		String del[] = request.getParameterValues("del");
		for (String messageid : del) {
			messageServiceImpl.deleteMessage(messageid);
		}

		return "redirect:mypage.do#tab_message";
	}

	@RequestMapping(value = "/mypage.do", method = RequestMethod.POST)
	public String mypageService(EvaluateVO evVo, MemberInfoVO mi, MessageVO mVo, TMinfoVO tmiVo, Model model) {

		return "/sub/sw_mypage";
	}	

	@RequestMapping(value = "/mypage_update.do", method = RequestMethod.POST)
	public String mypageUpdateService(HttpServletRequest req) throws IOException {
		ServletContext context = req.getServletContext();
		String path = context.getRealPath("img/member");
		//String path = "E:/javaSmartWeb/ShareWe/ShareWeWeb/WebContent/img/member";
		String encType = "UTF-8";
		int sizeLimit = 10 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(req, path, sizeLimit, encType, new DefaultFileRenamePolicy());

		MemberInfoVO mInfo = new MemberInfoVO();
		String picture = multi.getFilesystemName("picture");
		
		if(picture == null){
			picture = multi.getParameter("noimage");
		}
		
		mInfo.setAddress(multi.getParameter("address"));
		mInfo.setJob(multi.getParameter("job"));
		mInfo.setEmail(multi.getParameter("email"));
		mInfo.setPicture(picture);

		memberServiceImpl.updateMyInfo(mInfo);
		return "redirect:mypage.do";
	}

	@RequestMapping(value = "/deleteScrap.do")
	public String deleteScrapService(HttpServletRequest request, TMRequestVO rVo) {
		String del[] = request.getParameterValues("del");
		MemberInfoVO mVo = (MemberInfoVO) request.getSession().getAttribute("loginUser");
		String email = mVo.getEmail();


		for (String textid : del) {
			
			rVo.setEmail(email);
			rVo.setTextid(textid);
		}
		
		return "redirect:mypage.do";
	}
	
	@RequestMapping(value = "/scrap.do")
	public String scrapService(HttpServletRequest request, TMRequestVO rVo) {
		
		String textid = request.getParameter("textid");
		MemberInfoVO mVo = (MemberInfoVO) request.getSession().getAttribute("loginUser");
		String email = mVo.getEmail();
		
		rVo.setTextid(textid);
		rVo.setEmail(email);
		
		memberServiceImpl.scrapTMInfo(rVo);
		
		return "redirect:mypage.do#tab_scrap_sw";
	}

	@RequestMapping(value = "/ask.do", method = RequestMethod.GET)
	public String askService(HttpServletRequest request, MessageVO mVo, MemberInfoVO miVo) {

		miVo = (MemberInfoVO) request.getSession().getAttribute("loginUser");
		String sender = miVo.getEmail();
		String receiver = request.getParameter("receiver");
		String title = miVo.getNickname() + "님이 재능나눔을 신청하셨습니다";
		String content = "쪽지를 주고 받으며 여러분의 재능을 나누세요.";


		mVo.setReceiver(receiver);
		mVo.setSender(sender);
		mVo.setTitle(title);
		mVo.setContent(content);
		
		System.out.println(receiver);
		
		System.out.println(sender);
		System.out.println(title);
		System.out.println(content);

		memberServiceImpl.sendMessage(mVo);
		return "redirect:index.do";
	}
	

	@RequestMapping(value = "/join.do", method = RequestMethod.GET)
	public String join(Locale locale, Model model) {

		List<String> cssItems = new ArrayList<String>();
		List<String> jsItems = new ArrayList<String>();

		cssItems.add("css/reset.css");
		cssItems.add("css/sw_common.css");
		cssItems.add("css/sw_join_form.css");
		jsItems.add("js/jquery-1.11.1.min.js");
		jsItems.add("js/sw_common.js");

		model.addAttribute("cssItems", cssItems);
		model.addAttribute("jsItems", jsItems);
		return "sub/sw_join_form";
	}

	@RequestMapping(value = "/join.do", method = RequestMethod.POST)
	public String joinService(MemberInfoVO mInfo, HttpServletRequest request, Model model) {

		List<String> cssItems = new ArrayList<String>();
		List<String> jsItems = new ArrayList<String>();

		cssItems.add("css/sw_main.css");
		jsItems.add("js/sw_main.js");

		model.addAttribute("cssItems", cssItems);
		model.addAttribute("jsItems", jsItems);

		memberServiceImpl.insertMember(mInfo);
		System.out.println("insert complet");
		try {
			MailingSender.getInstance().initPost("www.sharewe.com", mInfo.getEmail(), "쉐어위 인증메일입니다.", "http://VII-84:8888/ShareWeWeb/validateMail.do?email=" + mInfo.getEmail() + "\n해당 링크로 접속하시면 이메일 인증을 하실 수 있습니다.").send();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/sw_index";
	}
	
	
	
	
	
	

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login(MemberInfoVO mInfo, HttpServletRequest request, Model model) {

		List<String> cssItems = new ArrayList<String>();
		List<String> jsItems = new ArrayList<String>();

		cssItems.add("css/reset.css");
		cssItems.add("css/sw_intro.css");
		cssItems.add("css/sw_common.css");
		jsItems.add("js/jquery-1.11.1.min.js");
		jsItems.add("js/sw_intro.js");
		jsItems.add("js/sw_intro_login_form.js");

		model.addAttribute("cssItems", cssItems);
		model.addAttribute("jsItems", jsItems);

		return "sw_intro";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String loginService(MemberInfoVO mInfo, HttpServletRequest request, Model model) {

		HttpSession session = request.getSession();

		MemberInfoVO member = memberServiceImpl.login(mInfo);

		if (member == null) {
			// 존재하지 않는 계정에 대한 처리

			session.setAttribute("loginNoUser", true);
			return "redirect:intro.do";
		} else {
			if (member.getPwd().equals(mInfo.getPwd())) {
				// 비밀번호까지 일치했을 때. 즉, 로그인 성공

				session.setAttribute("loginUser", memberServiceImpl.login(mInfo));
				return "redirect:/index.do";
			} else {
				// 비밀번호가 틀렸을 때

				session.setAttribute("loginWrongPwd", true);
				return "redirect:intro.do";
			}
		}
	}

	@RequestMapping(value = "logout.do", method = RequestMethod.GET)
	public String logoutService(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:intro.do";
	}

	@RequestMapping(value = "/idCheckForm.do", method = RequestMethod.GET)
	public String idCheckForm(MemberInfoVO mInfo, HttpServletRequest request, Model model) {

		MemberInfoVO member = memberServiceImpl.confirmId(mInfo);

		List<String> jsItems = new ArrayList<String>();

		jsItems.add("js/jquery-1.11.1.min.js");
		jsItems.add("js/sw_intro.js");

		String email = request.getParameter("email");

		model.addAttribute("jsItems", jsItems);
		model.addAttribute("email", email);
		model.addAttribute("member", member);

		return "sub/sw_idcheck";
	}

	@RequestMapping(value = "/idCheck.do", method = RequestMethod.GET)
	public String idCheck(MemberInfoVO mInfo, HttpServletRequest request, Model model) {

		MemberInfoVO member = memberServiceImpl.confirmId(mInfo);

		if (member == null) {
			return "sub/sw_idcheck_true";
		} else {
			return "sub/sw_idcheck_false";
		}
	}

	@RequestMapping(value = "/help_popup.do", method = RequestMethod.GET)
	public String helpPopup(Locale locale, Model model) {

		return "sub/sw_help_popup";
	}

	@RequestMapping(value = "/join_validate.do", method = RequestMethod.GET)
	public String joinValidate(Locale locale, Model model) {

		return "sub/sw_join_validate";
	}

	@RequestMapping(value = "/messageview.do", method = RequestMethod.GET)
	public String messageView(Locale locale, Model model, HttpServletRequest request) {

		List<String> cssItems = new ArrayList<String>();
		List<String> jsItems = new ArrayList<String>();

		cssItems.add("css/reset.css");
		cssItems.add("css/sw_common.css");
		cssItems.add("css/sw_view_proposal.css");
		jsItems.add("js/jquery-1.11.1.min.js");
		jsItems.add("js/sw_common.js");
		jsItems.add("js/sw_profile_view.js");
		
		model.addAttribute("cssItems", cssItems);
		model.addAttribute("jsItems", jsItems);
	
		String messageid = request.getParameter("messageid");
		MessageVO mVo = messageServiceImpl.selectView(messageid);
		messageServiceImpl.setMessageChecked(messageid);

		request.setAttribute("viewmessage", mVo);

		return "sub/sw_message_view";

	}

	@RequestMapping(value = "/messageview.do", method = RequestMethod.POST)
	public String messageViewService(MessageVO megVo, Model model, HttpServletRequest request) {

		return "sub/sw_message_view";
	}

	@RequestMapping(value = "/message.do", method = RequestMethod.GET)
	public String message(Locale locale, Model model, MessageVO msgVo, HttpServletRequest request) {

		String messageid = request.getParameter("messageid");
		if (messageid != null) {

			MessageVO mVo1 = messageServiceImpl.selectView(messageid);
			model.addAttribute("answer", mVo1);
		}
		return "sub/sw_message";
	}

	@RequestMapping(value = "/message.do", method = RequestMethod.POST)
	public String messageService(MessageVO msgVo, HttpServletRequest request, Model model) {
		messageServiceImpl.sendMessage(msgVo);

		System.out.println(msgVo);
		System.out.println("메세지 전송 성공");
		System.out.println(msgVo);
		
		model.addAttribute("msgFromSubmit", "<script>alert('메세지가 성공적으로 전송되었습니다.');window.close();</script>");
		return "sub/sw_message_view";

	}

	@RequestMapping(value = "/profile_view.do", method = RequestMethod.GET)
	public String profileView(Locale locale, Model model, HttpServletRequest req) {

		List<String> cssItems = new ArrayList<String>();
		List<String> jsItems = new ArrayList<String>();

		cssItems.add("css/reset.css");
		cssItems.add("css/sw_common.css");
		cssItems.add("css/sw_view_proposal.css");
		jsItems.add("js/jquery-1.11.1.min.js");
		jsItems.add("js/sw_common.js");
		jsItems.add("js/sw_profile_view.js");

		model.addAttribute("cssItems", cssItems);
		model.addAttribute("jsItems", jsItems);
		
		String email = req.getParameter("email");

		System.out.println("첫번쨰" + email);

		MemberInfoVO profile = memberServiceImpl.profileMembers(email);
		List<EvaluateVO> eVo = evaluateServiceImpl.selectHanjool(email);

		System.out.println("두번째" + email);
		model.addAttribute("profile", profile);
		model.addAttribute("han", eVo);
		
		return "sub/sw_profile_view";

	}

	@RequestMapping(value = "/profile_view.do", method = RequestMethod.POST)
	public String profileViewService(Model model, HttpServletRequest req) {
	
		return "sub/sw_profile_view";
	}
	@RequestMapping(value = "/hanjoolUpdate.do", method = RequestMethod.GET)
	public String HanjoolUpdate(Model model, HttpServletRequest req) {
		
		String email = req.getParameter("email");
		String content = req.getParameter("content");
		String evaluateid = req.getParameter("evaluateid");
		System.out.println(content);
		System.out.println(evaluateid);
		
		evaluateServiceImpl.updateHanjool(content, evaluateid);

		return "redirect:/profile_view.do?email=" + email + "#popup_tab3";

	}
	
	@RequestMapping(value = "/hanjooldel.do", method = RequestMethod.GET)
	public String HanjoolDelete(Model model, HttpServletRequest req, EvaluateVO tVo) {
		
		String email = req.getParameter("email");
		String evaluateid = req.getParameter("evaluateid");
		System.out.println(email);
		System.out.println(evaluateid);
		evaluateServiceImpl.deleteHanjool(evaluateid);

		return "redirect:/profile_view.do?email=" + email + "#popup_tab3";

	}
	
	@RequestMapping(value = "/hanjool.do", method = RequestMethod.POST)
	public String HanjoolWrite(Model model, HttpServletRequest req, EvaluateVO tVo) {
		
		HttpSession session = req.getSession();
		MemberInfoVO loginUser = (MemberInfoVO) session.getAttribute("loginUser");
		tVo.setVoteremail(loginUser.getEmail());
		String email = req.getParameter("targetemail");
		
		String rate = req.getParameter("rate");
		
		System.out.println(rate);
		System.out.println(tVo.getContent());
		if("Y".equals(rate)) {
			tVo.setFlag("U");
			evaluateServiceImpl.insertHanjool1(tVo);
		}else if("N".equals(rate)){
			tVo.setFlag("D");
			evaluateServiceImpl.insertHanjool2(tVo);
		}
		
		System.out.println(tVo.getFlag());
		
		return "redirect:/profile_view.do?email=" +email + "#popup_tab3";
	}


	

	@RequestMapping(value = "/semiMessage_view.do", method = RequestMethod.GET)
	public String semiMessageView(Locale locale, Model model) {

		List<String> cssItems = new ArrayList<String>();
		List<String> jsItems = new ArrayList<String>();

		cssItems.add("css/reset.css");
		cssItems.add("css/common.css");
		cssItems.add("css/sw_message_form.css");
		jsItems.add("js/jquery-1.11.1.min.js");

		model.addAttribute("cssItems", cssItems);
		model.addAttribute("jsItems", jsItems);

		return "sub/sw_semiMessage_view";
	}

	@RequestMapping(value = "/semiMessage_view.do", method = RequestMethod.POST)
	public String semiMessageViewService(MessageVO msgVo, Model model) {

		return "sub/sw_semiMessage_view";
	}

	@RequestMapping(value = "/semiMessage.do", method = RequestMethod.GET)
	public String semiMessageService(Model model) {
		List<String> cssItems = new ArrayList<String>();
		List<String> jsItems = new ArrayList<String>();

		cssItems.add("css/reset.css");
		cssItems.add("css/sw_common.css");
		cssItems.add("css/sw_view_proposal.css");
		jsItems.add("js/jquery-1.11.1.min.js");
		jsItems.add("js/sw_common.js");
		jsItems.add("js/sw_profile_view.js");

		model.addAttribute("cssItems", cssItems);
		model.addAttribute("jsItems", jsItems);

		
		
		return "sub/sw_semiMessage_view";
	}
	


	/*
	 * @RequestMapping(value = "/semiMessage.do", method = RequestMethod.GET)
	 * protected String semiMessage(Locale locale, Model model, MessageVO msgVo,
	 * HttpServletRequest request) {
	 * 
	 * List<String> cssItems = new ArrayList<String>(); List<String> jsItems =
	 * new ArrayList<String>();
	 * 
	 * cssItems.add("css/reset.css"); cssItems.add("css/common.css");
	 * cssItems.add("css/sw_message_form.css");
	 * jsItems.add("js/jquery-1.11.1.min.js");
	 * 
	 * model.addAttribute("cssItems", cssItems); model.addAttribute("jsItems",
	 * jsItems);
	 * 
	 * 
	 * messageServiceImpl.sendMessage(msgVo); System.out.println("메세지 전송 성공");
	 * String email = request.getParameter("receiver");
	 * 
	 * return "redirect:/profile_view.do?email="+email+"#popup_tab2";
	 * 
	 * }
	 */

	@RequestMapping(value = "/semiMessage.do", method = RequestMethod.POST)
	public String semiMessageService(Locale locale, Model model, MessageVO msgVo, HttpServletRequest request) {

		List<String> cssItems = new ArrayList<String>();
		List<String> jsItems = new ArrayList<String>();

		cssItems.add("css/reset.css");
		cssItems.add("css/common.css");
		cssItems.add("css/sw_message_form.css");
		jsItems.add("js/jquery-1.11.1.min.js");

		model.addAttribute("cssItems", cssItems);
		model.addAttribute("jsItems", jsItems);
		
		
		messageServiceImpl.sendMessage(msgVo);
		System.out.println("메세지 전송 성공");
		String email = request.getParameter("receiver");

		return "redirect:/profile_view.do?email=" + email + "#popup_tab2";

	}

	@RequestMapping(value = "/semiProfile_modal.do", method = RequestMethod.GET)
	public String semiProfileModal(Locale locale, Model model, HttpServletRequest request) {
		
		String email = request.getParameter("email");

		model.addAttribute("Gbar", graphBarServiceImpl.graphBar(email));
		model.addAttribute("member", memberServiceImpl.getMember(email));
		
		return "sub/sw_semiProfile_modal";
	}

	@RequestMapping(value = "/semiProfile_modal.do", method = RequestMethod.POST)
	public String semiProfileModalService(Model model) {

		return "sub/sw_semiProfile_modal";
	}

	@RequestMapping(value = "/talent_modal.do", method = RequestMethod.GET)
	public String talentModal(Locale locale, Model model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		MemberInfoVO loginUser = (MemberInfoVO) session.getAttribute("loginUser");
		
		String email = loginUser.getEmail();
		
		model.addAttribute("teacher", memberServiceImpl.selectTeacher(email));
		model.addAttribute("student", memberServiceImpl.selectStudent(email));
		model.addAttribute("winwin", memberServiceImpl.selectWinwin(email));
		
		return "sub/sw_talent_modal";
		
	}

	@RequestMapping(value = "/talent_modal.do", method = RequestMethod.POST)
	public String talentModalService(MemberInfoVO mi, Model model) {

		return "sub/sw_talent_modal";
	}

	@RequestMapping(value = "/update_form.do", method = RequestMethod.GET)
	public String updateForm(TMinfoVO vo, Model model) {

		List<String> cssItems = new ArrayList<String>();
		List<String> jsItems = new ArrayList<String>();

		cssItems.add("css/reset.css");
		cssItems.add("css/common.css");
		cssItems.add("css/sw_writing_form.css");
		jsItems.add("js/jquery-1.11.1.min.js");
		jsItems.add("js/sw_writing_form.js");

		TMinfoVO update = tminfoServletImpl.selectUpdate(vo);
		TMHashtagVO uphash = tmhashtagSerciveImpl.selectTalents(vo);

		model.addAttribute("suinfo", update);
		model.addAttribute("talent", uphash);

		model.addAttribute("cssItems", cssItems);
		model.addAttribute("jsItems", jsItems);

		return "/sub/sw_update_form/no_quick";
	}

	@RequestMapping(value = "/update_form.do", method = RequestMethod.POST)
	public String updateFormService(TMinfoVO tmifVo, Model model, TMHashtagVO tmhashVo, HttpServletRequest req) {
		tminfoServletImpl.updateTMInfoVO(tmifVo);
		tmhashtagSerciveImpl.deleteHashtags(tmifVo.getTextid());
		tmhashtagSerciveImpl.insertWritingHashtag(tmifVo);

		
		return "redirect:/index.do";
	}
	
	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public String DeleteService(Model model,HttpServletRequest req) {
		String textid = req.getParameter("textid");
		
		tminfoServletImpl.deleteWriting(textid);
		tmhashtagSerciveImpl.deleteHashtags(textid);
		
		return "redirect:/index.do";
	}


	

	

	
	@RequestMapping(value = "/commentdel.do", method = RequestMethod.GET)
	public String commentDel(HttpServletRequest req) {
		String tid = req.getParameter("textid");
		String comseq = req.getParameter("comseq");

		commentServiceImpl.deleteComment(comseq);
		return "redirect:/writeView.do?textid=" + tid;
	}

	@RequestMapping(value = "/commentUpdate.do", method = RequestMethod.GET)
	public String commentUpdate(HttpServletRequest req) {
		String tid = req.getParameter("textid");
		String comseq = req.getParameter("comseq");
		String comment_text = req.getParameter("comment");

		System.out.println(tid);
		System.out.println(comseq);
		System.out.println(comment_text);
		commentServiceImpl.updateComment(comment_text, comseq);
		return "redirect:/writeView.do?textid=" + tid;
	}

	
	
	@RequestMapping(value = "/commentWrite.do", method = RequestMethod.POST)
	public String commentWrite(CommentVO cVO, TMinfoVO tInfo, Model model, HttpServletRequest req) {
		MemberInfoVO loginUser = (MemberInfoVO) req.getSession().getAttribute("loginUser");
		String email = loginUser.getEmail();
		String textid = req.getParameter("textid");
		String comment_text = req.getParameter("sw_comment_text");

		System.out.println(email);
		System.out.println(textid);
		System.out.println(comment_text);

		commentServiceImpl.insertComment(textid, email, comment_text);

		return "redirect:/writeView.do?textid=" + textid;
		
		
	}
	
	@RequestMapping(value = "/deleteScrap.do", method = RequestMethod.POST)
	public String deleteScrap(Locale locale, HttpServletRequest request, Model model) {

		HttpSession session = request.getSession();
		MemberInfoVO loginUser = (MemberInfoVO) session.getAttribute("loginUser");
		
		String email = loginUser.getEmail();
		String del[] = request.getParameterValues("del");
		
		for(String textid : del){
			TMRequestVO trVo = new TMRequestVO();
			
			trVo.setEmail(email);
			trVo.setTextid(textid);
			
			tmrequestServiceImpl.deleteEachScrap(trVo);
		}
				
		return "redirect:/mypage.do";
	}

	@RequestMapping(value = "/deleteOffer.do", method = RequestMethod.POST)
	public String deleteOffer(Locale locale, HttpServletRequest request, Model model) {
		String del[] = request.getParameterValues("del");
		
		for(String textid : del){
			tmhashtagSerciveImpl.deleteHashtags(textid); //해시태그삭제
			tminfoServletImpl.deleteWriting(textid); // 글삭제
			tmrequestServiceImpl.scrapTMDel(textid);//담아두기 삭제
			commentServiceImpl.deleteComments(textid); // 코멘트 삭제
			
		}
		
		return "redirect:/mypage.do";
	}
	
	@RequestMapping(value="chat.do")
	public String chatService(){
		return "layouts/broadcast";
	}
	
	@RequestMapping(value="chat2.do")
	public String chat2Service(){
		return "/layouts/chat";
	}
	
	@RequestMapping(value="/validateMail.do", method = RequestMethod.GET)
	public String validateMail(HttpServletRequest req){
		String email = req.getParameter("email");
		
		int result = memberCheckServiceImpl.validateMember(email);
		
		if(result == 1){
			req.setAttribute("mailValidateSuccess", true);
		}else{
			req.setAttribute("mailValidateSuccess", false);
		}
		
		return "sub/sw_join_validate";
	}
}