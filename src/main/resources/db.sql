CREATE SCHEMA `stack` DEFAULT CHARACTER SET utf8mb4;
use stack;
create user stack_user IDENTIFIED by 'test321';
grant select,update,delete ,insert,create,alter on stack.* to stack_user;
#show grants for stack_user;

#用户信息
CREATE TABLE IF NOT EXISTS blockInfo(
id int(10) NOT NULL AUTO_INCREMENT,
`key` varchar(128) NOT NULL,
stack TEXT NOT NULL,
blockTime int(10),
insert_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
PRIMARY KEY (`id`)
);

CREATE INDEX key_blockInfo_index ON blockInfo(`key`);