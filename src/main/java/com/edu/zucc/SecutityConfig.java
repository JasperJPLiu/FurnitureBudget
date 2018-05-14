package com.edu.zucc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by moshennlin on 2017/12/15.
 */
@Configuration
public class SecutityConfig extends WebMvcConfigurerAdapter {
    public final static String SESSION_KEY_USER = "user";
    public final static String SESSION_KEY_TYPE = "type";

    @Bean
    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());
        addInterceptor.excludePathPatterns("/login", "/fonts/**", "/css/**", "/js/**", "/images/**", "/register");
        addInterceptor.addPathPatterns("/api/**","/index","/skills","/knowledge","/product","/budget"
                ,"/BrandManager","/BudgetManager","/FurnitureManager","/KnowManager","/MaterialManager",
                "/MessageManager","/MaterialTypeManager","/ProductManager","/SkillManager","/TypeManager","/UserManager","/WorkerManager");
    }

    private class SecurityInterceptor extends HandlerInterceptorAdapter {
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute(SESSION_KEY_USER);
            if (session.getAttribute(SESSION_KEY_USER) != null)
                return true;
            String url = "/";
            response.sendRedirect(url);
            return false;
        }
    }
}
