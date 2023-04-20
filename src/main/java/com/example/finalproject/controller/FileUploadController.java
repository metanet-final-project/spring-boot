package com.example.finalproject.controller;

import com.example.finalproject.domain.FileUploadResponse;
import com.example.finalproject.domain.Lost;
import com.example.finalproject.service.LostService;
import com.example.finalproject.upload.FileUploadUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Log4j2
@RestController
@RequestMapping("/api")
public class FileUploadController {

    @Autowired
    private LostService lostService;
    private final static String imageDirectory = Paths.get("").toAbsolutePath() + "/images/";
    @GetMapping("/files")
    public List<String> getFileNames() {
        return Stream.of(new File(imageDirectory).listFiles())
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toList());

    }

    @PostMapping("/saveUploadFile")
    public ResponseEntity saveUploadFile(@RequestParam("file") MultipartFile file, @RequestPart(required = true) Lost lost) {
        String fileName = file.getOriginalFilename();
        String filePath = imageDirectory + File.separator + fileName;
        System.out.println("=========================");
        System.out.println(lost);
        System.out.println(filePath);
        System.out.println(file.getOriginalFilename());

        lost.setFileName(fileName);
        System.out.println(lost);
        lostService.save(lost);

        try {
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            throw new RuntimeException("Fail to upload files.");
        }
    }

    @GetMapping(value = "/getImage/{filename}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable String filename) throws IOException {
        //경로 수정예정
        Resource resource = new FileSystemResource("C:/Users/Samsung/Pictures/Screenshots/" + filename);
        Path path = Paths.get(resource.getURI());
        byte[] bytes = Files.readAllBytes(path);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(bytes);
    }

    @PostMapping("/upload")
    public ResponseEntity upload(
            @RequestParam("files") MultipartFile[] files // 파일 받기
    ) {
        // 1. response 객체 생성
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> responseData = new HashMap<>();

        // 2. 받은 파일 데이터 확인
        List<HashMap<String, Object>> fileNames = new ArrayList<>();
        Arrays.stream(files).forEach(f -> {
            HashMap<String, Object> map = new HashMap<>();
            System.out.println("f.getOriginalFilename() = " + f.getOriginalFilename());
            map.put("fileName", f.getOriginalFilename());
            map.put("fileSize", f.getSize());

            fileNames.add(map);
        });

        // 3. response 하기
        responseData.put("files", fileNames);
        resultMap.put("response", responseData);
        return ResponseEntity.ok().body(resultMap);
    }

    @PostMapping("/uploadFile")
    public ResponseEntity<FileUploadResponse> uploadFile(@RequestParam("file")MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        long size= multipartFile.getSize();

        String fileCode = FileUploadUtil.saveFile(fileName,multipartFile);

        FileUploadResponse response = new FileUploadResponse();
        response.setFileName(fileName);
        response.setSize(size);
        response.setDownloadUri("/downloadFile/"+fileCode);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }





}
