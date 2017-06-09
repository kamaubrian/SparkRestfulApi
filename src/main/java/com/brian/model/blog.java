package com.brian.model;

import com.sun.corba.se.spi.ior.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class blog {
    @Id
    private ObjectId id;
    private String title;
    private String description;
    private String oth;


    public blog(){
        //Constructor.
    }
    public blog(String title,String description,String oth){
        //Overloaded Constructor.
        this.description=description;
        this.title=title;
        this.oth=oth;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
}
