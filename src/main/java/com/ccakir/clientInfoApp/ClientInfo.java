package com.ccakir.clientInfoApp;

import java.time.LocalDateTime;

public class ClientInfo {

    private final String name;
    private final String surname;
    private final int age;
    private final String remoteHost;
    private final long localPort;
    private final LocalDateTime localDateTime;

    public ClientInfo(String name, String surname, int age, String remoteHost, long localPort, LocalDateTime localDateTime) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.remoteHost = remoteHost;
        this.localPort = localPort;
        this.localDateTime = localDateTime;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getRemoteHost() {
        return remoteHost;
    }

    public long getLocalPort() {
        return localPort;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
