package ResourcesOnJson;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

import java.util.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReaderClass {
	
	
	public  List<HashMap<String, String>> getDataFromJson() throws IOException {
		
	String jsonContent=	FileUtils.readFileToString(new File("C://Users//subek//eclipse-workspace//ECommerceE2E//src//test//java//ResourcesOnJson//data.json"),StandardCharsets.UTF_8);
		ObjectMapper mapper=new ObjectMapper();
		
		List<HashMap<String,String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){
			
		});
		return data;
		
	}

}
