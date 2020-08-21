package spring.uploading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@ComponentScan
@EnableAutoConfiguration
public class UploadingFileApplication {

    public static void main(String[] args) {
        SpringApplication.run(UploadingFileApplication.class, args);
    }

//    @Bean
//    MultipartConfigElement multipartConfigElement() {
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        factory.setMaxFileSize(DataSize.parse("1MB"));
//        factory.setMaxRequestSize(DataSize.parse("1MB"));
//        return factory.createMultipartConfig();
//    }
}
