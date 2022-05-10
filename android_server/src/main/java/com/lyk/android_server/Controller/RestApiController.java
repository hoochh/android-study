package com.lyk.android_server.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lyk.android_server.model.User;
import com.lyk.android_server.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor // 주입할 필드가 여러개일 때 모두 생성자를 만들고 주입해줌
//body에 값이 전달되어야 안드로이드에서 사용 가능
public class RestApiController {
	
	private final UserRepository userRepository;
	
	@GetMapping("getUser/{id}")
	public User getUser(@PathVariable("id") Long id) {
		return userRepository.findById(id).get();
	}
	
	@PostMapping("insert")
	public String insertUser(@RequestBody User user) {
		userRepository.save(user);
		return "datasave";
	}
	
	@GetMapping("list")
	public Map<String,List<User>> getList(){
		Map<String,List<User>> map=new HashMap<String, List<User>>();
		map.put("users", userRepository.findAll());
		return map;
	}
}
