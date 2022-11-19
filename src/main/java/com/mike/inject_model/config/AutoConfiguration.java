package com.mike.inject_model.config;

import com.mike.inject_model.resolvers.InjectModelResolver;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@AllArgsConstructor
@Configuration
public class AutoConfiguration implements WebMvcConfigurer {

    ApplicationContext applicationContext;

    /**
     * @param argumentResolvers for register the inject model
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(injectModel());
    }

    /**
     * @return create an inject model with application context
     */
    private HandlerMethodArgumentResolver injectModel() {
        return applicationContext.getBean(InjectModelResolver.class);
    }
}
