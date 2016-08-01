package com.adapter.sharewe.aop;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adapter.sharewe.dto.MemberInfoVO;
import com.adapter.sharewe.service.impl.MessageServiceImpl;

@Component
public class Advices {
	@Autowired
	HttpServletRequest request;
	@Autowired
	MessageServiceImpl messageServiceImpl;

	public void beforeCall() {
		MemberInfoVO loginUser = (MemberInfoVO) request.getSession().getAttribute("loginUser");

		if (loginUser != null) {
			String email = loginUser.getEmail();

			int result = messageServiceImpl.selectChecked(email);

			if (result != 0) {
				request.setAttribute("notice_blink", true);
			} else {
				request.setAttribute("notice_blink", false);
			}
		}
	}
}
