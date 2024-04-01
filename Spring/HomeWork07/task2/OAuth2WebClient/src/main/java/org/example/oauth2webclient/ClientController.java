package org.example.oauth2webclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;
import java.util.Base64;

@Controller
public class ClientController {
    private final OAuth2AuthorizedClientService authorizedClientService;

    public ClientController(OAuth2AuthorizedClientService authorizedClientService) {
        this.authorizedClientService = authorizedClientService;
    }

    @GetMapping
    public String getCat(Model model, Principal principal) {
        RestTemplate template = new RestTemplate();
        String accessToken = authorizedClientService
                .loadAuthorizedClient("reg-client", principal.getName())
                .getAccessToken().getTokenValue();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "Bearer " + accessToken);
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        ResponseEntity<byte[]> response =
                template.exchange("http://localhost:8082/smile",
                        HttpMethod.GET, entity, byte[].class);

        String image = Base64.getEncoder().encodeToString(response.getBody());
        model.addAttribute("image", image);

        return "smile";
    }
}
