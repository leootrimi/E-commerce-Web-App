package com.eCommerce.eCommerceApp.Services;

<<<<<<< Updated upstream
import com.eCommerce.eCommerceApp.Models.Cart;
import com.eCommerce.eCommerceApp.Models.CartItem;
import com.eCommerce.eCommerceApp.Models.Product;
import com.eCommerce.eCommerceApp.Models.Users;
=======
import com.eCommerce.eCommerceApp.Models.*;
import org.springframework.stereotype.Service;
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes

import java.util.List;

@Service
public interface CartService {
    List<Product> getCartByUser(String username);

    int getCount(String username);

    List<Long> getProductIdsByUsername(String username);

    List<Product> getDataFromProductIds(List<Long> productIds);

    Double getTotalPriceofCart(List<Product> products);

    void removeProductFromCart(Long id, String username);


}
