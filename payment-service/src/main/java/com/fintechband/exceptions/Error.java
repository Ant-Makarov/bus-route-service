package com.fintechband.exceptions;

import com.fintechband.util.Code;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Builder
@Getter
@ToString
public class Error implements Response {
    private Code code;
    private String message;
    private HttpStatus status;
}
