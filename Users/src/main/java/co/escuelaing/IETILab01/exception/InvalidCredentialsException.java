package co.escuelaing.IETILab01.exception;

import co.escuelaing.IETILab01.data.ErrorCodeEnum;
import co.escuelaing.IETILab01.dto.ServerErrorResponseDto;
import org.springframework.http.HttpStatus;

import javax.ws.rs.InternalServerErrorException;

public class InvalidCredentialsException extends InternalServerErrorException {

    ServerErrorResponseDto s;
    public InvalidCredentialsException() {
        super();
        s = new ServerErrorResponseDto("User not found", ErrorCodeEnum.USER_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
}
