package com.example.fileupload.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record UploadCompletionRequest(
        @NotBlank String uploadId,
        @NotBlank String fileName,
        @Positive int totalChunks
) {}
