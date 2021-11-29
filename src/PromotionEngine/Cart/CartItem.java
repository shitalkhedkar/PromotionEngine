package PromotionEngine.Cart;

public class CartItem {

	public SKUitem Item;
	public int FinalPrice;
	public int ItemQuantity;

	public int getItemQuantity() {
		return ItemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.ItemQuantity = itemQuantity;
	}

	public CartItem(SKUitem item, int itemQuantity, int UnitPrice) {

		Item = item;
		FinalPrice = UnitPrice;
		ItemQuantity = itemQuantity;
	}

	public SKUitem getItem() {
		return Item;
	}

	public void setItem(SKUitem item) {
		Item = item;
	}

	public int getFinalPrice() {
		return FinalPrice;
	}

	public void setFinalPrice(int finalPrice) {
		FinalPrice = finalPrice;
	}

}
