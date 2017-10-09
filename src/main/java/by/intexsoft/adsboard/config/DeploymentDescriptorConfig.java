package by.intexsoft.adsboard.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DeploymentDescriptorConfig extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{ApplicationDataConfig.class};
    }

   @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{DispatcherServletContextConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/api/*"};
    }
}