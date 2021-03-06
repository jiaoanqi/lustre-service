package com.evan.lustre.handler;

import com.evan.lustre.common.exception.*;
import com.evan.lustre.common.model.vo.ResponseVO;
import com.evan.lustre.common.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityNotFoundException;

import static com.evan.lustre.common.consts.Message.EXCEPTION_DETAIL_HINT;

/**
 * @ClassName GlobalExceptionHandler
 * @Description
 * @Author EvanWang
 * @Version 1.0.0
 * @Date 2019/12/15 23:14
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {
    /**
     * Handle an exception and response a result.
     * If you not give an exception class to @ExceptionHandler,It will handle exceptions of the type of the method parameter it is labeling.
     *
     * @param e exception
     * @return Response result(ResponseVO) from ResponseUtil.
     */
    @ExceptionHandler
    public ResponseEntity<ResponseVO> authenticateFailedException(AuthenticateFailedExceptionAbstract e) {
        log.error(EXCEPTION_DETAIL_HINT, e.toString());
        return ResponseUtil.authenticateFailedResponse(e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<ResponseVO> badRequestException(BadRequestExceptionAbstract e) {
        log.error(EXCEPTION_DETAIL_HINT, e.toString());
        return ResponseUtil.badRequestResponse(e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<ResponseVO> internalException(InternalExceptionAbstract e) {
        log.error(EXCEPTION_DETAIL_HINT, e.toString());
        return ResponseUtil.internalErrorResponse(e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<ResponseVO> notFoundException(NotFoundExceptionAbstract e) {
        log.error(EXCEPTION_DETAIL_HINT, e.toString());
        return ResponseUtil.notFoundResponse(e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<ResponseVO> notNoSuchAnnotationException(NoSuchAnnotationExceptionAbstract e) {
        log.error(EXCEPTION_DETAIL_HINT, e.toString());
        return ResponseUtil.internalErrorResponse(e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<ResponseVO> unAuthorizedException(UnAuthorizedExceptionAbstract e) {
        log.error(EXCEPTION_DETAIL_HINT, e.toString());
        return ResponseUtil.authenticateFailedResponse(e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<ResponseVO> entityNotFoundException(EntityNotFoundException e) {
        log.error(EXCEPTION_DETAIL_HINT, e.toString());
        return ResponseUtil.notFoundResponse("找不到当前id对应的数据，请检查后重新填写");
    }

    @ExceptionHandler
    public ResponseEntity<ResponseVO> notLoginException(NotLoginExceptionAbstract e) {
        log.error(EXCEPTION_DETAIL_HINT, e.toString());
        return ResponseUtil.notLoginRequestResponse(e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<ResponseVO> beanUtilException(BeanUtilExceptionAbstract e) {
        log.error(EXCEPTION_DETAIL_HINT, e.toString());
        return ResponseUtil.internalErrorResponse(e.getMessage());
    }

    /**
     * Unified handle exceptions which param is marked @Valid.
     *
     * @param e MethodArgumentNotValidException.
     * @return exception message.
     */
    @ExceptionHandler
    public ResponseEntity<ResponseVO> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(EXCEPTION_DETAIL_HINT, e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return ResponseUtil.badRequestResponse(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

}
