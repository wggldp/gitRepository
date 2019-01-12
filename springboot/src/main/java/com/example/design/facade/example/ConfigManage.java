package com.example.design.facade.example;

public class ConfigManage {

    private static ConfigManage configManage=null;
    private static ConfigModel configModel=null;
    public ConfigManage(){

    }
    public static ConfigManage getInstance(){
        if(configManage==null){
            configManage=new ConfigManage();
            configModel=new ConfigModel();
        }
        return configManage;
    }

    public ConfigModel getConfigData(){
        return configModel;
    }
}
