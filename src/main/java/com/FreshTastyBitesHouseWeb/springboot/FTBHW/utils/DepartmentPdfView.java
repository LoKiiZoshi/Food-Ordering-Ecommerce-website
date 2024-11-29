/*
 * package com.FreshTastyBitesHouseWeb.springboot.FTBHW.utils;
 * 
 * import java.awt.Color; import java.util.Date; import java.util.List; import
 * java.util.Map;
 * 
 * 
 * import org.springframework.web.servlet.view.document.AbstractPdfView;
 * 
 * import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.Department; import
 * com.lowagie.text.Document; import com.lowagie.text.Element; import
 * com.lowagie.text.Font; import com.lowagie.text.HeaderFooter; import
 * com.lowagie.text.Paragraph; import com.lowagie.text.Phrase; import
 * com.lowagie.text.pdf.PdfPTable; import com.lowagie.text.pdf.PdfWriter;
 * 
 * import jakarta.servlet.http.HttpServletRequest; import
 * jakarta.servlet.http.HttpServletResponse;
 * 
 * 
 * public class DepartmentPdfView extends AbstractPdfView {
 * 
 * @Override protected void buildPdfMetadata( Map<String, Object> model,
 * Document document, HttpServletRequest request) { HeaderFooter header = new
 * HeaderFooter(new Phrase("DEPARTMENT PDF VIEW"), false);
 * header.setAlignment(Element.ALIGN_CENTER); document.setHeader(header);
 * 
 * HeaderFooter footer = new HeaderFooter(new Phrase(new
 * Date()+" (C) bway, Page # "), true);
 * footer.setAlignment(Element.ALIGN_CENTER); document.setFooter(footer); }
 * 
 * @Override protected void buildPdfDocument( Map<String, Object> model,
 * Document document, PdfWriter writer, HttpServletRequest request,
 * HttpServletResponse response) throws Exception {
 * 
 * //download PDF with a given filename
 * response.addHeader("Content-Disposition",
 * "attachment;filename=department.pdf");
 * 
 * //read data from controller
 * 
 * @SuppressWarnings("unchecked") List<Department> list = (List<Department>)
 * model.get("dList");
 * 
 * //create element //Font (Family, Size, Style, Color) Font titleFont = new
 * Font(Font.TIMES_ROMAN, 30, Font.BOLD, Color.RED); Paragraph title = new
 * Paragraph("DEPARTMENT DATA",titleFont);
 * title.setAlignment(Element.ALIGN_CENTER); title.setSpacingBefore(20.0f);
 * title.setSpacingAfter(25.0f); //add to document document.add(title);
 * 
 * Font tableHead = new Font(Font.TIMES_ROMAN, 12, Font.BOLD, Color.BLUE);
 * PdfPTable table = new PdfPTable(4);// no.of columns table.addCell(new
 * Phrase("ID",tableHead)); table.addCell(new
 * Phrase("DEPARTMENT NAME",tableHead)); table.addCell(new
 * Phrase("DEPARTMENT HOD",tableHead)); table.addCell(new
 * Phrase("DEPARTMENT PHONE",tableHead));
 * 
 * for(Department spec : list ) { table.addCell(String.valueOf(spec.getId()));
 * table.addCell(spec.getDepartmentName());
 * table.addCell(spec.getDepartmentHead());
 * table.addCell(spec.getDepartmentPhone()); } //add to document
 * document.add(table); } }
 */