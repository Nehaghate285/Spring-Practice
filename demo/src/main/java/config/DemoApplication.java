package config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import com.datastax.driver.core.Cluster;

@SpringBootApplication
@ComponentScan(basePackages={"controllers","service","dao","validators"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    
    @Bean
    public CassandraOperations establishDBConnection(){
    	return new CassandraTemplate(Cluster.builder().addContactPoint("10.20.3.163").build().connect("demo"));
    }
    
    /*@Bean
    public ProfileManager loadProfileManager(){
    	return new ProfileManager();
    }
    
    
    @Bean
    public ProfileDAO loadProfileDAO(){
    	return new ProfileDAO();
    }*/
    
}
