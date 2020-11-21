package com.example.demo;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//セキュリティ設定用クラス
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	//パスワードエンコーダーのBean定義
	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

	//データソース
	@Autowired
	private DataSource dataSource;

	//ユーザーIDとパスワードを取得するSQL文
	private static final String USER_SQL ="SELECT"
			+" user_name,"
			+" password,"
			+" true "
			+" FROM"
			+" user"
			+" WHERE"
			+" user_name=?";

	//ユーザーのロールを取得するSQL文
	private static final String ROLE_SQL ="SELECT"
			+" user_name,"
			+" role"
			+" FROM"
			+" user "
			+" WHERE"
			+" user_name=?";

	@Override
	public void configure(WebSecurity web) throws Exception {

		//静的リソースへのアクセスには、セキュリティを適用しない
		web.ignoring().antMatchers("/webjars/**","/css/**");
		web.ignoring().antMatchers("/webjars/**","/images/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		//ログイン不要ページの設定
		http.authorizeRequests()
		.antMatchers("/webjars/**").permitAll()
		.antMatchers("/css/**").permitAll()
		.antMatchers("/main").permitAll()
		.antMatchers("/login/login").permitAll()
		.antMatchers("/login/signup").permitAll()
		.antMatchers("/dramaInfo/dramaInfo/{dramaId}").permitAll()
		.anyRequest().authenticated();

		//ログイン
		http.formLogin()
		.loginProcessingUrl("/login/login")
		.loginPage("/login/login")
		.failureUrl("/login/login")
		.usernameParameter("userName")
		.passwordParameter("password")
		.defaultSuccessUrl("/main", true);

		//ログアウト
		http.logout()
		.logoutUrl("/logout")
		.logoutSuccessUrl("/main");

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//ログイン処理時のユーザー情報を、DBから取得する
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery(USER_SQL)
		.authoritiesByUsernameQuery(ROLE_SQL)
		.passwordEncoder(passwordEncoder());
	}
}