package com.ycbank.interfaces;

import com.ycbank.config.Config;

import java.sql.Connection;



public interface IDAO<T> {

    public Connection connect = Config.getInstance();

    public  T find(long id);
    public  T create(T obj);
    public  T update(T obj);
    public  void delete(T obj);

}

