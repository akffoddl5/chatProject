package com.project.chat.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.chat.friend.IFriendService;
import com.project.chat.user.IUserService;
import com.project.chat.user.UserVO;

@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IFriendService friendService;
	
	@RequestMapping(value="/login.go")
	public ModelAndView loginGo(ModelAndView mav){
		System.out.println("login.go");

		mav.setViewName("/login");
		return mav;
	}
	
	@RequestMapping(value="/login.do")
	public ModelAndView loginDo(UserVO user,ModelAndView mav , HttpServletRequest request) {
		System.out.println("=======user input ======");
		System.out.println(user.getId());
		System.out.println(user.getPassword());
		UserVO userVO = userService.selectUser(user);
		mav.setViewName("/login");
		if(userVO.getId() == null) {
			System.out.println("no id");
		}else if(user.getPassword().equals(userVO.getPassword())) {
			System.out.println("login success");
			HttpSession session = request.getSession();
			session.setAttribute("vo", userVO);
			mav.setViewName("redirect:index.go");
			return mav;
		}else {
			System.out.println("password error");
		}
		

		return mav;
	}
	// ---------------- 회占쏙옙占쏙옙占쏙옙 
	@RequestMapping(value="/join.go")
	public ModelAndView joinGo(ModelAndView mav){
		System.out.println("join.go");
		mav.setViewName("/join");
		return mav;
	}
	
	@RequestMapping(value = "/join.do")
	public ModelAndView joinDo(ModelAndView mav,UserVO user) {
		System.out.println("------Join USer Info--------");
		System.out.println(user);
		userService.insertUser(user);
		mav.setViewName("/login");
		return mav;
	}
	

	@RequestMapping(value = "/banCancle.do")
	public ModelAndView banCancle(ModelAndView mav,HttpServletRequest request) {
		System.out.println("banCancle exe");
		String myId = request.getParameter("myId");
		String banId = request.getParameter("banId");
		System.out.println(myId + " " + banId);
		userService.banCancle(myId, banId);
		
		mav.setViewName("/login");
		return mav;
	}
	
	@RequestMapping(value ="/addFriend.do")
	public ModelAndView addFriend(ModelAndView mav, HttpServletRequest request) {
		System.out.println("addFriend exe");
		String myId = request.getParameter("myId");
		String plusId = request.getParameter("plusId");
		System.out.println(myId + " " + plusId);
		UserVO tmpVO1 = new  UserVO();
		UserVO tmpVO2 = new UserVO();
		tmpVO1.setId(myId);
		tmpVO2.setId(plusId);
		UserVO getTmpVO2 = userService.selectUser(tmpVO2);
		List<UserVO> friendList1 = friendService.getMyFriends(tmpVO1);
		List<UserVO> friendList2 = friendService.getMyFriends(tmpVO2);
		boolean alreadyFriend = false;
		for(UserVO uVO : friendList1) {
			if(uVO.getId().equals(plusId)) {
				alreadyFriend = true;
			}
		}
		for(UserVO uVO : friendList2) {
			if(uVO.getId().equals(myId)) {
				alreadyFriend = true;
			}
		}
		
		if(alreadyFriend) {
			mav.addObject("data","already friend.");
		}else {
			if(getTmpVO2==null) {
				mav.addObject("data","not exist User");
			}else {
				friendService.addFriend(myId, plusId);
				mav.addObject("data",plusId + "plus complete.");
			}
			
		}
		
		mav.setViewName("/ajaxForPrint");
		return mav;
	}
	
	//----------------------占쏙옙占싱듸옙 占쌩븝옙체크 占쏙옙트占싼뤄옙
	@RequestMapping(value = "/idCheck")
	public int idCheck(@RequestParam("userId") String user_id) {	
		return userService.userIdCheck(user_id);
	}
	
	// ---------------------------회占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙 
	@RequestMapping(value = "/updateUser.do")
	public ModelAndView updateUser(ModelAndView mav,@RequestParam("profileImage") MultipartFile profileImage,UserVO user ,HttpServletRequest request) {
		System.out.println("------updateUser Info--------");
		
		System.out.println(profileImage.getOriginalFilename());
		if(profileImage.isEmpty()) {
			System.out.println("empty �릺湲댄븯�꽕");
			UserVO userVO = (UserVO)request.getSession().getAttribute("vo");
			if(userVO != null) {
				user.setThumbnailPath(userVO.getThumbnailPath());
			}
		}else {
			System.out.println("null �븘�떂");
			String imageName = profileImage.getOriginalFilename();
			ServletContext context = request.getServletContext();
			String saveDir = context.getRealPath("/resources/images/");
			File file1 = new File(saveDir + imageName);

			try {
				profileImage.transferTo(file1);

			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(saveDir + imageName);
			user.setThumbnailPath(imageName);
		}
		

		System.out.println(user);
		userService.updateUser(user);
		UserVO userVO = userService.selectUser(user);
		HttpSession session = request.getSession();
		session.setAttribute("vo", userVO);
		mav.setViewName("redirect:myProfile.go");
		return mav;

	}

}
