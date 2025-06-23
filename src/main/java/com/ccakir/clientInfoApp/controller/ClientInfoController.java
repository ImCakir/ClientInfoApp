package com.ccakir.clientInfoApp.controller;

import com.ccakir.clientInfoApp.ClientInfo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@Scope("request")
@RequestMapping("dev/api/info")
public class ClientInfoController {

    private final HttpServletRequest request;
    private final LocalDateTime timestamp;

    public ClientInfoController(HttpServletRequest request, LocalDateTime timestamp) {
        this.request = request;
        this.timestamp = timestamp;
    }

    @GetMapping("default")
    public ClientInfo getDefaultClientInfo() {
        int localPort = request.getLocalPort();
        String remoteHost = request.getRemoteHost();

        return new ClientInfo("Unknown", "Unknown", 0, remoteHost, localPort, timestamp);
    }

    @GetMapping("detailed")
    public ClientInfo getClientInfoWithParams(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "surname") String surname,
            @RequestParam(name = "age") int age) {

        int localPort = request.getLocalPort();
        String remoteHost = request.getRemoteHost();

        return new ClientInfo(name, surname, age, remoteHost, localPort, timestamp);
    }
}
