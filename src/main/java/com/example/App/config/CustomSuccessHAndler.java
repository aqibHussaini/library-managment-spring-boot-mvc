package com.example.App.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomSuccessHAndler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        authentication.getAuthorities().forEach(a->{
          if( a.getAuthority().equals("User"))
          {
              try
              {

                  httpServletResponse.sendRedirect("/user-home");
              }catch (Exception e)
              {

              }
          }
          else  if( a.getAuthority().equals("Admin"))
          {
              try
              {

                  httpServletResponse.sendRedirect("/admin/home");
              }catch (Exception e)
              {

              }

          }
        });
    }
}
