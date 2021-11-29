package PromotionEngine.JunitTest;

import java.util.ArrayList;
import java.util.List;

import PromotionEngine.Cart.Cart;
import PromotionEngine.Cart.CartItem;
import PromotionEngine.Cart.PromotionExecute;
import PromotionEngine.Cart.SKUitem;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ScenarioTestCases {

	public static final SKUitem a = new SKUitem("A", 50);
	public static final SKUitem b = new SKUitem("B", 30);
	public static final SKUitem c = new SKUitem("C", 20);
	public static final SKUitem d = new SKUitem("D", 15);

	Cart cart;
	List<CartItem> items;
	PromotionExecute objPromotion;

	@Test
	public void ScenarioA() {
		cart = new Cart();
		items = new ArrayList<CartItem>();
		objPromotion = new PromotionExecute();

		items.add(new CartItem(a, 1, a.UnitPrice));
		items.add(new CartItem(b, 1, b.UnitPrice));
		items.add(new CartItem(c, 1, c.UnitPrice));
		cart.setItems(items);

		objPromotion.Execute(cart);
		assertEquals(cart.getTotalPrice(), 100);
	}

	@Test
	public void ScenarioB() {
		cart = new Cart();
		items = new ArrayList<CartItem>();
		objPromotion = new PromotionExecute();

		items.add(new CartItem(a, 5, a.UnitPrice));
		items.add(new CartItem(b, 5, b.UnitPrice));
		items.add(new CartItem(c, 1, c.UnitPrice));
		cart.setItems(items);

		objPromotion.Execute(cart);
		assertEquals(cart.getTotalPrice(), 370);
	}

	@Test

	public void ScenarioC() {

		cart = new Cart();
		items = new ArrayList<CartItem>();
		objPromotion = new PromotionExecute();

		items.add(new CartItem(a, 3, a.UnitPrice));
		items.add(new CartItem(b, 5, b.UnitPrice));
		items.add(new CartItem(c, 1, c.UnitPrice));
		items.add(new CartItem(d, 1, d.UnitPrice));
		cart.setItems(items);

		objPromotion.Execute(cart);
		assertEquals(cart.getTotalPrice(), 280);
	}

}
