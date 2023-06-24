package currencynbp.currency;

import org.springframework.core.StandardReflectionParameterNameDiscoverer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;

@RestControllerAdvice
public class CurrencyAdvice {

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<String> handleNotFound(HttpClientErrorException.NotFound e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nie znaleziono podanej waluty");
    }

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<String> handleBadRequest(HttpClientErrorException.BadRequest e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request");
    }

    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<String> handleServerError(HttpServerErrorException.InternalServerError e){
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("BAD GATEWAY");
    }

    @ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity<String> handleResource(ResourceAccessException e){
        return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body("GATEWAY TIMEOUT");
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRunTimeException(RuntimeException runtimeException) {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
    }

}
