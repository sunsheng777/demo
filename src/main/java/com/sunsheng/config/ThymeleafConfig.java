package com.sunsheng.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.messageresolver.SpringMessageResolver;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
public class ThymeleafConfig implements ApplicationContextAware {
    private static final String UTF8 = "UTF-8";
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    private SpringResourceTemplateResolver htmlTemplateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(this.applicationContext);
        templateResolver.setPrefix("classpath:/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCacheable(false);
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }

    @Autowired
    private MessageSource messageSource;

    // 如果显示 ??x_zh_CN??, 缺少spring-context-support
    private SpringTemplateEngine templateEngine(SpringResourceTemplateResolver templateResolver) {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver);
//        templateEngine.setEnableSpringELCompiler(false);
//        return templateEngine;

        SpringTemplateEngine  templateEngine  = new SpringTemplateEngine();
        SpringMessageResolver messageResolver = new SpringMessageResolver();  //
        messageResolver.setMessageSource(messageSource);                      // 加入这三行，即为解决方案
        templateEngine.setMessageResolver(messageResolver);                   //
        templateEngine.setTemplateResolver(templateResolver);
        templateEngine.setEnableSpringELCompiler(false);
        return templateEngine;

    }

    @Bean
    public ViewResolver htmlViewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setApplicationContext(applicationContext);
        resolver.setTemplateEngine(templateEngine(htmlTemplateResolver()));
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }
}
