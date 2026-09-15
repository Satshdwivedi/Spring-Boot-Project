package com.example.demo.model;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor 
public class LoginDTO {
  private String email;
  private String password;
 
  public LoginDTO(String email, String password) {
    this.email = email;
    this.password = password;
  }
 
}
