/*
 * smart-doc https://github.com/shalousun/smart-doc
 *
 * Copyright (C) 2018-2022 smart-doc
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.smartdoc.gradle.extension;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yu 2020/4/8.
 */
public class SmartDocPluginExtension {

    /**
     * get config file
     */
    private File configFile;

    /**
     * exclude artifact
     */
    private final Set<String> exclude = new HashSet<>();

    /**
     * include artifact
     */
    private final Set<String> include = new HashSet<>();


    /**
     * Smart doc config file, like smart-doc.json
     * @return
     */
    public File getConfigFile() {
        return configFile;
    }

    public void setConfigFile(File configFile) {
        this.configFile = configFile;
    }

    /**
     * Excludes artifacts
     * @param excludes Array of artifact
     * @return SmartDocPluginExtension
     */
    public SmartDocPluginExtension exclude(String... excludes) {
        for (String exclude : excludes) {
            this.exclude.add(exclude);
        }
        return this;
    }

    public Set<String> getExclude() {
        return exclude;
    }

    /**
     * Includes artifacts
     * @param includes Array of artifact
     * @return SmartDocPluginExtension
     */
    public SmartDocPluginExtension include(String... includes) {
        for (String include : includes) {
            this.include.add(include);
        }
        return this;
    }

    public Set<String> getInclude() {
        return include;
    }
}
