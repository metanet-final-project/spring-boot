package com.example.finalproject.dto;

import lombok.Data;

@Data
public class FileUploadResponseDTO {
    private String fileName;
    private String downloadUri;
    private long size;
}
