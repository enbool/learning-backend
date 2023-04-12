package io.github.enbool.dict.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.enbool.dict.model.Result;
import io.github.enbool.dict.model.entity.Word;
import io.github.enbool.dict.model.form.WordForm;
import io.github.enbool.dict.model.vo.WordVO;
import io.github.enbool.dict.service.WordService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/4/11 17:56
 */
@OpenAPIDefinition(
        info = @Info(
                title = "Word API",
                version = "1.0",
                description = "Word API"
        ), tags = {
        @Tag(name = "Word", description = "Word API")
}
)
@RestController("/api/v1/word")
public class WordController extends BaseController {
    @Autowired
    private WordService wordService;

    @Operation(summary = "page word by dictionary", description = "example: /page?page=1&size=5&desc=name,rank")
    @GetMapping("/page")
    public Result<IPage<WordVO>> pageByDictionary(@RequestParam Long dictionaryId) {
        return Result.success(wordService.pageByDictionary(dictionaryId, this.getPage()));
    }

    @Operation(summary = "update word")
    @PutMapping("/update")
    public Result<Boolean> update(@RequestBody WordForm form) {
        return Result.success(wordService.update(form));
    }

    @Operation(summary = "delete word")
    @PutMapping("/delete")
    public Result<Boolean> delete(@RequestParam Long id) {
        return Result.success(wordService.removeById(id));
    }
}
