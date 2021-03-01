/**
 * 
 */
package tax.nalog.gov.by.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * @author AntonKralin
 *
 */

@Entity
@Table(name = "appeals")
public class Appeals {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int 	id;
	@Column
	@Type(type="date")
	private Date 	date;
	private String message;
	private String 	who;
	@Column(name="what", columnDefinition="TEXT")
	private String 	what;
	private String 	result;
	@Column(name="done", columnDefinition="TEXT")
	private String 	done;
	private String 	type;
	private String 	unit;
	
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name="id_imns")
	private Imns appeal_imns;
	
	public Appeals() {
		
	}

	public Appeals(int id, Date date, String who, String what, String result, String done, String type,
			String unit, Imns appeal_imns, String message) {
		super();
		this.id = id;
		this.date = date;
		this.who = who;
		this.what = what;
		this.result = result;
		this.done = done;
		this.type = type;
		this.unit = unit;
		this.appeal_imns = appeal_imns;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(String date) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			this.date = dateFormat.parse(date);
		}catch (Exception e) {
			e.printStackTrace();
			this.date = null;
			return;
		}
	}

	public String getWho() {
		return who;
	}

	public void setWho(String who) {
		this.who = who;
	}

	public String getWhat() {
		return what;
	}

	public void setWhat(String what) {
		this.what = what;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getDone() {
		return done;
	}

	public void setDone(String done) {
		this.done = done;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Imns getId_imns() {
		return appeal_imns;
	}

	public void setId_imns(Imns appeal_imns) {
		this.appeal_imns = appeal_imns;
	}
	
	public String getDateMessage() {
		if ( this.date == null ) {
			return message;
		}else {
			if ( (this.message==null) || (this.message.equals("")) ) {
				return this.date.toString();
			}else {
				return this.date.toString() +" / "+this.message;
			}
		}
	}
	
}
