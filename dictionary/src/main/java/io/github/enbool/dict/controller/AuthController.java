package io.github.enbool.dict.controller;

import io.github.enbool.dict.model.Result;
import io.github.enbool.dict.model.dto.AccessToken;
import io.github.enbool.dict.model.form.UsernamePasswordForm;
import io.github.enbool.dict.service.AuthService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/5/22 10:53
 */
@OpenAPIDefinition(
        info = @Info(
                title = "Auth API",
                version = "1.0",
                description = "Auth API"
        ), tags = {
        @Tag(name = "Auth", description = "Auth API")
}
)
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Operation(summary = "login by username")
    @PostMapping("/username")
    public Result<AccessToken> loginByUsername(@RequestBody @Validated UsernamePasswordForm form) {
        return Result.success(authService.loginByUsername(form));
    }
}
