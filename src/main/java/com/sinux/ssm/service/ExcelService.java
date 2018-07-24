package com.sinux.ssm.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

/**
 * 接口用途:定义Excel导入方法
 * */
public interface ExcelService {
	public String poireadExcel(MultipartFile pictureFile,HttpServletRequest request) throws Exception;// 根据指定路劲读取指定Excel内容
}
