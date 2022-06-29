package uz.ages.appclickup.entity.enums;

import javax.swing.plaf.PanelUI;
import java.util.Arrays;
import java.util.List;

public enum WorkspacePermissionName {
    CAN_ADD_OR_REMOVE_MEMBER("Add/remove members", "Gives user permission to add or removr members to the workspace", Arrays.asList(WorkspaceRoleName.ROLE_MEMBER, WorkspaceRoleName.ROLE_OWNER)),
    CAN_MANAGE_MEMBER("Can edit statues", "Gives permission ...", Arrays.asList(WorkspaceRoleName.ROLE_MEMBER, WorkspaceRoleName.ROLE_OWNER));

    public String name;
    public String description;
    public List<WorkspaceRoleName> workspaceRoleNameList;

    WorkspacePermissionName(String name, String description, List<WorkspaceRoleName> workspaceRoleNameList) {
        this.name = name;
        this.description = description;
        this.workspaceRoleNameList = workspaceRoleNameList;
    }
}
