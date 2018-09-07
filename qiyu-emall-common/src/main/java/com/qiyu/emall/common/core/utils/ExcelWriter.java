package com.qiyu.emall.common.core.utils;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.*;
import java.util.Calendar;

/**
 * 生成导出Excel文件对象
 *
 * @author shaozhou
 *
 */
public class ExcelWriter {
	// 设置cell编码解决中文高位字节截断
	//private static short XLS_ENCODING = HSSFCell.ENCODING_UTF_16;

	// 定制浮点数格式
	private static String NUMBER_FORMAT = "#,##0.00";

	// 定制日期格式
	private static String DATE_FORMAT = "m/d/yy"; // "m/d/yy h:mm"

	private OutputStream out = null;

	private SXSSFWorkbook workbook = null;

	private Sheet sheet = null;

	private Row row = null;

	private Logger logger = Logger.getLogger(this.getClass());

	public ExcelWriter() {
	}

	/**
	 * 初始化Excel
	 *
	 */
	public ExcelWriter(OutputStream out) {
		this.out = out;
		this.workbook = new SXSSFWorkbook(5000);
		this.sheet = (SXSSFSheet)workbook.createSheet();
	}

	public ExcelWriter(OutputStream out, Boolean b) {
		this.out = out;
		this.workbook = new SXSSFWorkbook(5000);
		if(b){
			this.sheet = workbook.createSheet();
		}
	}
	/**
	 * 导出Excel文件
	 *
	 * @throws IOException
	 */
	public void export() throws FileNotFoundException, IOException {
		try {
			workbook.write(out);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			throw new IOException(" 生成导出Excel文件出错! ", e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException(" 写入Excel文件出错! ", e);
		}

	}

	public void createSheet(String sheetname){
		this.sheet = this.workbook.createSheet(sheetname);
	}

	/**
	 * 增加一行
	 *
	 * @param index
	 *            行号
	 */
	public void createRow(int index) {
		this.row = this.sheet.createRow(index);
	}

	/**
	 * 获取单元格的值
	 *
	 * @param index
	 *            列号
	 */
	public String getCellValue(int index) {
		Cell cell = this.row.getCell(index);
		String strExcelCell = "";
		if (cell != null) { // add this condition
			// judge
			switch (cell.getCellType()) {
			case HSSFCell.CELL_TYPE_FORMULA:
				strExcelCell = "FORMULA ";
				break;
			case HSSFCell.CELL_TYPE_NUMERIC: {
				strExcelCell = String.valueOf(cell.getNumericCellValue());
			}
				break;
			case HSSFCell.CELL_TYPE_STRING:
				strExcelCell = cell.toString();
				break;
			case HSSFCell.CELL_TYPE_BLANK:
				strExcelCell = "";
				break;
			default:
				strExcelCell = "";
				break;
			}
		}
		return strExcelCell;
	}

	public Cell getCell(int index){
		return this.row.getCell(index);
	}

	/**
	 * 设置单元格
	 *
	 * @param index
	 *            列号
	 * @param value
	 *            单元格填充值
	 */
	public void setCell(int index, Integer value) {
		Cell cell = this.row.createCell(index);

		if (value == null) {
			cell.setCellType(Cell.CELL_TYPE_STRING);
			//cell.setEncoding(XLS_ENCODING);
			cell.setCellValue(new HSSFRichTextString(" "));
		} else {
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellValue(value);
		}
	}

	/**
	 * 设置单元格
	 *
	 * @param index
	 *            列号
	 * @param value
	 *            单元格填充值
	 */
	public void setCell(int index, Double value) {
		Cell cell = this.row.createCell(index);
		if (value == null) {
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			//cell.setEncoding(XLS_ENCODING);
			cell.setCellValue(new HSSFRichTextString(" "));
		} else {

			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(value);
			CellStyle cellStyle = workbook.createCellStyle(); // 建立新的cell样式
			DataFormat format = workbook.createDataFormat();
			cellStyle.setDataFormat(format.getFormat(NUMBER_FORMAT)); // 设置cell样式为定制的浮点数格式
			cell.setCellStyle(cellStyle); // 设置该cell浮点数的显示格式
		}
	}


	/**
	 * 设置单元格
	 *
	 * @param index
	 *            列号
	 * @param value
	 *            单元格填充值
	 */
	public void setCell(int index, Long value) {
		Cell cell = this.row.createCell(index);
		if (value == null) {
			cell.setCellType(Cell.CELL_TYPE_STRING);
			//cell.setEncoding(XLS_ENCODING);
			cell.setCellValue(new HSSFRichTextString(" "));
		} else {

			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellValue(value);
		}
	}
	/**
	 * 设置单元格
	 *
	 * @param index
	 *            列号
	 * @param value
	 *            单元格填充值
	 */
	public void setCell(int index, String value) {
		if (value == null)
			value = " ";

		Cell cell = this.row.createCell(index);
		CellStyle cellStyle = this.workbook.createCellStyle();
		DataFormat format = this.workbook.createDataFormat();
		cellStyle.setDataFormat(format.getFormat("@"));
		cell.setCellStyle(cellStyle);
		cell.setCellValue(new HSSFRichTextString(value));
	}

	public void setCellBackergroundRed(int index){
		Cell cell = this.row.getCell(index);
		CellStyle style = workbook.createCellStyle();
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setFillForegroundColor(HSSFColor.RED.index);
		cell.setCellStyle(style);
	}

	public void setCellBackergroundRed(int x,int y){
		Cell cell = this.sheet.getRow(x).getCell(y);
		CellStyle style = workbook.createCellStyle();
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setFillForegroundColor(HSSFColor.RED.index);
		cell.setCellStyle(style);
	}

	public void setCell(int index, String value,short colorIndex) {
		if (value == null)
			value = " ";

		Font font = workbook.createFont();
		CellStyle cellStyle = workbook.createCellStyle();
        font.setColor(colorIndex);    //绿字
        cellStyle.setFont(font);

		Cell cell = this.row.createCell(index);
		cell.setCellType(Cell.CELL_TYPE_STRING);
		cell.setCellStyle(cellStyle);
		//cell.setEncoding(XLS_ENCODING);
		cell.setCellValue(new HSSFRichTextString(value));
	}

	public void setCellFontColor(HSSFCell cell,short colorIndex){
		Font font = workbook.createFont();
		CellStyle cellStyle = cell.getCellStyle();
        font.setColor(colorIndex);    //绿字
        cellStyle.setFont(font);
        cell.setCellStyle(cellStyle);
	}

	public void setCell(){

	}

	/**
	 * 设置单元格
	 *
	 * @param index
	 *            列号
	 * @param value
	 *            单元格填充值
	 */
	public void setCell(int index, Calendar value) {
		Cell cell = this.row.createCell(index);
		//cell.setEncoding(XLS_ENCODING);
		cell.setCellValue(value.getTime());
		CellStyle cellStyle = workbook.createCellStyle(); // 建立新的cell样式
		cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat(DATE_FORMAT)); // 设置cell样式为定制的日期格式
		cell.setCellStyle(cellStyle); // 设置该cell日期的显示格式
	}

