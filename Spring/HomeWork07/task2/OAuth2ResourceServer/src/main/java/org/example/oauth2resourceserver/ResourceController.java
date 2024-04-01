package org.example.oauth2resourceserver;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ResourceController {
    @GetMapping("/smile")
    public ResponseEntity<byte[]> getSmile() throws IOException {
        Resource resource = new ClassPathResource("smile.png");
        byte[] image = StreamUtils.copyToByteArray(resource.getInputStream());
        return ResponseEntity.ok(image);
    }
}
