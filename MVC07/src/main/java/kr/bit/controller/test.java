package kr.bit.controller;

import java.util.*;

import com.google.gson.Gson;

public class test {
public static void main(String[] args) {
	List<testclass> foo = new ArrayList<testclass>();
    foo.add(new testclass());
    foo.add(new testclass(1,"k"));
    foo.add(new testclass(2,"s"));
    
    String json = new Gson().toJson(foo);
    System.out.println(json);
}
	
}
