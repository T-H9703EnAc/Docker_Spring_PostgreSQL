package jp.com.app.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {
    /**
     * @ResponseStatus ステータスコード 500
     * @ExceptionHandler 対象のExceptionクラス
     * @param ex 対象のExceptionクラス
     * @param request WebRequest
     * @return handleExceptionInternal
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ DBException.class })
    public ResponseEntity<Object> dbHandler(DBException ex, WebRequest request){
        ErrorMessage message = new ErrorMessage();
        message.setErrorMessage(ex.getMessage());       
        return super.handleExceptionInternal(ex, message, new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR,request);
    }
}
