package com.example.spring2.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUpload {
    public final String UPLOAD_DIRECTORY = new ClassPathResource("static/images/").getFile().getAbsolutePath();
    // public final String UPLOAD_DIRECTORY = "/home/jay/Desktop/programming/innogent/eclipse_workspace/spring2/src/main/resources/static/images";
    
    public FileUpload()throws IOException{

    }

    public boolean uploadFile(MultipartFile file){
        boolean f = false;
        try{
            System.out.println(UPLOAD_DIRECTORY+File.separator+file.getOriginalFilename());
            Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIRECTORY+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            f = true;
        }catch(Exception e){
            System.out.println(e);
        }
        return f;
    }
}
