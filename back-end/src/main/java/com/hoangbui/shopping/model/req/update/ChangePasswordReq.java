package com.hoangbui.shopping.model.req.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ChangePasswordReq {
    @NotNull(message = "Mật khẩu cũ trống")
    @NotEmpty(message = "Mật khẩu cũ trống")
    @Size(min = 4, max = 20, message = "Mật khẩu phải chứa từ 4 - 20 ký tự")
//    @ApiModelProperty(
//            example = "verysecretpassword",
//            notes = "Mật khẩu trống",
//            required = true
//    )
    @JsonProperty("old_password")
    private String oldPassword;

    @NotNull(message = "Mật khẩu mới trống")
    @NotEmpty(message = "Mật khẩu mới trống")
    @Size(min = 4, max = 20, message = "Mật khẩu phải chứa từ 4 - 20 ký tự")
//    @ApiModelProperty(
//            example = "verysecretpassword",
//            notes = "Mật khẩu trống",
//            required = true
//    )
    @JsonProperty("new_password")
    private String newPassword;
}