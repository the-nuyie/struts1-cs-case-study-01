package com.casestudy.cs.action;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.extras.actions.DispatchAction;

public class DailyAction extends DispatchAction {

    public ActionForward GetExcelDaily(ActionMapping mapping, ActionForm form,
                                       HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ServletOutputStream out = response.getOutputStream();
        out.print("Hello, this is from GetExcelDeaily method.");

        // return mapping.findForward("success");
        return null;
    }

}