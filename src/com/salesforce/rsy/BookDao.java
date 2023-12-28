package com.salesforce.rsy;

import java.util.List;

public interface BookDao {

	public int insert(BookVo vo);

	public List<BookVo> select();

	public int delete(int bookId);

	public int update(BookVo vo);
	
	public List<BookVo> search(String ch);

}
