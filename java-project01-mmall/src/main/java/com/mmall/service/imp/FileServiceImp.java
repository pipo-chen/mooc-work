package com.mmall.service.imp;

import com.google.common.collect.Lists;
import com.mmall.service.IFileService;
import com.mmall.util.FTPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service("iFileService")
public class FileServiceImp implements IFileService {

	private Logger logger = LoggerFactory.getLogger(FileServiceImp.class);
	@Override
	public String upload(MultipartFile file, String path) {
		String fileName = file.getOriginalFilename();

		String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
		String uploadFileName = UUID.randomUUID().toString()+"."+fileExtensionName;
		//A abc.jpg
		//B abc.jpg 避免被替换
		logger.info("开始上传文件，上传文件的文件名：{} 上传的路径:{} 新文件名：{}", fileName, path, uploadFileName);

		File fileDir = new File(path);
		if (!fileDir.exists()) {
			fileDir.setWritable(true);
			fileDir.mkdirs();
		}
		File targetFile = new File(path, uploadFileName);

		try {
			file.transferTo(targetFile);
			//将 targetFile 上传到我们的FTP服务器上
			FTPUtil.uploadFile(Lists.<File>newArrayList(targetFile));
			//上传完之后，删除 upload 下面的文件
			targetFile.delete();

		} catch (IOException e) {
			logger.error("上传文件异常",e);
			return null;
		}

		return targetFile.getName();
	}

	public static void main(String[] args) {
		String fileName = "abc.jpg";
		//读取到 jpg
		System.out.println(fileName.substring(fileName.lastIndexOf(".")+1));
	}
}
