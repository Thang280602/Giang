package com.project.sportstore.controller.admin;

import com.project.sportstore.model.Blog;
import com.project.sportstore.service.BlogService;
import com.project.sportstore.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Controller
@RequestMapping("/admin")
public class BlogController {
	@Autowired
	private BlogService blogService;
	@Autowired
	private StorageService seStorageService;

	@GetMapping("/blog")
	public String Index(Model model, @Param("keyword") String keyword,
			@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo) {
		Page<Blog> list = this.blogService.getAll(pageNo);
		if (keyword != null) {
			list = this.blogService.searchCategory(keyword, pageNo);
			model.addAttribute("keyword", keyword);
		}
		model.addAttribute("totalPage", list.getTotalPages());
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("list", list);
		return "admin/blog/index";
	}

	@GetMapping("/blog-add")
	public String add(Model model) {
		Blog blog = new Blog();
		blog.setDate(new Date());
		model.addAttribute("blog", blog);
		return "admin/blog/add";
	}

	@PostMapping("/blog-add")
	public String save(@ModelAttribute("blog") Blog blog, @RequestParam("fileImage") MultipartFile file) {
		this.seStorageService.store(file);
		String fileName = file.getOriginalFilename();
		blog.setBlogImage(fileName);
		blog.setDate(new Date());
		if (this.blogService.create(blog)) {
			return "redirect:/admin/blog";
		}
		return "admin/blog/add";
	}

	@GetMapping("/edit-blog/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		Blog blog = this.blogService.findById(id);
		model.addAttribute("blog", blog);
		return "admin/blog/edit";
	}

	@PostMapping("/edit-blog")
	public String upddate(@ModelAttribute("blog") Blog blog,@RequestParam("fileImage") MultipartFile file) {
		String fileName = file.getOriginalFilename();
		boolean isEmpty = fileName == null || fileName.trim().length() == 0;
		if (!isEmpty) {
			this.seStorageService.store(file);
			blog.setBlogImage(fileName);
			blog.setDate(new Date());
		}
		if (this.blogService.create(blog)) {
			return "redirect:/admin/blog";
		} else {
			return "admin/blog/add";
		}
	}

	@GetMapping("/delete-blog/{id}")
	public String delete(@PathVariable("id") Integer id) {
		this.blogService.delete(id);
		return "redirect:/admin/blog";
	}
}
