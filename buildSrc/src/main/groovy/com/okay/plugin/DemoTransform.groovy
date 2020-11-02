package com.okay.plugin

import com.android.build.api.transform.Format
import com.android.build.api.transform.QualifiedContent
import com.android.build.api.transform.Transform
import com.android.build.api.transform.TransformException
import com.android.build.api.transform.TransformInvocation
import com.android.build.gradle.internal.pipeline.TransformManager
import com.android.utils.FileUtils;

/**
 * @author : linxin
 * @date : 2020/11/2
 * @e-mail : linxin@okjiaoyu.cn
 * @description :
 */
class DemoTransform extends Transform {
    @Override
    String getName() {
        return "linxin"
    }

    @Override
    Set<QualifiedContent.ContentType> getInputTypes() {
        return TransformManager.CONTENT_CLASS
    }

    @Override
    Set<? super QualifiedContent.Scope> getScopes() {
        return TransformManager.SCOPE_FULL_PROJECT
    }

    @Override
    boolean isIncremental() {
        return false
    }

    @Override
    void transform(TransformInvocation transformInvocation) throws TransformException, InterruptedException, IOException {
        def inputs = transformInvocation.inputs // 获取输入
        def outputProvider = transformInvocation.outputProvider // 获取输出
        inputs.each {
            // 遍历 jar 文件，将其复制到 transform 文件夹下
            //  appPath\app\build\intermediates\transforms\...
            it.jarInputs.each {
                File dest = outputProvider.getContentLocation(it.name, it.contentTypes, it.scopes, Format.JAR)
                println "Jar: ${it.file}, Dest: ${dest}"
                FileUtils.copyFile(it.file, dest)
            }
            // 将项目编译生成的文件夹(BuildConfig.java 等赋复制过去)
            it.directoryInputs.each {
                File dest = outputProvider.getContentLocation(it.name, it.contentTypes, it.scopes, Format.DIRECTORY)
                println "Dir: ${it.file}, Dest: ${dest}"
                FileUtils.copyDirectory(it.file, dest)
            }
        }
    }
}
