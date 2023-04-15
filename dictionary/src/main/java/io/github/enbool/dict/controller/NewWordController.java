package io.github.enbool.dict.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.github.enbool.dict.controller.BaseController;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * <p>
 * 生词本 Controller
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:52
 */
@OpenAPIDefinition(
        info = @Info(
                title = "NewWord API",
                version = "1.0",
                description = "NewWord API"
        ), tags = {
        @Tag(name = "NewWord", description = "NewWord API")
}
)
@RestController("/dict/new-word")
public class NewWordController extends BaseController {

}
