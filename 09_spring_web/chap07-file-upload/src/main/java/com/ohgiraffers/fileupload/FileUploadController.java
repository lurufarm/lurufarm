package com.ohgiraffers.fileupload;

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

@Controller
public class FileUploadController {

    @Autowired
    private ResourceLoader resourceLoader;

    @PostMapping("single-file")
    public String singleFileUpload(@RequestParam MultipartFile singleFile,
                                   @RequestParam String singleFileDescription,
                                   Model model) throws IOException {
        System.out.println("singleFile: " + singleFile);
        System.out.println("singleFileDescription: " + singleFileDescription);

        /** 파일 저장 경로 설정. classpath를 붙여주면 build 폴더가 root로 설정됨.
         * 여기에 파일을 저장하겠다는게 아니라 이 경로에서 resource를 불러오겠다는 의미임 */
        Resource resource = resourceLoader.getResource("classpath:static/img/single");
        String filePath = null;

        if(!resource.exists())
        {
            String root = "src/main/resources/static/img/single";
            File file = new File(root);
            file.mkdirs(); // 경로가 없다면 위의 root 경로를 생성하는 메소드

            filePath = file.getAbsolutePath();
        }
        else
            filePath = resource.getFile().getAbsolutePath();

        /** 파일명 변경 처리 */
        String originFileName = singleFile.getOriginalFilename();
        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        String savedName = UUID.randomUUID().toString().replace("-", "") + ext;

        /** 파일을 저장 */
        try {
            singleFile.transferTo(new File(filePath + "/" + savedName));
            model.addAttribute("message", "파일 업로드 성공!");
            model.addAttribute("img", "static/img/single/" + savedName);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "파일 업로드 실패!");
        }

        return "result";
    }

    @PostMapping("multi-file")
    public String multiFileUpload(@RequestParam List<MultipartFile> multiFiles,
                                  @RequestParam String multiFileDescription,
                                  Model model) throws IOException {
        /** 파일 저장 경로 지정 */
        Resource resource = resourceLoader.getResource("classpath:static/img/multi/");
        String filePath = null;

        if(!resource.exists())
        {
            String root = "src/main/resources/static/img/multi";
            File file = new File(root);
            file.mkdirs(); // 경로가 없다면 위의 root 경로를 생성하는 메소드

            filePath = file.getAbsolutePath();
        }
        else
            filePath = resource.getFile().getAbsolutePath();

        /** 파일에 관한 정보 저장을 위한 처리 */
        List<FileDTO> files = new ArrayList<>(); // 파일에 관한 정보 저장할 리스트
        List<String> savedFiles = new ArrayList<>();

        try {
            for (MultipartFile file : multiFiles) {
                /** 파일명 변경 처리 */
                String originFileName = file.getOriginalFilename();
                String ext = originFileName.substring(originFileName.lastIndexOf("."));
                String savedFileName = UUID.randomUUID().toString().replace("-", "") + ext;

                /** 파일정보 등록 */
                files.add(new FileDTO(originFileName, savedFileName, filePath, multiFileDescription));

                /** 파일 저장 */
                file.transferTo(new File(filePath + "/" + savedFileName));
                savedFiles.add("static/img/multi/" + savedFileName);
            }

            model.addAttribute("message", "파일 업로드 성공!");
            model.addAttribute("imgs", savedFiles);
        } catch (Exception e) {
            for (FileDTO file : files)
            {
                new File(filePath + "/" + file.getSavedName()).delete();
            }
            model.addAttribute("message", "파일 업로드 실패!");
        }
        return "result";
    }


}
