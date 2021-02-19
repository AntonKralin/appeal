/**
 * 
 */
package tax.nalog.gov.by.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * @author AntonKralin
 *
 */

@Entity
@Table(name = "imns")
public class Imns {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int number;
	private String name;
	private String unp;
	private String address;
	private String post;
	private String mail;
	@Column(name = "shot_name")
	private String shotName;
	
	@OneToMany(mappedBy="admin_imns", fetch=FetchType.LAZY)
	private List<Admins> admins;
	
	@OneToMany(mappedBy="appeal_imns", fetch=FetchType.LAZY)
	private List<Appeals> appeals;
	
	public Imns() {	
	}
	
	public Imns(int id, int number, String name, String unp, String address, String post, String mail,
			String shotName) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
		this.unp = unp;
		this.address = address;
		this.post = post;
		this.mail = mail;
		this.shotName = shotName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnp() {
		return unp;
	}
	public void setUnp(String unp) {
		this.unp = unp;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getShotName() {
		return shotName;
	}
	public void setShotName(String shotName) {
		this.shotName = shotName;
	}
	
	@Override
	public String toString() {
		return "models.Imns{" +
                "id=" + id +
                ", shotname='" + shotName + '\'' +
                ", age=" + number +
                ", unp=" + unp +
                '}';
	}
}
