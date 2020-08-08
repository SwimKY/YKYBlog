/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.19 : Database - myblog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ykyblog` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `ykyblog`;

/*Table structure for table `archives` */

DROP TABLE IF EXISTS `archives`;

CREATE TABLE `archives` (
  `id` int NOT NULL AUTO_INCREMENT,
  `archiveName` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `archives` */

insert  into `archives`(`id`,`archiveName`) values (5,'2020年8月');

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `id` int NOT NULL AUTO_INCREMENT,
  `articleId` bigint NOT NULL,
  `author` varchar(255) NOT NULL,
  `originalAuthor` varchar(255) NOT NULL,
  `articleTitle` varchar(255) NOT NULL,
  `articleContent` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `articleTags` varchar(255) NOT NULL,
  `articleType` varchar(255) NOT NULL,
  `articleCategories` varchar(255) NOT NULL,
  `publishDate` varchar(255) NOT NULL,
  `updateDate` varchar(255) NOT NULL,
  `articleUrl` varchar(255) NOT NULL,
  `articleTabloid` mediumtext NOT NULL,
  `likes` int NOT NULL,
  `lastArticleId` bigint DEFAULT NULL,
  `nextArticleId` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `article` */

insert  into `article`(`id`,`articleId`,`author`,`originalAuthor`,`articleTitle`,`articleContent`,`articleTags`,`articleType`,`articleCategories`,`publishDate`,`updateDate`,`articleUrl`,`articleTabloid`,`likes`,`lastArticleId`,`nextArticleId`) values (20,1596711672,'爱敲代码的小游子','爱敲代码的小游子','LINUX','\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20200802095715865.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ0ODk1Mzk3,size_16,color_FFFFFF,t_70)\n> 写博客即是为了记录自己的学习历程，也希望能够结交志同道合的朋友一起学习。文章在撰写过程中难免有疏漏和错误，欢迎你在下方留言指出文章的不足之处；更多内容请点进[我的博客K](https://blog.csdn.net/qq_44895397)阅览。\n> 临渊羡鱼，不如退而结网。一起加油！\n\n\n[Linux系列第一谈：阿里云服务器基本Linux操作（开启安全组、使用面板搭建环境 使用命令行搭建环境 安装jdk、tomcat、Docker）](https://blog.csdn.net/qq_44895397/article/details/107676627)\n\n[Linux系列第二谈（开机关机、Linux中的文件、目录管理、基本属性）](https://blog.csdn.net/qq_44895397/article/details/107701064)\n\n[Linux系列第三谈（Linux常用命令：文件查看、Linux软硬链接、Vim编辑器）](https://blog.csdn.net/qq_44895397/article/details/107722128)\n\n[Linux系列第四谈（Linux中的账号管理）](https://blog.csdn.net/qq_44895397/article/details/107738084)\n\n## 一、磁盘管理\n### 1、概述\nLinux磁盘管理好坏直接关系到整个系统的性能问题。\nLinux磁盘管理常用命令为 df、du。\n\n• df ：列出文件系统的整体磁盘使用量\n• du：检查磁盘空间使用量\n### 2、df\ndf命令参数功能：检查文件系统的磁盘空间占用情况。可以利用该命令来获取硬盘被占用了多少空间，目前还剩下多少空间等信息。\n\n**语法：**\n\n```bash\ndf [-ahikHTm] [目录或文件名]\n```\n\n**选项与参数：**\n- -a ：列出所有的文件系统，包括系统特有的 /proc 等文件系统；\n- -k ：以 KBytes 的容量显示各文件系统；\n- -m ：以 MBytes 的容量显示各文件系统；\n- -h ：以人们较易阅读的 GBytes, MBytes, KBytes 等格式自行显示；\n- -H ：以 M=1000K 取代 M=1024K 的进位方式；\n- -T ：显示文件系统类型, 连同该 partition 的 filesystem 名称 (例如 ext3) 也列出；\n- -i ：不用硬盘容量，而以 inode 的数量来显示\n\n**测试：**\n\n```bash\n# 将系统内所有的文件系统列出来！\n# 在 Linux 底下如果 df 没有加任何选项\n# 那么默认会将系统内所有的 (不含特殊内存内的文件系统与 swap) 都以 1 Kbytes 的容量来列出来！\n[root@YKY /]# df\nFilesystem     1K-blocks    Used Available Use% Mounted on\ndevtmpfs         1929728       0   1929728   0% /dev\ntmpfs            1940088       4   1940084   1% /dev/shm\ntmpfs            1940088     456   1939632   1% /run\ntmpfs            1940088       0   1940088   0% /sys/fs/cgroup\n/dev/vda1       41152812 2658820  36590284   7% /\ntmpfs             388020       0    388020   0% /run/user/0\n```\n![在这里插入图片描述](https://img-blog.csdnimg.cn/202008020931470.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ0ODk1Mzk3,size_16,color_FFFFFF,t_70)\n<font color = orange> **将容量结果以易读的容量格式显示出来**\n```bash\n# 将容量结果以易读的容量格式显示出来\n[root@YKY /]# df -h\nFilesystem      Size  Used Avail Use% Mounted on\ndevtmpfs        1.9G     0  1.9G   0% /dev\ntmpfs           1.9G  4.0K  1.9G   1% /dev/shm\ntmpfs           1.9G  456K  1.9G   1% /run\ntmpfs           1.9G     0  1.9G   0% /sys/fs/cgroup\n/dev/vda1        40G  2.6G   35G   7% /\ntmpfs           379M     0  379M   0% /run/user/0\n```\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20200802093408620.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ0ODk1Mzk3,size_16,color_FFFFFF,t_70)\n\n<font color = skyblue>**将系统内的所有特殊文件格式及名称都列出来**\n\n```bash\n#将系统内的所有特殊文件格式及名称都列出来\n[root@YKY /]# df -aT\nFilesystem     Type       1K-blocks   Used Available Use% Mounted on\nsysfs         sysfs               0       0         0    - /sys\nproc           proc                0       0         0    - /proc\ndevtmpfs       devtmpfs       889100       0    889100   0% /dev\nsecurityfs     securityfs          0       0         0    - /sys/kernel/security\ntmpfs         tmpfs          899460     708    898752   1% /dev/shm\ndevpts         devpts              0       0         0    - /dev/pts\ntmpfs         tmpfs          899460     496    898964   1% /run\ntmpfs         tmpfs          899460       0    899460   0% \n......\n```\n<font color = pink>**将 /etc 底下的可用的磁盘容量以易读的容量格式显示**\n```bash\n# 将 /etc 底下的可用的磁盘容量以易读的容量格式显示\n[root@YKY /]# df -h /etc\nFilesystem     Size Used Avail Use% Mounted on\n/dev/vda1       40G  6.3G   32G  17% /\n```\n\n### 3、du\nLinux du命令也是查看使用空间的，**但是与df命令不同的是Linux du命令是对文件和目录磁盘使用的空间的查看**，还是和df命令有一些区别的，这里介绍Linux du命令。\n\n**语法：**\n\n```bash\ndu [-ahskm] 文件或目录名称\n```\n\n**选项与参数：**\n- -a ：列出所有的文件与目录容量，因为默认仅统计目录底下的文件量而已。\n- -h ：以人们较易读的容量格式 (G/M) 显示；\n- -s ：列出总量而已，而不列出每个各别的目录占用容量；\n- -S ：不包括子目录下的总计，与 -s 有点差别。\n- -k ：以 KBytes 列出容量显示；\n- -m ：以 MBytes 列出容量显示；\n\n**测试：**\n\n<font color = skyblue>**只列出当前目录下的所有文件夹容量**\n```bash\n# 只列出当前目录下的所有文件夹容量（包括隐藏文件夹）:\n# 直接输入 du 没有加任何选项时，则 du 会分析当前所在目录的文件与目录所占用的硬盘空间。\n[root@YKY home]# du\n16	./redis\n8	./www/.oracle_jre_usage  # 包括隐藏文件的目录\n24	./www\n48	.                        # 这个目录(.)所占用的总量\n```\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20200802093821358.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ0ODk1Mzk3,size_16,color_FFFFFF,t_70)\n<font color = orange>**将文件的容量也列出来**</font>\n\n```bash\n# 将文件的容量也列出来\n[root@YKY home]# du -a\n4./redis/.bash_profile\n64	./yky/apache-tomcat-9.0.37/logs\n17308	./yky/apache-tomcat-9.0.37\n10952	./yky/apache-tomcat-9.0.37.tar.gz\n187456	./yky\n363612	.\n```\n<font color = pink>**检查根目录底下每个目录所占用的容量**</font>\n```bash\n# 检查根目录底下每个目录所占用的容量\n[root@kuangshen home]# du -sm /*\n0/bin\n146/boot\n.....中间省略....\n0/proc\n.....中间省略....\n1/tmp\n3026/usr  # 系统初期最大就是他了啦！\n513/var\n2666/www\n```\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20200802094457150.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ0ODk1Mzk3,size_16,color_FFFFFF,t_70)\n\n通配符 * 来代表每个目录。\n与 df 不一样的是，<font color = red>**du 这个命令其实会直接到文件系统内去搜寻所有的文件数据。**</font>\n\n### 4、磁盘挂载与卸除\n根文件系统之外的其他文件要想能够被访问，都必须通过“关联”至根文件系统上的某个目录来实现，此关联操作即为“挂载”，此目录即为“挂载点”,解除此关联关系的过程称之为“卸载”\n**Linux 的磁盘挂载使用mount命令，卸载使用umount命令。**\n\n**磁盘挂载语法：**\n\n```bash\nmount [-t 文件系统] [-L Label名] [-o 额外选项] [-n] 装置文件名 挂载点\n```\n\n测试：\n\n```bash\n# 将 /dev/hdc6 挂载到 /mnt/hdc6 上面！\n[root@www ~]# mkdir /mnt/hdc6\n[root@www ~]# mount /dev/hdc6 /mnt/hdc6\n[root@www ~]# df\nFilesystem           1K-blocks     Used Available Use% Mounted on\n/dev/hdc6              1976312     42072   1833836   3% /mnt/hdc6\n```\n\n**磁盘卸载命令 umount 语法：**\n\n```bash\numount [-fn] 装置文件名或挂载点\n```\n\n**选项与参数：**\n- -f ：强制卸除！可用在类似网络文件系统 (NFS) 无法读取到的情况下；\n- -n ：不升级 /etc/mtab 情况下卸除。\n\n卸载/dev/hdc6\n\n```bash\n[root@www ~]# umount /dev/hdc6\n```\n\n## 三、进程管理\n\n 1. 进程两种存在：\n     1. 前台\n      2. 后台\n2. 每个进程都有自己的id \n3. 每个进程都有一个父进程\n\n**命令：**\n```bash\nps -xxx：查看当前系统的进程\n```\n\n - -a：显示当前终端运行的所有进程信息\n -  -u：用户信息显示进程\n - -x：显示后台进程参数 ps \n - -aux：查看所有进程 ps \n - -aux|grep redis...查看redis的相关进程 ps\n -  -ef 查看父进程的信息\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20200802094758502.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ0ODk1Mzk3,size_16,color_FFFFFF,t_70)\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20200802095319388.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ0ODk1Mzk3,size_16,color_FFFFFF,t_70)\n\n\n**查看进程树：**\n\n```bash\npstree\n```\n\n- -p：显示父id\n- -u：显示用户组\n![在这里插入图片描述](https://img-blog.csdnimg.cn/2020080209485884.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ0ODk1Mzk3,size_16,color_FFFFFF,t_70)\n\n\n**结束进程：**\n\n```bash\nkill -9 进程id\n```\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20200802095447646.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ0ODk1Mzk3,size_16,color_FFFFFF,t_70)\n\n','Linux,原创','原创','SpringBoot','2020-08-06','2020-08-06','https://www.zhyocean.cn/article/1596711672','写博客即是为了记录自己的学习历程，也希望能够结交志同道合的朋友一起学习。文章在撰写过程中难免有疏漏和错误，欢迎你在下方留言指出文章的不足之处；更多内容请点进我的博客K阅览。临渊羡鱼，不如退而结网。一起加油！Linux系列第一谈：阿里云服务器基本Linux操作（开启安全组、使用面板搭建环境使用命令行搭建环境安装jdk、tomcat、Docker）Linux系列第二谈（开机关机、Linux中的文...',0,0,0);

