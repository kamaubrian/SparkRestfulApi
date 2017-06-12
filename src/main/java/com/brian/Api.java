package com.brian;
import com.google.gson.Gson;
import com.brian.model.blog;
import com.brian.service.userService;

import static spark.Spark.get;
import static spark.Spark.post;

/**
 * Created by brian-kamau on 6/9/17.
 */
public class Api {
    public static userService userservice = new userService();

    public static void main(String [] args){
        System.out.println("Welcome To The World Of Application Programming Interfaces.");
        final Gson gson = new Gson();
        post("/addpost",(req,res)->{
            res.type("application/json");
            blog Blog = gson.fromJson(req.body(),blog.class);
            return userservice.addPost(Blog);
        },gson::toJson);

        get("/api/v1/posts/:table",(req,res)->{
            res.type("application/json");
            String table = req.params(":table");
            System.out.println("this is the resource we want" + table);
//            return userservice.getAllPosts();
            return userservice.getData(table);
        },gson::toJson);

        get("/:username",(req,res)->{
            res.type("application/json");
            blog log = userservice.getPostbyName(req.params("username"));
            if(log!=null){
                return log;
            }else{
                return "Post Not Found";
            }
        },gson::toJson);
    }
}
