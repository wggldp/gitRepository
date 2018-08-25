package com.example.design.facade.example;

public class Presentation {

    public  void gennerate(){
        ConfigModel configData = ConfigManage.getInstance().getConfigData();
        if(configData.isNeedPre()){
            System.out.println("aa");
        }
    }
}
