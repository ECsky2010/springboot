package springboot;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import springboot.mapper.CategoryMapper;
import springboot.pojo.Category;
import springboot.web.CategoryController;
//该类应放在test文件夹中才能正常导入注解
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Applicaiton.class)
public class TestMyatis {
	@Autowired CategoryMapper categoryMapper;
	@Test
	public void test() {
		List<Category> cs = categoryMapper.findAll();
		for(Category c : cs) {
			System.out.println("c.getname():"+c.getName());
		}
	}
}
