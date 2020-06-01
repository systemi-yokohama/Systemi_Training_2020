public class Book {
	private int id;
	private int authors_id;
	private String title;

	public  int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAuthors_id() {
		return this.authors_id;
	}
	public void setAuthors_id(int authors_id) {
		this.authors_id = authors_id;
	}
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Book [id=]" + id + ", authors_id=" + authors_id
			+ ", title=" + title + "]";
	}
}