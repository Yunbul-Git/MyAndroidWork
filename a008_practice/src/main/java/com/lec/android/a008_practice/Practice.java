package com.lec.android.a008_practice;

public class Practice {
    String name;
    String age;
    String address;

    public Practice() {
    }

    public Practice(String name, String age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
}//end Practice
