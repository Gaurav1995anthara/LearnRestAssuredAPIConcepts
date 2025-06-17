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
public class Complex {
	
	private int id;
	private String name;
	private Category category;
	private List<String> photoUrls;
	private List<Tagsk> tags;
	private String status;
	private Address address;
	private String fullname;
	
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Address{
		private String city;
		private String state;
		private Geo geo;
	}

	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Geo{
		private String latt;
		private String longg;
	}
	
	
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Tagsk{
		private int id;
		private String name;
	}
	
	
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Category{
		private List<King> king;
		private int id;
		private String name;
	}
	
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class King{
		private int id;
		private String name;
	}
}
