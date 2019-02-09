package ua.bryzhatov.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ua.bryzhatov.controller")
public class WebConfig extends WebMvcConfigurerAdapter {
    @Bean
    public ViewResolver getViewResolver() {
        FreeMarkerViewResolver freeMarker = new FreeMarkerViewResolver();
        freeMarker.setOrder(1); // порядок загрузки
        freeMarker.setSuffix(".ftl"); // расширение файлов
        return freeMarker;
    }

    @Bean
    public FreeMarkerConfigurer getFreeMarkerConfigurer(){
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPaths("/", "/WEB-INF/views"); // где будут лежать темплейты
        return configurer;
    }
}
