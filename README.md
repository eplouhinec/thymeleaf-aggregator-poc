# thymeleaf-aggregator-poc
A webapp made with spring-boot using Thymeleaf and thymeleaf-layout-dialect.
The goal is to allow the use of a layout resource not localized in the classpath (like usual): on an HTTP server.

Here, the server used is the webserver of IntelliJ IDEA in this URL: http://localhost:63342/thymeleaf-aggregator-poc/src/main/resources/cms/layout.html
An other version of the layout is available in classpath, as a fallback, in the Thymeleaf usual folder: classpath:/src/main/resources/templates/layout.html
