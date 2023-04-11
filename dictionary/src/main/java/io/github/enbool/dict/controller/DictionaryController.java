package io.github.enbool.dict.controller;

import io.github.enbool.dict.model.Result;
import io.github.enbool.dict.model.entity.Dictionary;
import io.github.enbool.dict.model.query.DictionaryQuery;
import io.github.enbool.dict.service.DictionaryService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/4/11 16:40
 */
@OpenAPIDefinition(
        info = @Info(
                title = "Dictionary API",
                version = "1.0",
                description = "Dictionary API"
        ), tags = {
        @Tag(name = "Dictionary", description = "Dictionary API")
}
)
@RestController("/api/v1/dictionary")
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    @Operation(summary = "list dictionary")
    @PostMapping("/list")
    public Result<List<Dictionary>> list(DictionaryQuery query) {
        return Result.success(dictionaryService.list(query));
    }

    @Operation(summary = "save dictionary")
    @PostMapping("/save")
    public Result<Long> save(Dictionary dictionary) {
        return Result.success(dictionaryService.save(dictionary));
    }

    @Operation(summary = "delete dictionary")
    @DeleteMapping("/delete")
    public Result<Boolean> delete(Long id) {
        return Result.success(dictionaryService.delete(id));
    }
}
