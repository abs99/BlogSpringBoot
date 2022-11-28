package blog.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Setter
@Getter
public class UserDto {
   
	 private Long id;
	 private String username;
	 private String email;
	 private String password;
}
