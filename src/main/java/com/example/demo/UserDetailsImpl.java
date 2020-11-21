package com.example.demo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.main.domain.model.User;

public class UserDetailsImpl implements UserDetails {

	    private final User user;

	    public UserDetailsImpl(User user) {
	        this.user = user;
	    }

	    public int getId() {
	        return user.getId();
	    }

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			// TODO 自動生成されたメソッド・スタブ
			return null;
		}

		@Override
		public String getPassword() {
			// TODO 自動生成されたメソッド・スタブ
			return null;
		}

		@Override
		public String getUsername() {
			// TODO 自動生成されたメソッド・スタブ
			return null;
		}

		@Override
		public boolean isAccountNonExpired() {
			// TODO 自動生成されたメソッド・スタブ
			return false;
		}

		@Override
		public boolean isAccountNonLocked() {
			// TODO 自動生成されたメソッド・スタブ
			return false;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			// TODO 自動生成されたメソッド・スタブ
			return false;
		}

		@Override
		public boolean isEnabled() {
			// TODO 自動生成されたメソッド・スタブ
			return false;
		}
	}
