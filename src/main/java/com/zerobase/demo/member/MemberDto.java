package com.zerobase.demo.member;

public class MemberDto {

    private String userId;

    private String password;

    private String userName;

    private String email;
    private String phone;

    private String role;



    public String getUserId() {

        return userId;

    }

    public void setUserId(String userId) {

        this.userId = userId;

    }



    public String getPassword() {

        return password;

    }

    public void setPassword(String password) {

        this.password = password;

    }



    public String getUserName() {

        return userName;

    }

    public void setUserName(String userName) {

        this.userName = userName;

    }




    public String getPhone() {

        return phone;

    }

    public void setPhone(String phone) {

        this.phone = phone;

    }

    public String getEmail() {

        return email;

    }

    public void setEmail(String email) {

        this.email = email;

    }

    public String getRole() {

        return role;

    }

    public void setRole(String role) {

        this.role = role;

    }





    @Override

    public String toString() {

        String str = String.format("아이디:%s \n이름:%s \n주민번호:%s \n이메일:%s \n",

                userId, userName, email, role);



        return str;

    }
}

