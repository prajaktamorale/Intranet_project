package com.arcus.intranet.controller;

import com.arcus.intranet.domain.EmployeeDAO;
import com.arcus.intranet.domain.HelpDeskDAO;
import com.arcus.intranet.model.Employee;
import com.arcus.intranet.model.HelpDesk;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sindhya on 5/4/17.
 */

@CrossOrigin
@RestController
public class IntranetServiceController {

    @RequestMapping(value = "/employee/list",method = RequestMethod.GET)
    public List getEmployees(@RequestParam(value = "employeeNumber",required = false,defaultValue = "0") Integer employee_number){
        EmployeeDAO employeeDAO=new EmployeeDAO();
        List<Employee> employeeList=employeeDAO.getEmployeeList(employee_number);
        return employeeList;
    }

    @RequestMapping(value = "/helpdesk",method = RequestMethod.POST)
    public ResponseEntity<HelpDesk> createHelpMessage(@RequestParam(value = "message",required = false,defaultValue = "0") String message){

        HelpDeskDAO helpDeskDAO=new HelpDeskDAO();
        HelpDesk helpDesk1=helpDeskDAO.createMessage(message);

        return new ResponseEntity<HelpDesk>(helpDesk1, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/employee/email",method = RequestMethod.GET)
    public List getEmployee(@RequestParam(value = "email",required = true) String email){
        EmployeeDAO employeeDAO=new EmployeeDAO();
        List<Employee> employeeList=employeeDAO.getEmployeeByEmail(email);
        return employeeList;
    }


    @RequestMapping(value = "/helpdesk",method = RequestMethod.GET)
    public List getHelpMessage(){

        HelpDeskDAO helpDeskDAO=new HelpDeskDAO();
        List<HelpDesk> helpDesk=helpDeskDAO.getMessageList();

        return helpDesk;
    }
}
