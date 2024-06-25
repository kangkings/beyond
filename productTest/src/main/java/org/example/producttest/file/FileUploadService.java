package org.example.producttest.file;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    public String makeFolder();
    public String saveFile(MultipartFile file);
}
