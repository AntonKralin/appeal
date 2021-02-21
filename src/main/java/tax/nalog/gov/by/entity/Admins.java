/**
 * 
 */
package tax.nalog.gov.by.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * @author AntonKralin
 *
 */

@Entity
@Table(name = "admins")
public class Admins {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String login;
	private String password;
	private int access;
	
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name="id_imns")
	private Imns admin_imns;
	
	
	public Admins() {
		
	}

	public Admins(int id, String login, String password, Imns admin_imns, int access) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.admin_imns = admin_imns;
		this.access = access;
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

	public Imns getImns() {
		return admin_imns;
	}

	public void setImns(Imns admin_imns) {
		this.admin_imns = admin_imns;
	}

	public int getAccess() {
		return access;
	}

	public void setAccess(int access) {
		this.access = access;
	}
	
	@Override
	public String toString() {
		return "models.Admins{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password=" + password +
                ", access=" + access +
                '}';
	}
}
