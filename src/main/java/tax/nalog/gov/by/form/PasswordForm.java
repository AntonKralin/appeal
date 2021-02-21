package tax.nalog.gov.by.form;

import org.apache.log4j.Logger;
import tax.nalog.gov.by.entity.Admins;

public class PasswordForm {
		private String username;
		private String password;
		private int access;
		private static final Logger logger = Logger.getLogger(PasswordForm.class);
		
		public PasswordForm() {
		}
		
		public PasswordForm(String username, String password, int access) {
			super();
			this.username = username;
			this.password = password;
			this.access = access;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public int getAccess() {
			return access;
		}

		public void setAccess(int access) {
			this.access = access;
		}
		
		public boolean equals(Admins admin) {
			boolean rez = false;
			
			if (this.username.equals(admin.getLogin()) ) {
				if (this.password.equals(admin.getPassword())) {
					rez = true;
				}
			}
			
			return rez;
		}
		
}
