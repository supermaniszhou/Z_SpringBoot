package com.family.zhou.controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 周刘成   2019/7/8
 */
public class BaseController {


    public AjaxResult success(String msg, Object object, Long count) {
        return new AjaxResult(msg, AjaxResult.Type.SUCCESS_CODE, object, count);
    }

    public AjaxResult success(String msg) {
        return new AjaxResult(AjaxResult.Type.SUCCESS_CODE, msg);
    }

    public AjaxResult success() {
        return new AjaxResult(AjaxResult.Type.SUCCESS_CODE, "操作成功！");
    }

    public AjaxResult error(String msg) {
        return new AjaxResult(AjaxResult.Type.ERROR_CODE, msg);
    }

    public AjaxResult error() {
        return new AjaxResult(AjaxResult.Type.ERROR_CODE, "操作出错了！");
    }

    /**
     * 是否是Ajax异步请求
     *
     * @param request
     * @return
     */
    public boolean isAjaxRequest(HttpServletRequest request) {
        String xRequestedWith = request.getHeader("X-Requested-With");
        boolean isAjax = false;
        if (null != xRequestedWith) {
            isAjax = "XMLHttpRequest".equals(xRequestedWith) ? true : false;
        }
        return isAjax;
    }

    public String renderString(HttpServletResponse response, String msg) {
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
