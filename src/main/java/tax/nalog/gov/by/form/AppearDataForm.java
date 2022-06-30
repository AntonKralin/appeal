package tax.nalog.gov.by.form;

import java.text.SimpleDateFormat;
import java.util.Date;

import tax.nalog.gov.by.entity.Appeals;

public class AppearDataForm {
	private int 	id;
	private String 	date;
	private String	message;
	private String 	who;
	private String 	what;
	private String 	result;
	private String 	done;
	private String 	type;
	private String 	unit;
	private String	imns[];
	
	public AppearDataForm() {
		this.id = 0;
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
		Date parsingDate = new Date();
		this.date = ft.format(parsingDate);
	}

	public AppearDataForm(int id, String date, String who, String what, String result, String done, String type, String unit, String[] imns, String message) {
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
		this.message = message;
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
	
	public String[] getImns() {
		return imns;
	}
	
	public String getImns2() {
		String buf="";
		for (String str:this.imns) {
			if (buf.equals("")) {
				buf += str;
			}else {
				buf += ","+str;
			}
		}
		return buf;
	}

	public void setImns(String[] imns) {
		this.imns = imns;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setByAppeal(Appeals appeal) {
		this.id = appeal.getId();
		if (appeal.getDate() != null) {
			this.date = appeal.getDate().toString();
		}else {
			this.date = "";
		}
		this.message = appeal.getMessage();
		this.who = appeal.getWho();
		this.what = appeal.getWhat();
		this.result = appeal.getResult();
		this.done = appeal.getDone();
		this.type = appeal.getType();
		this.unit = appeal.getUnit();
		if (appeal.getImns() != null) {
			this.imns = appeal.getImns().split(",");
		}else {
			this.imns = null;
		}
	} 
	
}
