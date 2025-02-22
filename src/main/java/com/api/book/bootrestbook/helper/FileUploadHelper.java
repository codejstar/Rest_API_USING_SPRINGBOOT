package com.api.book.bootrestbook.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.io.IOException;

// import org.apache.tomcat.util.http.fileupload.impl.IOFileUploadException;
import org.springframework.core.io.ClassPathResource;

// import java.io.File;
// import java.io.FileOutputStream;
// import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
    // public final String UPLOAD_DIR = "C:\\Users\\Jagdeep
    // jakhu\\Desktop\\springbootproject\\bootrestbook\\src\\main\\resources\\static\\image";

    public final String UPLOAD_DIR = new ClassPathResource("static/image/").getFile().getAbsolutePath();

    public FileUploadHelper() throws IOException {

    }

    public boolean uploadFile(MultipartFile multipart) {
        boolean f = false;
        try {
            // InputStream is = multipart.getInputStream();
            // byte data[] = new byte[is.available()];
            // is.read(data);

            // // write
            // FileOutputStream fos = new FileOutputStream(
            // (UPLOAD_DIR + File.separator + multipart.getOriginalFilename()));

            // fos.write(data);
            // fos.flush();
            // fos.close();

            Files.copy(multipart.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + multipart
                    .getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);

            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}
