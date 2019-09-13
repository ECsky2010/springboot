package springboot.Controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@RequestMapping("/uploadPage")
	public String uploadPage() {
		return "uploadPage";
	}
	@RequestMapping(value = "/upload",method = RequestMethod.POST)
	public String upload(HttpServletRequest request,@RequestParam("file") MultipartFile file,Model m) {
		try {
			String filename = System.currentTimeMillis()+file.getOriginalFilename();
			String destFileName = request.getServletContext().getRealPath("")+"uploaded"+File.separator+filename;
			File destFile = new File(destFileName);
			destFile.getParentFile().mkdirs();
			file.transferTo(destFile);
			m.addAttribute("filename",filename);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "showImg";
	}
}
