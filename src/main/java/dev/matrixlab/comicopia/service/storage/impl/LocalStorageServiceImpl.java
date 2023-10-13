package dev.matrixlab.comicopia.service.storage.impl;

import dev.matrixlab.comicopia.constant.Constants;
import dev.matrixlab.comicopia.service.storage.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class LocalStorageServiceImpl implements FileStorageService {

    private static final Logger logger = LoggerFactory.getLogger(LocalStorageServiceImpl.class);

    private final Path fileStoragePath;

    private static final String EXTENSION = "jpg";

    public LocalStorageServiceImpl() {
        // 指定文件存储的目录，可以根据您的需求修改
        this.fileStoragePath = Paths.get(Constants.PROJECT_PATH + File.separator + Constants.IMAGE_STORAGE_PATH);
        try {
            if (!Files.exists(this.fileStoragePath)) {
                Files.createDirectories(this.fileStoragePath);
            }
        } catch (IOException e) {
            throw new RuntimeException("无法创建文件存储目录", e);
        }
    }

    @Override
    public String storeFile(MultipartFile file, String fileUID, int type) {
        String uri = File.separator + Constants.IMAGE_STORAGE_PATH + File.separator + fileUID + "." + EXTENSION;
        try {
            Path targetPath = this.fileStoragePath.resolve(fileUID + "." + EXTENSION);
            if (!Files.exists(targetPath)) {
                file.transferTo(targetPath);
            }
            return uri;
        } catch (IOException e) {
            throw new RuntimeException("文件上传失败", e);
        }
    }

    @Override
    public boolean deleteFile(String fileUID, int type) {
        try {
            Path targetPath = this.fileStoragePath.resolve(fileUID + "." + EXTENSION);
            Files.deleteIfExists(targetPath);
            return true;
        } catch (IOException e) {
            throw new RuntimeException("文件删除失败", e);
        }
    }
}
