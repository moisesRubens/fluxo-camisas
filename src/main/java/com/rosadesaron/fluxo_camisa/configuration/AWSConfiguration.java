package com.rosadesaron.fluxo_camisa.configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSConfiguration {
    @Value("${cloud.aws.credentials.access-key}")
    String acessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    String secretKey;

    @Value("${cloud.aws.region.static}")
    String region;

    @Bean
    public AmazonS3 createS3() {
        BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(acessKey, secretKey);

        return AmazonS3ClientBuilder.standard().
                withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials)).
                withRegion(Regions.fromName(region)).build();
    }
}
