package payloads;

import com.fasterxml.jackson.core.sym.Name;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Setter
@Getter
public class UserDto {
   
	 private String id;
	 private String username;
	 private String email;
	 private String password;
}
