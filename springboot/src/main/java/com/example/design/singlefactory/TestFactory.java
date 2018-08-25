package com.example.design.singlefactory;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestFactory {

    //私有化 构造
    private TestFactory(){

    }
    //静态工厂
    public static Api createApi(){
        //选择合适的实现类创建实例对象

        //返回实例对象
        Properties p=new Properties();
        InputStream inputStream=null;
        Api api=null;
        try {
            inputStream=TestFactory.class.getResourceAsStream("TestFactory.properties");
            p.load(inputStream);
            api= (Api) Class.forName(p.getProperty("ImplAClass")).newInstance();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if (inputStream!=null){
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return api;
    }
}
