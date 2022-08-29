package com.sycho.security.model;

import com.keencho.lib.spring.security.model.KcAccountBaseModel;
import com.sycho.security.config.AccountRoleCode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Data
@Entity
@Table(name = "ADMIN_ACCOUNT")
public class AdminAccount extends KcAccountBaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Override
    public int maxLoginAttemptCnt() {
        return 10;
    }

    @Override
    public Collection<? extends GrantedAuthority> authorities() {
        var set = new HashSet<String>();
        set.add(AccountRoleCode.ROLE_COMMON);
        set.add(AccountRoleCode.ROLE_ADMIN);

        return set.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }
}
