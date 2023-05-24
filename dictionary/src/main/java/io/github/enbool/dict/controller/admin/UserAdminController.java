package io.github.enbool.dict.controller.admin;

import io.github.enbool.dict.model.Result;
import io.github.enbool.dict.model.form.UserRegisterForm;
import io.github.enbool.dict.service.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/5/23 11:17
 */
@OpenAPIDefinition(
        info = @Info(
                title = "User admin API",
                version = "1.0",
                description = "User admin  API"
        ), tags = {
        @Tag(name = "UserAdmin", description = "User admin  API")
}
)
@RestController
@RequestMapping("/admin/user")
public class UserAdminController {
    @Autowired
    private UserService userService;


    @Operation(summary = "register admin")
    @PutMapping("/register/admin")
    public Result<Long> registerAdmin(@RequestBody @Validated UserRegisterForm form) {
        return Result.success(userService.registerAdmin(form));
    }
}
