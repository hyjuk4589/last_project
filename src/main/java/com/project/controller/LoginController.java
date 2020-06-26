package com.project.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.project.dao.UserDAO;
import com.project.dto.UserDTO;
import com.test.tst.NaverLoginBO;

import javafx.scene.control.Alert;
/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	@Autowired
	private UserDAO dao;
	
	/* NaverLoginBO */
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;
	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}
	//로그인 첫 화면 요청 메소드
	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Model model, HttpSession session) {
		/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		//https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
		//redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
		System.out.println("네이버:" + naverAuthUrl);
		//네이버
		model.addAttribute("url", naverAuthUrl);
		
		return "login&join/login";
	}
	//네이버 로그인 성공시 callback호출 메소드
	@RequestMapping(value = "/callback", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session) throws IOException, ParseException {
		System.out.println("여기는 callback");
		OAuth2AccessToken oauthToken;
		oauthToken = naverLoginBO.getAccessToken(session, code, state);
		System.out.println(oauthToken);
		//1. 로그인 사용자 정보를 읽어온다.
		apiResult = naverLoginBO.getUserProfile(oauthToken); //String형식의 json데이터
		/** apiResult json 구조
{"resultcode":"00",
"message":"success",
"response":{"id":"33666449","nickname":"shinn****","age":"20-29","gender":"M","email":"sh@naver.com","name":"\uc2e0\ubc94\ud638"}}
		 **/
		//2. String형식인 apiResult를 json형태로 바꿈
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(apiResult);
		JSONObject jsonObj = (JSONObject) obj;
		//3. 데이터 파싱
		//Top레벨 단계 _response 파싱
		JSONObject response_obj = (JSONObject)jsonObj.get("response");
		//response의 nickname값 파싱
		String name = (String)response_obj.get("name");
		String nickname = (String)response_obj.get("nickname");
		String email = (String)response_obj.get("email");
		String gender = (String)response_obj.get("gender");
		String age = (String)response_obj.get("age");
//		String token = (String)response_obj.get("access_token");
//		System.out.println(token);
		int idx = email.indexOf("@"); 
		String id = email.substring(0,idx);
		System.out.println(id);
		
		//4.파싱 닉네임 세션으로 저장
		
//		if(dao.select(id) ==null) {
			UserDTO dto = new UserDTO();
			dto.setId(id);dto.setName(name);
			
			model.addAttribute("NaverDto", dto);
			return "login&join/join";
//		}else {
//			System.out.println("이미존재하는 회원입니다");
//			return "redirect:index";
//		}
//		
		//"nid.naver.com/oauth2.0/token?grant_type=delete&client_id=Kw8vD_2MRNtNf4TERrlM&client_secret=nfGVNN_nu7&access_token="
//		+ "AAAAN_LCbVdhtfBQxzlMnQ2eqTVupLkpDvSCH4p7AzX6pOEu8Km7G0722fmlWmrn9haz_6BRsm_4X_DNGYoadZNOO7k&service_provider=NAVER";
			
//			<form action="fileUpload" method="post" enctype="multipart/form-data" name="fname" target="param">
//			<input type="file" id="file" name="file" onchange="changeValue(this)" style="display:none; "/>
//		</form>
//		<iframe id="if" name="param" style="display:none;"></iframe>
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index";
	}
	
}

