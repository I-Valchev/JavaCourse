import java.nio.file.Paths;

public class PathReducer {

	public static String reducePath(String path) {
		return Paths.get(path).normalize().toString();
	}

	public static void main(String[] args) {
		System.out.println(PathReducer.reducePath("/../me/test/./"));
	}

}