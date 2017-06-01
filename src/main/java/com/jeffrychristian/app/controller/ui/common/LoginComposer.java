package com.jeffrychristian.app.controller.ui.common;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;

/**
 * Created by jeffry.christian on 11/8/2016.
 */
public class LoginComposer extends BaseComposer {

    @Override
    public void doAfterCompose(Window comp) throws Exception {
        super.doAfterCompose(comp);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.getPrincipal().equals("anonymousUser")) {
            Executions.getCurrent().sendRedirect("/app");
        }

    }

}