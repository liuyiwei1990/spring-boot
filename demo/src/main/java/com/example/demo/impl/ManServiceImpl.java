package com.example.demo.impl;

import org.bson.Document;
import org.springframework.stereotype.Service;

import com.example.demo.model.Man;
import com.example.demo.service.ManService;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

@Service
public class ManServiceImpl implements ManService {

	@Override
	public Man getManInfoById(int id) {
		// TODO Auto-generated method stub
		// 连接到 mongodb 服务
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		String DB_NAME = "runoob";
		String DB_COL = "runoob";
		StringBuffer sb = new StringBuffer();
		// 连接到数据库
		MongoDatabase mongoDatabase = mongoClient.getDatabase(DB_NAME);
		// 获取集合
		MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(DB_COL);
		FindIterable<Document> findIterable = mongoCollection.find();
		MongoCursor<Document> mongoCursor = findIterable.iterator();
		while (mongoCursor.hasNext()) {
			sb.append(mongoCursor.next());
		}
		mongoClient.close();
		Man man =new Man();
		man.setName(sb.toString());
		return man;
	}

}
