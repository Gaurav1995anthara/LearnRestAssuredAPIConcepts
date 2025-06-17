package april_21st;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetAPI {

	private int id;
	private String name;
	private String status;
	private Category category;
	private List<String> photoUrls;
	private List<Tags> tags;
	
	
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Category{
		private int id;
		private String name;
	}
	
	
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Tags{
		private int id;
		private String name;
	}
}
