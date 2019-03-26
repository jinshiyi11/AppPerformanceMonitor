CREATE SCHEMA `stack` DEFAULT CHARACTER SET utf8mb4;
use stack;
create user stack_user IDENTIFIED by 'test321';
grant select,update,delete ,insert,create,alter on stack.* to stack_user;
#show grants for stack_user;

#block表
CREATE TABLE IF NOT EXISTS blockInfo(
id int(10) NOT NULL AUTO_INCREMENT,
`key` varchar(128) NOT NULL,
stack TEXT NOT NULL,
blockTime int(10),
model TEXT,
versionName TEXT,
versionCode int,
insert_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
PRIMARY KEY (`id`)
);

CREATE INDEX key_blockInfo_index ON blockInfo(`key`);

#matrix内存泄漏表
CREATE TABLE IF NOT EXISTS matrixLeakInfo(
id int(10) NOT NULL AUTO_INCREMENT,
activity TEXT,
tag TEXT,
process TEXT,
occurTime BIGINT,
insertTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
PRIMARY KEY (`id`)
);

#leakCanary内存泄漏表
CREATE TABLE IF NOT EXISTS leakCanaryInfo(
id int(10) NOT NULL AUTO_INCREMENT,
`key` varchar(128) NOT NULL,
stack TEXT NOT NULL,
blockTime int(10),
model TEXT,
versionName TEXT,
versionCode int,
insert_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
PRIMARY KEY (`id`)
);