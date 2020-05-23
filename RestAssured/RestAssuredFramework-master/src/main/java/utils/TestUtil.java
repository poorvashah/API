package utils;

import java.util.ArrayList;
import java.util.Iterator;

public class TestUtil {
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcel(){
	
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		
	reader= new Xls_Reader("C:\\Users\\dell\\Downloads\\RestAssuredFrameworkDemo\\RestAssuredFramework-master\\inputs\\Testdata.xlsx");
	
	
	for(int rownum =2; rownum<=reader.getRowCount("GetAPI"); rownum++)
	 {
		  
			String host = reader.getCellData("GetAPI", "EndPoint", rownum);
			String ContentType = reader.getCellData("GetAPI", "ContentType", rownum);
			String application = reader.getCellData("GetAPI", "Application", rownum);
			String applicationjson=reader.getCellData("GetAPI", "Json", rownum);
			System.out.println(host);
			System.out.println(ContentType + application + applicationjson);

			Object ob[] = { host,ContentType,application,applicationjson};
			myData.add(ob);

}
	
	
	
	return myData;
	

	
	}
	
	
	public static void main (String args[])
			{
		TestUtil.getDataFromExcel();
			}

}