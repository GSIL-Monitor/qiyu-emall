package com.qiyu.emall.controller;

import com.qiyu.emall.common.core.configer.PropertyConfigurer;
import com.qiyu.emall.common.core.constants.Constant;
import com.qiyu.emall.common.core.constants.ConstantEnum;
import com.qiyu.emall.common.core.response.ResponseData;
import com.qiyu.emall.common.core.utils.FileUtil;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



@Controller
@RequestMapping("/fileUpload")
public class FileUploadController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());
	private final static int MAX_SIZE = 10485760;//10MB
	
	@Autowired
	private PropertyConfigurer propertyConfigurer;
	
	/**
	 * 这里这里用的是MultipartFile[] myfiles参数,所以前台就要用<input type="file"
	 * name="myfiles"/>
	 * 上传文件完毕后返回给前台[0`filepath],1表示上传成功(后跟上传后的文件路径),0表示失败(后跟失败描述)
	 */
	@RequestMapping(value = "/file")
	@ResponseBody
	public ResponseData upload(@RequestParam("myfiles") MultipartFile[] myfiles, HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 使用在异步JSON里面
		logger.info("=========图片上传========");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int maxSize_ = MAX_SIZE;
		// 如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\upload\\文件夹中
		// 这里实现文件上传操作用的是commons.io.FileUtils类,它会自动判断/upload是否存在,不存在会自动创建
//		String realPath = request.getSession().getServletContext().getRealPath(File.separator + Constant.PicPath.rootPath + File.separator);
		String realPath = propertyConfigurer.getProperty(Constant.IMAGE_UPLOAD_DIR).toString();
		logger.info("realPath=" + realPath);
		// 上传文件的原名(即上传前的文件名字)
		String originalFilename = null;
		// 新文件名
		String newName = null;
		// 如果只是上传一个文件,则只需要MultipartFile类型接收文件即可,而且无需显式指定@RequestParam注解
		// 如果想上传多个文件,那么这里就要用MultipartFile[]类型来接收文件,并且要指定@RequestParam注解
		// 上传多个文件时,前台表单中的所有<input
		// type="file"/>的name都应该是myfiles,否则参数里的myfiles无法获取到所有上传的文件
		for (MultipartFile myfile : myfiles) {
			if (myfile.isEmpty()) {
				logger.info("请选择文件后上传！");
				return ResponseData.failure(ConstantEnum.IMAGE_UPLOAD_EMPTY_ERROR);
			} else {
				originalFilename = myfile.getOriginalFilename();
				newName = myfile.getOriginalFilename();
				logger.info("文件原名: " + originalFilename);
				logger.info("文件名称: " + myfile.getName());
				logger.info("文件长度: " + myfile.getSize());
				if (myfile.getSize() >= maxSize_) {
					resultMap.put("status", 0);
					resultMap.put("errorType", 1);
					resultMap.put("msg", "文件大小超过了最大限制！");
					return ResponseData.failure(ConstantEnum.IMAGE_UPLOAD_SIZE_ERROR);
				}
				logger.info("文件类型: " + myfile.getContentType());
				String fileType = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
				if (".exe".indexOf(fileType.toLowerCase()) > -1) {
					logger.info("文件类型不对");
					return ResponseData.failure(ConstantEnum.IMAGE_UPLOAD_TYPE_ERROR);
				}
				logger.info("========================================");
				try {
					// 这里不必处理IO流关闭的问题,因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉
					// 此处也可以使用Spring提供的MultipartFile.transferTo(File
					// dest)方法实现文件的上传
					if (originalFilename.indexOf(".") > -1) {
						newName = FileUtil.generateFileName() + originalFilename.substring(originalFilename.indexOf("."), originalFilename.length());
					}
					FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realPath, newName));
				} catch (IOException e) {
					logger.info("文件[" + originalFilename + "]上传失败,堆栈轨迹如下");
					logger.error(e);
					return ResponseData.failure(ConstantEnum.IMAGE_UPLOAD_ERROR);
				}
			}
		}
		// 此时在Windows下输出的是[D:\Develop\apache-tomcat-6.0.36\webapps\AjaxFileUpload\\upload\愤怒的小鸟.jpg]
		// logger.info(realPath + "\\" + originalFilename);
		// 此时在Windows下输出的是[/AjaxFileUpload/upload/愤怒的小鸟.jpg]
		// logger.info(request.getContextPath() + "/upload/" +
		// originalFilename);
		// 不推荐返回[realPath + "\\" + originalFilename]的值
		// 因为在Windows下<img src="file:///D:/aa.jpg">能被firefox显示,而<img
		// src="D:/aa.jpg">firefox是不认的
		return ResponseData.success();
	}

	@RequestMapping(value = "/test")
	@ResponseBody
	public ResponseData upload(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("test");
		return ResponseData.success();
	}

	public static void main(String[] args) {
		System.out.println(".exe".indexOf("json".toLowerCase()));
	}
    
}
