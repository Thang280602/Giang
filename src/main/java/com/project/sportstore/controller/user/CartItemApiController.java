package com.project.sportstore.controller.user;

/**
 * @author thang
 */
import com.project.sportstore.model.CardItem;
import com.project.sportstore.service.CardItemSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author thang
 */
@RestController
@RequestMapping("/api/cartItem")
public class CartItemApiController {

    @Autowired
    private CardItemSevice cardItemService;

    @PutMapping("/{id}")
      CardItem update(@PathVariable("id") Integer id, @RequestBody CardItem cardItem) {
        CardItem cardItem1 = this.cardItemService.findId(id);
        cardItem1.setQuantity(cardItem.getQuantity());
        return this.cardItemService.update(cardItem1);
    }
}
