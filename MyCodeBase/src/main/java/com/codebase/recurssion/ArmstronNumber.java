package com.codebase.recurssion;

public class ArmstronNumber {
	public static void main(String[] args) {
		System.out.println(checkArmstrong(400));
	}

	static int checkArmstrong(int num) {
		int count = 0;
		for (int i = 1; i <= num; i++) {
			if (i == getQube(i)) {
				count++;
				System.out.println(i);
			}
		}
		return count;
	}

	static int getQube(int num) {
		int digit = 0;
		if (num > 0) {
			digit = num % 10;
			num = num / 10;
			return (digit * digit * digit) + getQube(num);
		}
		return digit;
	}

}
