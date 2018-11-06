/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.validation.api.builtin.stringvalidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.netbeans.validation.api.Problems;
import org.openide.util.NbBundle;

/**
 *
 * @author SC
 */
public class DNIValidator extends StringValidator {

    @Override
    public void validate(Problems problems, String compName, String model) {
        /* seguir http://www.ruidoquattro.com/blog/entry?code=7XB1M*/
        /*
        boolean correcto = false;
        Pattern pattern = Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
        Matcher matcher = pattern.matcher(model);
        */
        if (model.length() != 9) {
            String message = NbBundle.getMessage(DNIValidator.class, "MSG_LONG_DNI", compName);
            problems.add(message);
        } /*else if  {
            
        }*/
    }

}
