package net.wanho.controller.show;


import com.github.pagehelper.PageInfo;
import net.wanho.pojo.Product;
import net.wanho.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/show")
public class ShowController {

    @Autowired
    ProductService productService;



    @RequestMapping("/Temp")
    public String temp(HttpSession session)
    {
        return "Temp";
    }

    @RequestMapping("/Index")
    public String showindex(HttpSession session)
    {
        PageInfo<Product> productPageInfo = productService.selectProductbyEntity(0, 6, 1);
        PageInfo<Product> productPageInfo1 =productService.selectProductbyEntity(1,6,1);
        PageInfo<Product> productPageInfo2 =productService.selectProductbyEntity(2,6,1);
        PageInfo<Product> productPageInfo3 =productService.selectProductbyEntity(3,6,1);
        PageInfo<Product> productPageInfo4 =productService.selectProductbyEntity(4,6,1);
        PageInfo<Product> productPageInfo5 =productService.selectProductbyEntity(5,6,1);
        PageInfo<Product> productPageInfo6 =productService.selectProductbyEntity(6,6,1);

        session.setAttribute("productlist",productPageInfo.getList());
        session.setAttribute("productlist1",productPageInfo1.getList());
        session.setAttribute("productlist2",productPageInfo2.getList());
        session.setAttribute("productlist3",productPageInfo3.getList());
        session.setAttribute("productlist4",productPageInfo4.getList());
        session.setAttribute("productlist5",productPageInfo5.getList());
        session.setAttribute("productlist6",productPageInfo6.getList());

        session.setAttribute("filepath", "D:\\springbootbase\\src\\main\\webapp\\files\\");




        return "Index";
    }
}
