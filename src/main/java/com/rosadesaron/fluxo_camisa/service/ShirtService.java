package com.rosadesaron.fluxo_camisa.service;

import com.amazonaws.services.s3.AmazonS3;
import com.rosadesaron.fluxo_camisa.domain.shirt.Shirt;
import com.rosadesaron.fluxo_camisa.domain.shirt.ShirtRequestDTO;
import com.rosadesaron.fluxo_camisa.domain.shirt.ShirtResponseDTO;
import com.rosadesaron.fluxo_camisa.repository.ShirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.awt.print.PageFormat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class ShirtService {
    @Autowired
    ShirtRepository shirtRepository;

    @Autowired
    AmazonS3 s3;

    @Value("${cloud.aws.s3.bucket-name}")
    String bucketName;

    public Shirt create(ShirtRequestDTO data) {
        Shirt shirt = new Shirt();
        String imgUrl = null;

        if(data.img() != null) uploading(data.img());

        shirt.setImgUrl(imgUrl);
        shirt.setColor(data.color());
        shirt.setSleeve(data.sleeve());
        shirt.setSize(data.size());
        shirt.setPrice(data.price());
        shirt.setCollar(data.collar());
        shirt.setQuantity(data.quantity());

        shirtRepository.save(shirt);
        return shirt;
    }

    private String uploading(MultipartFile data) {
        String imgUrl = UUID.randomUUID()+data.getOriginalFilename();

        try {
            File file = (convertMultipartToFile(data));
            s3.putObject(bucketName, imgUrl, file);
            file.delete();
            return s3.getUrl(bucketName, imgUrl).toString();
        } catch (Exception e) {
            System.out.println("Erro ao fazer uploading");
            return null;
        }
    }

    private File convertMultipartToFile(MultipartFile multipartFile) throws IOException {
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(multipartFile.getBytes());
        fos.close();
        return file;
    }

    public List<ShirtResponseDTO> getAllShirts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Shirt> allShirts = shirtRepository.findAll(pageable);
        return allShirts.map(shirt -> new ShirtResponseDTO(shirt.getSleeve(), shirt.getCollar(),
                                                            shirt.getColor(), shirt.getPrice(),
                                                            shirt.getQuantity(), shirt.getSize(),
                                                            shirt.getId(), shirt.getImgUrl())).stream().toList();
    }
}
