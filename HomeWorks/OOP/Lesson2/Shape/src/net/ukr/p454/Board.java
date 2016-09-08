package net.ukr.p454;

public class Board {

	private Shape[] shapes = new Shape[4];

	public void addShape(Shape shape, int position) {

		position--;
		int freePositions = 0;
		try {
			if (shapes[position] == null) {
				shapes[position] = shape;
				System.out.println("You drawed the figure " + shape.getType());
			} else {
				System.err.println("You can't draw the figure on this place. On this place was drawed "
						+ shapes[position].getType());

				StringBuilder stringBuilder = new StringBuilder();

				for (int i = 0; i < shapes.length; i++) {
					if (shapes[i] == null) {
						stringBuilder.append((i + 1) + " ");
						freePositions++;
					}
				}

				if (freePositions > 0) {
					System.out.println("You can draw on next places:" + stringBuilder.toString());
				} else {
					System.out.println("You have not free places");
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Wrong position on board. Try from 1 to 4");
		}

	}

	public void remShape(Shape shape) {
		for (int i = 0; i < shapes.length; i++) {
			if (shapes[i] != null && shapes[i].getClass() == shape.getClass()) {
				shapes[i] = null;
				System.out.println("Figure was removed");
				break;
			}
		}
	}

	public void erasePlace(int position) {
		position--;
		try {
			if (shapes[position] != null) {
				shapes[position] = null;
				System.out.println("You erased this part of board");
			} else {
				System.out.println("Needless to erase. This place is free.");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Wrong position on board. Try from 1 to 4");
		}
	}

	public double getAllArea() {
		double area = 0;
		for (int i = 0; i < shapes.length; i++) {
			if (shapes[i] != null) {
				area = area + shapes[i].getArea();
			}
		}
		return area;
	}

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("What can you see on board:");
		stringBuffer.append(System.lineSeparator());

		for (int i = 0; i < shapes.length; i++) {
			if (shapes[i] == null) {
				stringBuffer.append("Free");
			} else {
				stringBuffer.append(shapes[i].toString());
			}
			stringBuffer.append(System.lineSeparator());

		}
		stringBuffer.append("All area:" + getAllArea());
		return stringBuffer.toString();
	}

}
