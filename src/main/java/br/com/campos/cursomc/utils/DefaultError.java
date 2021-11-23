package br.com.campos.cursomc.utils;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefaultError implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer httpCode;
	private String msg;
	private Long timeStamp;
	
	public DefaultError(Integer httpCode, String msg, Long timeStamp) {
		super();
		this.httpCode = httpCode;
		this.msg = msg;
		this.timeStamp = timeStamp;
	}
	
	

}
