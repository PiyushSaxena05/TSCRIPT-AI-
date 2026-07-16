package com.TScript.AI.TScript.AI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

@CrossOrigin(origins = "http://localhost:5174")
@RestController
@RequestMapping("/api/transcribe")
public class TranscriptionController {

    private static final String FFMPEG_PATH =
            "C:\\Users\\Dell\\AppData\\Local\\Microsoft\\WinGet\\Packages\\" +
                    "Gyan.FFmpeg_Microsoft.Winget.Source_8wekyb3d8bbwe\\" +
                    "ffmpeg-8.1.2-full_build\\bin";

    @PostMapping
    public ResponseEntity<String> transcribeAudio(
            @RequestParam("file") MultipartFile file) {

        File tempFile = null;
        Path transcriptPath = null;

        try {

            if (file.isEmpty()) {
                return ResponseEntity.badRequest()
                        .body("Please upload an audio file.");
            }

            String originalFileName =
                    file.getOriginalFilename();

            String extension = ".mp3";

            if (originalFileName != null &&
                    originalFileName.contains(".")) {

                extension =
                        originalFileName.substring(
                                originalFileName.lastIndexOf(".")
                        );
            }

            tempFile =
                    File.createTempFile(
                            "audio",
                            extension
                    );

            file.transferTo(tempFile);

            System.out.println(
                    "Uploaded File : "
                            + tempFile.getAbsolutePath()
            );

            ProcessBuilder processBuilder =
                    new ProcessBuilder(
                            "py",
                            "-3.11",
                            "-m",
                            "whisper",
                            tempFile.getAbsolutePath(),
                            "--model",
                            "large-v3",
                            "--language",
                            "en",
                            "--initial_prompt",
                            "This audio may contain technical terms such as Spring AI, Spring Boot, Java, OpenAI, Artificial Intelligence, Maven and IntelliJ.",
                            "--condition_on_previous_text",
                            "False",
                            "--output_format",
                            "txt",
                            "--output_dir",
                            tempFile.getParent()
                    );

            processBuilder.redirectErrorStream(true);

            processBuilder.environment().put(
                    "PATH",
                    System.getenv("PATH")
                            + ";" + FFMPEG_PATH
            );

            System.out.println(
                    "PATH : "
                            + processBuilder
                            .environment()
                            .get("PATH")
            );

            Process process =
                    processBuilder.start();

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    process.getInputStream(),
                                    StandardCharsets.UTF_8
                            )
                    );

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode =
                    process.waitFor();

            System.out.println(
                    "Whisper Exit Code : "
                            + exitCode
            );

            if (exitCode != 0) {

                return ResponseEntity
                        .status(
                                HttpStatus.INTERNAL_SERVER_ERROR
                        )
                        .body(
                                "Whisper transcription failed."
                        );
            }

            String txtFileName =
                    tempFile.getName()
                            .substring(
                                    0,
                                    tempFile.getName()
                                            .lastIndexOf(".")
                            )
                            + ".txt";

            transcriptPath =
                    Path.of(
                            tempFile.getParent(),
                            txtFileName
                    );

            System.out.println(
                    "Transcript Path : "
                            + transcriptPath
            );

            if (!Files.exists(transcriptPath)) {

                return ResponseEntity
                        .status(
                                HttpStatus.INTERNAL_SERVER_ERROR
                        )
                        .body(
                                "Transcript file was not generated."
                        );
            }

            String transcript =
                    Files.readString(
                            transcriptPath,
                            StandardCharsets.UTF_8
                    ).trim();

            if (transcript.isBlank()) {
                transcript = "No speech detected.";
            }

            return ResponseEntity.ok(
                    transcript
            );

        }
        catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity
                    .status(
                            HttpStatus.INTERNAL_SERVER_ERROR
                    )
                    .body(
                            "Error : "
                                    + e.getMessage()
                    );
        }
        finally {

            try {

                if (transcriptPath != null) {
                    Files.deleteIfExists(
                            transcriptPath
                    );
                }

                if (tempFile != null &&
                        tempFile.exists()) {

                    tempFile.delete();
                }

            }
            catch (Exception ignored) {
            }
        }
    }
}