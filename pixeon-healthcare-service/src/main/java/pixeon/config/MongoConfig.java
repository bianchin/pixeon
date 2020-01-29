package pixeon.config;

import com.mongodb.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gian on 28/01/20.
 */
@Configuration
public class MongoConfig {

    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.port}")
    private Integer port;

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Value("${spring.data.mongodb.username}")
    private String username;

    @Value("${spring.data.mongodb.password}")
    private String password;

    @Bean
    public MongoClient mongoClient() {
        List<ServerAddress> saList = new ArrayList<>();
        saList.add(new ServerAddress(host, port));
        saList.add(new ServerAddress(host, port));
        saList.add(new ServerAddress(host, port));

        MongoCredential credential = MongoCredential.createCredential(username, "admin", password.toCharArray());

        //set sslEnabled to true here
        MongoClientOptions options = MongoClientOptions.builder()
                .readPreference(ReadPreference.primaryPreferred())
                .retryWrites(true)
                .requiredReplicaSetName("Cluster0-shard-0")
                .maxConnectionIdleTime(6000)
                .sslEnabled(true)
                .build();

        MongoClient mongoClient = new MongoClient(saList, credential, options);

        return mongoClient;
    }

}
