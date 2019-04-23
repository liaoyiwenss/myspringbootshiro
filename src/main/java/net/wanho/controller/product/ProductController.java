package net.wanho.controller.product;

import com.github.pagehelper.PageInfo;
import net.wanho.pojo.Product;
import net.wanho.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("doproduct")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("queryproductList")
    public String queryproductList(String proName,Integer productid,Integer pageno,HttpSession session){

        if(pageno==null)
        {
            pageno=1;
        }
        session.removeAttribute("pcid");
        session.removeAttribute("proName");
        if(proName!=null)
        {
            session.setAttribute("proName",proName);
        }else if(productid!=null) {
            session.setAttribute("pcid", productid);
        }

        PageInfo<Product> productPageInfo = productService.selectProductbyEntity(productid,proName,pageno, 5, 4);

        session.setAttribute("pagehelper",productPageInfo);

        return "redirect:/show/CategoryList";
    }

    @RequestMapping("product")
    public String product(Long tid,HttpSession session){


        Product product=productService.selectByPrimaryKey(tid);
        session.setAttribute("pro",product);
        return "redirect:/show/Product";

    }
}
