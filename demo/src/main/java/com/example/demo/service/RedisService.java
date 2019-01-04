package com.example.demo.service;

import com.example.demo.model.RedisModel;

public interface RedisService {
	RedisModel getRedisValueByKey(String key);
}
