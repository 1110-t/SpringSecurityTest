package login.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Autowired
    private DataSource dataSource;
    // ログイン後は/homeに遷移させる
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	// csrf認証は使わない
        http.csrf().disable();
        http.headers().frameOptions().disable();
        //　cssなどのリソースファイルにはログイン無しでもアクセスが可能
        http.authorizeHttpRequests(authz -> authz
            .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
            .mvcMatchers("/").permitAll() // ログインなしでもアクセス可能なページ
            .antMatchers("/h2-console/**").permitAll() // ログインなしでもアクセス可能なページパターン
            .mvcMatchers("/general").hasRole("GENERAL") // 権限GENERALがアクセス可能
            .mvcMatchers("/admin").hasRole("ADMIN") // 権限ADMINがアクセス可能
            .anyRequest().authenticated() // 他のURLについてはログイン後にアクセスが可能となる
        );
        // ログインでの認証成功・失敗時の処理の記述
        http.formLogin(form -> form
    		.loginProcessingUrl("/login")
        	.loginPage("/login")
            .defaultSuccessUrl("/home")
            .failureUrl("/login?error")
            .permitAll()
        );
        // ログアウト時の処理の記述
        http.logout(logout -> logout
        	.logoutUrl("/logout")
        	.logoutSuccessUrl("/login")
        );
        System.out.println(this.dataSource);
        return http.build();
    }
    // データベースと連携してログイン処理を行う
//     @Bean
//     public UserDetailsManager users(DataSource dataSource){
    	// ログイン処理が開始したら入力されたユーザー名を元にデータを取得する
//    	String USERQUERY = "select username,password,enabled from users where username = ?";
//    	// 権限についてユーザー名を元にデータを取得する
//    	String AUTHQUERY = "select username,'GENERAL' from authorities where username = ?";
//    	JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//    	users.setUsersByUsernameQuery(USERQUERY);
//    	users.setAuthoritiesByUsernameQuery(AUTHQUERY);
//    	return users;
//    }
}
