class NondominateableEntities {
	static class Entity {
		public int x;
		public int y;
		public Entity(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "(" + this.x + "," + this.y + ")"; 
		}
	}

	public static int findNoneDominatable(Entity[] input) {
		if(input == null || input.length == 0) {
			return 0;
		}
		int result = 0;
		for(int i=0; i<input.length; i++) {
			result += isDominatable(i, input) ? 1 : 0;
		}
		return result;
	}

	private static boolean isDominatable(int i, Entity[] input) {
		for(int j=0; j<input.length; j++) {
			if(i != j && input[i].x < input[j].x && input[i].y < input[j].y) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args){
		Entity[] input = new Entity[]{new Entity(1,7), new Entity(2,4), new Entity(4,6)};
		// for(int i=0; i<input.length; i++) {
		// 	System.out.println(input[i].toString());
		// }
		System.out.println("result: " + findNoneDominatable(input));
	}
}
