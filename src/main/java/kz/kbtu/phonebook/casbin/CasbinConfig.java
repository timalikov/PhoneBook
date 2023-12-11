package kz.kbtu.phonebook.casbin;

import org.casbin.jcasbin.main.Enforcer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CasbinConfig {

    @Bean
    public Enforcer casbinEnforcer() {
        String modelPath = "classpath:casbin/model.conf";
        String policyPath = "classpath:casbin/policy.csv";

        Enforcer enforcer = new Enforcer(modelPath, policyPath);
        return enforcer;
    }
}

