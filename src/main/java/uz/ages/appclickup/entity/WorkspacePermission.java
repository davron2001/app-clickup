package uz.ages.appclickup.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.ages.appclickup.entity.enums.WorkspacePermissionName;
import uz.ages.appclickup.entity.enums.WorkspaceRoleName;
import uz.ages.appclickup.entity.template.AbsUUIDEntity;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WorkspacePermission extends AbsUUIDEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private WorkspaceRole workspaceRole;

    @Column(nullable = false)
    private WorkspacePermissionName workspacePermissionName;

}
