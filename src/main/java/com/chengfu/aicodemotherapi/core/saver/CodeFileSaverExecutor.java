package com.chengfu.aicodemotherapi.core.saver;

import com.chengfu.aicodemotherapi.ai.model.HtmlCodeResult;
import com.chengfu.aicodemotherapi.ai.model.MultiFileCodeResult;
import com.chengfu.aicodemotherapi.exception.BusinessException;
import com.chengfu.aicodemotherapi.exception.ErrorCode;
import com.chengfu.aicodemotherapi.model.enums.CodeGenTypeEnum;

import java.io.File;

/**
 * @Author: Chengfu Shi
 * @Description: 代码文件保存执行器
 **/
public class CodeFileSaverExecutor {
    public static final HtmlCodeFileSaverTemplate htmlCodeFileSaver= new HtmlCodeFileSaverTemplate();
    public static final MultiFileCodeFileSaverTemplate multiFileCodeFileSaver = new MultiFileCodeFileSaverTemplate();

    /**
     * 执行代码保存
     *
     * @param codeResult  代码结果对象
     * @param codeGenType 代码生成类型
     * @return 保存的目录
     */
    public static File executeSaver(Object codeResult, CodeGenTypeEnum codeGenType, Long appId) {
        return switch (codeGenType) {
            case HTML -> htmlCodeFileSaver.saveCode((HtmlCodeResult) codeResult,appId);
            case MULTI_FILE -> multiFileCodeFileSaver.saveCode((MultiFileCodeResult) codeResult,appId);
            default -> throw new BusinessException(ErrorCode.SYSTEM_ERROR, "不支持的代码生成类型: " + codeGenType);
        };
    }
}

