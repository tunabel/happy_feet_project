package c1812m.happyfeet.commons.response;

import c1812m.happyfeet.model.Brand;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class DataApiResult extends BaseApiResult {

    private Object data;

    public DataApiResult(boolean isSuccess, String message) {
        super(isSuccess, message);
    }

    public DataApiResult(Object data) {
        this.data = data;
    }
}
