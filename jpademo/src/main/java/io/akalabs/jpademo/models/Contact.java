package io.akalabs.jpademo.models;

import jakarta.persistence.*;

@Entity
@Table(name="contacts")
public class Contact {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String email;

    private String mobile;

    private String status;

    private long lastModified;

    public Contact() {
        super();
    }

    public Contact(Long id,String name,String email,String mobile, String status, long lastModified){
        this.id=id;
        this.name=name;
        this.email=email;
        this.mobile=mobile;
        this.status=status;
        this.lastModified=lastModified;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getMobile(){
        return mobile;
    }

    public void setMobile(String mobile){
        this.mobile=mobile;
    }

       public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status=status;
    }

       public long getLastModified(){
        return lastModified;
    }

    public void setLastModified(long lastModified){
        this.lastModified=lastModified;
    }

}
