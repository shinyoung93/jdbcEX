package comsalesforce;

public class AuthorApp {

	public static void main(String[] args) {
		int count = 0;
		AuthorDao dao = new AuthorDaoImpl();
		AuthorVO vo = new AuthorVO(1,"홍길동", "홍길동");
		System.out.println("AutorApp.dao.insert(vo) --> "  + vo);
		//count = dao.insert(vo);
		
		System.out.println("AutorApp.dao.insert(vo) --> "  + count);
		dao.getList();
		dao.delete(36);
		vo = new AuthorVO(1,"이문열", "이상한데");
		dao.update(vo);
		dao.getList();
		int id = 28;
		long id2 = 28;
		Long id3 = new Long(28);
		Integer id4 = new Integer(28);
		dao.delete(id);
		
	}

}
