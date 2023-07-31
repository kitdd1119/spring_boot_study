package com.example.hr1.domain.temp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/temp")
public class TempControllerApiV1 {
    
    @GetMapping("/200")
    public ResponseEntity<?> get200() {
        return new ResponseEntity<>("성공", HttpStatus.OK);
    }

    @GetMapping("/400")
    public ResponseEntity<?> get400(){
        return new ResponseEntity<>("잘못된 요청입니다.", HttpStatus.BAD_REQUEST);
    }

    // 401 UNAUTHORIZED
    @GetMapping("/401")
    public ResponseEntity<?> get401(){
        return new ResponseEntity<>("클라이언트가 인증되지 않은 상태입니다.", HttpStatus.UNAUTHORIZED);
    }
    // 403 FORBIDDEN
    @GetMapping("/403")
    public ResponseEntity<?> get403(){
        return new ResponseEntity<>("리소스에 대한 권한이 없습니다.", HttpStatus.FORBIDDEN);
    }
    // 404 NOT_FOUND
    @GetMapping("/404")
    public ResponseEntity<?> get404(){
        return new ResponseEntity<>("요청한 리소스를 찾을 수 없습니다.", HttpStatus.NOT_FOUND);
    }
    // 405 METHOD_NOT_ALLOWED
    @GetMapping("/405")
    public ResponseEntity<?> get405(){
        return new ResponseEntity<>("허용되지 않은 메서드를 사용하였습니다.", HttpStatus.METHOD_NOT_ALLOWED);
    }
    // 500 INTERNAL_SERVER_ERROR
    @GetMapping("/500")
    public ResponseEntity<?> get500(){
        return new ResponseEntity<>("서버 내부에 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
