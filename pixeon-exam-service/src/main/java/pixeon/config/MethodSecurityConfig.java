package pixeon.config;

/**
 * Created by gian on 28/01/20.
 */
/*@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = false,
        jsr250Enabled = false)*/
public class MethodSecurityConfig /*extends WebSecurityConfigurerAdapter*/ {

/*
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/projetos/{projetoId}/**").access("@security.hasPermission(authentication, 'PROJETOS', #projetoId)")
                .antMatchers("/admin/**").access("hasRole('ADMIN')")
                .antMatchers(HttpMethod.POST, "/api/**").permitAll()
                .anyRequest().permitAll();
    }*/




}