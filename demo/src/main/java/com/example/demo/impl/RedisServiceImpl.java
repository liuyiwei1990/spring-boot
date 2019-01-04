package com.example.demo.impl;

import org.springframework.stereotype.Service;

import com.example.demo.model.RedisModel;
import com.example.demo.service.RedisService;

import redis.clients.jedis.Jedis;

@Service
public class RedisServiceImpl implements RedisService {

	@Override
	public RedisModel getRedisValueByKey(String key) {
		// TODO Auto-generated method stub
		RedisModel redisModel = new RedisModel();
		@SuppressWarnings("resource")
		Jedis jedis = new Jedis("localhost");
		redisModel.setKey(key);
		redisModel.setValue(jedis.get(key));
		return redisModel;
	}

}
