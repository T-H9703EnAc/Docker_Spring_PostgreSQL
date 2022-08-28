package jp.com.app.exception;

public class DBException extends Exception{
    private String errorCode = "500";
    private  String errorMessage = "DBException Occurred!";
    
    public DBException(){}

    public DBException(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public DBException(String errorCode,String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getCode(){
        return this.errorCode;
    }

    public String getMessage(){
        return this.errorMessage;
    }
}
