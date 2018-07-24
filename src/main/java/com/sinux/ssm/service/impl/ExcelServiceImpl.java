package com.sinux.ssm.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sinux.ssm.common.utils.AuthUtil;
import com.sinux.ssm.dao.UserDao;
import com.sinux.ssm.entity.User;
import com.sinux.ssm.service.ExcelService;

/**
 * 类用途:继承Excel服务，实现Excel导入数据库
 * */
@Service
public class ExcelServiceImpl implements ExcelService {
	@Autowired
	private UserDao userDao;

	@Override
	public String poireadExcel(MultipartFile pictureFile,
			HttpServletRequest request) throws Exception {
		String fileBase = request.getSession().getServletContext()
				.getRealPath("/")
				+ "fileUpload\\temp\\";
		String filePath = editItemSubmit(pictureFile, fileBase);
		String result = "failed";// 函数返回值
		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(filePath));// 读取指定Excel文件内容
		List<List<String>> lists = new ArrayList<List<String>>();// 定义最终将Excel内容存储在List集合中
		List<String> list = null;// 存储Excel每一行的每一项的值
		for (int k = 0; k < wb.getNumberOfSheets(); k++) {// 得到文件的所有行，并遍历每行内容
			HSSFSheet sheet = wb.getSheetAt(k);
			int rows = sheet.getPhysicalNumberOfRows();// 得到总行数
			list = new ArrayList<String>();
			;// 存储Excel每一行的每一项的值
			for (int r = 0; r < rows; r++) {
				HSSFRow row = sheet.getRow(r);// 取一行Excel数据
				if (row == null) {
					continue;
				}
				int cells = row.getPhysicalNumberOfCells();
				list = new ArrayList<String>();
				for (int c = 0; c < cells; c++) {// 取出一行中每一项的数值
					HSSFCell cell = row.getCell(c);
					String value = null;
					switch (cell.getCellType()) {
					case HSSFCell.CELL_TYPE_FORMULA:
						value = cell.getCellFormula();
						break;
					case HSSFCell.CELL_TYPE_NUMERIC:
						value = String.valueOf(cell.getNumericCellValue());
						break;
					case HSSFCell.CELL_TYPE_STRING:
						value = cell.getStringCellValue();
						break;
					default:
					}
					if (value.matches("[\\d]+\\.[\\d]")) {// 通过正则表达式对浮点型字符串进行截取
						String[] strId = value.split("\\.");
						value = strId[0];
//						System.out.println("value="+value);
					}
					list.add(value);
				}
				lists.add(list);
			}
		}
		for (int u = 1; u < lists.size(); u++) {// 将Excel数据映射成Java数据对象
			User user = new User();// 保存成User对象
			System.out.println();
			user.setName(lists.get(u).get(0));
			user.setNumber(lists.get(u).get(1));
			user.setLoginname(lists.get(u).get(2));
//			user.setPassword(lists.get(u).get(3));
			user.setPassword(AuthUtil.encryptByMd5(lists.get(u).get(3)));
			user.setAge(Integer.valueOf(lists.get(u).get(4)));
			if (userDao.findUser(user.getNumber()) == 0) {// 通过查询数据库判断学号是否重复
				userDao.savaUserList(user);// 将数据保存在数据库中
				result = "success";
			} else {
				continue;
			}
		}
		return result;
	}

	public String editItemSubmit(MultipartFile pictureFile, String fileBase)
			throws Exception {
		String originalFilename = "";
		// 进行文件上传
		if (pictureFile != null && pictureFile.getOriginalFilename() != null
				&& pictureFile.getOriginalFilename().length() > 0) {
			// 上传文件的名称
			originalFilename = pictureFile.getOriginalFilename();
			// 新文件
			File file = new java.io.File(fileBase + originalFilename);
			// 将内存中的文件写入磁盘
			pictureFile.transferTo(file);
		}
		return fileBase + originalFilename;
	}
}
