package springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import springboot.mapper.CategoryMapper;
import springboot.pojo.Category;

@Controller
public class CategoryController {
	@Autowired CategoryMapper CategoryMapper;
	@GetMapping("/categories")
	public String listCategory(Model m,@RequestParam(value = "start", defaultValue = "1") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
		//根据start,size进行分页，并且设置id 倒升序
		if(start < 1)
			start = 1;
		PageHelper.startPage(start,size,"id asc");
		//获取的是分页集合
		List<Category> cs = CategoryMapper.findAll();
		PageInfo<Category> page = new PageInfo<Category>(cs);
		m.addAttribute("page",page);
		return "listCategory";
		
	}
	@PostMapping("/categories")
	public String listCategory(Category c) throws Exception {
		CategoryMapper.save(c);
		return "redirect:/categories";
	}
	@DeleteMapping("/categories/{id}")
	public String deleteCategory(Category c) throws Exception{
		CategoryMapper.delete(c.getId());
		return "redirect:/categories";
	}
	@PutMapping("/categories/{id}")
	public String updateCategory(Category c) throws Exception{
		CategoryMapper.update(c);
		return "redirect:/categories";
	}
	@GetMapping("/categories/{id}")
	public String editCategory(@PathVariable("id")int id,Model m) throws Exception{
		Category category = CategoryMapper.get(id);
		m.addAttribute("c",category);
		return "editCategory";
	}
	
}