/*Table structure for table `article_likes_record` */

DROP TABLE IF EXISTS `article_likes_record`;

CREATE TABLE `article_likes_record` (
  `id` int NOT NULL AUTO_INCREMENT,
  `articleId` bigint NOT NULL,
  `likerId` int NOT NULL,
  `likeDate` varchar(255) NOT NULL,
  `isRead` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Data for the table `article_likes_record` */

/*Table structure for table `blog_user` */

DROP TABLE IF EXISTS `blog_user`;

CREATE TABLE `blog_user` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `user_name` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(11) NOT NULL COMMENT '密码',
  `phone` varchar(20) NOT NULL COMMENT '手机号',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `sign` varchar(1024) DEFAULT NULL COMMENT '签名',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='用户表';

/*Data for the table `blog_user` */

/*Table structure for table `blog_user2` */

DROP TABLE IF EXISTS `blog_user2`;

CREATE TABLE `blog_user2` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `user_name` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(11) NOT NULL COMMENT '密码',
  `phone` varchar(20) NOT NULL COMMENT '手机号',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `sign` varchar(1024) DEFAULT NULL COMMENT '签名',
  `version` bigint unsigned NOT NULL DEFAULT '1' COMMENT '乐观锁',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='用户表';

/*Data for the table `blog_user2` */

/*Table structure for table `categories` */

DROP TABLE IF EXISTS `categories`;

CREATE TABLE `categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `categories` */

insert  into `categories`(`id`,`categoryName`) values (1,'我的故事'),(2,'SpringBoot'),(8,'spring'),(9,'Linux');

/*Table structure for table `comment_likes_record` */

DROP TABLE IF EXISTS `comment_likes_record`;

CREATE TABLE `comment_likes_record` (
  `id` int NOT NULL AUTO_INCREMENT,
  `articleId` bigint NOT NULL,
  `pId` int NOT NULL,
  `likerId` int NOT NULL,
  `likeDate` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `comment_likes_record` */

/*Table structure for table `comment_record` */

DROP TABLE IF EXISTS `comment_record`;

CREATE TABLE `comment_record` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `pId` bigint NOT NULL,
  `articleId` bigint NOT NULL,
  `answererId` int NOT NULL,
  `respondentId` int NOT NULL,
  `commentDate` varchar(255) NOT NULL,
  `likes` int NOT NULL,
  `commentContent` text NOT NULL,
  `isRead` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `comment_record` */

insert  into `comment_record`(`id`,`pId`,`articleId`,`answererId`,`respondentId`,`commentDate`,`likes`,`commentContent`,`isRead`) values (2,0,1533196734,1,1,'2020-08-03 00:15',1,'测试评论功能，嘻嘻嘻',0),(3,2,1533196734,1,1,'2020-08-03 00:15',0,'一切正常，哈哈哈',0);

/*Table structure for table `daily_speech` */

DROP TABLE IF EXISTS `daily_speech`;

CREATE TABLE `daily_speech` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `mood` varchar(20) NOT NULL,
  `picsUrl` text,
  `publishDate` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `daily_speech` */

insert  into `daily_speech`(`id`,`content`,`mood`,`picsUrl`,`publishDate`) values (1,'前端页面最让人头大<br>\r\n<br>\r\n把那些不想在空间或是朋友圈说的话<br>\r\n在自己的这片空间里<br>\r\n记录每日的心情<br>\r\n写写身边发生的小事<br>','happy','https://zhy-myblog.oss-cn-shenzhen.aliyuncs.com/public/dailySpeech/2018-12-06/1544079972079.jpeg,https://zhy-myblog.oss-cn-shenzhen.aliyuncs.com/public/dailySpeech/2018-12-06/1544079973042.jpeg,https://zhy-myblog.oss-cn-shenzhen.aliyuncs.com/public/dailySpeech/2018-12-06/1544079973159.jpeg,https://zhy-myblog.oss-cn-shenzhen.aliyuncs.com/public/dailySpeech/2018-12-06/1544079973261.jpeg,https://zhy-myblog.oss-cn-shenzhen.aliyuncs.com/public/dailySpeech/2018-12-06/1544079973360.jpeg,https://zhy-myblog.oss-cn-shenzhen.aliyuncs.com/public/dailySpeech/2018-12-06/1544079973453.jpeg,https://zhy-myblog.oss-cn-shenzhen.aliyuncs.com/public/dailySpeech/2018-12-06/1544079973688.jpeg,https://zhy-myblog.oss-cn-shenzhen.aliyuncs.com/public/dailySpeech/2018-12-06/1544079973939.jpeg,https://zhy-myblog.oss-cn-shenzhen.aliyuncs.com/public/dailySpeech/2018-12-06/1544079974188.jpeg','2020-08-07 15:06:14'),(2,'fsdf4<br/>\n','happy','http://ykyblog.oss-cn-shenzhen.aliyuncs.com/2020/08/07/4c584018a672496cbcffe60d22fbad20','2020-08-07 00:42:20');

/*Table structure for table `feedback` */

DROP TABLE IF EXISTS `feedback`;

CREATE TABLE `feedback` (
  `id` int NOT NULL AUTO_INCREMENT,
  `feedbackContent` text NOT NULL,
  `contactInfo` varchar(255) DEFAULT NULL,
  `personId` int NOT NULL,
  `feedbackDate` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `feedback` */

/*Table structure for table `friendlink` */

DROP TABLE IF EXISTS `friendlink`;

CREATE TABLE `friendlink` (
  `id` int NOT NULL AUTO_INCREMENT,
  `blogger` varchar(40) NOT NULL,
  `url` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `friendlink` */

insert  into `friendlink`(`id`,`blogger`,`url`) values (1,'爱敲代码的小游子','https://youkaiyang.blog.csdn.net/');

/*Table structure for table `leave_message_likes_record` */

DROP TABLE IF EXISTS `leave_message_likes_record`;

CREATE TABLE `leave_message_likes_record` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pageName` varchar(255) NOT NULL,
  `pId` int NOT NULL,
  `likerId` int NOT NULL,
  `likeDate` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `leave_message_likes_record` */

/*Table structure for table `leave_message_record` */

DROP TABLE IF EXISTS `leave_message_record`;

CREATE TABLE `leave_message_record` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pageName` varchar(255) NOT NULL,
  `pId` int NOT NULL,
  `answererId` int NOT NULL,
  `respondentId` int NOT NULL,
  `leaveMessageDate` varchar(255) NOT NULL,
  `likes` int NOT NULL,
  `leaveMessageContent` text NOT NULL,
  `isRead` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `leave_message_record` */

insert  into `leave_message_record`(`id`,`pageName`,`pId`,`answererId`,`respondentId`,`leaveMessageDate`,`likes`,`leaveMessageContent`,`isRead`) values (14,'categories',0,1,1,'2018-09-19 13:53',0,'分类留言测试',0),(15,'archives',0,1,1,'2018-09-19 13:53',0,'归档留言',0),(16,'tags',0,1,1,'2018-09-19 13:53',0,'标签留言',0),(17,'update',0,1,1,'2018-09-19 13:53',0,'更新留言',0),(18,'friendlylink',0,1,1,'2018-09-19 13:54',0,'需要添加友链的朋友可在www.zhyocean.cn/friendlylink下方留言（网站名称+网址），随后验证后会在本人博客中添加友链链接',0),(19,'categories',14,1,1,'2020-08-07 16:59',0,'nihao',0),(20,'categories',14,1,1,'2020-08-07 17:00',0,'好',0);

/*Table structure for table `privateword` */

DROP TABLE IF EXISTS `privateword`;

CREATE TABLE `privateword` (
  `id` int NOT NULL AUTO_INCREMENT,
  `privateWord` varchar(255) NOT NULL,
  `publisherId` varchar(255) NOT NULL,
  `replierId` varchar(255) DEFAULT NULL,
  `replyContent` varchar(255) DEFAULT NULL,
  `publisherDate` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `privateword` */

insert  into `privateword`(`id`,`privateWord`,`publisherId`,`replierId`,`replyContent`,`publisherDate`) values (8,'悄悄话测试','1','0',NULL,'2018-09-19 14:13:32'),(9,'b','1','0',NULL,'2020-08-06 15:27:21');

/*Table structure for table `reward` */

DROP TABLE IF EXISTS `reward`;

CREATE TABLE `reward` (
  `id` int NOT NULL,
  `fundRaiser` varchar(30) NOT NULL,
  `fundRaisingSources` varchar(50) NOT NULL,
  `fundraisingPlace` varchar(50) NOT NULL,
  `rewardMoney` float NOT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  `rewardDate` datetime NOT NULL,
  `rewardUrl` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `reward` */

insert  into `reward`(`id`,`fundRaiser`,`fundRaisingSources`,`fundraisingPlace`,`rewardMoney`,`remarks`,`rewardDate`,`rewardUrl`) values (1,'y','y','y',1,'无','2020-08-08 00:00:00','https://zhy-myblog.oss-cn-shenzhen.aliyuncs.com/public/rewardRecord/2019-07-15/1563121018.jpeg');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`id`,`name`) values (1,'ROLE_USER'),(2,'ROLE_ADMIN'),(3,'ROLE_SUPERADMIN');

/*Table structure for table `tags` */

DROP TABLE IF EXISTS `tags`;

CREATE TABLE `tags` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tagName` varchar(255) NOT NULL,
  `tagSize` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `tags` */

insert  into `tags`(`id`,`tagName`,`tagSize`) values (1,'随笔感悟',15),(4,'SpringBoot',17),(5,'个人博客',18),(18,'原创',20),(19,'Linux',20),(20,'LinuxLinux',20),(21,'spring',20);

/*Table structure for table `tb_article` */

DROP TABLE IF EXISTS `tb_article`;

CREATE TABLE `tb_article` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `category_id` varchar(32) DEFAULT NULL COMMENT '分类ID',
  `content` text COMMENT '内容',
  `type` int DEFAULT NULL COMMENT '类型 0表示富文本，1表示markdown',
  `status` int NOT NULL COMMENT '状态 0表示已经发布，1表示草稿，2表示等待发布',
  `view_count` bigint unsigned NOT NULL DEFAULT '0' COMMENT '浏览量',
  `publish_time` datetime NOT NULL COMMENT '发布时间',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `category_id` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='文章表';

/*Data for the table `tb_article` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `phone` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `gender` char(255) NOT NULL,
  `trueName` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `personalBrief` varchar(255) DEFAULT NULL,
  `avatarImgUrl` text NOT NULL,
  `recentlyLanded` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`phone`,`username`,`password`,`gender`,`trueName`,`birthday`,`email`,`personalBrief`,`avatarImgUrl`,`recentlyLanded`) values (1,'18773672707','爱敲代码的小游子','af71e002ee454c44b13e23ea4605c6b6','male','爱敲代码的小游子','1997-07-05','1125694337@qq.com','','https://ykyblog.oss-cn-shenzhen.aliyuncs.com/blog_front/timg.gif','2020-08-07 16:59:42'),(16,'11111111111','yky','af71e002ee454c44b13e23ea4605c6b6','male','yky','2000-08-03','2049995219@qq.com',' ','https://ykyblog.oss-cn-shenzhen.aliyuncs.com/blog_front/timg.gif','2020-08-07 19:14:28');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `User_id` int NOT NULL,
  `Role_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

insert  into `user_role`(`User_id`,`Role_id`) values (1,1),(1,2),(1,3),(16,3),(16,1),(16,2);

/*Table structure for table `visitor` */

DROP TABLE IF EXISTS `visitor`;

CREATE TABLE `visitor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `visitorNum` bigint NOT NULL,
  `pageName` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `visitor` */

insert  into `visitor`(`id`,`visitorNum`,`pageName`) values (1,3228,'totalVisitor'),(2,1032,'visitorVolume'),(3,42,'article/1532884460'),(5,57,'article/1533196734'),(22,0,'article/1596711672');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
