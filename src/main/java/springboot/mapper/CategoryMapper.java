package springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import springboot.pojo.Category;

@Mapper
public interface CategoryMapper {
	@Select("select * from category")
	List<Category> findAll();
	@Insert("insert into category (name) values (#{name})")
	public int save(Category category);
	@Delete("delete from category where id=#{id}")
	public void delete (int id);
	@Select("select * from category where id=#{id}")
	public Category get(int id);
	@Update("update category set name=#{name} where id=#{id}")
	public int update(Category category);
}
