package comsalesforce;

public interface AuthorDao {
	public int insert(AuthorVO vo);
	public void getList();
	public int delete(int authorId);
	public int update(AuthorVO vo);
}
