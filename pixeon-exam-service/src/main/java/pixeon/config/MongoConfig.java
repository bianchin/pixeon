package pixeon.config;

import com.mongodb.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gian on 28/01/20.
 */
@Configuration
public class MongoConfig {

    @Bean
    public MongoClient mongoClient() {
        List<ServerAddress> saList = new ArrayList<>();
        saList.add(new ServerAddress("cluster0-shard-00-00-96z4g.mongodb.net", 27017));
        saList.add(new ServerAddress("cluster0-shard-00-00-96z4g.mongodb.net", 27017));
        saList.add(new ServerAddress("cluster0-shard-00-00-96z4g.mongodb.net", 27017));

        char[] pwd =  "vcs1gFUK5i7rsGAZ".toCharArray();
        MongoCredential credential = MongoCredential.createCredential("pixeon", "admin", pwd);

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
