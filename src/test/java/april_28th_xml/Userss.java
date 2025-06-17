package april_28th_xml;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "objects")
public class Userss {

	@JacksonXmlProperty(isAttribute = true, localName = "type")
	private String type;
	
	@JacksonXmlElementWrapper(useWrapping = false)
	@JacksonXmlProperty(localName = "object")
	private List<ObjectData> object;
	
	@Data
	public static class ObjectData{
		
		@JacksonXmlProperty(localName = "name")
		private String name;

		@JacksonXmlProperty(localName = "gender")
		private String gender;

		@JacksonXmlProperty(localName = "email")
		private String email;

		@JacksonXmlProperty(localName = "status")
		private String status;
		
		@JacksonXmlProperty(localName = "id")
		private ID id;
		
		@Data
		public static class ID{
			
			@JacksonXmlProperty(isAttribute = true)
			private String type;
			
			@JacksonXmlText
			private int value;
		}

	}
	
}
