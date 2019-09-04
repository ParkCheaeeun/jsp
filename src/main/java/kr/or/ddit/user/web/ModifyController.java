package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.util.FileuploadUtil;

@WebServlet("/modify")
@MultipartConfig(maxFileSize = 1024*1024*5, maxRequestSize = 1024*1024*5*5)
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ModifyController.class);
    private UserService userService;
    
    @Override
    public void init() throws ServletException {
    	userService = new UserService();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		
		logger.debug("userId : {}", userId);
		
		User user = userService.getUser(userId);
		
		request.setAttribute("user", user);
		
		request.getRequestDispatcher("/user/modifyForm.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String userId = req.getParameter("userId");
		String userNm = req.getParameter("userNm");
		String alias = req.getParameter("alias");
		String reg_dt = req.getParameter("reg_dt");
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String zipcode = req.getParameter("zipcode");
		String pass = req.getParameter("pass");
		Date reg_dt_date = null;
		
		logger.debug("reg_dt : {}" , reg_dt);
		logger.debug("userId : {}" , userId);
		logger.debug("userNm : {}" , userNm);
		User user = userService.getUser(userId);
		File file = new File(user.getRealfilename());
		Part picture = req.getPart("picture");
		
		//사용자가 파일을 업로드한 경우
		String filename = "";
		String path = "";
		if(picture != null) {
			filename = FileuploadUtil.getFilename(picture.getHeader("Content-Disposition")); //사용자가 업로드한 파일명
			String realFilename = UUID.randomUUID().toString();
			String ext = FileuploadUtil.getFileExtension(picture.getHeader("Content-Disposition"));
			path = FileuploadUtil.getpath() + realFilename + ext;
			
			picture.write(path);
		}else {
			path = user.getFilename();
		}
		
		try {
			reg_dt_date = new SimpleDateFormat("yyyy-MM-dd").parse(reg_dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//validation
		Pattern p = Pattern.compile("^([a-zA-Z\\d\\.@]{5,20}$)");
		Matcher m = p.matcher(userId);
		if(!m.find()) {
			req.setAttribute("userIdMsg", "사용자 아이디가 잘못 되었습니다.");
			doGet(req, resp);
		}else {
			
			logger.debug("user parameter : {}, {}, {}, {}, {}, {}, {}, {}",
					userId, userNm, alias, reg_dt, addr1, addr2, zipcode, pass, filename, path);
			
			//사용자 등록
			User ModifiedUser = new User(userId, userNm, alias, reg_dt_date, addr1, addr2, zipcode, pass, filename, path);
			int updateCnt = 0;
			
			//비정상 테스트를 위해 데이터 조작
			updateCnt = userService.updateUser(ModifiedUser);
			
			//정상등록 : 사용자 상세화면으로 이동
			if(updateCnt == 1) {
				resp.sendRedirect(req.getContextPath() + "/user?userId=" + userId);
				
				if(file.exists() && picture != null) {
					logger.debug("file.exists() : {}", file.exists());
					file.delete();
				}
				else {
					logger.debug("file.exists() : {}", file.exists());
				}
			}
			//비정상 : 사용자 수정화면으로 이동
			else {
				doGet(req, resp);
			}
		}
	}

}
