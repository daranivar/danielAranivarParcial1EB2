package com.elaparato.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/anonymous")
    public ResponseEntity<String> getAnonymous(){
        return ResponseEntity.ok("Hello Anonymous");
    }
    @GetMapping("/admin")
    public ResponseEntity<String> getAdmin() {
        return ResponseEntity.ok("Hello Admin");
    }

    @GetMapping("/vendedor")
    public ResponseEntity<String> getVendedor() {
        return ResponseEntity.ok("Hello vendedor");
    }

    @GetMapping("/repositor")
    public ResponseEntity<String> getRepositor() {
        return ResponseEntity.ok("Hello repositor");
    }

}
