package io.github.enbool.dict.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.github.enbool.dict.controller.BaseController;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * <p>
 * 书籍 Controller
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:52
 */
 @OpenAPIDefinition(
         info = @Info(
                 title = "Book API",
                 version = "1.0",
                 description = "Book API"
         ), tags = {
         @Tag(name = "Book", description = "Book API")
 }
 )
@RestController("/dict/book")
public class BookController extends BaseController {

}
