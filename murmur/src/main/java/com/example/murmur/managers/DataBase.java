package com.example.murmur.managers;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.*;

public class DataBase {
    private static final String connectionString = "mongodb+srv://marimix19:bLXH6aC6ElR2NqON@cluster0.kinbh5k.mongodb.net/?retryWrites=true&w=majority";
    private static final String databaseName = "murmur_db";
    private final MongoClient mongoClient;
    private final MongoDatabase database;
    private static DataBase INSTANCE;


    private DataBase(){
        MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(new ConnectionString(connectionString)).build();
        mongoClient = MongoClients.create(settings);
        database = mongoClient.getDatabase(databaseName);
    }

    public static DataBase getInstance(){
        if(INSTANCE == null){
            INSTANCE = new DataBase();
        }

        return INSTANCE;
    }

    public String insert(Map<String, Object> data, String collectionName) {
        Document document = new Document(data);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.insertOne(document);
        return document.get("_id").toString();
    }

    public Document get(String id, String collectionName) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        return collection.find(new Document("_id", new ObjectId(id))).first();
    }

    public Document getByFieldValue(String fieldName, String fieldValue, String collectionName) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        return collection.find(new Document(fieldName, fieldValue)).first();
    }

    public Object getFieldValue(String id, String fieldName, String collectionName) {
        Document result = INSTANCE.get(id, collectionName);

        if (result != null && result.containsKey(fieldName)) {
            return result.get(fieldName);
        }

        return null;
    }

    public void update(String id, String fieldName, Object fieldValue, String collectionName) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.updateOne(Filters.eq("_id", new ObjectId(id)), Updates.set(fieldName, fieldValue));
    }

    public void delete(String id, String collectionName) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.deleteOne(new Document("_id", new ObjectId(id)));
    }

    public void close() {
        mongoClient.close();
    }
}
