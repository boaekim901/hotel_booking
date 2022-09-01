# hotel_booking

sever.xml을 open <br>
https://tomcat.apache.org/  이동 <br>
왼쪽메뉴 Documentation 에서 톰캣9.0 선택 <br>
10번에 JDBC DataSource 클릭<br>
3번째줄에 Database Connection Pool (DBCP 2) Configurations 안에 보면 <br>
4. Oracle 8i, 9i & 10g 클릭<br>
1. Context configuration 확인 가능<br>
파란박스 소스 드래그 <Resource name= << 여기문구
<pre> < Resource name="jdbc/myoracle" auth="Container"
              type="javax.sql.DataSource" driverClassName="oracle.jdbc.OracleDriver"
              url="jdbc:oracle:thin:@127.0.0.1:1521:mysid"
              username="scott" password="tiger" maxTotal="20" maxIdle="10"
              maxWaitMillis="-1"/ > </pre>
              
 server.xml로돌아가서 

<Context docBase="프로젝트명" ~~~~~~ /> 여기서 종료태그 / 삭제 후 아랫줄에 </Context> 생성 <br>
복사한 소스를  여기 사이에 복사   </Context> <br>
 url="jdbc:oracle:thin:@127.0.0.1:1521:XE"  에서 mysid를 XE로 변경 <br>
 username="유저네임" password="설정된 비밀번호" 으로 db랑 연결 <br>
