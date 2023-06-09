package io.github.enbool.dict.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.github.enbool.dict.controller.BaseController;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * <p>
 * Controller
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:53
 */
@OpenAPIDefinition(
        info = @Info(
                title = "UserBook API",
                version = "1.0",
                description = "UserBook API"
        ), tags = {
        @Tag(name = "UserBook", description = "UserBook API")
}
)
@RestController("/dict/user-book")
public class UserBookController extends BaseController {

}
