package PromotionEngine.Cart;

import java.util.List;

public class Cart {
	public List<CartItem> Items;

	public List<CartItem> getItems() {
		return Items;
	}

	public void setItems(List<CartItem> items) {
		Items = items;
	}

	public int TotalPrice;

	public int getTotalPrice() {
		return TotalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		TotalPrice = totalPrice;
	}

	public void AddItems(SKUitem item, int numberOfItems) {
		Items.add(new CartItem(item, numberOfItems, item.UnitPrice));
	}

	public void RemoveItem(String skuItemId) {
		if (!IsValidSKU(skuItemId))
			throw new IllegalArgumentException("Item not found on cart!");

		for (int i = 0; i < getItems().size(); i++) {
			if (((Items.get(i).getItem()).toString()).equals(skuItemId))
				Items.remove(i);
		}
	}

	private boolean IsValidSKU(String sku) {
		for (int i = 0; i < getItems().size(); i++) {
			if (((Items.get(i).getItem()).toString()).equals(sku))
				return true;
		}
		return false;

	}

}