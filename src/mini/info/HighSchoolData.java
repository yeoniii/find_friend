package mini.info;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HighSchoolData {
   public static void main(String[] args) {
      
      Connection conn = null;
      PreparedStatement pstmt = null;
      try {
         String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";   //본인 데이터베이스 설정에 맞게 쓸것
         String id = "find";   // 본인 데이터베이스 아이디에 맞춰서 쓸것
         String pw = "friend";   // 본인 데이터베이스 비밀번호에 맞춰서 쓸것
         
         Class.forName("oracle.jdbc.driver.OracleDriver");

         conn = DriverManager.getConnection(url, id, pw);

         BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\YR\\Desktop\\MINI\\school\\school_info.txt"), "euc-kr"));   // 파일경로는 본인에 맞춰서..
          String line;
          String [] str = null;
          
          String sql = "insert into highschool values(school_num_seq.nextval,?,?,?)";   // 시퀀스 이름 바꿀것
          
          pstmt = conn.prepareStatement(sql);
          
          while ((line = in.readLine()) != null) {
             str = line.split(",");
             if(str.length == 2) {
                pstmt.setString(1, str[0]);
                pstmt.setString(2, str[1]);
                pstmt.setNull(3, java.sql.Types.NULL);
                pstmt.executeUpdate();
             } else if (str.length == 3) {
                pstmt.setString(1, str[0]);
                pstmt.setString(2, str[1]);
                pstmt.setString(3, str[2]);
                pstmt.executeUpdate();
             }
          }
          System.out.println("고등학교 자료 넣기 완료");
          in.close();
          
          } catch (Exception e) {
              System.err.println(e);
          } finally {
             if(pstmt != null) try{pstmt.close();}catch(SQLException sqle){}
             if(conn != null) try{conn.close();}catch(SQLException sqle){} 
          }
   }
}