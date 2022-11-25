package com.apitest.Springboottest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData {

    private String fileName;
    private String DownloadURl;
    private String fileType;
    private Long fileSize;


}
