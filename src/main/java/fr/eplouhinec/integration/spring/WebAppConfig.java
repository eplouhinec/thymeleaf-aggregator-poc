package fr.eplouhinec.integration.spring;

import com.squareup.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.templateresolver.TemplateResolver;

import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableWebMvc
public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient();
    }

    @Bean
    public TemplateResolver httpTemplateResolver() {
        TemplateResolver templateResolver = new TemplateResolver();
        Set<String> patterns = new HashSet<>();
        patterns.add("cms/*");

        templateResolver.setResolvablePatterns(patterns);
        templateResolver.setPrefix("http://localhost:63342/thymeleaf-aggregator-poc/src/main/resources/");
        templateResolver.setOrder(1);
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setTemplateMode("LEGACYHTML5");
        templateResolver.setCacheable(true);
        templateResolver.setCacheTTLMs(3600L);

        HttpResourceResolver httpResourceResolver = new HttpResourceResolver(okHttpClient());
        templateResolver.setResourceResolver(httpResourceResolver);
        return templateResolver;
    }
}
