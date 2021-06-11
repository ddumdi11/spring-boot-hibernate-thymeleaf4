package de.cmis.test.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import de.cmis.test.service.CmisTestService;

@Controller
@RequestMapping("/")
public class CmisTestMvcController {

	@Autowired
	CmisTestService service;

	@RequestMapping
	public String startPageTests(Model model) {
		return "startpage-tests";
	}

	@RequestMapping(path = { "/startAdminSession" })
	public String startAdminSession(Model model) {
		service.startAdminSession();
		return "redirect:/";
	}

	@RequestMapping(path = { "/startUserSession" })
	public String startUserSession(Model model, String connectionName, String username, String pwd) {
		service.startUserSession(connectionName, username, pwd);
		return "redirect:/";
	}

	@RequestMapping(path = { "/listTopFolder" })
	public String listTopFolder(Model model) {
		service.listTopFolder();
		return "redirect:/";
	}

	@RequestMapping(path = { "/getListTopFolder" })
	public String getListTopFolder(Model model) {
		List<String> topFolderList = service.getListTopFolder();
		model.addAttribute("topFolderList", topFolderList);
		return "list-top-folder";
	}

}
