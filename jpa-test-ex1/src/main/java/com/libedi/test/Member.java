package com.libedi.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author libedi
 *
 */
@Entity
@Table(name="MEMBER")
public class Member {
	
	@Id
	@Column(name="ID")
	private String id;			// 아이디
	
	@Column(name="NAME")
	private String username;	// 이름
	
	// 매핑 정보가 없는 필드 : DB가 대소문자를 구분하면 명시적으로 @Column을 해줘야한다.
	private Integer age;		// 나이
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
