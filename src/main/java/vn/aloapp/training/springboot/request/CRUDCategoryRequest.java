package vn.aloapp.training.springboot.request;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CRUDCategoryRequest extends BaseRequest{

	@NotEmpty(message = "Mã người nhập không được để trống")
	@JsonProperty("user_id")
    private int userId;

	@NotEmpty(message = "Code không được phép null")
    private String code;

	@NotEmpty(message = "Tên không được phép null")
    private String name;

	@NotNull(message = "Tên tiền tố không được null")
    private String prefixName;

	@NotNull(message = "Normalize Name tố không được null")
    @Column(name = "normalize_name")
    private String normalizeName;

    private String description;

    private int sort;
}
