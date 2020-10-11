package c1812m.happyfeet.commons;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomUtils {

    public ResponseEntity<Map<String, Object>> createResponse(Object data, HttpStatus status) {
        Map<String, Object> result = new HashMap<>();
        result.put("data", data);

        return new ResponseEntity<>(result, status);
    }

}