	public SXSSFWorkbook getWorkbook() {
		return workbook;
	}

	public void setWorkbook(SXSSFWorkbook workbook) {
		this.workbook = workbook;
	}

	public Sheet getSheet() {
		return sheet;
	}

	public void setSheet(Sheet sheet) {
		this.sheet = sheet;
	}


	public static void main(String[] args) {
		System.out.println(" 开始导出Excel文件 ");

		File f = new File("d://qt.xls");
		ExcelWriter e = new ExcelWriter();

		try {
			e = new ExcelWriter(new FileOutputStream(f));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		e.createRow(0);
		e.setCell(0, "试题编码 ");
		e.setCell(1, "题型");
		e.setCell(2, "分值");
		e.setCell(3, "难度");
		e.setCell(4, "级别");
		e.setCell(5, "知识点");

		e.createRow(1);
		e.setCell(0, "t1");
		e.setCell(1, 1);
		e.setCell(2, 3.0);
		e.setCell(3, 1);
		e.setCell(4, "重要");
		e.setCell(5, "专业");

		try {
			e.export();
			System.out.println(" 导出Excel文件[成功] ");
		} catch (IOException ex) {
			System.out.println(" 导出Excel文件[失败] ");
			ex.printStackTrace();
		}
	}

	public void close(OutputStream out ){
		if(out!=null){
			try {
				out.flush();
				out.close();
				out=null;
			} catch (IOException e) {
				logger.error("close ", e);
			}
		}
	}

	public OutputStream getOut() {
		return out;
	}



}
