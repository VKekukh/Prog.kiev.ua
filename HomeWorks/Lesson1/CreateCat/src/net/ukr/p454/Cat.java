package net.ukr.p454;

import java.util.Random;

public class Cat {
	private String nickname;
	private int age;
	private double weight;
	private boolean isPurebred;

	public Cat(String nickname, int age, double weight, boolean isPurebred) {
		super();
		this.nickname = nickname;
		this.age = age;
		this.weight = weight;
		this.isPurebred = isPurebred;
	}

	public Cat() {
		super();
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public boolean isPurebred() {
		return isPurebred;
	}

	public void setPurebred(boolean isPurebred) {
		this.isPurebred = isPurebred;
	}
	
	
	@Override
	public String toString() {
		return "Your cat: " + nickname + ", age: " + age + " years old, weight: " + weight + ", isPurebred: " + isPurebred;
	}

	public void meow() {
		System.out.println("Meow! Meow! Meow!");
	}

	public void purr() {
		System.out.println("Purr... Purr... Purr... ");
	}

	public void askingFood(String typeFood) {
		meow();
		System.out.println("Your cat " + this.nickname + " wants to eat....");
		meow();

		if (!this.isPurebred || typeFood.equalsIgnoreCase("fish")) {
			purr();
		} else {
			for (int i = 0; i < 10; i++) {
				meow();
			}
		}
	}

	public void playWithBall() {
		System.out.println("Your cat " + this.nickname + " wants to play! ");

		if (this.weight > 7.0) {
			System.out.println("Your cat " + this.nickname + " too fat to play with ball!");
			return;
		}

		if (this.age > 10) {
			System.out.println("Your cat " + this.nickname + " too old to play with ball!");
			return;
		}

		Random random = new Random();
		int powerHit = 0;
		do {
			powerHit = random.nextInt(100);
			
			if (powerHit < 20) {
				System.out.println("Hit!");
			} else if (powerHit < 60) {
				System.out.println("Hit!");
				System.out.println("The ball bounced off the wall!");
				System.out.println("Meow!");
			} else if (powerHit < 80) {
				System.out.println("Hit!");
				System.out.println("The ball bounced off the window!");
				System.out.println("Meow!");
			} else {
				System.out.println("Hit!");
				System.out.println("The ball under the fridge!");
				System.out.println("Game over....");
			}
		} while (powerHit < 80);

	}

}
