package ru.fes.rest;

import ru.fes.common.AppConsts;
import ru.fes.common.LoginPassCheckResult;
import ru.fes.common.RestResult;
import ru.fes.dto.user.AccessAuthDto;
import ru.fes.dto.user.UserAuthDto;
import ru.fes.dto.user.UserDto;
import ru.fes.entities.common.User;
import ru.fes.services.AuthService;
import ru.fes.services.TokenService;
import ru.fes.services.UserService;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

/**
 * Created by VMakarenko on 2/4/15.
 */
@Path(value = "auth/")
public class AuthResource {
    @Inject
    UserService userService;
    @Inject
    AuthService authService;
    @Inject
    TokenService tokenService;

    @POST
    @Path("register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(UserDto dto) {
        userService.createUser(dto);
        return Response.ok().build();
    }

    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(UserAuthDto dto, @Context HttpServletRequest request) {
        AccessAuthDto accessAuthDto = authService.login(dto);
        if (accessAuthDto != null) {
            String path = "/fes";
            String domain = "";//request.getServerName();
            tokenService.createEntry(accessAuthDto.getId(), accessAuthDto.getToken());
            NewCookie tokenCookie = new NewCookie(AccessAuthDto.COOKIE_TOKEN, accessAuthDto.getToken(), path, domain, "", -1, false);
            NewCookie idCookie = new NewCookie(AccessAuthDto.COOKIE_ID, accessAuthDto.getId(), path, domain, "", -1, false);
            return Response.ok(RestResult.getOk()).cookie(tokenCookie).cookie(idCookie).build();
        } else {
            return Response.ok(RestResult.getBad()).build();
        }
    }

    @POST
    @Path("logout")
    @Produces(MediaType.APPLICATION_JSON)
    public Response logout(@Context HttpServletRequest request) {
        if (request.getSession().getAttribute(AppConsts.CURRENT_USER_ATTRIBUTE) != null) {
            request.getSession().removeAttribute("currentUser");
            return Response.ok(RestResult.getOk()).build();
        }else{
            return Response.ok(RestResult.getBad()).build();
        }
    }

    @GET
    @Path("getCurrentUser")
    @Produces(MediaType.APPLICATION_JSON)
    public User getCurrentUser(@Context HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("currentUser");
        if(user != null){
            user.setPassword(null);
        }
        return user;
    }

    @GET
    @Path("isAuthenticated")
    @Produces(MediaType.APPLICATION_JSON)
    public Response isAuthenticated(@Context HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        String token = "";
        String id = "";
        for(Cookie cookie: cookies){
            if(cookie.getName().equals(AccessAuthDto.COOKIE_TOKEN)){
                token = cookie.getValue();
            }
            if(cookie.getName().equals(AccessAuthDto.COOKIE_ID)){
                id = cookie.getValue();
            }
        }

        return Response.ok(tokenService.checkEntry(id, token)? RestResult.getOk() : RestResult.getBad()).build();
    }
}

class LoginDto {
    private String username;
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

