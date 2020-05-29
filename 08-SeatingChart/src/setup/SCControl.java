
package setup;

import javax.swing.JOptionPane;
import Images.imgList;
import java.util.Arrays;
import java.util.ArrayList;

public class SCControl {
	/* ================================= */
	private static final int SIZE = 5;
	private static final int CHART_MAX = 25;
	/* ================================= */
	private static Window _w = new Window();
	private static ArrayList<String> chart = new ArrayList<String>();
	private static String[] options1 = new String[] { "Add", "Remove", "Swap", "Create", "Exit" };

	/*
	 * This is the main method which runs the entire program
	 */
	public static void main(String[] args) {
		addnames();
		JOptionPane.showMessageDialog(null, "", "Welcome to the Not so good Seating chart", -1, imgList.chartish);
		while (true) {
			int result = JOptionPane.showOptionDialog(null, SeatingChart(), "Your Current Seating Chart: ", -1, -1,
					imgList.right, options1, options1[3]);
			if (result == 0) {
				String position = JOptionPane.showInputDialog(null, "Select The Position you'd Like to Edit", "Adding",
						-1);
				int x = Integer.parseInt(position) - 1;
				if (x < 0) {
					_w.msg("Please input a number between 1-" + CHART_MAX);
					System.out.println("Error");
				} else if (x > CHART_MAX) {
					_w.msg("Seat does not exist");
				} else {
					String name = _w.in("Name of child?");
					add(x, name);
				}
			}
			if (result == 1) {
				String position = JOptionPane.showInputDialog(null, "Select The Position you'd Like to Edit", "Remove",
						-1);
				int x = Integer.parseInt(position) - 1;
				if (x < 1) {
					_w.msg("Please input a number between 1-" + CHART_MAX);
					System.out.println("Error");
				} else if (x > CHART_MAX) {
					_w.msg("Seat does not exist");
				} else {
					remove(x);
				}
			}
			if (result == 2) {
				String position = JOptionPane.showInputDialog(null, "Select The Position you'd Like to Edit", "Swap",
						-1);
				int x = Integer.parseInt(position) - 1;
				if (x < 0) {
					_w.msg("Please input a number between 1-" + CHART_MAX, "ERROR");
					System.out.println("Error");
				} else if (x > CHART_MAX) {
					_w.msg("Seat does not exist");
				} else {
					String position2 = JOptionPane.showInputDialog(null, "Select The 2nd Position you'd Like to Edit",
							"Swap", -1);
					int y = Integer.parseInt(position2) - 1;
					if (y > CHART_MAX) {
						_w.msg("Seat does not exist");
					} else {
						swap(x, y);
					}
				}
			}
			if (result == 3) {
				int cnt = 0;
				for (int i = 0; i < chart.size(); ++i) {
					remove(i);
				}
				JOptionPane.showMessageDialog(null, null, null, 0, imgList.cust);
				while (cnt < CHART_MAX) {
					String[] options = { "Back to where we started :(", "Exit" };
					String customName = JOptionPane.showInputDialog(null,
							"Insert Name for Position: " + (cnt + 1)
									+ "\nType 'DONE' to Finish Editing\n\n Type 'Surprise' for a surprise",
							"Create Custom Seating Chart", -1);
					if (customName.equalsIgnoreCase("Surprise")) {
						JOptionPane.showMessageDialog(null, "Surprise", null, -1);
						int y = JOptionPane.showOptionDialog(null, null, null, -1, -1, imgList.surp, options,
								options[0]);
						if (y == 0) {
							break;
						}
						if (y != 1) {
							break;
						}
						_w.msg("Bye", "Bye");
						System.exit(0);
					}
					if (customName.equalsIgnoreCase("DONE")) {
						if (cnt != CHART_MAX) {
							for (int a = cnt; a < CHART_MAX; ++a) {
								chart.set(a, String.valueOf(String.valueOf(a + 1)) + ". Empty");
							}
						}
						cnt = CHART_MAX;
					} else {
						custom(cnt, customName);
						++cnt;
					}
				}
			}
			if (result == 4) {
				System.exit(0);
			}
		}
	}

	/*
	 * This method is used to add the names to the chart array
	 */
	public static void addnames() {
		chart.add("1. Empty");
		chart.add("2. Empty");
		chart.add("3. Empty");
		chart.add("4. Empty");
		chart.add("5. Empty");
		chart.add("6. Empty");
		chart.add("7. Empty");
		chart.add("8. Empty");
		chart.add("9. Empty");
		chart.add("10. Empty");
		chart.add("11. Empty");
		chart.add("12. Empty");
		chart.add("13. Empty");
		chart.add("14. Empty");
		chart.add("15. Empty");
		chart.add("16. Empty");
		chart.add("17. Empty");
		chart.add("18. Empty");
		chart.add("19. Empty");
		chart.add("20. Empty");
		chart.add("21. Empty");
		chart.add("22. Empty");
		chart.add("23. Empty");
		chart.add("24. Empty");
		chart.add("25. Empty");
	}

	/*
	 * This method is used to get the
	 */
	public static String[] SeatingChart() {
		String[][] newChart = new String[SIZE][SIZE];
		int cnt = 0;
		for (int c = 0; c < newChart[0].length; ++c) {
			for (int r = 0; r < newChart.length; ++r) {
				Arrays.toString(newChart);
				newChart[r][c] = chart.get(cnt);
				++cnt;
			}
		}
		String[] arr = new String[5];
		for (int r = 0; r < newChart.length; ++r) {
			String s = "";
			for (int c2 = 0; c2 < newChart[0].length; ++c2) {
				s = String.valueOf(String.valueOf(s)) + newChart[r][c2] + "       ";
			}
			arr[r] = s;
		}
		return arr;
	}

	/*
	 * This method is used to add a person to the SeatingChart
	 * 
	 */
	public static void add(int x, String name) {
		if (!chart.get(x).equals(String.valueOf(String.valueOf(x + 1)) + ". Empty")) {
			_w.msg("Seat already taken!");
		} else {
			chart.set(x, String.valueOf(String.valueOf(x + 1)) + ". " + new String(name));
		}
	}

	/*
	 * This method is used to remove the person from the SeatingChart
	 */
	public static void remove(int x) {
		if (chart.get(x).equals("Empty")) {
			_w.msg("Seat is already Empty!");
		} else {
			chart.set(x, String.valueOf(String.valueOf(x + 1)) + ". Empty");
		}
	}

	/*
	 * This method is used to swap the people ins the SeatingChart using 
	 * two ints
	 */
	public static void swap(int x, int y) {
		String e = chart.get(x).substring(chart.get(x).indexOf(46) + 1);
		chart.set(x,
				String.valueOf(String.valueOf(x + 1)) + "." + chart.get(y).substring(chart.get(y).indexOf(46) + 1));
		chart.set(y, String.valueOf(String.valueOf(y + 1)) + "." + e);
	}

	/*
	 * This method is used to create a custom seating chart by placing them in a specific seat(by number)
	 */
	public static void custom(int x, String name) {
		chart.set(x, String.valueOf(String.valueOf(x + 1)) + ". " + new String(name));
	}

}
