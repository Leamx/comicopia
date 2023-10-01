package dev.matrixlab.comicopia.service.storage;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    String storeFile(MultipartFile file, String fileUID, int type);

    boolean deleteFile(String fileUID, int type);

}