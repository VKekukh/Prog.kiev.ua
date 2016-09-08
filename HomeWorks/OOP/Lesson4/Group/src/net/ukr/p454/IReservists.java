package net.ukr.p454;

public interface IReservists {
	
	default Human[] getReservists(Human[] humans){
		int position = 0;
		Human[] newList = new Human[humans.length];
		for (Human human : humans) {
			if(human.getAge()>=18 && human.getSex() == Sex.MALE){
				newList[position++] = human;
			}
		}
		return newList;
	}
}
