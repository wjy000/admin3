-- 关闭外键约束检查
set
foreign_key_checks = 0;

INSERT INTO user (id, username, avatar, created_time, gender, state, organization_id, desc)
VALUES (1, 'admin', 'avatar.jpg', '2023-01-05 17:16:11.000000', 0, 0, 1, "不可能！我的代码怎么可能会有bug！");
INSERT INTO user (id, username, avatar, created_time, gender, state, organization_id, desc)
VALUES (2, 'employee', 'avatar.jpg', '2023-01-05 17:16:11.000000', 1, 0, 3, "");
INSERT INTO user (id, username, avatar, created_time, gender, state, organization_id, desc)
VALUES (3, 'guest', 'avatar.jpg', '2023-01-05 17:16:11.000000', 0, 0, 3, "");

INSERT INTO user_credential (id, credential, identifier, identity_type, user_id)
VALUES (1, 'a66abb5684c45962d887564f08346e8d', 'admin', 0, 1);
INSERT INTO user_credential (id, credential, identifier, identity_type, user_id)
VALUES (2, '9c0967753a201ecde21ef29efa514761', 'employee', 0, 2);
INSERT INTO user_credential (id, credential, identifier, identity_type, user_id)
VALUES (3, 'fe4ceeb01d43a6c29d8f4fe93313c6c1', 'guest', 0, 3);

INSERT INTO organization (id, name, parent_ids, type, parent_id)
VALUES (1, '根节点', '/', 0, null);
INSERT INTO organization (id, name, parent_ids, type, parent_id)
VALUES (2, '水浒传', '/1/', 0, 1);
INSERT INTO organization (id, name, parent_ids, type, parent_id)
VALUES (3, '测试账号', '/1/', 0, 1);

INSERT INTO role (id, available, description, name)
VALUES (1, true, '超级管理员可以对企业内的所有用户进行管理，请谨慎修改超管权限', '超级管理员');
INSERT INTO role (id, available, description, name)
VALUES (2, true, '项目开发人员', '开发者');
INSERT INTO role (id, available, description, name)
VALUES (3, true, '普通的用户', '普通用户');
INSERT INTO role (id, available, description, name)
VALUES (4, false, '只能查看的角色', '游客');

INSERT INTO user_role (user_id, role_id)
VALUES (1, 1);
INSERT INTO user_role (user_id, role_id)
VALUES (2, 2);
INSERT INTO user_role (user_id, role_id)
VALUES (3, 4);
INSERT INTO user_role (user_id, role_id)
VALUES (202, 2);
INSERT INTO user_role (user_id, role_id)
VALUES (203, 1);
INSERT INTO user_role (user_id, role_id)
VALUES (203, 3);
INSERT INTO user_role (user_id, role_id)
VALUES (204, 3);
INSERT INTO user_role (user_id, role_id)
VALUES (205, 3);
INSERT INTO user_role (user_id, role_id)
VALUES (206, 3);
INSERT INTO user_role (user_id, role_id)
VALUES (207, 3);
INSERT INTO user_role (user_id, role_id)
VALUES (208, 3);
INSERT INTO user_role (user_id, role_id)
VALUES (209, 3);
INSERT INTO user_role (user_id, role_id)
VALUES (210, 3);
INSERT INTO user_role (user_id, role_id)
VALUES (211, 3);
INSERT INTO user_role (user_id, role_id)
VALUES (212, 3);
INSERT INTO user_role (user_id, role_id)
VALUES (302, 2);



