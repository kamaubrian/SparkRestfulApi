package com.brian.service;
import com.brian.model.blog;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by brian-kamau on 6/9/17.
 */
public class userService {
    MongoClient client = new MongoClient("localhost",27017);
    Datastore datastore = new Morphia().createDatastore(client,"blog");


    public String addPost(blog Blog){
        datastore.save(Blog);
        return "add post";
    }
    public List<blog> getAllPosts(){
        List<blog> list = datastore.find(blog.class).asList();
        if(!list.isEmpty()){
            return list;
        }
        return null;
    }
    public blog getPostbyName(String username){
        blog log = datastore.find(blog.class,"oth",username).get();
        if(log!=null){
            return log;
        }else{
            return null;
        }
    }

    public Object getData(String table) {
        //Declare variable results
        List<String> resultsArrayList  = new ArrayList<String>();
        //Check if tablel exists in database

        //Select all from table  if exists

        //Create list with the data
        //resultArrayList  = $select* from table ;
        //return this list
        return resultsArrayList;
    }
}
