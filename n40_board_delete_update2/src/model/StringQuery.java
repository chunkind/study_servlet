package model;
/*
 * 이제까지 Dao에서는 비지니스 로직 마다마다 그에 해당하는 sql문이 들어갔었다.
 * 이런 요인 때문에 dao는 길어질수 밖에 없었고 쿼리문의 수정이 불가파할때는
 * 비지니스 로직을 건드려야 하는 일이 빈번해졌다.
 * --> 
 * 1)쿼리문을 상수값으로 만들어서 외부로 분리시켰다
 *   interface StringQuery 
 * 2)나중에 인터페이스는 xml로 전환될 것이다.
 *   IBatis / MyBatis 프레임워크 기술 
 */
public interface StringQuery {
	String INSERT_POSTING=
			"INSERT INTO board (no, title, writer, password, content, time_posted)"
			+ " VALUES(board_seq.nextVal,?,?,?,?,sysdate)";
	
	String CURRNET_NO=  
			"SELECT board_seq.currVal FROM dual";//1
	
	String SELECT_POSTING =
			"SELECT no, title, writer, content,hits, time_posted FROM board"
			+ " WHERE no=?";
	String PAGE_LIST = 
			"SELECT no, title, writer, hits, to_char(time_posted,'YYYY.MM.DD')"
			+ " time_posted FROM board";
	String CHECK_PASS = 
			"SELECT COUNT(-1) FROM board WHERE no=? AND password=?";
	
	String DELETE_POSTING= 
			"DELETE FROM board WHERE no=?";
	
	String UPDATE_HITS=
			"UPDATE board set hits =(?)+1 WHERE no =?";
	
	String UPDATE_POSTING =
			"UPDATE board set title = ?, writer = ?, content = ? WHERE no =?";
}













