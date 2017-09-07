package solr_build_customer;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class MigrationResourseTest {

	public void CallAPI() throws Exception {
		String url = 
        		//MNC_DC
        		"http://172.25.16.125/restlet/v1/public/index/rebuild?"; 
        		//ERGO_UAT2
				//"http://172.25.12.122/restlet/v1/pa/migration/policy";
        RestTemplate restTemplate = new RestTemplate();
        // set http headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        // get permission
        headers.add("Authorization", "Basic QURNSU46ZUJhbzEyMzQ= ");
        
        // set url parameters to http request  --organization
        InputStream is = this.getClass()
                       .getResourceAsStream("Org_Index_Rebuild.json");
        String IndexJson=IOUtils.toString(is);
        System.out.println("^^^^^^^^^^^^Org_Index_Rebuild^^^^^^^^^^^^\n"+IndexJson);
        HttpEntity<String> requestEntity = new HttpEntity<String>(IndexJson, headers);

        // get Party object through restful services
        //String result = restTemplate.postForObject(url, requestEntity, String.class);
        ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Object.class);  
        
        System.out.println("^^^^^^^^^^^^Org_Index_Rebuild result^^^^^^^^^^^^\n"+response);

        // set url parameters to http request  --individual
        is = this.getClass()
                .getResourceAsStream("Indi_Index_Rebuild.json");
        
        IndexJson=IOUtils.toString(is);
        System.out.println("^^^^^^^^^^^^Indi_Index_Rebuild^^^^^^^^^^^^\n"+IndexJson);
        requestEntity = new HttpEntity<String>(IndexJson, headers);

        // get Party object through resful services
        //String result = restTemplate.postForObject(url, requestEntity, String.class);
        response = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Object.class);  
   
        System.out.println("^^^^^^^^^^^^Indi_Index_Rebuild result^^^^^^^^^^^^\n"+response);

	}

	/*public String getAccessToken() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		 String url =
		// "http://172.25.17.213:8091/cas-server/v1/tickets?username=ADMIN&password=eBao1234";
		//MNC_DC
		 "http://172.25.16.125/cas-server/v1/tickets?username=ADMIN&password=eBao1234";
		//"http://172.25.12.122/cas-server/v1/tickets?username=ADMIN&password=eBao1234";
		ResponseEntity<String> response = restTemplate.exchange(url,
				HttpMethod.POST, null, String.class);
		String accessToken = response.getBody().toString();
		accessToken = accessToken.replace("{\"access_token\":\"", "");
		accessToken = accessToken.replace("\"}", "");
		System.out.println("*******************" + accessToken);
		accessToken = "TGT-34-Tg241FtQDB5eMXL19GtP4MzkdzmCgupQcHPMfGC04YwT0LOWPn-cas01.example.org";
		return accessToken;

	}*/

	public static void main(String args[]) throws Exception {
		System.out.println("I am Ready!");
		long starttime = System.currentTimeMillis();
		MigrationResourseTest migrationResourseTest = new MigrationResourseTest();
		migrationResourseTest.CallAPI();
		
		long endtime = System.currentTimeMillis();
		System.out.println((endtime - starttime) / 1000 + "s");
	}

}
