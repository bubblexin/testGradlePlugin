package com.okay.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class TestPlugin1 implements Plugin<Project> {
    @Override
    void apply(Project target) {
        def extension = target.extensions.create("test", TestExtension)
        target.afterEvaluate {
            println "Hello ${extension.name}"
        }
    }
}