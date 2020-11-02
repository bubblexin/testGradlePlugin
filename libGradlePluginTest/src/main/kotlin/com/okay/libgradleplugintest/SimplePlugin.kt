package com.okay.libgradleplugintest

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * @author : linxin
 * @date : 2020/10/26
 * @e-mail : linxin@okjiaoyu.cn
 * @description :
 */
internal class SimplePlugin : Plugin<Project> {
    override fun apply(project: Project) {
//        project.task("test") {
//            it.doLast {
//
//            }
//        }
        val handler = project.dependencies
        project.configurations.forEach { configuration ->
            println(configuration.name)
            configuration.dependencies.forEach {
                println("${it.group}:${it.name}:${it.version}")
            }
        }
//        handler.add("implementation", "com.squareup.okhttp3:okhttp:4.7.2")

        project.tasks.register("greeting") {
            it.doLast {
                println("Hello SimplePlugin")
//                // 应用名称
//                val projectName = project.name
//                // 打包日期，格式为：年月日时分秒
////        val buildTime = Date().format("yyyyMMddHHmmss")
//                // project有很多扩展信息，我们这里需要 Android 相关的扩展信息，com.android.build.gradle.AppExtension
//                val appExtension = project.extensions.getByType(AppExtension::class.java)
//                for (applicationVariant in appExtension.applicationVariants) {
//                    val vCode = applicationVariant.versionCode
//                    val vName = applicationVariant.versionName
//                    val buildTypeName = applicationVariant.buildType.name
//                    val flavorName = applicationVariant.flavorName
//                    applicationVariant.outputs.all {
//
//                    }
//                    println("projectName:$projectName | vCode:$vCode | vName:$vName | buildTypeName:$buildTypeName | flavorName:$flavorName")
//                }


            }
        }

    }
}