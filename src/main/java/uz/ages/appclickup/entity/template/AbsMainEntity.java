package uz.ages.appclickup.entity.template;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import uz.ages.appclickup.entity.User;

import javax.persistence.*;
import java.sql.Timestamp;
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbsMainEntity {
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;
    @JoinColumn(updatable = false)
    @ManyToOne
    private User createdBy;
    @ManyToOne(fetch = FetchType.LAZY)
    private User updateBy;

}
