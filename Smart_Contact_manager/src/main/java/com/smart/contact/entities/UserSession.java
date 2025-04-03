package com.smart.contact.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class UserSession implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String email;
}
