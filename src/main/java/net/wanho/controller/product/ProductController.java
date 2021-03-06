package net.wanho.controller.product;

import com.github.pagehelper.PageInfo;
import net.wanho.pojo.Product;
import net.wanho.pojo.Productcategory;
import net.wanho.service.product.ProductCategoryService;
import net.wanho.service.product.ProductService;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("doproduct")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService productCategoryService;


    private Logger logger= LoggerFactory.getLogger(ProductController.class);

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

    @RequestMapping("getallproduct")
    public String getallproduct(Integer pageno,HttpSession session){

        if(pageno==null)
        {
            pageno=1;
        }
        PageInfo<Product> pagehelper = productService.queryListProduct(pageno, 10,4);
        session.setAttribute("pagehelper", pagehelper);
        return "redirect:/show/Member_Money";
    }

    @RequestMapping("deleteProduct")
    public String deleteProduct(Long tid){
        productService.deleteByPrimaryKey(tid);
        return "redirect:/doproduct/getallproduct";
    }

    @RequestMapping("addProduct")
    public String addProduct(@RequestParam("picpath") CommonsMultipartFile file, HttpServletRequest request,
                             Long one, Long two, Long three, String action,String picname,
                             Float price, Long stock,HttpSession session){

        Product product=new Product();

        product.setName(picname);
        product.setCategorylevel1id(one);
        product.setCategorylevel2id(two);
        product.setCategorylevel3id(three);
        product.setPrice(price);
        product.setStock(stock);
        if (!file.isEmpty()) {
            String type = file.getOriginalFilename().substring(
                    file.getOriginalFilename().indexOf("."));// 取文件格式后缀名
            String filename = UUID.randomUUID() + type;// 取当前时间戳作为文件名
            product.setFilename(filename);
            String path = request.getSession().getServletContext()
                    .getRealPath("/files/"+ filename);// 存放位置
            File destFile = new File(path);
//            String realpath="D:\\workspace\\Sumpermarkets\\WebContent\\files\\"+filename;
//            File realFile=new File(realpath);
            try {
                /*file.transferTo(destFile);*/
                // FileUtils.copyInputStreamToFile()这个方法里对IO进行了自动操作，不需要额外的再去关闭IO流
                FileUtils.copyInputStreamToFile(file.getInputStream(), destFile);// 复制临时文件到指定目录下
//                FileUtils.copyInputStreamToFile(file.getInputStream(), realFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int r = 0;
        if(action.equals("add"))
        {
                r = productService.insert(product);
        }
        if(action.equals("update"))
        {
                Product updateproduct=(Product) session.getAttribute("product");
                product.setTid(updateproduct.getTid());
                if(file.isEmpty())
                {
                    product.setFilename(updateproduct.getFilename());
                }
                r=productService.updateByPrimaryKey(product);
        }
            return "redirect:/doproduct/getallproduct";
    }


    @RequestMapping("updateProduct")
    public String updateProduct(Long tid,HttpSession session){

        Product product = productService.selectByPrimaryKey(tid);
        session.setAttribute("product", product);

        Productcategory c1 = productCategoryService.selectByPrimaryKey(product.getCategorylevel1id());
        Productcategory c2 = productCategoryService.selectByPrimaryKey(product.getCategorylevel2id());
        Productcategory c3 = productCategoryService.selectByPrimaryKey(product.getCategorylevel3id());
        session.setAttribute("c1", c1);
        session.setAttribute("c2", c2);
        session.setAttribute("c3", c3);
        return "redirect:/show/toAddProduct";
    }
}
