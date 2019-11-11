package devfun.bookstore.rest.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration // 이 자바 클래스는 스프링 컨테이너에 의해 처리되는 구성파일이란것을 알려줌 
@ComponentScan(basePackages = {"devfun.bookstore.rest.controller"},
useDefaultFilters = false, includeFilters = {@Filter(Controller.class)})
// 스캔범위 설정
@EnableWebMvc // Spring Web MVC 사용을 위한 어노테이션
public class RestConfig extends WebMvcConfigurerAdapter {
	
	/*
	 * 웹 어플리케이션 설정 클래스
	 */
	
	// Json 사용 위해 필요 S
	/*
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(mappingJacksonHttpMessageConverter());
	}
	
	@Bean
	public MappingJackson2HttpMessageConverter mappingJacksonHttpMessageConverter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		return converter;
	}
	*/
	// Json 사용 위해 필요 E
	
	// XML 사용 위해 필요
	@Bean
	public Jaxb2Marshaller jaxb2Marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setPackagesToScan(new String[] {
				"devfun.bookstore.common.domain",
				"devfun.bookstore.rest.domain"
		});
		return marshaller;
	}
	
	@Bean
	public MarshallingHttpMessageConverter marshallingHttpMessageConverter() {
		MarshallingHttpMessageConverter converter = new MarshallingHttpMessageConverter();
		
		converter.setMarshaller(jaxb2Marshaller());
		converter.setUnmarshaller(jaxb2Marshaller());
		return converter;
	}
	
	@Override
	public void configureMessageConverters ( List<HttpMessageConverter<?>> converters) {
		converters.add(marshallingHttpMessageConverter());
	}
}
