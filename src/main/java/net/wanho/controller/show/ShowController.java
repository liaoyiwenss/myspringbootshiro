package net.wanho.controller.show;


import com.github.pagehelper.PageInfo;
import net.wanho.pojo.Product;
import net.wanho.pojo.vo.ProductCategoryVO;
import net.wanho.service.product.ProductCategoryService;
import net.wanho.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/show")
public class ShowController {

    @Autowired
    ProductService productService;


    @Autowired
    ProductCategoryService productCategoryService;

    @RequestMapping("/Temp")
    public String temp(HttpSession session)
    {
        return "Temp";
    }

    @RequestMapping("/Index")
    public String showindex(HttpSession session, HttpServletRequest request, Map map)
    {
        List<ProductCategoryVO> pclist = productCategoryService.getDomList();


        session.setAttribute("pclist",pclist);
        PageInfo<Product> productPageInfo = productService.selectProductbyEntity(null,null,0, 6, 1);
        PageInfo<Product> productPageInfo1 =productService.selectProductbyEntity(null,null,1,6,1);
        PageInfo<Product> productPageInfo2 =productService.selectProductbyEntity(null,null,2,6,1);
        PageInfo<Product> productPageInfo3 =productService.selectProductbyEntity(null,null,3,6,1);
        PageInfo<Product> productPageInfo4 =productService.selectProductbyEntity(null,null,4,6,1);
        PageInfo<Product> productPageInfo5 =productService.selectProductbyEntity(null,null,5,6,1);
        PageInfo<Product> productPageInfo6 =productService.selectProductbyEntity(null,null,6,6,1);

        map.put("productlist",productPageInfo.getList());
        map.put("productlist1",productPageInfo1.getList());
        map.put("productlist2",productPageInfo2.getList());
        map.put("productlist3",productPageInfo3.getList());
        map.put("productlist4",productPageInfo4.getList());
        map.put("productlist5",productPageInfo5.getList());
        map.put("productlist6",productPageInfo6.getList());

        /*session.setAttribute("productlist",productPageInfo.getList());
        session.setAttribute("productlist1",productPageInfo1.getList());
        session.setAttribute("productlist2",productPageInfo2.getList());
        session.setAttribute("productlist3",productPageInfo3.getList());
        session.setAttribute("productlist4",productPageInfo4.getList());
        session.setAttribute("productlist5",productPageInfo5.getList());
        session.setAttribute("productlist6",productPageInfo6.getList());*/

        String filepath=request.getContextPath();
        session.setAttribute("filepath", filepath+"/files/");




        return "Index";
    }


    @RequestMapping("Login")
    public String Login()
    {
        return "Login";
    }

    @RequestMapping("Regist")
    public String Regist(){
        return "Regist";
    }

    @RequestMapping("CategoryList")
    public String CategoryList(){
        return "CategoryList";
    }

    @RequestMapping("Product")
    public String Product(){
        return "Product";
    }


    @RequestMapping("toSettlement")
    public String toSettlement(){

        return "/settlement/toSettlement";
    }


    @RequestMapping("settlement1")
    public String settlement1(){
        return "/settlement/settlement1";
    }

    @RequestMapping("settlement2")
    public String settlement2(){
        return "/settlement/settlement2";
    }

    @RequestMapping("settlement3")
    public String settlement3(){
        return "/settlement/settlement3";
    }
}
