package tech.wetech.admin3.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.wetech.admin3.common.CommonResultStatus;
import tech.wetech.admin3.common.SecurityUtil;
import tech.wetech.admin3.common.StringUtils;
import tech.wetech.admin3.common.authz.RequiresPermissions;
import tech.wetech.admin3.entity.Organization;
import tech.wetech.admin3.entity.User;
import tech.wetech.admin3.entity.UserCredential;
import tech.wetech.admin3.exception.UserException;
import tech.wetech.admin3.repository.UserCredentialRepository;
import tech.wetech.admin3.service.OrganizationService;
import tech.wetech.admin3.service.SessionService;
import tech.wetech.admin3.service.UserService;
import tech.wetech.admin3.service.dto.PageDTO;
import tech.wetech.admin3.service.dto.UserinfoDTO;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

/**
 * @author cjbi
 */
@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/users")
public class UserController {

    private final OrganizationService organizationService;
    private final UserService userService;
    private final SessionService sessionService;
    @Autowired
    private UserCredentialRepository userCredentialRepository;

    public UserController(OrganizationService organizationService, UserService userService, SessionService sessionService) {
        this.organizationService = organizationService;
        this.userService = userService;
        this.sessionService = sessionService;
    }

    @RequiresPermissions("user:view")
    @GetMapping
    public ResponseEntity<PageDTO<User>> findUsers(Pageable pageable, User user) {
        return ResponseEntity.ok(userService.findUsers(pageable, user));
    }

    @RequiresPermissions("user:create")
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid CreateUserRequest request) {
        Organization organization = organizationService.findOrganization(request.organizationId());
        return new ResponseEntity<>(userService.createUser(request.username(), request.avatar(), request.gender(), User.State.NORMAL, organization), HttpStatus.CREATED);
    }

    @RequiresPermissions("user:update")
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody @Valid UpdateUserRequest request) {
        Organization organization = organizationService.findOrganization(request.organizationId());
        return ResponseEntity.ok(userService.updateUser(userId, request.avatar(), request.gender(), User.State.NORMAL, organization));
    }

    @RequiresPermissions("user:update")
    @PostMapping("/{userId}:disable")
    public ResponseEntity<User> disableUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.disableUser(userId));
    }

    @RequiresPermissions("user:update")
    @PostMapping("/{userId}:enable")
    public ResponseEntity<User> enableUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.enableUser(userId));
    }

    @RequiresPermissions("user:delete")
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.delete(userId);
        return ResponseEntity.noContent().build();
    }

    record CreateUserRequest(@NotBlank String username, @NotNull User.Gender gender,
                             @NotBlank String avatar, Long organizationId) {
    }

    record UpdateUserRequest(@NotNull User.Gender gender,
                             @NotBlank String avatar, Long organizationId) {
    }

    //账户编辑
    @PutMapping("/editAccount")
    public ResponseEntity<Void> editAccount(@RequestParam String newPassword, @RequestParam String oldPassword, @RequestParam String desc) throws NoSuchAlgorithmException {
        UserinfoDTO userInfo = sessionService.getCurrentUserInfo();

        if (!StringUtils.isEmpty(oldPassword) && !StringUtils.isEmpty(newPassword)) {
            Optional<UserCredential> credentialOptional = userCredentialRepository.findCredential(userInfo.username(), UserCredential.IdentityType.PASSWORD);
            if (credentialOptional.isEmpty()) {
                throw new UserException(CommonResultStatus.FAIL, "用户密钥不存在");
            }
            UserCredential credential = credentialOptional.get();
            if (!credential.doCredentialMatch(oldPassword)) {
                throw new UserException(CommonResultStatus.FAIL, "旧密码不正确");
            }
            String newCredential = SecurityUtil.md5(userInfo.username(), newPassword);
            credential.setCredential(newCredential);
            userCredentialRepository.save(credential);
        }

        User user = userService.findUserById(userInfo.userId());
        user.setDesc(desc);
        userService.getUserRepository().save(user);

        //refersh userinfo
        sessionService.refresh();

        return ResponseEntity.ok().build();
    }
}
