package fr.eplouhinec.integration.spring;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.TemplateProcessingParameters;
import org.thymeleaf.resourceresolver.IResourceResolver;

import java.io.IOException;
import java.io.InputStream;

/**
 * HTTP {@linkplain IResourceResolver}. Search resource in a HTTP way.
 */
public class HttpResourceResolver implements IResourceResolver {

    private final Logger logger = LoggerFactory.getLogger(getName());
    public static final String NAME = "HTTP";

    private OkHttpClient okHttpClient;

    public HttpResourceResolver(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public InputStream getResourceAsStream(TemplateProcessingParameters templateProcessingParameters, String resourceName) {
        Request request = new Request.Builder().url(resourceName).build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body().source().inputStream();
            }
        } catch (IOException e) {
            logger.warn("An error occurred during HTTP call to " + resourceName, e);
        }
        return null;
    }

}