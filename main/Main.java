package main;

import process.ShiritoriSys;

public class Main {

	public static void main(String[] args) {
		System.out.println("しりとりGAME");
		new Help();
		play();
	}

	static void play() {
		new ShiritoriSys();
	}

}
