<h1 align="center">Smart-Doc Gradle Plugin</h1>

![gradle](https://img.shields.io/gradle-plugin-portal/v/com.github.shalousun.smart-doc)
[![License](https://img.shields.io/badge/license-Apache%202-green.svg)](https://www.apache.org/licenses/LICENSE-2.0)
![number of issues closed](https://img.shields.io/github/issues-closed-raw/shalousun/smart-doc-gradle-plugin)
![closed pull requests](https://img.shields.io/github/issues-pr-closed-raw/shalousun/smart-doc-gradle-plugin)
![java version](https://img.shields.io/badge/JAVA-1.8+-green.svg)
[![chinese](https://img.shields.io/badge/chinese-中文文档-brightgreen)](https://github.com/smart-doc-group/smart-doc-gradle-plugin/blob/master/README_CN.md)

## Introduce
smart-doc-gradle-plugin is a `gradle` plugin developed by the smart-doc official team. 
This plugin is available from smart-doc 1.8.6.
Using smart-doc-gradle-plugin makes it easier to integrate smart-doc into your project, and integration is more lightweight. 
You no longer need to write unit tests in your project to
Start smart-doc to scan source code analysis and generate API documents. 
You can run the `gradle` command directly or click on the preset` goal` of the smart-doc-maven-plugin in the IDE to generate API documentation. 
smart-doc-gradle-plugin will also make smart-doc's ability to generate API documentation more powerful.
[About smart-doc](https://smart-doc-group.github.io/#/)
## Best Practice
smart-doc + [Torna](http://torna.cn) form an industry-leading document generation and management solution, using smart-doc to complete Java source code analysis and extract annotations to generate API documents without intrusion, and automatically push the documents to the Torna enterprise-level interface document management platform.

![smart-doc+torna](https://raw.githubusercontent.com/shalousun/smart-doc/master/images/smart-doc-torna-en.png)
## Getting started
### Add plugin
Using the plugins DSL:
```
plugins {
  id "com.github.shalousun.smart-doc" version "[latest]"
}
```
Using legacy plugin application:
```
buildscript {
  repositories {
    maven {
      url "https://plugins.gradle.org/m2/"
    }
  }
  dependencies {
    classpath "com.github.shalousun:smart-doc-gradle-plugin:[latest]"
  }
}

apply plugin: "com.github.shalousun.smart-doc"
```
### Plugin options

| Option | Default value | Description |
| ------ | ------------- | ----------- |
|configFile|src/main/resources/default.json||
|exclude||exclude artifact,usage:exclude 'org.springframework.boot:spring-boot-starter-tomcat' |
|include||Let the plugin download the specified java lib source,usage:include 'org.springframework.boot:spring-boot-starter-tomcat' |

Example setting of options:
```
smartdoc {
    configFile = file("src/main/resources/default.json")
    
    // exclude example
    // exclude artifact
    exclude 'org.springframework.boot:spring-boot-starter-tomcat'
    // exclude artifact use pattern
    exclude 'org.springframework.boot.*'
    // You can use the include configuration to let the plugin automatically load the specified source.
    // include example
    include 'org.springframework.boot:spring-boot-starter-tomcat'
}
```
For multi-module gradle projects, if you do not want to configure in each module, you can put the smart-doc plugin related configuration into subprojects.
```
subprojects{
    apply plugin: 'com.github.shalousun.smart-doc'
    smartdoc {
        //
        configFile = file("src/main/resources/smart-doc.json")
        // exclude artifact
        exclude 'org.springframework.boot:xx'
        exclude 'org.springframework.boot:ddd'
        // You can use the include configuration to let the plugin automatically load the specified source.
        // include example
        include 'org.springframework.boot:spring-boot-starter-tomcat'
    }
}
```
### Create a json config 
Create a json configuration file in your project. If it is multiple modules, put them in the modules that need to generate documents.
The smart-doc-gradle-plugin plugin will use this configuration information.
For example, create `/src/main/resources/smart-doc.json` in the project. 
The configuration contents are as follows.

**Minimize configuration:**
```
{
   "allInOne": true, // whether to merge documents into one file, generally recommended as true
   "isStrict": false,//If the strict mode is set to true, Smart-doc forces that the public method in each interface in the code has a comment.
   "outPath": "/src/main/resources" //Set the api document output path.
}
```
Only three configuration items are required to use the smart-doc-gradle-plugin to generate API documentation. In fact, only outPath must be configured.

**Detailed configuration content:**

smart-doc provides a lot of configuration options. For more configuration options,
please refer to the [official documentation](https://smart-doc-group.github.io/#/diy/config?id=allconfig)

### Generated document
#### Use Gradle command
```
// Generate html
gradle smartDocRestHtml
// Generate markdown
gradle smartDocRestMarkdown
// Generate adoc
gradle smartDocRestAdoc
// Generate postman collection
gradle smartDocPostman
// Generate Open Api 3.0+
gradle smartDocOpenApi
// Generate document and send to Torna
gradle tornaRest

// For Apache Dubbo Rpc
gradle smartDocRpcHtml
// Generate markdown
gradle smartDocRpcMarkdown
// Generate adoc
gradle smartDocRpcAdoc
```
#### Use In IntelliJ IDEA
On Use IntelliJ IDE, if you have added smart-doc-gradle-plugin to the project, 
you can directly find the plugin smart-doc plugin and click to generate API documentation.

![smart-doc-gradle-plugin](https://raw.githubusercontent.com/shalousun/smart-doc-gradle-plugin/master/images/idea.png)

### Generated document example
#### Interface header rendering
![header](https://images.gitee.com/uploads/images/2019/1231/223538_be45f8a9_144669.png "header.png")
#### Request parameter example rendering
![request-params](https://images.gitee.com/uploads/images/2019/1231/223710_88933f55_144669.png "request.png")
#### Response parameter example renderings
![response-fields](https://images.gitee.com/uploads/images/2019/1231/223817_32bea6dc_144669.png "response.png")
## Building
you can build with the following commands. (Java 1.8 is required to build the master branch)
```
// build and publish to local
gradle publishToMavenLocal
// build and publish to nexus
gradle publish
```
## Other reference
- [Smart-doc manual](https://smart-doc-group.github.io/#/)

## Who is using
These are only part of the companies using smart-doc, for reference only. If you are using smart-doc, please [add your company here](https://github.com/shalousun/smart-doc/issues/12) to tell us your scenario to make smart-doc better.

![iFLYTEK](https://raw.githubusercontent.com/shalousun/smart-doc/dev/images/known-users/iflytek.png)
&nbsp;&nbsp;<img src="https://raw.githubusercontent.com/shalousun/smart-doc/dev/images/known-users/oneplus.png" title="OnePlus" width="83px" height="83px"/>
&nbsp;&nbsp;<img src="https://raw.githubusercontent.com/shalousun/smart-doc/dev/images/known-users/xiaomi.png" title="Xiaomi" width="170px" height="83px"/>
<img src="https://raw.githubusercontent.com/shalousun/smart-doc/dev/images/known-users/yuanmengjiankang.png" title="yuanmengjiankang" width="260px" height="83px"/>
<img src="https://raw.githubusercontent.com/shalousun/smart-doc/dev/images/known-users/zhongkezhilian.png" title="zhongkezhilian" width="272px" height="83px"/>
<img src="https://raw.githubusercontent.com/shalousun/smart-doc/dev/images/known-users/puqie_gaitubao_100x100.jpg" title="puqie" width="83px" height="83px"/>&nbsp;&nbsp;
<img src="https://raw.githubusercontent.com/shalousun/smart-doc/dev/images/known-users/tianbo-tech.png" title="tianbo tech" width="127px" height="70px"/>

## License
smart-doc-gradle-plugin is under the Apache 2.0 license.  See the [LICENSE](https://raw.githubusercontent.com/shalousun/smart-doc-maven-plugin/master/LICENSE) file for details.
## Contact
Email： 836575280@qq.com
