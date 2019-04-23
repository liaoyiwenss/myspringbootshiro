package net.wanho.controller.shoppingcar;


import net.wanho.pojo.Product;
import net.wanho.pojo.vo.ShoppingCart;
import net.wanho.pojo.vo.ShoppingCartItem;
import net.wanho.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("shopping")
public class ShoppingController {


    @Autowired
    private ProductService productService;



    @RequestMapping("buycar")
    public String buycar(Long tid, Long quntity, HttpSession session) {

        Product product = productService.selectByPrimaryKey(tid);

        float cost = product.getPrice() * quntity;

        ShoppingCart cartlist = (ShoppingCart) session.getAttribute("cartlist");
        if (cartlist == null) {
            ShoppingCartItem productitem = new ShoppingCartItem(product, quntity, cost);
            cartlist = new ShoppingCart();
            List<ShoppingCartItem> items = new ArrayList<ShoppingCartItem>();
            items.add(productitem);
            cartlist.setSum(productitem.getCost());
            cartlist.setItems(items);
            session.setAttribute("cartlist", cartlist);
            List<ShoppingCartItem> itemsss = cartlist.getItems();
            for (int i = 0; i < itemsss.size(); i++) {
                System.out.println("11");
                System.out.println(itemsss.get(i).getProduct().getName());
            }
            return "redirect:/show/Temp";
        } else {
            List<ShoppingCartItem> items = cartlist.getItems();
            boolean flag = false;
            for (int i = 0; i < items.size(); i++) {
                ShoppingCartItem item = items.get(i);
                Product pro = item.getProduct();
                if (pro.getTid().equals(tid)) {
                    if ((pro.getStock() - (item.getQuantity() + quntity)) > 0) {
                        item.setQuantity(item.getQuantity() + quntity);
                        item.setCost(item.getCost() + quntity * pro.getPrice());
                        cartlist.setSum(cartlist.getSum() + cost);
                        cartlist.setItems(items);
                        flag = true;

                    }
                }
            }
            if (!flag) {
                if ((product.getStock() - quntity) > 0) {
                    ShoppingCartItem productitem = new ShoppingCartItem(product, quntity, cost);
                    items.add(productitem);
                    cartlist.setSum(cartlist.getSum() + cost);
                    cartlist.setItems(items);
                    flag = true;
                }
            }
            session.setAttribute("cartlist", cartlist);
            if (flag) {
                //cartlist更新了
                session.setAttribute("message", "");
            } else {
                //cartlist没有更新了
                session.setAttribute("message", "库存不够无法插入！！");
            }
            return "redirect:/show/Temp";
        }
    }


    @RequestMapping("buycar1")
    public String buycar1(){
        return "redirect:/show/Temp";
    }



}