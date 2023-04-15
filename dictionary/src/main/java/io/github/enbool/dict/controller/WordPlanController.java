package io.github.enbool.dict.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.github.enbool.dict.controller.BaseController;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * <p>
 * 单词计划 Controller
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:53
 */
 @OpenAPIDefinition(
         info = @Info(
                 title = "WordPlan API",
                 version = "1.0",
                 description = "WordPlan API"
         ), tags = {
         @Tag(name = "WordPlan", description = "WordPlan API")
 }
 )
@RestController("/dict/word-plan")
public class WordPlanController extends BaseController {

}
