package spring.uploading;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;

@Controller
public class FileUploadController {

    private static final String PATH = "C:/Users/ropa0917/IdeaProjects/Test/src/main/resources/download_files/";

    @GetMapping("/test")
    public String test() {
        return "index";
    }

//    @GetMapping("/upload")
//    public @ResponseBody
//    String provideUploadInfo() {
//        return "Вы можете загружать файл с использованием того же URL.";
//    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(PATH + name + "-upload.txt")));
                stream.write(bytes);
                stream.close();
                File file1 = new File(PATH + name + "-upload.txt");
                FileWriter fileWriter = new FileWriter(file1);
                fileWriter.write("Was modified");
                fileWriter.close();
                return "index";
            } catch (Exception e) {
                return "Вам не удалось загрузить файл " + name + " => " + e.getMessage();
            }
        } else {
            return "Вам не удалось загрузить файл " + name + " потому что файл пустой";
        }
    }

    @GetMapping("/files")
    public String downloadFiles(Model model) {
        model.addAttribute("files", getFileList());
        return "index";
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<InputStreamResource> downloadFile(@PathVariable String fileName) throws IOException {
        File file = new File(PATH + fileName);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                .contentType(MediaType.IMAGE_JPEG).contentLength(file.length()).body(resource);

    }

    private ArrayList<String> getFileList() {
        File dir = new File(PATH);
        File[] files = dir.listFiles();
        ArrayList<String> filePaths = new ArrayList();
        for (File file : files) {
            filePaths.add(file.getName());
        }
        return filePaths;
    }


}
