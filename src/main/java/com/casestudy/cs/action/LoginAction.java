package com.casestudy.cs.action;

import com.casestudy.cs.form.LoginForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        LoginForm loginForm = (LoginForm) form;

        if (loginForm.getUserName() == null || loginForm.getPassword() == null
                || !loginForm.getUserName().equalsIgnoreCase("admin")
                || !loginForm.getPassword().equals("P@ssw0rd")) {
            return mapping.findForward("failure");
        } else
            return mapping.findForward("success");
    }
}
