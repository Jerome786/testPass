package com.jackson0714.passjava.question.controller;

import com.jackson0714.common.utils.PageUtils;
import com.jackson0714.common.utils.R;
import com.jackson0714.passjava.question.entity.QuestionEntity;
import com.jackson0714.passjava.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * @author jackson0714
 * @email jackson0585@163.com
 * @date 2020-12-29 23:58:02
 */
@RestController
@RequestMapping("question/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("question:question:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = questionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("question:question:info")
    public R info(@PathVariable("id") Long id) {
        QuestionEntity question = questionService.getById(id);

        return R.ok().put("question", question);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("question:question:save")
    public R save(@RequestBody QuestionEntity question) {
        questionService.save(question);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("question:question:update")
    public R update(@RequestBody QuestionEntity question) {
        questionService.updateById(question);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("question:question:delete")
    public R delete(@RequestBody Long[] ids) {
        questionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
