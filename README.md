# Client Info App

Bu proje, istemciden alınan bilgileri ve bağlantı detaylarını döndüren basit bir **Spring Boot** REST API uygulamasıdır.

## Özellikler

- İstemcinin ad, soyad ve yaş bilgilerini HTTP parametreleri üzerinden alır.
- HTTP isteği üzerinden istemcinin IP adresi ve sunucu portunu algılar.
- Her istekte geçerli olan bir zaman damgası (timestamp) üretir.
- JSON formatında bir `ClientInfo` nesnesi döner.

## API Endpoint'leri

### 1. `GET /dev/api/info/default`

İstemciden herhangi bir parametre almaz. Varsayılan (bilinmeyen) değerler ile birlikte bağlantı bilgilerini döner.

#### Örnek Yanıt:
```json
{
  "name": "Unknown",
  "surname": "Unknown",
  "age": 0,
  "remoteHost": "127.0.0.1",
  "localPort": 8080,
  "timestamp": "2025-06-23T14:23:45.123"
}
```

### 2. `GET /dev/api/info/detailed`

Ad, soyad ve yaş bilgilerini query parametreleri ile alır ve bu bilgileri yanıt olarak döner.

```
Parametreler:
name (String) – Kullanıcının adı
surname (String) – Kullanıcının soyadı
age (int) – Kullanıcının yaşı
```
Örnek İstek:

###  `GET /dev/api/info/detailed?name=Ali&surname=Veli&age=30

Örnek Yanıt:
```json

{
  "name": "Ali",
  "surname": "Veli",
  "age": 30,
  "remoteHost": "192.168.1.10",
  "localPort": 8080,
  "timestamp": "2025-06-23T14:25:12.789"
}
```

### Notlar

timestamp değeri her HTTP isteği için yeniden oluşturulur. Bunun sebebi, @Scope("request") anotasyonu sayesinde her istekte yeni bir ClientInfoController nesnesi oluşturulmasıdır.
Geliştirme ortamında remoteHost değeri genellikle localhost olur. Gerçek istemci IP'sini görmek için uygulamayı bir ağ üzerinden test etmeniz önerilir.

