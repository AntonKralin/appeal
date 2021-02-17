/**
 * 
 */
package tax.nalog.gov.by.entity;

/**
 * @author AntonKralin
 *
 */
public class Admins {
	
	private int id;
	private String login;
	private String password;
	private int id_imns;
	private int id_access;
	
	public Admins() {
		
	}

	public Admins(int id, String login, String password, int id_imns, int id_access) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.id_imns = id_imns;
		this.id_access = id_access;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId_imns() {
		return id_imns;
	}

	public void setId_imns(int id_imns) {
		this.id_imns = id_imns;
	}

	public int getId_access() {
		return id_access;
	}

	public void setId_access(int id_access) {
		this.id_access = id_access;
	}
	
}
