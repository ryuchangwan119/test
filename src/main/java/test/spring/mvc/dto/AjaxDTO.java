package test.spring.mvc.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AjaxDTO {
	private String msg;
	private String extra;
	@Override
	public String toString() {
		return "Ajax[msg : " + msg + ", extra :" + extra + "]";
	}
	
	
}
