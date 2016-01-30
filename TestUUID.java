package examples;

import java.util.UUID;

public class TestUUID {

	public static void main(String[] args) {
		for(int index = 0; index < 10; index++) {
			System.out.println(UUID.randomUUID().toString());
		}

	}

}
