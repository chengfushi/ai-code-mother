package com.chengfu.aicodemotherapi.service;

import com.chengfu.aicodemotherapi.model.dto.app.AppQueryRequest;
import com.chengfu.aicodemotherapi.model.entity.User;
import com.chengfu.aicodemotherapi.model.vo.app.AppVO;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.chengfu.aicodemotherapi.model.entity.App;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * 服务层。
 *
 * @author Chengfu
 */
public interface AppService extends IService<App> {

    Flux<String> chatToGenCode(Long appId, String message, User loginUser);

    /*
     * app类转 视图
     *
     * @author: Chengfu Shi
     * @param: app
     * @return: app视图封装
     **/
    AppVO getAppVO(App app);

    /*
     * 构造查询对象
     *
     * @author: Chengfu Shi
     * @param: appQueryRequest 分页查询请求
     * @return: 查询对象
     **/
    QueryWrapper getQueryWrapper(AppQueryRequest appQueryRequest);

    /**
     * 获取视图列表
     *
     * @param appList
     * @return
     */
    List<AppVO> getAppVOList(List<App> appList);
}
