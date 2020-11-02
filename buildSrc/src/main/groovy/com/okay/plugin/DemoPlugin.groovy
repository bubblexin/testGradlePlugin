package com.okay.plugin

import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class DemoPlugin implements Plugin<Project> {
    @Override
    void apply(Project target) {
        def extension = target.extensions.create("testExtension", TestExtension)
        // project 执行完毕再触发
        target.afterEvaluate {
            println "Hello ${extension.name}"
        }

        def transform = new DemoTransform()
        def baseExtension = target.extensions.getByType(BaseExtension)
        baseExtension.registerTransform(transform)
    }
}