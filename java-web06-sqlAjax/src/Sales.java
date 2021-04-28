public class Sales {
	private int t_id;

	private float t_price;

	private int t_num;

	private String t_name;

	public Sales(int t_id, float t_price, int t_num, String t_name) {
		this.t_id = t_id;
		this.t_price = t_price;
		this.t_num = t_num;
		this.t_name = t_name;
	}

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public float getT_price() {
		return t_price;
	}

	public void setT_price(float t_price) {
		this.t_price = t_price;
	}

	public int getT_num() {
		return t_num;
	}

	public void setT_num(int t_num) {
		this.t_num = t_num;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
}
