package dev.matrixlab.comicopia.service.comic;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    boolean storeFile(MultipartFile file, String fileUID, int type);

    boolean deleteFile(String fileUID, int type);

}