package PromotionEngine.Cart;

public class SKUitem {
	public String ID;
	public int UnitPrice;

	public float getUnitPrice() {
		return UnitPrice;
	}

//	private void setUnitPrice(float unitPrice) {
//		UnitPrice = unitPrice;
//	}

	public String getID() {
		return ID;
	}

	public SKUitem(String id, int unitPrice) {
		if (id == null)
			throw new IllegalArgumentException("Invalid or missing SKU id!");
		if (unitPrice <= 0)
			throw new IllegalArgumentException("Invalid unit price! It must be grater than zero!");

		ID = id;
		UnitPrice = unitPrice;
	}

	public void UpdateUnitPrice(int price) {
		UnitPrice = price;
	}
}
