/**
 * 
 */
package tax.nalog.gov.by.entity;

/**
 * @author AntonKralin
 *
 */
public class Appeals {

	private int 	id_appeals;
	private String 	date;
	private String 	who;
	private String 	what;
	private String 	result;
	private String 	done;
	private String 	type;
	private String 	unit;
	private int 	id_imns;
	
	public Appeals() {
		
	}

	public Appeals(int id_appeals, String date, String who, String what, String result, String done, String type,
			String unit, int id_imns) {
		super();
		this.id_appeals = id_appeals;
		this.date = date;
		this.who = who;
		this.what = what;
		this.result = result;
		this.done = done;
		this.type = type;
		this.unit = unit;
		this.id_imns = id_imns;
	}

	public int getId_appeals() {
		return id_appeals;
	}

	public void setId_appeals(int id_appeals) {
		this.id_appeals = id_appeals;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public int getId_imns() {
		return id_imns;
	}

	public void setId_imns(int id_imns) {
		this.id_imns = id_imns;
	}
	
}
