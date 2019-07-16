package com.sgb.entity;

public class User {
    private Integer id;

    private String image;

    private String username;
    //    @NotEmpty(message = "不能为空")
    private String password;
    private Integer sex;
    private String birth;

//    public User(String image, String username, String password, Integer sex, String birth) {
//        this.image = image;
//        this.username = username;
//        this.password = password;
//        this.sex = sex;
//        this.birth = birth;
//    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", birth='" + birth + '\'' +
                '}';
    }
}


