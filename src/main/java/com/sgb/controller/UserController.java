package com.sgb.controller;

import com.sgb.entity.User;
import com.sgb.service.UserService;
import com.sgb.utils.ImageName;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;
import java.util.UUID;

@Controller
public class UserController {
    @Autowired
    private UserService userService;



    @RequestMapping(path = "/toRegister")
    public String toRegister(HttpSession session){

        return "register";
    }

    @RequestMapping(path = "/register")
    public String register(User user, Model model, @RequestParam(value = "file") MultipartFile file
                           ) throws IOException {

        List<User> list = userService.find();
        for(User u:list){
            if(u.getUsername().equals(user.getUsername())){
                model.addAttribute("nameExist","用户名已存在");
                return "register";
            }
        }
        String path="E:/HeadImage";
         String imageName = UUID.randomUUID()+file.getOriginalFilename();
        String realPath=path+"/"+imageName;

        if(file.getOriginalFilename().equals("")||file.getOriginalFilename()==null){
            user.setImage(null);
        }else {
            user.setImage(realPath);
        }

        userService.register(user);
        file.transferTo(new File(realPath));
        return "index";
    }




    @RequestMapping(path = "toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping(path = "/login")
    public String login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password, Model model,
                        HttpSession session, HttpServletRequest request){

        User user = userService.findByName(username);


        if(user==null && !user.getPassword().equals(password)){
                model.addAttribute("loginErr","用户不存在");

                return "login";
            }else {

                session.setAttribute("username",username);
                return "index";
            }
  }


    @RequestMapping(path = "/toSuccess")
    public String toSuccess(HttpSession session, Model model,HttpServletRequest request) throws IOException {

        List list = userService.find();
        User user=userService.findByName((String) session.getAttribute("username"));
        String srcPath = user.getImage();
        String imageName= srcPath.substring(srcPath.lastIndexOf("/")+1);

        String imagePath = request.getSession().getServletContext().getRealPath("/pic");
        File fileCopy = new File(imagePath);
        File srcFile = new File(srcPath);
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(srcFile));

        if(!fileCopy.exists()){
            fileCopy.mkdirs();
        }
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(imagePath+"/"+imageName));
        IOUtils.copy(in,out);
        IOUtils.closeQuietly(in);
        IOUtils.closeQuietly(out);

        request.setAttribute("imagePath","pic/"+imageName);
        model.addAttribute("users",list);
        return "success";

    }



    @RequestMapping(path = "/logout")
    public String logout(HttpSession session){
        session.setAttribute("username",null);
        session.removeAttribute("image");
        return "index";
    }

    @RequestMapping(path = "/toUpdate/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model){
        User user = userService.findUser(id);
        model.addAttribute("user",user);
        return "update";
    }
    @RequestMapping(path = "update")
    public String update(@ModelAttribute("updateUser") User user, HttpSession session){
        String username = (String) session.getAttribute("username");
        userService.update(user);
        if(username.equals(user.getUsername())){
            session.setAttribute("username",null);
            return "index";
        }
        return "redirect:/toSuccess";
    }
    @ModelAttribute
    public void getUser(@RequestParam(value = "id",required = false) Integer id,Model model){
        if(id!=null){
            User user = userService.findUser(id);
            model.addAttribute("updateUser",user);
        }
    }


    @RequestMapping(path = "/delete/{id}")
    public String delete(@PathVariable("id") Integer id,HttpSession session){
        User user = userService.findUser(id);
        String username = (String) session.getAttribute("username");
        userService.delete(user);

        if(username.equals(user.getUsername())){
            session.setAttribute("username",null);
            return "index";
        }
        return "redirect:/toSuccess";
    }

    @RequestMapping(path = "/registeri18n")
    public String registeri18n(@RequestParam(value = "locale",defaultValue = "zh_CN") String str){
        return "register";
    }

    @RequestMapping(path = "/indexi18n")
    public String indexi18n(@RequestParam(value = "locale",defaultValue = "zh_CN") String str){
        return "index";
    }

    //下载
    @RequestMapping(path = "/download")
    public void download(HttpServletResponse response,HttpSession session) throws UnsupportedEncodingException {

        BufferedInputStream in=null;
        BufferedOutputStream out=null;
        User user = userService.findByName((String) session.getAttribute("username"));
        String image = user.getImage();
           String imageName = ImageName.getImageName(image);
//       下载文件名为中文时是乱码
        imageName= new String(imageName.getBytes("GBK"),"ISO-8859-1");
        try {
             in = new BufferedInputStream(new FileInputStream(new File(image)));
            out = new BufferedOutputStream(response.getOutputStream());
         /*
         * 设置响应头
         * Content-Disposition告诉浏览器不要直接打开下载文件
         * attachment告诉浏览这是附件
         * filename设置下载文件名
         * */
            response.setHeader("Content-Disposition","attachment;filename="+imageName);

//            int len=-1;
//            byte[] bytes = new byte[1024];
//            while ((len=in.read(bytes))!=-1){
//                out.write(bytes,0,len);
//            }
//            out.close();
//            in.close();

            IOUtils.copy(in,out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    测试ajax提交
    @RequestMapping(path = "/username")
    @ResponseBody
          public void username(HttpServletResponse response,HttpServletRequest request) throws IOException {
        String username = request.getParameter("username");
        System.out.println(username);
        User name = userService.findByName(username);
        response.setContentType("text/html;charset=utf-8");
        if(name==null){
            response.getWriter().write("用户不存在");
        }

    }

}
