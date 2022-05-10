package com.imantou.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imantou.system.service.SysLogService;

import com.imantou.common.dao.SysLogMapper;
import com.imantou.common.domain.SysLog;
import org.springframework.stereotype.Service;

/**
* @author huang
* @description 针对表【sys_log(系统日志)】的数据库操作Service实现
* @createDate 2022-04-27 11:37:24
*/
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog>
    implements SysLogService {

}




