package com.audi.msi.damage;

import com.audi.msi.damage.domain.DamageModel;
import com.audi.msi.damage.repository.DamageModelRepository;
import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;

import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.schema.AlternateTypeRules.newRule;

@SpringBootApplication
@EnableSwagger2
public class DamageServiceApplication {

    @Autowired
    private DamageModelRepository damageModelRepository ;

    @Autowired
    private TypeResolver typeResolver;

    public static void main(String[] args) {
		SpringApplication.run(DamageServiceApplication.class, args);
	}

	@Bean
    public Docket petApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .directModelSubstitute(LocalDate.class,
                        String.class)
                .genericModelSubstitutes(ResponseEntity.class)
                .alternateTypeRules(
                        newRule(typeResolver.resolve(DeferredResult.class,
                                typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
                                typeResolver.resolve(WildcardType.class)))
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET,
                        newArrayList(new ResponseMessageBuilder()
                                .code(500)
                                .message("500 message")
                                .responseModel(new ModelRef("Error"))
                                .build()))
                .securitySchemes(newArrayList(apiKey()))
                .enableUrlTemplating(true)
                .globalOperationParameters(
                        newArrayList(new ParameterBuilder()
                                .name("someGlobalParameter")
                                .description("Description of someGlobalParameter")
                                .modelRef(new ModelRef("string"))
                                .parameterType("query")
                                .required(true)
                                .build()))
                .tags(new Tag("Pet Service", "All apis relating to pets"));
    }

    private ApiKey apiKey() {
        return new ApiKey("mykey", "api_key", "header");
    }

	@Bean
    public CommandLineRunner initTestData() {
	    return args -> {
            DamageModel model = new DamageModel();
            model.setReferenceNumber("123456");
            model.setDamageType(1L);
            model.setTotalDamage(3);
            damageModelRepository.save(model);

            model = new DamageModel();
            model.setReferenceNumber("789");
            model.setDamageType(1L);
            model.setTotalDamage(3);
            damageModelRepository.save(model);

            model = new DamageModel();
            model.setReferenceNumber("789");
            model.setDamageType(1L);
            model.setTotalDamage(3);
            damageModelRepository.save(model);

            model = new DamageModel();
            model.setReferenceNumber("789");
            model.setDamageType(1L);
            model.setTotalDamage(3);
            damageModelRepository.save(model);
        };
    }
}
