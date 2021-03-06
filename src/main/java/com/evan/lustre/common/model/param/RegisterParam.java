package com.evan.lustre.common.model.param;

import com.evan.lustre.common.model.dto.base.InputConverter;
import com.evan.lustre.common.model.entity.User;
import lombok.Data;

import javax.validation.constraints.*;

/**
 * @ClassName RegisterParam
 * @Description
 * @Author EvanWang
 * @Version 1.0.0
 * @Date 2019/12/5 16:32
 */
@Data
public class RegisterParam implements InputConverter<User> {

    @NotBlank(message = "用户名不能为空")
    @Size(min = 8, max = 50, message = "账户的字符长度必须在 {min} - {max} 之间")
    private String accountId;

    @NotBlank(message = "注册密码不能为空")
    @Size(min = 8, max = 50, message = "注册密码的字符长度必须在 {min} - {max} 之间")
    private String password;

    @NotBlank(message = "昵称不能为空")
    @Size(max = 50, message = "昵称长度不能超过 {max}")
    private String nickName;

    @NotNull(message = "性别标识不能为空")
    @Min(value = 0, message = "性别标识不能小于 {value}")
    @Max(value = 1, message = "性别标识不能大于 {value}")
    private Integer gender;

    @NotBlank(message = "地址不能为空")
    @Size(max = 255, message = "地址内容长度不能超过 {max}")
    private String address;

    @Pattern(regexp = "^1[3456789]\\d{9}$", message = "输入手机号码格式不正确，请重新输入")
    private String phoneNumber;

    @Email(message = "电子邮件地址的格式不正确")
    @NotBlank(message = "电子邮件地址不能为空")
    @Size(max = 50, message = "电子邮件的字符长度不能超过 {max}")
    private String email;

    @NotNull(message = "角色标识不能为空")
    @Min(value = 1, message = "角色标识不能小于 {value}")
    @Max(value = 3, message = "角色标识不能大于 {value}")
    private Integer role;
}
