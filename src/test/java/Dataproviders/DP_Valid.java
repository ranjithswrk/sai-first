package Dataproviders;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

import Genericlibraries.Xls_Reader;

public class DP_Valid {
	
	@DataProvider(name = "Valid_DP")
	
		public static Object[][] Valid_DP ()
	
	
	{
		
		DP_Valid forexcel = new DP_Valid();
		List<String> valid = forexcel.excelreader("P");
		Object[][] obj = new Object[valid.size()][4];
		
		for(int i=0;i<valid.size();i++){
			
			obj[i][0]= valid.get(i).split(";")[0];
			//System.out.println(obj[i][0]);
			obj[i][1] = valid.get(i).split(";")[1];
			obj[i][2] = valid.get(i).split(";")[2];
			obj[i][3] = valid.get(i).split(";")[3];
		}
		
		
			
		return obj;
		
		
				
		
	}
	
	@DataProvider (name = "Invalidlogin")
	
	public static Object[] Invalidlogin(){
		
		
		DP_Valid invalid = new DP_Valid();
		
		List<String> listinvalid = invalid.excelreader("N");
		Object[][] obj = new Object[listinvalid.size()][3];
		for (int i=0;i<listinvalid.size();i++){
			
			 obj[i][0] = listinvalid.get(i).split(";")[0];
			 obj[i][1] = listinvalid.get(i).split(";")[1];
			 obj[i][2] = listinvalid.get(i).split(";")[2];
			 obj[i][3] = listinvalid.get(i).split(";")[3];
		}
		
		return obj;
		
		
		
	}
	
	
	
	public List<String> excelreader(String key){
		//get excel
		Xls_Reader read = new Xls_Reader("C:\\Users\\RE041943\\Desktop\\information\\Training\\Framework\\Test_Data.xlsx");
		//read data and count
		
		int rowCount = read.getRowCount("Scenario_Login");
		//get data and str in list later so create list
		
		List<String> arr = new ArrayList<String>();
		for(int i=2;i<=rowCount;i++){
			
			
			
			String status = read.getCellData("Scenario_Login", "Status", i);
			
			if(status.equals(key)){
				
				String TC_ID = read.getCellData("Scenario_Login", "TC_ID", i);
				String Uname = read.getCellData("Scenario_Login", "Uname", i);
				String Pwd = read.getCellData("Scenario_Login", "Pwd", i);
				String Exp_Res = read.getCellData("Scenario_Login", "Exp_Res", i);
				
				arr.add(TC_ID+";"+Uname+";"+Pwd+";"+Exp_Res);
				
				
			}
			
			
			
			
		}
		
		return arr;
		
		
	}
	
	

}
