package springboot.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest request,Exception e) throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception",e);
		mav.addObject("url",request.getRequestURL());
		mav.setViewName("errorpage");
		return mav;
	}
}
