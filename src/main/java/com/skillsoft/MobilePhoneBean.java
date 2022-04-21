package com.skillsoft;

import com.mysql.cj.jdbc.MysqlDataSource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Named;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Named("PhoneBean")
@RequestScoped
public class MobilePhoneBean implements Serializable {

    private String repoName="Qenel Repo";
    Connection connection;
    String brandName;
    String productName;
    String os;
    int storageCapacity;
    int ram;


    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public static Connection getDataSourceConnection() throws SQLException{

        MysqlDataSource getDS=null;

        try{
            getDS=new MysqlDataSource();

            getDS.setURL("jdbc:mysql://localhost:3306/Products");
            getDS.setUser("root");
            getDS.setPassword("");
        } catch (Exception e){
            e.printStackTrace();
        }
        return getDS.getConnection();
    }

    public ArrayList getPhones(){

        ArrayList<MobilePhone> listOfPhones=new ArrayList<>();

        try{
            connection=getDataSourceConnection();
            Statement stmt=connection.createStatement();

            ResultSet rs = stmt.executeQuery("select * from phones");

            while(rs.next()){
                MobilePhone phone = new MobilePhone();
                phone.setId(rs.getInt("id"));
                phone.setBrandName(rs.getString("brandName"));
                phone.setProductName(rs.getString("productName"));
                phone.setOs(rs.getString("os"));
                phone.setStorageCapacity(rs.getInt("storageCapacity"));
                phone.setRam(rs.getInt("ram"));
                listOfPhones.add(phone);
            }
            connection.close();
        } catch (Exception e){
            System.out.println(e);
        }
        return listOfPhones;
    }

    public String save(){
        int result=0;

        try{
            connection=getDataSourceConnection();
            PreparedStatement stmt=connection.prepareStatement(
                    "insert into phones (brandName, productName, os, storageCapacity, ram)"+
                     "values(?,?,?,?,?)");
            stmt.setString(1,brandName);
            stmt.setString(2,productName);
            stmt.setString(3,os);
            stmt.setInt(4,storageCapacity);
            stmt.setInt(5,ram);
            result=stmt.executeUpdate();
            connection.close();

        } catch (Exception e){
            System.out.println(e);
        }
        if(result!=0){
            return "view.xhtml?faces-redirect=true";
        }else{
            return "create.xhtml?faces-redirect=true";
        }
    }
}
