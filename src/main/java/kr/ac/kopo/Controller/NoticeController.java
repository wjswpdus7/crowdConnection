package kr.ac.kopo.Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.kopo.Service.NoticeService;
import kr.ac.kopo.model.Attach;
import kr.ac.kopo.model.Member;
import kr.ac.kopo.model.Notice;
import kr.ac.kopo.pager.Pager;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	final String path = "notice/";
	final String uploadPath = "c://upload/";
	
	@Autowired
	NoticeService service;
	
	@RequestMapping("/list")
	public String list(Model model, Pager pager) {
		List<Notice> list = service.list(pager);
		
		model.addAttribute("list", list);
		
		return path + "list";
	}
	
	@RequestMapping("/guide")
	public String guide() {
		return path + "guide";
	}
	
	@GetMapping("/add")
	public String add() {
		return path + "add";
	}
	
	@PostMapping("/add")
	public String add(Notice item, @SessionAttribute Member member) {
		item.setMemberId(member.getId());
	      
	      try {
	      List<Attach> list = new ArrayList<Attach>();
	      
	      for(MultipartFile attach : item.getAttach()) {
	         
	      if(attach != null && !attach.isEmpty()) {
	         String filename = attach.getOriginalFilename();
	         
	         attach.transferTo(new File(uploadPath + filename));
	         
	         Attach attachItem = new Attach();
	         
	         attachItem.setFilename(filename);
	         
	         list.add(attachItem);
	      }
	      }
	         item.setAttachs(list);
	         
	         service.add(item);
	      }   catch (Exception e) {
	         e.printStackTrace();
	      }
	      
	      return "redirect:list";
	   }
	@GetMapping("/update/{num}")
	public String update(@PathVariable int num, Model model) {
		Notice item = service.item(num);
		
		model.addAttribute("item", item);
		
		return path + "update";
	}
	
	@PostMapping("/update/{num}")
	public String update(@PathVariable int num, Notice item) {
		item.setNum(num);
		
		service.update(item);
		
		return "redirect:../list";
	}
	
	@RequestMapping("/getail/{id}")
	public String getail(@PathVariable int id,Model model) {
		Notice item = service.item(id);
		
		model.addAttribute("item",item);
		return path + "getail";
	}
	
	@GetMapping("/detail")
		public String detail() {
		return path + "detail";
	}
}
