package com.ohgiraffers.chap06fileupload;

public class FileDTO {

    private String originalFileName;
    // 파일원본이름은 데이터 베이스에 저장한다.

    private String saveName;
    // 애도 데이터베이스에 저장 원본,변경이름 ,저장경로,설명

    private String filePath;

    private String fileDescription;

    public FileDTO() {
    }

    public FileDTO(String originalFileName, String saveName, String filePath, String fileDescription) {
        this.originalFileName = originalFileName;
        this.saveName = saveName;
        this.filePath = filePath;
        this.fileDescription = fileDescription;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public String getSaveName() {
        return saveName;
    }

    public void setSaveName(String saveName) {
        this.saveName = saveName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    @Override
    public String toString() {
        return "FileDTO{" +
                "originalFileName='" + originalFileName + '\'' +
                ", saveName='" + saveName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileDescription='" + fileDescription + '\'' +
                '}';
    }
}
