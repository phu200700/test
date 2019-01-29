/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author QuangPhu
 */
@Controller
@RequestMapping("/home")
public class ImageController {

    @RequestMapping("index")
    public String form() {
        return "home/index";
    }

    @RequestMapping("apply")
    public String apply(HttpServletRequest servletRequest,ModelMap model, @RequestParam("photo") MultipartFile photo) {
        if (photo.isEmpty()) {
            model.addAttribute("message", "Vui lòng chọn file !");
        } else {
            try {
                String filename = photo.getOriginalFilename();
                File imageFile = new File(servletRequest.getServletContext().getRealPath("/images"), filename);
                photo.transferTo(imageFile);
                model.addAttribute("photo_name", photo.getOriginalFilename());
                return "home/index";
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return "home/index";
    }
}
