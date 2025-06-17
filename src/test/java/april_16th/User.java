package april_16th;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

		private String name;
		private String gender;
		private String email;
		private String status;
	
}
