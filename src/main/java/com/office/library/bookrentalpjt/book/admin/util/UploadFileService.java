package com.office.library.bookrentalpjt.book.admin.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Service
public class UploadFileService {
    @Value("${org.file.upload.path}")
    private String uploadPath;

    public String upload(MultipartFile file) {

        boolean result = false;

        // File 저장
        String fileOriName = file.getOriginalFilename();
        String fileExtension =
                fileOriName.substring(fileOriName.lastIndexOf("."), fileOriName.length());
        String uploadDir = uploadPath;

        UUID uuid = UUID.randomUUID();
        String uniqueName = uuid.toString().replaceAll("-", "");

        File saveFile = new File(uploadDir + uniqueName + fileExtension);

        if (!saveFile.exists())
            saveFile.mkdirs();

        try {
            file.transferTo(saveFile);
            result = true;

        } catch (Exception e) {
            e.printStackTrace();

        }

        if (result) {
            System.out.println("[UploadFileService] FILE UPLOAD SUCCESS!!");
            return uniqueName + fileExtension;

        } else {
            System.out.println("[UploadFileService] FILE UPLOAD FAIL!!");
            return null;

        }


    }

}
