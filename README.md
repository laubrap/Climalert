# Climalert

Sistema de monitoreo climático y envío automático de alertas, desarrollado con Spring Boot para la cátedra de Diseño de Sistemas de Información (UTN FRBA).

1. Creá `src/main/resources/application.yaml`:
```yaml
spring:
  application:
    name: climalert
  mail:
    host: smtp.gmail.com
    port: 587
    username: ${GMAIL_USERNAME:tu-correo@gmail.com}
    password: ${GMAIL_APP_PASSWORD:tu-contrasena-de-aplicacion}
    properties:
      mail:
        smtp:
          auth: true
          starttls:
            enable: true
 
weatherapi:
  base-url: http://api.weatherapi.com/v1
  key: ${WEATHERAPI_KEY:tu-api-key-de-weatherapi}
  location: "Cape Verde"
```

2. Reemplazá los valores por default, o seteá variables de entorno (`GMAIL_USERNAME`, `GMAIL_APP_PASSWORD`, `WEATHERAPI_KEY`) en vez de hardcodear los reales en el archivo.
3. **Contraseña de aplicación de Gmail**: requiere verificación en dos pasos activada en la cuenta. Se genera en [myaccount.google.com/apppasswords](https://myaccount.google.com/apppasswords).
4. **API key de WeatherAPI**: se obtiene registrándose gratis en [weatherapi.com](https://www.weatherapi.com/).
