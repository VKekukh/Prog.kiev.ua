package net.ukr.p454.task723;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file = createFile();
		save(file, drawApp());
	}

	public static File createFile() {
		Scanner sc = new Scanner(System.in);

		System.out.print("Input path to file:");
		String filePath = parsePath(sc.nextLine());

		System.out.print("Input file name:");
		String fileName = checkFolder(filePath) + "/" + sc.nextLine();

		File file = new File(fileName);
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.err.println("Can't create file " + e);
		}
		sc.close();
		return file;
	}

	static String checkFolder(String folderPath) {
		File folder = new File(folderPath);
		if (!folder.exists()) {
			folderPath = ".";
		}
		return folderPath;
	}

	static String parsePath(String path) {

		path = path.replace("\\", "/");
		return path;

	}

	public static void save(File file, String text) {
		try (PrintWriter printWriter = new PrintWriter(file)) {
			printWriter.write(text);
		} catch (IOException e) {
			System.err.println("Can't write to file");
		}
		System.out.println("DONE!");
	}

	static String drawApp() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i <= 12; i++) {
			for (int j = 0; j <= 20; j++) {
				if (i == 0) {
					if (j == 0 || j == 20) {
						stringBuilder.append(" ");

					} else {
						stringBuilder.append("_");
					}
				}

				if (i == 1) {
					if (j == 0 || j == 20) {
						stringBuilder.append("|");
					} else if (j == 1 || j == 19 || j == 2 || j == 18) {
						stringBuilder.append(" ");
					} else {
						stringBuilder.append("_");
					}
				}
				if (i == 2) {
					if (j == 0 || j == 20 || j == 2 || j == 18) {
						stringBuilder.append("|");
					} else {
						stringBuilder.append(" ");
					}
				}

				if (i == 3) {
					if (j == 0 || j == 20 || j == 2 || j == 18) {
						stringBuilder.append("|");
					} else if (j == 6 || j == 14) {
						stringBuilder.append("0");
					} else {
						stringBuilder.append(" ");
					}
				}
				if (i == 4) {
					if (j == 0 || j == 20 || j == 2 || j == 18) {
						stringBuilder.append("|");
					} else if (j == 10) {
						stringBuilder.append("-");
					} else {
						stringBuilder.append(" ");
					}
				}

				if (i == 5) {
					if (j == 0 || j == 20 || j == 2 || j == 18) {
						stringBuilder.append("|");

					} else if (j == 8) {
						stringBuilder.append("\\");
					} else if (j > 8 && j < 12) {
						stringBuilder.append("_");
					} else if (j == 12) {
						stringBuilder.append("/");
					} else {
						stringBuilder.append(" ");
					}
				}
				if (i == 6) {
					if (j == 0 || j == 20 || j == 2 || j == 18) {
						stringBuilder.append("|");

					} else if ((j > 2 && j < 8) || (j > 12 && j < 18)) {
						stringBuilder.append("_");
					} else {
						stringBuilder.append(" ");
					}
				}

				if (i == 7) {
					if (j == 0 || j == 20) {
						stringBuilder.append("|");

					} else if ((j > 0 && j < 8) || (j > 12 && j < 20)) {
						stringBuilder.append("_");

					} else if (j == 8 || j == 12) {
						stringBuilder.append("|");
					} else if (j == 9) {
						stringBuilder.append("\\");
					} else if (j == 10) {
						stringBuilder.append("_");
					} else if (j == 11) {
						stringBuilder.append("/");

					} else {
						stringBuilder.append(" ");
					}
				}

				if (i == 8) {
					if (j == 4 || j == 16) {
						stringBuilder.append("_");
					} else if (j == 5 || j == 15) {
						stringBuilder.append("|");
					} else if (j == 8 || j == 12) {
						stringBuilder.append("|");
					} else if (j == 9) {
						stringBuilder.append("/");
					} else if (j == 10) {
						stringBuilder.append(" ");
					} else if (j == 11) {
						stringBuilder.append("\\");
					} else if (j == 6 || j == 7 || j == 13 || j == 14) {
						stringBuilder.append("_");
					} else {
						stringBuilder.append(" ");
					}
				}
				if (i == 9) {
					if (j == 2) {
						stringBuilder.append("/");
					} else if (j == 18) {
						stringBuilder.append("\\");
					} else if (j > 2 && j < 18) {
						stringBuilder.append("*");
					}

					else {
						stringBuilder.append(" ");
					}
				}
				if (i == 10) {
					if (j == 1) {
						stringBuilder.append("/");
					} else if (j == 19) {
						stringBuilder.append("\\");
					} else if (j > 1 && j < 19) {
						stringBuilder.append("*");
					}

					else {
						stringBuilder.append(" ");
					}
				}
				if (i == 11) {
					stringBuilder.append("-");
				}

			}
			stringBuilder.append(System.lineSeparator());

		}
		return stringBuilder.toString();
	}
}
