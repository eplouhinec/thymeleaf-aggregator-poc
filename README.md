# thymeleaf-aggregator-poc
A webapp made with [Spring Boot](https://github.com/spring-projects/spring-boot) using [Thymeleaf](https://github.com/thymeleaf/thymeleaf) and [Thymeleaf Layout Dialect](https://github.com/ultraq/thymeleaf-layout-dialect).

The goal is to allow the use of a layout resource not localized in the classpath (like usual): on an HTTP server.

## How it works
- The remote HTTP server configured is the webserver of IntelliJ IDEA in this URL: `http://localhost:63342/thymeleaf-aggregator-poc/src/main/resources/cms/layout.html`
- An other version of the layout is available in classpath, as a fallback, in the folder `/src/main/resources/templates`: `classpath:/src/main/resources/templates/cms/layout.html`.

## Run it

* Go to [http://localhost:8080/decorate](http://localhost:8080/decorate)
* If page title is "_This page uses the HTTP layout_": it found the layout on `http://localhost:63342/thymeleaf-aggregator-poc/src/main/resources/cms/layout.html`.
* If page title is "_This page uses the classpath layout_": it does not found the layout on `http://localhost:63342/thymeleaf-aggregator-poc/src/main/resources/cms/layout.html` and used `classpath:/src/main/resources/templates/cms/layout.html` instead.
