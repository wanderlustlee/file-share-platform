# file-share-platform
教学资源共享平台

## 功能介绍

实现文件的上传、下载、预览功能。

支持录入选择题、简答题，并支持生成.doc格式试卷及答案文档功能

## 技术框架

#### 基于SpringBoot框架搭建，使用SSM框架

#### Redis做热点数据存储

#### 集成JWT做登录校验

相关文档：https://www.jianshu.com/p/e88d3f8151db

#### 密码基于MD5算法存储

#### 基于Apache POI 实现Java操作word文档
相关文档：https://houbb.github.io/2019/02/14/poi-word-02-quick-start

#### 基于 Docker 和 kkFileView 实现文件的预览功能

docker 运行服务步骤：

1、拉取镜像
```
docker pull keking/kkfileview
```
2、运行
```
docker run -it -p 8012:8012 keking/kkfileview
```

3、浏览器访问容器8012端口（http://xxx.xxx.xxx.xxx:8012 ）即可看到项目演示用首页

4、当您的项目内需要预览文件时，只需要调用浏览器打开本项目的预览接口，并传入须要预览文件的url，示例如下：
  
  ```
  var url = 'http://127.0.0.1:8080/file/test.txt'; //要预览文件的访问地址
  window.open('http://127.0.0.1:8012/onlinePreview?url='+encodeURIComponent(previewUrl));
  ```
#### 数据库结构
.sql文件在根目录下
