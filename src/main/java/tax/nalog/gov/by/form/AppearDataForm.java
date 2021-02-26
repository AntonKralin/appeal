package tax.nalog.gov.by.form;

import tax.nalog.gov.by.entity.Appeals;

public class AppearDataForm {
	private int 	id;
	private String 	date;
	private String 	who;
	private String 	what;
	private String 	result;
	private String 	done;
	private String 	type;
	private String 	unit;
	private int		imns;
	
	public AppearDataForm() {
		this.id = 0;
	}

	public AppearDataForm(int id, String date, String who, String what, String result, String done, String type, String unit, int imns) {
		super();
		this.id = id;
		this.date = date;
		this.who = who;
		this.what = what;
		this.result = result;
		this.done = done;
		this.type = type;
		this.unit = unit;
		this.imns = imns;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public int getImns() {
		return imns;
	}

	public void setImns(int imns) {
		this.imns = imns;
	}

	public void setByAppeal(Appeals appeal) {
		this.id = appeal.getId();
		this.date = appeal.getDate();
		this.who = appeal.getWho();
		this.what = appeal.getWhat();
		this.result = appeal.getResult();
		this.done = appeal.getDone();
		this.type = appeal.getType();
		this.unit = appeal.getUnit();
		this.imns = appeal.getId_imns().getId();
	} 
	
}
