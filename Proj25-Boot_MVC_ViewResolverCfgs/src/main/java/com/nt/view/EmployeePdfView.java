package com.nt.view;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.nt.model.Employee;

@Component("pdfreport")
public class EmployeePdfView extends AbstractPdfView {

	public EmployeePdfView() {
		System.out.println("EmployeePdfView.EmployeePdfView()");
	}
	
	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("EmployeePdfView.buildPdfDocument()");
		//get Model attribute data
		Iterable<Employee> empList = (Iterable<Employee>)map.get("empList");
		//add paragraph
		Paragraph para = new Paragraph("Employee Report", new Font(Font.BOLDITALIC));
		document.add(para);
		//add table content
		Table table = new Table(5, ((ArrayList)empList).size());

		for(Employee emp : empList) {
			table.addCell(String.valueOf(emp.getEmpno()));
			table.addCell(String.valueOf(emp.getEname()));
			table.addCell(String.valueOf(emp.getJob()));
			table.addCell(String.valueOf(emp.getSal()));
			table.addCell(String.valueOf(emp.getDeptno()));
		}
		document.add(table);
	}

}
