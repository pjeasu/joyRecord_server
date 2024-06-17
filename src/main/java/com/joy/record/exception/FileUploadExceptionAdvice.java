package com.joy.record.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class FileUploadExceptionAdvice {

    /**
     * 파일 크기 초과 예외를 처리합니다.
     *
     * @param exc 예외 객체
     * @param redirectAttributes 리다이렉트 속성
     * @return 리다이렉트할 URL
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseStatus(HttpStatus.PAYLOAD_TOO_LARGE)
    public String handleMaxSizeException(MaxUploadSizeExceededException exc, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "파일 크기가 너무 큽니다. 최대 업로드 크기를 확인해주세요.");
        return "redirect:/uploadStatus";
    }

    /**
     * 잘못된 파일 형식 예외를 처리합니다.
     *
     * @param exc 예외 객체
     * @param redirectAttributes 리다이렉트 속성
     * @return 리다이렉트할 URL
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleIllegalArgumentException(IllegalArgumentException exc, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", exc.getMessage());
        return "redirect:/uploadStatus";
    }
}