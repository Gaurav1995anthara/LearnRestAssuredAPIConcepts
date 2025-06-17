package april_28th_xml;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "MRData")
public class MRData {

	@JacksonXmlProperty(isAttribute = true)
	private String series;
	
	@JacksonXmlProperty(isAttribute = true)
	private String url;
	
	@JacksonXmlProperty(isAttribute = true)
	private String limit;
	
	@JacksonXmlProperty(isAttribute = true)
	private String offset;
	
	@JacksonXmlProperty(isAttribute = true)
	private String total;
	
	@JacksonXmlProperty(localName = "CircuitTable")
	private CircuitTable circuitTable;
	
	@Data
	public static class CircuitTable{
		
		@JacksonXmlProperty(isAttribute = true)
		private String season;
		
		@JacksonXmlProperty(localName = "Circuit")
		private List<Circuit> circuits;
		
		@Data
		public static class Circuit{
			

			@JacksonXmlProperty(isAttribute = true)
			private String circuitId;

			@JacksonXmlProperty(isAttribute = true)
			private String url;

			@JacksonXmlProperty(localName = "CircuitName")
			private String circuitName;
			
			@JacksonXmlProperty(localName = "Location")
			private Location location;
			
			@Data
			public static class Location{
				
				@JacksonXmlProperty(isAttribute = true, localName = "lat")
				private String latitude;

				@JacksonXmlProperty(isAttribute = true, localName = "long")
				private String longitude;

				@JacksonXmlProperty(localName = "Locality")
				private String locality;

				@JacksonXmlProperty(localName = "Country")
				private String country;
				
			}
			
		}
	}
}
