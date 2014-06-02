package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import beans.StoreMsgBean;
import beans.ViewMsgBean;

@Controller
public class BeanController extends BasicController {
	
	@RequestMapping(value = "/")
	public String storeMsg(Model model) throws Exception {
		StoreMsgBean bean = createBean(StoreMsgBean.class);
		bean.init();
		model.addAttribute("manager", bean);
		
		return "/main";
	}
	
	@RequestMapping(value = "/rez")
	public String viewMsg(Model model) {
		ViewMsgBean bean = context.getBean(ViewMsgBean.class);
		bean.init();
		model.addAttribute("manager", bean);
		
		return "/rez";
	}
}