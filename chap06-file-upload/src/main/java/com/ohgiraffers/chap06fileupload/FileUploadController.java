package com.ohgiraffers.chap06fileupload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
// 서비스에서 작성해야함

@Controller
public class FileUploadController {

    private ResourceLoader resourceLoader;

    @Autowired
    public FileUploadController(ResourceLoader resourceLoader){
        this.resourceLoader = resourceLoader;
    }

    @PostMapping("single-file")
    public String singFileUpload(@RequestParam MultipartFile singleFile, String SingleFileDescription, Model model) throws IOException {

        Resource resource = resourceLoader.getResource("classpath:static/img/single");

        String filePath = null;

        //만약 해당 경로가 없다면
        if(!resource.exists()){
            String root = "src/main/resources/static/img/single";
            File file = new File(root);

            file.mkdirs(); // 위의 경로의 파일을 이곳에 만들어라

            //d\class\gangnam\spring 절대경로 c: 나 d: 드라이브 부터 시작하는것이 절대경로 ,언제어디서든 이위치를 지정할 수 있는것
            //       \spring\src\main\resource\static\img 상대경로
            filePath = file.getAbsolutePath();
        }else {
            filePath = resourceLoader.getResource("classpath:static/img/single").getFile().getAbsolutePath();
        }

        String originFileName = singleFile.getOriginalFilename(); // 파일의 원본이름을 불러오는것
        String ext = originFileName.substring(originFileName.lastIndexOf(".")); // 확장자를 분리시키는것
        String saveName = UUID.randomUUID().toString().replace("-","") + ext; // dasdasdsadasdasd3123213.png 가 뒤에 붙는다

        try {

        singleFile.transferTo(new File(filePath + "/" + saveName));
        model.addAttribute("message","파일업로드 성공");
        model.addAttribute("img","static/img/single/"+ saveName);
        }catch (Exception exception){
            exception.printStackTrace();
            model.addAttribute("message", " 파일 업로드 실패");
        }

        return "result";
    }
    @PostMapping("multi-file")
    public String multiFileUpload(@RequestParam List<MultipartFile> multipartFiles,
                                  String multiFileDescription, Model model) throws IOException {

        Resource resource = resourceLoader.getResource("classpath:static/img/multi");
        String filePath = null;

        if(!resource.exists()){
            String root = "src/main/resources/static/img/multi";
            File file = new File(root);
            file.mkdirs();
            filePath = file.getAbsolutePath();
        }else{
            filePath = resourceLoader.getResource("classpath:static/img/multi").getFile().getAbsolutePath();
        }

        List<FileDTO> files = new ArrayList<>();
        List<String> saveFiles = new ArrayList<>();
        try{
            for(MultipartFile file : multipartFiles){
                String originFileName = file.getOriginalFilename();
                String ext = originFileName.substring(originFileName.lastIndexOf("."));
                String savedName = UUID.randomUUID().toString().replace("-", "")+ext;

                files.add(new FileDTO(originFileName, savedName, filePath, multiFileDescription));

                file.transferTo(new File(filePath+"/"+savedName));
                saveFiles.add("static/img/multi/"+savedName);
            }
            model.addAttribute("message", "파일 업로드 성공!");
            model.addAttribute("imgs", saveFiles);
        }catch (Exception e){
            e.printStackTrace();

            for (FileDTO file: files) {
                new File(filePath + "/" + file.getSaveName()).delete();
            }
            model.addAttribute("message", "파일 업로드 실패!");
        }
        return "result";



    }
}