INSERT INTO resource (id, icon, name, parent_ids, permission, type, url, parent_id)
VALUES (1, null, '根节点', null, '*', null, null, null);
INSERT INTO resource (id, icon, name, parent_ids, permission, type, url, parent_id)
VALUES (2, 'Odometer', '仪表盘', null, 'dashboard', 0, '/dashboard', 1);
INSERT INTO resource (id, icon, name, parent_ids, permission, type, url, parent_id)
VALUES (3, 'SetUp', '系统管理', null, 'sys', 0, '/sys', 1);
INSERT INTO resource (id, icon, name, parent_ids, permission, type, url, parent_id)
VALUES (4, 'User', '用户管理', null, 'user:view', 0, '/users', 3);
INSERT INTO resource (id, icon, name, parent_ids, permission, type, url, parent_id)
VALUES (5, 'Tickets', '角色管理', null, 'role:view', 0, '/roles', 3);
INSERT INTO resource (id, icon, name, parent_ids, permission, type, url, parent_id)
VALUES (6, 'Collection', '权限资源', null, 'resource:view', 0, '/resources', 3);
INSERT INTO resource (id, icon, name, parent_ids, permission, type, url, parent_id)
VALUES (7, null, '查看用户', null, 'user:view', 1, null, 4);
INSERT INTO resource (id, icon, name, parent_ids, permission, type, url, parent_id)
VALUES (8, null, '新增用户', null, 'user:create', 1, null, 4);
INSERT INTO resource (id, icon, name, parent_ids, permission, type, url, parent_id)
VALUES (9, null, '修改用户', null, 'user:update', 1, null, 4);
INSERT INTO resource (id, icon, name, parent_ids, permission, type, url, parent_id)
VALUES (10, null, '删除用户', null, 'user:delete', 1, null, 4);
INSERT INTO resource (id, icon, name, parent_ids, permission, type, url, parent_id)
VALUES (11, null, '查看角色', null, 'role:view', 1, null, 5);
INSERT INTO resource (id, icon, name, parent_ids, permission, type, url, parent_id)
VALUES (12, null, '新增角色', null, 'role:create', 1, null, 5);
INSERT INTO resource (id, icon, name, parent_ids, permission, type, url, parent_id)
VALUES (13, null, '修改角色', null, 'role:update', 1, null, 5);
INSERT INTO resource (id, icon, name, parent_ids, permission, type, url, parent_id)
VALUES (14, null, '删除角色', null, 'role:delete', 1, null, 5);
INSERT INTO resource (id, icon, name, parent_ids, permission, type, url, parent_id)
VALUES (15, null, '查看资源', null, 'resource:view', 1, null, 6);
INSERT INTO resource (id, icon, name, parent_ids, permission, type, url, parent_id)
VALUES (16, null, '新增资源', null, 'resource:create', 1, null, 6);
INSERT INTO resource (id, icon, name, parent_ids, permission, type, url, parent_id)
VALUES (17, null, '修改资源', null, 'resource:update', 1, null, 6);
INSERT INTO resource (id, icon, name, parent_ids, permission, type, url, parent_id)
VALUES (18, null, '删除资源', null, 'resource:delete', 1, null, 6);
INSERT INTO resource (id, icon, name, parent_ids, permission, type, url, parent_id)
VALUES (19, null, '新增组织架构', null, 'organization:create', 1, null, 4);
INSERT INTO resource (id, icon, name, parent_ids, permission, type, url, parent_id)
VALUES (20, null, '修改组织架构', null, 'organization:update', 1, null, 4);
INSERT INTO resource (id, icon, name, parent_ids, permission, type, url, parent_id)
VALUES (21, null, '删除组织架构', null, 'organization:delete', 1, null, 4);
INSERT INTO resource (id, icon, name, parent_ids, permission, type, url, parent_id)
VALUES (22, 'Timer', '操作日志', null, 'log:view', 0, '/logs', 3);
INSERT INTO resource (id, icon, name, parent_ids, permission, type, url, parent_id)
VALUES (23, null, '清空日志', null, 'log:clean', 1, null, 22);
INSERT INTO resource (id, icon, name, parent_ids, permission, type, url, parent_id)
VALUES (24, null, '查看日志', null, 'log:view', 1, null, 22);
INSERT INTO resource (id, icon, name, parent_ids, permission, type, url, parent_id)
VALUES (25, 'Files', '对象存储', null, 'storage:view', 0, '/storage', 3);
INSERT INTO resource (id, icon, name, parent_ids, permission, type, url, parent_id)
VALUES (26, null, '查看对象存储', null, 'storage:view', 1, null, 25);
INSERT INTO resource (id, icon, name, parent_ids, permission, type, url, parent_id)
VALUES (27, null, '新增对象存储', null, 'storage:create', 1, null, 25);
INSERT INTO resource (id, icon, name, parent_ids, permission, type, url, parent_id)
VALUES (28, null, '更新对象存储', null, 'storage:update', 1, null, 25);
INSERT INTO resource (id, icon, name, parent_ids, permission, type, url, parent_id)
VALUES (29, null, '删除对象存储', null, 'storage:delete', 1, null, 25);
INSERT INTO resource (id, icon, name, parent_ids, permission, type, url, parent_id)
VALUES (30, null, '设置默认存储', null, 'storage:markAsDefault', 1, null, 25);


