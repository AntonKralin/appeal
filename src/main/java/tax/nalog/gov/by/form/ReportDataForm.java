package tax.nalog.gov.by.form;

import java.time.LocalDate;

public class ReportDataForm {
	private String 	from;
	private String	to;
	
	public ReportDataForm() {
		LocalDate date = LocalDate.now();
		to = date.toString();
	}

	public ReportDataForm(String from, String to) {
		super();
		this.from = from;
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}
	
	
}
