package quartz.task.controller;

import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quartz.task.entity.SysJob;
import quartz.task.result.ResultMap;
import quartz.task.service.SysJobService;

/**
 * 任务执行接口
 *
 * @author hejq
 * @date 2019/7/15 9:21
 */
@RequestMapping("/sysJob")
@RestController
public class SysJobController {

    @Autowired
    private SysJobService jobService;

    @GetMapping("/list")
    public ResultMap getJobList(Page pageInfo) {
        Page<SysJob> jobPage = jobService.findByPage(pageInfo);
        return ResultMap.success(jobPage);
    }

    @GetMapping("/hello")
    public ResultMap hello() {
        return ResultMap.success("hello");
    }
}
