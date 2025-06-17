package practice;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Info {

	private int id;
	private String name;
	private Category category;
	private List<String> photoUrls;
	private List<Tags> tags;
	private String status;
	private Address address;
	private String fullname;
	
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Category{
		private List<Kingg> King;
		private int id;
		private String name;		
	}
	
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Kingg{
		
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
	
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Address{
		
		private Geo geo;
		private String city;
		private String state;	
	}
	
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Geo{
		private int latt;
		private int longg;
	}
}
