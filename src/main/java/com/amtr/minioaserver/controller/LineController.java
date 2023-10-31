package com.amtr.minioaserver.controller;

import com.amtr.minioaserver.pojo.Line;
import com.amtr.minioaserver.pojo.Result;
import com.amtr.minioaserver.service.LineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*") // 允许来自指定域名的跨域请求
@RequestMapping("/line")
public class LineController {
    @Autowired
    private LineService lineService;

    @GetMapping
    public Result select() {
        log.info("查询全部线路");
        List<Line> list = lineService.select();
        return Result.success(list);
    }

    @PostMapping
    public Result insert(@RequestBody Line line) {
        log.info("创建新线路:{}", line);
        if (lineService.insert(line))
            return Result.success();
        else return Result.failMsg("线路已存在");
    }

    @DeleteMapping
    public Result delete(@RequestParam("id") int id) {
        log.info("根据id删除线路：{}", id);
        lineService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Line line) {
        log.info("更新线路信息：{}", line);
        lineService.update(line);
        return Result.success();
    }
}
