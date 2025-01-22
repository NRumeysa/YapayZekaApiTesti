# API Test Otomasyon Projesi

Bu proje, ReqRes API'sini test etmek için oluşturulmuş bir API test otomasyon projesidir. Page Object Model (POM) tasarım deseni kullanılarak geliştirilmiştir. Proje, modern yazılım geliştirme süreçlerini destekleyen Windsurf IDE ve Cursor'un AI pair programming özellikleri kullanılarak geliştirilmiş olup, insan yaratıcılığı ve yapay zeka işbirliğinin güzel bir örneğini temsil etmektedir.

## Technologies Used

- Java 23
- Maven
- Cucumber
- REST Assured
- JUnit
- WebDriverManager

## Proje Yapısı 

src
├── main/java
│   └── com/apitest
│       └── Main.java
└── test
    ├── java
    │   ├── pages
    │   │   ├── BasePage.java
    │   │   └── UserPage.java
    │   ├── runners
    │   │   └── TestRunner.java
    │   └── steps
    │       └── UserSteps.java
    └── resources
        ├── features
        │   └── Kullanicilar.feature
        ├── cucumber.properties
        └── junit-platform.properties

## Özellikler

Proje aşağıdaki API işlemleri için test senaryolarını içerir:

1. Kullanıcı Listesini Getir
   - API'den kullanıcı listesini getirir
   - Başarılı yanıt ve veri yapısını doğrular

2. Kullanıcı Oluştur
   - Ad ve iş bilgisi ile yeni bir kullanıcı oluşturur
   - Oluşturma yanıtını ve kullanıcı verilerini doğrular

3. Kullanıcı Güncelle
   - Mevcut bir kullanıcının bilgilerini günceller
   - Güncelleme işleminin başarılı olduğunu doğrular

4. Kullanıcı Sil
   - Sisteme kayıtlı bir kullanıcıyı siler
   - Başarılı silme işlemini doğrular

## Kurulum ve Yükleme

1. Deposunu klonlayın:
   ```bash
   git clone https://github.com/NRumeysa/YapayZekaApiTesti.git
   ```

2. Bağımlılıkları yükleyin:
   ```bash
   mvn clean install
   ```

3. Aşağıdaki yazılımların yüklü olduğundan emin olun:
   - Java JDK 23 veya üzeri
   - Maven
   - Chrome tarayıcı (Selenium WebDriver testleri için)

## Testleri Çalıştırma

Tüm testleri çalıştırmak için:
```bash
mvn clean test
```

Belirli özelliklere ait testleri çalıştırmak için:
```bash
mvn test -Dcucumber.options="--tags @your_tag"
```

## Test Raporları

Testlerin çalıştırılmasının ardından raporları aşağıdaki yerlerde bulabilirsiniz:
- HTML Raporu: `target/cucumber-reports/cucumber.html`
- JSON Raporu: `target/cucumber-reports/cucumber.json`

## Yapılandırma

- `src/test/resources/cucumber.properties`: Cucumber yapılandırması
- `src/test/resources/junit-platform.properties`: JUnit yapılandırması
- Base URL ve diğer API yapılandırmaları `BasePage.java` dosyasında bulunabilir

## Katkıda Bulunma

1. Deposunu forklayın
2. Özellik dalınızı oluşturun (`git checkout -b feature/AmazingFeature`)
3. Değişikliklerinizi kaydedin (`git commit -m 'Add some AmazingFeature'`)
4. Değişikliklerinizi dalınıza gönderin (`git push origin feature/AmazingFeature`)
5. Bir çekme talebi açın

## Lisans

Bu proje açık kaynaklı ve [MIT Lisansı](LICENSE) altında kullanılabilir.