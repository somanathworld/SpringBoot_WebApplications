package com.nt.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.nt.model.Employee;

@Component("excelreport")
public class EmployeeExcelView extends AbstractXlsView{

	private int i = 0;

	@Override
	protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("EmployeeExcelView.buildExcelDocument()");
		//get Model attribute
		Iterable<Employee> empList = (Iterable<Employee>)map.get("empList");
		//create sheet
		Sheet sheet1 = workbook.createSheet("Sheet1");
		//add Rows to sheet
		empList.forEach(emp->{
			//add Row Sheet representing employee record
			Row row = sheet1.createRow(i);
			//add cells to Row
			row.createCell(0).setCellValue(emp.getEmpno());
			row.createCell(1).setCellValue(emp.getEname());
			row.createCell(2).setCellValue(emp.getJob());
			row.createCell(3).setCellValue(emp.getSal());
			if(emp.getDeptno() != null)
				row.createCell(4).setCellValue(emp.getDeptno());
			
			i++;
		});
	}
	
}
