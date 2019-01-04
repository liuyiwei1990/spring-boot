package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Man;
import com.example.demo.model.RedisModel;
import com.example.demo.model.User;
import com.example.demo.service.ManService;
import com.example.demo.service.RedisService;
import com.example.demo.service.UserService;

@RestController
public class IndexController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/getUserById", method = RequestMethod.GET)
	public User getUserById(@RequestParam int id) {
		User user = userService.getUserById(id);
		return user;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public Map<String, String> index() {
		Map map = new HashMap<String, String>();
		map.put("老夫子", "是个教授");
		map.put("孙悟空", "是个猴精");
		return map;
	}

	@Autowired
	private ManService manService;

	@RequestMapping(value = "/getManInfoById", method = RequestMethod.GET)
	public Man getManInfoById(@RequestParam int id) {
		Man man = manService.getManInfoById(id);
		return man;
	}

	@Autowired
	private RedisService redisService;

	@RequestMapping(value = "/getRedisValueByKey", method = RequestMethod.GET)
	public RedisModel getRedisValueByKey(@RequestParam String key) {
		RedisModel redisModel = redisService.getRedisValueByKey(key);
		return redisModel;
	}
}
