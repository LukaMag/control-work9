package controlwork9.demo.entity.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
        ROLE_DEVELOPER,ROLE_ADMIN;

        @Override
        public String getAuthority() {
                return name();
        }
}