INSERT INTO role_resource (role_id, resource_id)
VALUES (1, 2);
INSERT INTO role_resource (role_id, resource_id)
VALUES (1, 3);
INSERT INTO role_resource (role_id, resource_id)
VALUES (1, 4);
INSERT INTO role_resource (role_id, resource_id)
VALUES (1, 5);
INSERT INTO role_resource (role_id, resource_id)
VALUES (1, 6);
INSERT INTO role_resource (role_id, resource_id)
VALUES (1, 7);
INSERT INTO role_resource (role_id, resource_id)
VALUES (1, 8);
INSERT INTO role_resource (role_id, resource_id)
VALUES (1, 9);
INSERT INTO role_resource (role_id, resource_id)
VALUES (1, 10);
INSERT INTO role_resource (role_id, resource_id)
VALUES (1, 11);
INSERT INTO role_resource (role_id, resource_id)
VALUES (1, 12);
INSERT INTO role_resource (role_id, resource_id)
VALUES (1, 13);
INSERT INTO role_resource (role_id, resource_id)
VALUES (1, 14);
INSERT INTO role_resource (role_id, resource_id)
VALUES (1, 15);
INSERT INTO role_resource (role_id, resource_id)
VALUES (1, 16);
INSERT INTO role_resource (role_id, resource_id)
VALUES (1, 17);
INSERT INTO role_resource (role_id, resource_id)
VALUES (1, 18);
INSERT INTO role_resource (role_id, resource_id)
VALUES (1, 19);
INSERT INTO role_resource (role_id, resource_id)
VALUES (1, 20);
INSERT INTO role_resource (role_id, resource_id)
VALUES (1, 21);
INSERT INTO role_resource (role_id, resource_id)
VALUES (1, 22);
INSERT INTO role_resource (role_id, resource_id)
VALUES (1, 23);
INSERT INTO role_resource (role_id, resource_id)
VALUES (1, 24);
INSERT INTO role_resource (role_id, resource_id)
VALUES (1, 25);
INSERT INTO role_resource (role_id, resource_id)
VALUES (1, 26);
INSERT INTO role_resource (role_id, resource_id)
VALUES (1, 27);
INSERT INTO role_resource (role_id, resource_id)
VALUES (1, 28);
INSERT INTO role_resource (role_id, resource_id)
VALUES (1, 29);
INSERT INTO role_resource (role_id, resource_id)
VALUES (1, 30);
INSERT INTO role_resource (role_id, resource_id)
VALUES (2, 2);
INSERT INTO role_resource (role_id, resource_id)
VALUES (2, 3);
INSERT INTO role_resource (role_id, resource_id)
VALUES (2, 6);
INSERT INTO role_resource (role_id, resource_id)
VALUES (2, 15);
INSERT INTO role_resource (role_id, resource_id)
VALUES (2, 16);
INSERT INTO role_resource (role_id, resource_id)
VALUES (2, 17);
INSERT INTO role_resource (role_id, resource_id)
VALUES (2, 18);
INSERT INTO role_resource (role_id, resource_id)
VALUES (2, 22);
INSERT INTO role_resource (role_id, resource_id)
VALUES (2, 23);
INSERT INTO role_resource (role_id, resource_id)
VALUES (2, 24);
INSERT INTO role_resource (role_id, resource_id)
VALUES (2, 25);
INSERT INTO role_resource (role_id, resource_id)
VALUES (2, 26);
INSERT INTO role_resource (role_id, resource_id)
VALUES (2, 27);
INSERT INTO role_resource (role_id, resource_id)
VALUES (2, 28);
INSERT INTO role_resource (role_id, resource_id)
VALUES (2, 29);
INSERT INTO role_resource (role_id, resource_id)
VALUES (2, 30);
INSERT INTO role_resource (role_id, resource_id)
VALUES (3, 2);
INSERT INTO role_resource (role_id, resource_id)
VALUES (4, 2);
INSERT INTO role_resource (role_id, resource_id)
VALUES (4, 3);
INSERT INTO role_resource (role_id, resource_id)
VALUES (4, 4);
INSERT INTO role_resource (role_id, resource_id)
VALUES (4, 5);
INSERT INTO role_resource (role_id, resource_id)
VALUES (4, 6);
INSERT INTO role_resource (role_id, resource_id)
VALUES (4, 7);
INSERT INTO role_resource (role_id, resource_id)
VALUES (4, 11);
INSERT INTO role_resource (role_id, resource_id)
VALUES (4, 15);

INSERT INTO storage_config (type, id, is_default, name, address, storage_path, access_key, bucket_name, endpoint,
                            secret_key, create_time, create_user, storage_id)
VALUES (0, 1, true, '本地', 'storage/fetch/', 'files', null, null, null, null, '2023-07-10 17:00:48.000000', 'admin',
        'SsIPzgpd9rFgxJhe3yUxk');

-- 开启外键约束检查
set
foreign_key_checks = 1;
