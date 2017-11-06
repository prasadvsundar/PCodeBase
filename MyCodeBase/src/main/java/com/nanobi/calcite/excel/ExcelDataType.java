package com.nanobi.calcite.excel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.calcite.adapter.java.JavaTypeFactory;
import org.apache.calcite.rel.type.RelDataType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 * @author Prasad V S(EmpId:1036)
 * @version 1.0
 * @organization NanoBi Analytics
 * @Date Nov 17, 2014
 */
public class ExcelDataType {
	final int MAX_CHECK_COLUMN_COUNT = 10;
	private Iterator<Row> rows;

	public ExcelDataType(Iterator<Row> rows) {
		this.rows = rows;
	}

	public Map<String, Object> getColumnNameAndType(JavaTypeFactory typeFactory) {
		Map<String, Object> columnData = new HashMap<String, Object>();
		List<RelDataType> typesList = new ArrayList<>();
		List<String> names = new ArrayList<>();
		List<ExcelFieldType> ExcelFieldTypes = new ArrayList<>();
		
		RelDataType[] types;
		int counter=0;
		while(rows.hasNext()){
			 Row row = rows.next();
	    	 Iterator<Cell> cellIterator = row.cellIterator();
	    	  while (cellIterator.hasNext()){
	    		Cell cell = cellIterator.next();
				names.add(cell.getStringCellValue());
			}
	    	break;
	      }
		types = new RelDataType[names.size()];
		if(rows.hasNext()&&checkArrayHasNullValue(types)){
			 Row row = rows.next();
	    	 Iterator<Cell> cellIterator = row.cellIterator();
	    	  while (cellIterator.hasNext()){
	    		Cell cell = cellIterator.next();
				ExcelFieldType fieldType = ExcelFieldType.of(cell);
				RelDataType type;
				if (fieldType == null) {
      	          type = typeFactory.createJavaType(String.class);
      	        } else {
      	          type = fieldType.toType(typeFactory);
      	        }
                if(types[cell.getColumnIndex()]==null){
                	types[cell.getColumnIndex()]=type;
                	ExcelFieldTypes.add(fieldType);
                }
			}
	      }
		convertAllNullToStringType(types,typeFactory);
		typesList = Arrays.asList(types);
		columnData.put("columnDataTyeps", typesList);
		columnData.put("columnNames", names);
		columnData.put("excelFieldTypes", ExcelFieldTypes);
		return columnData;
	}
	
	boolean checkArrayHasNullValue(RelDataType[] array){
		for(RelDataType obj:array){
			if(obj==null){
				return true;
			}
		}
		return false;
	}
	
	void convertAllNullToStringType(RelDataType[] array,JavaTypeFactory typeFactory){
		for(int i=0;i<array.length;i++){
			if(array[i]==null){
				RelDataType type = typeFactory.createJavaType(String.class);
				array[i]=type;
			}
		}
	}
	
	public Object getValue(Cell cell) {

		switch (cell.getCellType()) {
		
		case Cell.CELL_TYPE_NUMERIC: {
			return cell.getNumericCellValue();
		}
		
		case Cell.CELL_TYPE_BOOLEAN:{
			return cell.getBooleanCellValue();
		
		}
		
		case Cell.CELL_TYPE_STRING:{
			
		}
		return cell;
	}
		return cell;
	}
	
}
