package tamrin.repository;

import java.sql.*;

public class StudentRepository {
    static final String url = "jdbc:oracle:thin:@192.168.100.121:1521/lcdev";
    static final String user = "train";
    static final String pass = "train";
    private Connection getConnection() {
        Connection connection = null;
        try {
            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }
    private void close(){
        try {
            getConnection().close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public void findById(){
        PreparedStatement preparedStatement=null;
        try {
             preparedStatement = getConnection().prepareStatement("select * from STUDENT where id='2000'");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println("id: " + resultSet.getInt(1)
                        + "  name: " + resultSet.getString(2)
                        + "  family: " + resultSet.getString(3)
                        + "  age: " + resultSet.getInt(4));
                System.out.println("---------***********************-------------");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public void findAll()  {
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement = getConnection().prepareStatement("select * from STUDENT");
           ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("id: " + resultSet.getInt(1)
                        + "  name: " + resultSet.getString(2)
                        + "  family: " + resultSet.getString(3)
                        + "  age: " + resultSet.getInt(4));
                System.out.println("---------***********************-------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close();
        }
    }
    public void insert() {
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement =
                    getConnection().prepareStatement("insert into STUDENT (ID,FIRSTNAME,LASTNAME,STU_AGE) values (?,?,?,?)");
            preparedStatement.setInt(1, 2006);
            preparedStatement.setString(2, "moh");
            preparedStatement.setString(3, "n");
            preparedStatement.setInt(4, 25);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("exception");
        }finally {
            close();
        }
    }
    public void update(){
        PreparedStatement preparedStatement=null;
        try{

            preparedStatement=getConnection().prepareStatement("update STUDENT SET FIRSTNAME= ?,LASTNAME= ?,STU_AGE= ? where ID= ?");
            preparedStatement.setString(1,"'hadis'");
            preparedStatement.setString(2,"moharamnezha");
            preparedStatement.setInt(3,24);
            preparedStatement.setInt(4,2002);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("exception");
        }finally {
            close();
        }
    }
    public void delete(){
        PreparedStatement preparedStatement=null;
        try{

            preparedStatement=getConnection().prepareStatement("delete STUDENT where ID= ?");
            preparedStatement.setInt(1,2002);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("exception");
        }finally {
            close();
        }
    }
}
