/*
 * package com.FreshTastyBitesHouseWeb.springboot.FTBHW.utils;
 * 
 * 
 * import java.util.List; import java.util.Map;
 * 
 * 
 * import org.apache.poi.ss.usermodel.Row; import
 * org.apache.poi.ss.usermodel.Sheet; import
 * org.apache.poi.ss.usermodel.Workbook; import
 * org.springframework.web.servlet.view.document.AbstractXlsxView;
 * 
 * import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.Department;
 * 
 * import jakarta.servlet.http.HttpServletRequest; import
 * jakarta.servlet.http.HttpServletResponse;
 * 
 * public class DepartmentExcelView extends AbstractXlsxView {
 * 
 * @Override protected void buildExcelDocument( Map<String, Object> model,
 * Workbook workbook, HttpServletRequest request, HttpServletResponse response)
 * throws Exception {
 * 
 * //1. define your own excel file name
 * response.addHeader("Content-Disposition",
 * "attachment;filename=department.xls");
 * 
 * //2. read data given by Controller
 * 
 * @SuppressWarnings("unchecked") List<Department> list = (List<Department>)
 * model.get("dList");
 * 
 * //3. create one sheet Sheet sheet = workbook.createSheet("DEPARTMENT");
 * 
 * //4. create row#0 as header setHead(sheet);
 * 
 * //5. create row#1 onwards from List<T> setBody(sheet,list); }
 * 
 * private void setHead(Sheet sheet) { Row row = sheet.createRow(0);
 * row.createCell(0).setCellValue("ID");
 * row.createCell(1).setCellValue("DEPARTMENT NAME");
 * row.createCell(2).setCellValue("DEPARTMENT HOD");
 * row.createCell(3).setCellValue("DEPARTMENT PHONE"); }
 * 
 * private void setBody(Sheet sheet, List<Department> list) { int rowNum = 1;
 * for(Department spec : list) { Row row = sheet.createRow(rowNum++);
 * row.createCell(0).setCellValue(spec.getId());
 * row.createCell(1).setCellValue(spec.getDepartmentName());
 * row.createCell(2).setCellValue(spec.getDepartmentHead());
 * row.createCell(3).setCellValue(spec.getDepartmentPhone()); } }
 * 
 * }
 */