package solr_build_customer;
import java.sql.Connection;

public class Pub_Variable {
	/* Define Public Variable
     * @param 
     * @return 
     * @author   Wing.Xu
     * @Date creation  8/15/2016 4:14:35 PM
     * @Date modification  
     */
	
	public static JDBC_connect jdbcconnection =  new JDBC_connect();
	public static String url = 
			//eBao
			"jdbc:oracle:thin:@172.16.28.46:1523:o46g4";
			//ergo sg
    		//"jdbc:oracle:thin:@10.9.10.9:1521:uatdb";
	public static String user = 
	 "ergo_dm_src_2A";
	//"ERGO_DM_SRC_2A_N1";
	public static String pwd = 
	"ergo_dm_src_2Apwd";
	//"ERGO_DM_SRC_2A_N1";
	
	public static Connection connection = jdbcconnection.JDBCConnection(url,user,pwd);
	
	public static String cfgtab = "T_JSON_RESPONSE";

}
