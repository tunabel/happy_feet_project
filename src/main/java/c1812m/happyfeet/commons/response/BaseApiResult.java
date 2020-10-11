package c1812m.happyfeet.commons.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaseApiResult {

   private boolean isSuccess;
   private String message;
}
