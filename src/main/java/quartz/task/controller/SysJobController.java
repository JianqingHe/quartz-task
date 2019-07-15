package quartz.task.controller;

import com.baomidou.mybatisplus.plugins.Page;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    /**
     * 获取任务列表
     *
     * @param pageInfo 分页参数
     * @return 查询结果
     */
    @GetMapping("/list")
    public ResultMap getJobList(Page pageInfo) {
        Page<SysJob> jobPage = jobService.findByPage(pageInfo);
        return ResultMap.success(jobPage);
    }

    /**
     * 立即执行任务
     *
     * @param jobId 任务id
     * @return 执行结果
     */
    @PostMapping("/run/{jobId}")
    public ResultMap runJob(@PathVariable("jobId") Long jobId) throws SchedulerException {
        jobService.run(jobId);
        return ResultMap.success();
    }
}
