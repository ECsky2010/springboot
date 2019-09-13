package springboot.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageHelper;

@Configuration
public class PageHelplerConfig {
	@Bean
	public PageHelper pageHelder() {
		PageHelper paggHelper = new PageHelper();
		Properties p = new Properties();
		//会将RowBounds第一个参数offset当成pageNum页码使用.
		p.setProperty("offsetAsPageNum", "true");
		//rowBoundsWithCount:设置为true时，使用RowBounds分页会进行count查询.
		p.setProperty("rowBoundWithCount","true");
		//启用合理化时，如果pageNum<1会查询第一页，如果pageNum>pages会查询最后一页。
		p.setProperty("reasonable", "true");
		paggHelper.setProperties(p);
		return paggHelper;
	}
}
