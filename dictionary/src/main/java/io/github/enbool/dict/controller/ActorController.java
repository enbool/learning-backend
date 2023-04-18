package io.github.enbool.dict.controller;

import io.github.enbool.dict.model.Result;
import io.github.enbool.dict.model.vo.ActorVO;
import io.github.enbool.dict.service.ActorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.github.enbool.dict.controller.BaseController;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

/**
 * <p>
 * actor Controller
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:52
 */
@OpenAPIDefinition(
        info = @Info(
                title = "Actor API",
                version = "1.0",
                description = "Actor API"
        ), tags = {
        @Tag(name = "Actor", description = "Actor API")
}
)
@RestController("/api/v1/actor")
public class ActorController extends BaseController {
    @Autowired
    private ActorService actorService;

    @Operation(summary = "list active actor")
    @GetMapping("/list/active")
    public Result<List<ActorVO>> list() {
        return Result.success(actorService.listActive());
    }

    @GetMapping("/my")
    public Result<List<ActorVO>> findByCurrentUser() {
        return Result.success(actorService.findByCurrentUser());
    }

    @PostMapping("/{id}/purchase")
    public Result<Boolean> purchase(@PathVariable Long id) {
        return Result.success(actorService.purchase(id));
    }
}
